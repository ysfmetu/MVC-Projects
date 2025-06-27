package com.ysf.personel.controller;


import com.ysf.personel.model.*;
import com.ysf.personel.model.PersonelDigerOgrenim;
import com.ysf.personel.repository.*;
import com.ysf.personel.service.DisiplinService;
import com.ysf.personel.service.PersonelGozlemService;
import com.ysf.personel.service.PersonelService;
import com.ysf.personel.service.PersonelSondurumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.nio.file.Paths;
import java.util.*;

@Controller
@RequestMapping("/personel")
public class PersonelController {
    @Autowired
    private PersonelGozlemService personelGozlemService;
    @Autowired
    private PersonelService personelService;
    @Value("${uploadDir}")
    private String uploadFolder;
    @Autowired
    private PersonelSondurumService personelSondurumService;
    @Autowired
    private PersonelGeciciGorevRepository geciciRepo;
    @Autowired
    private PersonelSondurumRepository sondurumRepo;
    @Autowired
    private DisiplinService disiplinService;
    @Autowired
    private DisiplinRepository disiplinRepo;
    @Autowired
    private PersonelHareketRepository personelHareketRepo;
    @Autowired
    private PersonelDigerOgrenimRepository ogrenimRepo;

    @GetMapping
    public String personelEkle() {
        return "personelEkle";
    }

    @GetMapping("/personelDetay")
    public String showProductDetails(@RequestParam("id") Long id, Optional<PersonelInfo> personel,
                                     Optional<PersonelGozlem> personelResim, Model model) {
        String sicilResim = personelService.getPersonelId(id).get().getSicil();
        PersonelOzet personelOzet = personelSondurumService.findPersonelOzet(sicilResim);
        List<PersonelHareket> personelHareket = personelHareketRepo.findPersonelHareketInfo(sicilResim);
        List<PersonelDigerOgrenim> personelOgrenim = ogrenimRepo.findPersonelOgrenim(sicilResim);
        model.addAttribute("personelhareket", personelHareket);
        if (disiplinService.checkSicilExists(sicilResim)) {
            List<DisiplinOzet> disiplinOzet = disiplinRepo.findDisiplinOzet(sicilResim);
            for (DisiplinOzet disiplin : disiplinOzet) {
                String isyeriadi = geciciRepo.findByIsyeriAdi(disiplin.getIsyerikodu());
                String cezaadi = disiplinRepo.findByVerilen_cezaAdi(disiplin.getOnerilencezakodu());
                String makamadi = disiplinRepo.findByCezaMakamAdi(disiplin.getCezamakamadi());
                String sorusturma = disiplinRepo.findBySorusturmaAdi(disiplin.getSorusturmakonukodu());

                disiplin.setIsyerikodu(isyeriadi);
                disiplin.setOnerilencezaadi(cezaadi);
                disiplin.setCezamakamadi(makamadi);
                disiplin.setSorusturmakonuadi(sorusturma);
            }
            model.addAttribute("disiplinozet", disiplinOzet);
        } else if (!disiplinService.checkSicilExists(sicilResim)) {
            model.addAttribute("disiplin1", true);
        }
        for (PersonelHareket personelH : personelHareket) {
            personelH.setUnvankodu(geciciRepo.findByUnvanAdi(personelH.getUnvankodu()));
            personelH.setIsyerikodu(geciciRepo.findByIsyeriAdi(personelH.getIsyerikodu()));
            personelH.setEski_isyerikodu(geciciRepo.findByIsyeriAdi(personelH.getEski_isyerikodu()));
            personelH.setEski_unvankodu(geciciRepo.findByUnvanAdi(personelH.getEski_unvankodu()));
            personelH.setIslemturu_detay(personelHareketRepo.findIslemturuDetay(personelH.getIslemturu_detay()));
        }
        for (PersonelDigerOgrenim ogrenim : personelOgrenim) {
            ogrenim.setOkul(sondurumRepo.findByOkulAdi(ogrenim.getOkul()));
            ogrenim.setBolum(sondurumRepo.findByBolumAdi(ogrenim.getBolum()));
            ogrenim.setFakulte(sondurumRepo.findByFakulteAdi(ogrenim.getFakulte()));
        }
        model.addAttribute("personeldigerogrenim", personelOgrenim);


        try {

            if (id != 0) {

                personel = personelService.getPersonelId(id);
                Long resimid = personelGozlemService.findBySicil(sicilResim).getId();
                personelResim = personelGozlemService.findById(resimid);


                personelOzet.setUnvanadi(geciciRepo.findByUnvanAdi(personelOzet.getUnvanadi()));
                personelOzet.setOkul(sondurumRepo.findByOkulAdi(personelOzet.getOkul()));
                personelOzet.setFakulte(sondurumRepo.findByFakulteAdi(personelOzet.getFakulte()));
                personelOzet.setBolum(sondurumRepo.findByBolumAdi(personelOzet.getBolum()));
                personelOzet.setDogumIl(sondurumRepo.findByIladi(personelOzet.getDogumIll()));

                int noOfDays = personelOzet.getKidemtoplam();
                int month, year, days;
                month = 0;
                year = 0;
                days = 0;
                year = noOfDays / 360;
                noOfDays = noOfDays % 360;
                month = noOfDays / 30;
                days = noOfDays % 30;

                if (personel.isPresent()) {
                    model.addAttribute("id", personel.get().getId());
                    model.addAttribute("sicil", personel.get().getSicil());
                    model.addAttribute("ad", personel.get().getAd());
                    model.addAttribute("soyad", personel.get().getSoyad());
                    model.addAttribute("unvanadi", personelOzet.getUnvanadi());
                    model.addAttribute("okul", personelOzet.getOkul());
                    model.addAttribute("isyeri", personel.get().getIsyeri());
                    model.addAttribute("image", personelResim.get().getImage());
                    model.addAttribute("imageId", personelResim.get().getId());
                    model.addAttribute("dogumtarih", personelOzet.getDogumTarihi());
                    model.addAttribute("dogumyeri", personelOzet.getDogumYeri());
                    model.addAttribute("okul", personelOzet.getOkul());
                    model.addAttribute("bolum", personelOzet.getBolum());
                    model.addAttribute("fakulte", personelOzet.getFakulte());
                    model.addAttribute("dogumil", personelOzet.getDogumIl());
                    model.addAttribute("yil", year);
                    model.addAttribute("ay", month);
                    model.addAttribute("gun", days);
                    return "personel-Detay1";
                }
                return "redirect:/personel";
            }
            return "redirect:/personel";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/personel";
        }
    }

