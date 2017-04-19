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
import blog.forms.LoginForm;
import blog.models.Account;
import blog.models.Accounttype;
import blog.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import blog.services.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
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
public class HomeController {
    
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
    
    
    
    
    
    
    
@RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexGet(Model model, HttpServletRequest request) {
        
        return "index";
    }
    
    /**
     *
     * @param model
     * @param request
     * @return
     * @throws java.lang.Exception
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String indexPost(Model model, HttpServletRequest request) throws Exception {
        String invoer1 = request.getParameter("invoer1");
        String invoer2 = request.getParameter("invoer2");
        String invoer3 = request.getParameter("invoer3");
        String invoer4 = request.getParameter("invoer4");
        String invoer5 = request.getParameter("invoer5");
        String invoer6 = request.getParameter("invoer6");
        
        
        
        System.out.println("invoer1 = " + invoer1);
        System.out.println("invoer2 = " + invoer2);
        System.out.println("invoer3 = " + invoer3);
        System.out.println("invoer4 = " + invoer4);
        System.out.println("invoer5 = " + invoer5);
        System.out.println("invoer6 = " + invoer6);
        
        
        
        
        
        
        //List <Account> accountList = accountservice.read(invoer1, invoer2);
        //for(Account temp: accountList){
        //    System.out.println(temp.getIdAccount());
        //}
        //accountservice.create(Integer.parseInt(invoer1),invoer2,invoer3,Integer.parseInt(invoer4));
        
        //artikelService.update(Integer.parseInt(invoer4),invoer1, new BigDecimal(invoer2), Integer.parseInt(invoer3));
       //Boolean exists = accountservice.exists(invoer1,invoer2);
       //System.out.println (exists);
       
       //boolean b1 = checkFormat.isInteger(invoer1);
       //boolean b2 = checkFormat.isBigDecimal(invoer2);
       //boolean b3 = checkFormat.isEmailAdresOfLeeg(invoer3);
       
       
       //if (!b1) throw new NietGeheel();
       //if (!b2) throw new NietNumeriek();
       //if (!b3) throw new EmailadresOngeldig();
       
       //artikelService.create(invoer1, new BigDecimal(invoer2), Integer.parseInt(invoer3));
       //artikelService.delete(Integer.parseInt(invoer1))
       //boolean exists = artikelService.exists(Integer.parseInt(invoer1));
       // boolean exists =artikelService.exists(invoer1);
       
       //artikelService.update(Integer.parseInt(invoer1), invoer2, new BigDecimal(invoer3), Integer.parseInt(invoer4));
       //klantService.create(invoer1, invoer2, invoer3, invoer4, invoer5);
       //Klant klant = klantService.read(Integer.parseInt(invoer1));
       //Boolean exists = klantService.exists(invoer1);
       
       //klantService.update(Integer.parseInt(invoer1), invoer2, invoer3, invoer4, invoer5, invoer6);
  
       //bestellingService.create(Integer.parseInt(invoer1), Integer.parseInt(invoer2) );
       //bestellingService.delete(Integer.parseInt(invoer1));
      //Bestelling bestelling = bestellingService.read(Integer.parseInt(invoer1));
       //System.out.println(bestelling.getIdKlant());
      //List <Bestelling> bestellingList = bestellingService.readByIdKlantIdAccount(Integer.parseInt(invoer1), Integer.parseInt(invoer2));
      //List <Bestelling> bestellingList = bestellingService.readByIdAccount(Integer.parseInt(invoer1));
      // for (Bestelling bestelling:bestellingList){
      //     System.out.println(bestelling.getIdBestelling());
      // }
      //int idBestelling = bestellingService.create(Integer.parseInt(invoer1), Integer.parseInt(invoer2) 
      //bestelArtikelService.create(Integer.parseInt(invoer1), Integer.parseInt(invoer2), Integer.parseInt(invoer3));
      //bestelArtikelService.delete(Integer.parseInt(invoer1), Integer.parseInt(invoer2));
      //BestelArtikel bestelArtikel = bestelArtikelService.read(Integer.parseInt(invoer1), Integer.parseInt(invoer2));
      //List<BestelArtikel> bestelArtikelList = bestelArtikelService.readByIdArtikel(Integer.parseInt(invoer1));
      //for (BestelArtikel bestelArtikel:bestelArtikelList){
      //     System.out.println(bestelArtikel.getIdBestelling());
      // }
      //System.out.println(bestelArtikel.getAantal());
     
     int idAccount = userService.idAccount(invoer1, invoer2);
     
      
    
      System.out.println(idAccount);
       
        
        return "answers/answer1";
    }    
    
    
}










