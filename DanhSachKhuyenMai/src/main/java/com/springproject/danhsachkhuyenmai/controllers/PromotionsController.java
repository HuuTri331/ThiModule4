package com.springproject.danhsachkhuyenmai.controllers;

import com.springproject.danhsachkhuyenmai.model.Promotion;
import com.springproject.danhsachkhuyenmai.model.PromotionDto;
import com.springproject.danhsachkhuyenmai.services.IPromotionsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/promotions")
public class PromotionsController {

    @Autowired
    private IPromotionsRepository repo;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @GetMapping({"",  "/"})
    public String showProductsList(Model model) {
        List<Promotion> promotions = repo.findAll(Sort.by(Sort.Direction.DESC,"id"));
        model.addAttribute("promotions", promotions);
        return "promotions/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        Promotion promotionDto =  new Promotion();
        model.addAttribute("promotionDto",promotionDto);
        return "promotions/CreatePromotion";
    }

    @PostMapping("/create")
    public String createPromotion(
            @Valid @ModelAttribute("promotionDto") PromotionDto promotionDto,
            BindingResult result,
            RedirectAttributes redirectAttributes
    ) {
        if (result.hasErrors()) {
            return "promotions/CreatePromotion";
        }

        return "redirect:/promotions";
    }
}
