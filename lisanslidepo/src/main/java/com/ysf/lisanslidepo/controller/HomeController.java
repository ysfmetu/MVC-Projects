package com.ysf.lisanslidepo.controller;

import com.ysf.lisanslidepo.model.Il;
import com.ysf.lisanslidepo.model.Isyeri;
import com.ysf.lisanslidepo.model.LisansliDepo;
import com.ysf.lisanslidepo.repository.LisansRepo;
import com.ysf.lisanslidepo.service.IlService;
import com.ysf.lisanslidepo.service.IsyeriService;
import com.ysf.lisanslidepo.service.LisansService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController<list> {
    @Autowired
    private LisansRepo lisRepo;
    private LisansliDepo lisans;
    @Autowired
    private LisansService lisansService;
    @Autowired
    private IsyeriService isyeriService;
    @Autowired
    private IlService ilService;


    @GetMapping("/")
    public String home(Model model) {
        String keyword = null;
        return findPaginated(1, "lisdepoadi", "asc", keyword, model);
    }

   /* @GetMapping("/showNewLisansForm")
    public String showNewLisansForm(Model model) {
        // create model attribute to bind form data
        LisansliDepo lisansliDepo = new LisansliDepo();
        model.addAttribute("lisansKayit", lisansliDepo);
        return "new_lisans";
    }*/

    @GetMapping("/page/new_lisans")
    public String add(Model model) {
        List<Isyeri> isyeriall = isyeriService.getAllIsyeri();
        List<Il> ilall = ilService.getAllIl();
        model.addAttribute("ilisimleri", ilall);
        model.addAttribute("isyerleri", isyeriall);

        LisansliDepo lisansliDepo = new LisansliDepo();
        lisansliDepo.setSira(lisansService.maxSira() + 1);
        model.addAttribute("newlisans", lisansliDepo);
        return "new_lisans";
    }

    @GetMapping("/new_lisans")
    public String add1(Model model) {
        List<Il> ilall = ilService.getAllIl();
        model.addAttribute("ilisimleri", ilall);
        List<Isyeri> isyeriall = isyeriService.getAllIsyeri();
        model.addAttribute("isyerleri", isyeriall);
        LisansliDepo lisansliDepo = new LisansliDepo();
        lisansliDepo.setSira(lisansService.maxSira() + 1);
        model.addAttribute("newlisans", lisansliDepo);
        return "new_lisans";
    }

    @PostMapping("/saveLisans")
    public String add(@Validated @ModelAttribute("new_lisans") LisansliDepo lisans, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            return "redirect:/new_lisans";
        }
        if (lisans.getBagli_oldugu_sube().length() == 1) {
            redirectAttributes.addFlashAttribute("message", "Kaydetme hatası---işyeri seçmek zorunludur");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/new_lisans";
        }
        if (lisans.getSubeno() == 0) {
            redirectAttributes.addFlashAttribute("message", "Kaydetme hatası-  Şube no << 0 >> dan farklı bir değer olmalıdır");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/new_lisans";
        }
        lisans.setAdres("XX");
        lisans.setDepo_min(888888);
        lisans.setDepo_max(999999);
        lisans.setAktif("A");
        lisans.setLisdepono(lisansService.maxSira()+1);

        lisansService.saveEmployee(lisans);
        return "redirect:/";
    }
    @PostMapping("/updateLisans")
    public String update(@Validated @ModelAttribute("updatelisans") LisansliDepo lisans, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        LisansliDepo oldLisans=lisRepo.findById(lisans.getLisdepono()).get();

        oldLisans.setLisdepoadi(lisans.getLisdepoadi());
        oldLisans.setSira(lisans.getSira());
        oldLisans.setSubeno(lisans.getSubeno());
        oldLisans.setLisansli_depoculuk_no(lisans.getLisansli_depoculuk_no());
        oldLisans.setYetkili_siniflandirici_no(lisans.getYetkili_siniflandirici_no());
        lisansService.saveEmployee(oldLisans);
        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                @Param("keyword") String keyword,
                                Model model) {
        int pageSize = 9;

        Page<LisansliDepo> page = lisansService.findPaginated(pageNo, pageSize, sortField, sortDir, keyword);
        List<LisansliDepo> listLisans = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listLisans", listLisans);
        model.addAttribute("keyword", keyword);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "index";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        LisansliDepo lisansliDepo = lisansService.getLisansliDepoById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("updatelisans", lisansliDepo);
        return "update_employee";
    }
}
