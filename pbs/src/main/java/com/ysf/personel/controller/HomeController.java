package com.ysf.personel.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ysf.personel.model.GeciciOzet;
import com.ysf.personel.model.Isyeri;
import com.ysf.personel.model.PersonelInfo;
import com.ysf.personel.repository.IsyeriRepository;
import com.ysf.personel.repository.PersonelGeciciGorevRepository;
import com.ysf.personel.repository.PersonelRepository;
import com.ysf.personel.service.PersonelGeciciGorevService;
import com.ysf.personel.service.PersonelService;
import com.ysf.personel.service.PersonelSondurumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ysf.personel.model.UserInfo;
import com.ysf.personel.model.security.UserRole;
import com.ysf.personel.repository.RoleRepository;
import com.ysf.personel.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private IsyeriRepository isyeriRepo;
    @Autowired
    private PersonelGeciciGorevRepository geciciRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private PersonelService personelService;
    @Autowired
    private PersonelSondurumService sondurumService;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private PersonelGeciciGorevService pggService;
    @Autowired
    private PersonelRepository personelRepo;

    @GetMapping(value = {"/", "/index"})
    public String home() {
        return "index";
    }

    @GetMapping("/userFront")
    public String UserFront(Model model) {
        List<PersonelInfo> personeller = personelService.personelAll();
        for (PersonelInfo personel : personeller) {
            personel.setKanGrubu(personelRepo.findKangrubuAdı(personel.getKanGrubu()));
        }
        model.addAttribute("personeller", personeller);
        return "userFront";
    }

    @GetMapping("/userMerkez")
    public String UserMerkez(Model model) {
        List<PersonelInfo> personeller = personelService.personelMerkez();
        for (PersonelInfo personel : personeller) {
            personel.setKanGrubu(personelRepo.findKangrubuAdı(personel.getKanGrubu()));
        }
        model.addAttribute("personeller", personeller);

        return "userFront";
    }

    @GetMapping("/userTasra")
    public String UserTasra(Model model) {
        List<PersonelInfo> personeller = personelService.personelTasra();
        for (PersonelInfo personel : personeller) {
            personel.setKanGrubu(personelRepo.findKangrubuAdı(personel.getKanGrubu()));
        }
        model.addAttribute("personeller", personeller);
        return "userFront";
    }

    @GetMapping("/ozet")
    public String ozet(Model model) {
        return "personel-Detay1";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        UserInfo user = new UserInfo();
        model.addAttribute("user", user);
        return "signup";
    }

    @GetMapping("/gozlem")
    public String gozlem(Model model) {
        long count = sondurumService.findCountEntity();
        long countTasra = sondurumService.findTasraSayi();
        long countMerkez = sondurumService.findMerkezSayi();
        long countPGG = pggService.findAllGGP();

        model.addAttribute("countPGG", countPGG);
        model.addAttribute("countMerkez", countMerkez);
        model.addAttribute("countTasra", countTasra);
        model.addAttribute("count", count);
        return "gozlem";
    }

    @GetMapping("/userGecici")
    public String userGecici(Model model) {
        List<GeciciOzet> geciciAll = geciciRepo.findGeciciOzet();
        List<Isyeri> isyerleri = isyeriRepo.findAll();
        for (GeciciOzet gecici : geciciAll) {
            gecici.setIsyeriadi1(geciciRepo.findByIsyeriAdi(gecici.getOther_isyeri()));
            gecici.setIsyeriadi2(geciciRepo.findByIsyeriAdi(gecici.getOwner_isyeri()));
            gecici.setUnvan(geciciRepo.findByUnvanAdi(gecici.getUnvan()));
            gecici.setGorev_turu(geciciRepo.findByDurumAdi(gecici.getGorev_turu()));
            if (gecici.getDurum().equals("D")) {
                gecici.setDurum("DEVAM EDİYOR");
            } else if (gecici.getDurum().equals("B")) {
                {
                    gecici.setDurum("TAMAMLANDI");
                }
            }
            if (gecici.getHarcirah().equals("S")) {
                {
                    gecici.setHarcirah("EVET");
                }
            } else if (gecici.getHarcirah().equals("H")) {
                {
                    gecici.setHarcirah("HAYIR");
                }
            }

        }

        model.addAttribute("geciciAll", geciciAll);
        model.addAttribute("isyerleri", isyerleri);
        return "userGecici";
    }

    @PostMapping("/signup")
    public String signupPost(@ModelAttribute("user") UserInfo user, Model model) {

//		if (userService.checkEmailExists(user.getEmail())) {
//			model.addAttribute("emailExists", true);
//		}
//
//		if (userService.checkUsernameExists(user.getUsername())) {
//			model.addAttribute("usernameExists", true);
//			}
//
//		return "signup";
//		} else {
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, roleRepo.findByName("ROLE_USER")));
        userService.createUser(user, userRoles);
        return "redirect:/";

    }

}
