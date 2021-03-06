/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.controllers;

import blog.Exceptions.VoorraadNegatief;
import blog.Exceptions.ArtikelnaamLeeg;
import blog.Exceptions.ArtikelprijsNegatief;
import blog.Exceptions.KlantAchternaamLeeg;
import blog.Exceptions.KlantVoornaamLeeg;
import blog.Exceptions.EmailadresOngeldig;
import blog.Exceptions.NietGeheel;
import blog.Exceptions.NietNumeriek;
import blog.format.CheckFormat;
import blog.forms.Form1;
import blog.forms.LoginForm;
import blog.models.Account;
import blog.models.Accounttype;
import blog.models.*;
import blog.security.IngelogdeGebruiker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import blog.services.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


//@Controller
//public class HomeController {
    //@Autowired
    //private PostService postService;
//@RequestMapping("/")
    //public String index(Model model) {
        //List<Post> latest5Posts = postService.findLatest5();
        //model.addAttribute("latest5posts", latest5Posts);
        //List<Post> latest3Posts = latest5Posts.stream()
        //.limit(3).collect(Collectors.toList());
        //model.addAttribute("latest3posts", latest3Posts);
        //return "index";
    //}
//}

@Controller
public class IdBestellingVoegToeIdArtikelAantalController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AccountService accountservice;
    
    
    @Autowired
    private AccounttypeService accounttypeservice;
    
    @Autowired
    private ArtikelService artikelService;
    
    @Autowired
    private BestelArtikelService bestelArtikelService;
    
    @Autowired
    private BestellingService bestellingService;
    
    @Autowired
    private KlantService klantService;
    
    @Autowired 
    private CheckFormat checkFormat;
    
    @Autowired
    private NotificationService notifyService;
    
     @Autowired
    private IngelogdeGebruiker ingelogdeGebruiker;
    
    
    
    
    
    
    
@RequestMapping(value = "/idbestellingvoegtoeidartikelaantal", method = RequestMethod.GET)
    public String idBestellingVoegToeIdArtikelAantalGet() {
        return "/idbestellingvoegtoeidartikelaantal";
    }

    @RequestMapping(value = "/idbestellingvoegtoeidartikelaantal", method = RequestMethod.POST)
    //ublic String aanmakenAccounttypePost(Model model, HttpServletRequest request) {
    public String idBestellingVoegToeIdArtikelAantalPost(Model model, HttpServletRequest request){
        
        int idAccount = ingelogdeGebruiker.getIdAccountIngelogdeGebruiker();
        String idBestelling = request.getParameter("idBestelling");
        String idArtikel =  request.getParameter("idArtikel");
        String aantal =  request.getParameter("aantal");
        
        bestelArtikelService.create(Integer.parseInt(idBestelling), Integer.parseInt(idArtikel),Integer.parseInt(aantal),idAccount);
        
     

        return "answers/opdrachtuitgevoerd";
        
    }    
    
    
}










