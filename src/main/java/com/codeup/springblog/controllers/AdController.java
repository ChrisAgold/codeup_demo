//package com.codeup.springblog.controllers;
//
//import com.codeup.springblog.models.Ad;
//import com.codeup.springblog.models.Post;
//import com.codeup.springblog.models.User;
//import com.codeup.springblog.repo.AdRepository;
//import com.codeup.springblog.repo.UserRepository;
//import com.codeup.springblog.services.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//public class AdController {

//    @Autowired
//    private EmailService emailService;
//
//    private final AdRepository adDao;
//    private final UserRepository userDao;
//
//    AdController(AdRepository adDao, UserRepository userDao){
//        this.adDao = adDao;
//        this.userDao = userDao;
//    }

//    @GetMapping("/ads")
//    public String seeAllAds(Model viewModel){
//        List<Ad> adsFromDB = adDao.findAll();
//        viewModel.addAttribute("ads", adsFromDB);
//        // do not use a / to reference a template
//        return "ads/index";
//    }
//
//    @GetMapping("/ads/{id}")
//    public String showOneAd(@PathVariable Long id, Model vModel){
//        vModel.addAttribute("ad", adDao.getOne(id));
//        return "ads/show";
//    }
//
//    @GetMapping("/ads/create")
//    public String viewAdForm(Model model){
//        model.addAttribute("ad", new Ad());
//        return "ads/create";
//    }
//
//    @PostMapping("/ads/create")
//    @ResponseBody
//    public String createAd(@ModelAttribute Ad ad){
//
//        User user = userDao.getOne(1L);
//        ad.setOwner(user);
//        Ad savedAd = adDao.save(ad);
//        emailService.prepareAndSend(savedAd, "New Ad!", "A new Ad has been created in the app");
//
//        return "You created an ad.";
//    }
//
//    @GetMapping("/ads/{id}/update")
//    public String updateAdForm(@PathVariable Long id, Model model){
//
//        Ad adFromDb = adDao.getOne(id);
//
//        model.addAttribute("oldAd",adFromDb);
//
//        return "ads/update";
//    }
//
//    @PostMapping("/ads/{id}/update")
//    @ResponseBody
//    public String updateAd(@PathVariable Long id,@RequestParam("ad_title") String title, @RequestParam("ad_description") String description){
//
//        Ad adToSave = new Ad(id,title,description);
//
//        adDao.save(adToSave);
//        return "You updated an ad.";
//    }
//
//    @PostMapping("/ads/{id}/delete")
//    @ResponseBody
//    public String deleteAd(@PathVariable Long id){
//        adDao.deleteById(id);
//        return "You deleted an ad.";
//
//    }
//
//
//
//}