    @GetMapping("/show")
    public String show(Model model) {
        List<PersonelGozlem> personels = personelGozlemService.findAll();
        model.addAttribute("personels", personels);
        return "personelGozlem";
    }


    @GetMapping("/display/{id}")
    @ResponseBody
    public void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<PersonelGozlem> personel)
            throws ServletException, IOException {
        String sicil = personelGozlemService.findById(id).get().getSicil();
        Long secondid = personelGozlemService.findBySicil(sicil).getId();
        personel = personelGozlemService.findById(secondid);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(personel.get().getImage());
        response.getOutputStream().close();
    }

    @PostMapping("/personelEkle")
    public @ResponseBody
    ResponseEntity<?> createProduct(@RequestParam("sicil") String sicil, Model model, HttpServletRequest request
            , final @RequestParam("image") MultipartFile file) {
        try {
            String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
            String fileName = file.getOriginalFilename();
            String filePath = Paths.get(uploadDirectory, fileName).toString();
            if (fileName == null || fileName.contains("..")) {
                model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
                return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
            }
            try {
                File dir = new File(uploadDirectory);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                // Save the file locally
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                stream.write(file.getBytes());
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            byte[] imageData = file.getBytes();
            PersonelGozlem personel = new PersonelGozlem();
            if (personelGozlemService.checkSicilExists(sicil)) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            personel.setSicil(sicil);
            personel.setImage(imageData);
            personelGozlemService.savePersonel(personel);
            return new ResponseEntity<>("Product Saved With File - " + fileName, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
