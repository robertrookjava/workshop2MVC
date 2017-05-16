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
import java.util.ArrayList;
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
public class ToonBestellingenVanIdKlantController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AccountService accountservice;
    
    @Autowired
    private IngelogdeGebruiker ingelogdeGebruiker;
    
    
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
    
    
    
    
    
    
    
@RequestMapping(value = "/toonbestellingenvanidklant", method = RequestMethod.GET)
    public String toonBestellingenVanIdKlantGet() {
        return "toonbestellingenvanidklant";
    }

    @RequestMapping(value = "/toonbestellingenvanidklant", method = RequestMethod.POST)
    //ublic String aanmakenAccounttypePost(Model model, HttpServletRequest request) {
    public String toonBestellingenVanIdKlantPost(Model model, HttpServletRequest request) throws Exception {
        
        String idKlant = request.getParameter("idKlant");
        int idAccount = ingelogdeGebruiker.getIdAccountIngelogdeGebruiker();
        List<String> antwoord = new ArrayList<String>();

      
        //klantService.create(voornaam, achternaam, tussenvoegsel, telefoonnummer, emailadres);
        Klant klant= klantService.read(Integer.parseInt(idKlant));
        System.out.println("idKlant: " + klant.getIdKlant());
        System.out.println("voornaam: " +klant.getVoornaam());
        System.out.println("achternaam: "+klant.getAchternaam());
        System.out.println("tussenvoegsel: "+klant.getTussenvoegsel());
        System.out.println("telefoonnummer: "+klant.getTelefoonnummer());
        System.out.println("emailadres: "+ klant.getEmailadres());
        System.out.println("******************************");
        System.out.println("");
        
        antwoord.add("idKlant: " + klant.getIdKlant());
        antwoord.add("voornaam: " +klant.getVoornaam());
        antwoord.add("achternaam: "+klant.getAchternaam());
        antwoord.add("tussenvoegsel: "+klant.getTussenvoegsel());
        antwoord.add("telefoonnummer: "+klant.getTelefoonnummer());
        antwoord.add("emailadres: "+ klant.getEmailadres());
        antwoord.add("******************************");
        antwoord.add("");
        
        
        // nodig zijn de volgende methoden:
        //
        List<Bestelling> bestellingList = bestellingService.readByIdKlantIdAccount(Integer.parseInt(idKlant),idAccount);
        for (Bestelling bestelling:bestellingList){
            // gegevens...... bestelling.getIdBestelling();
            System.out.println ("idBestelling :"+ bestelling.getIdBestelling());
            System.out.println("");
            antwoord.add("idBestelling :"+ bestelling.getIdBestelling());
            antwoord.add("");
            
            List<BestelArtikel> bestelArtikelList = bestelArtikelService.readByIdBestelling(bestelling.getIdBestelling());
            for (BestelArtikel bestelArtikel:bestelArtikelList){
                // gegevens........bestelArtikel.getidArtikel
                // gegevens .......naam van dit artikel
                
                // gegevens .............bestelArtikel.getAantal();
                // ******************************************
                
                Artikel artikel = artikelService.read(bestelArtikel.getIdArtikel());
                System.out.println("idArtikel: "+ artikel.getIdArtikel());
                System.out.println("naam: "+ artikel.getNaam());
                System.out.println("prijs: "+ artikel.getPrijs());
                System.out.println("voorraad " + artikel.getVoorraad());
                System.out.println("************************");
                
                antwoord.add("idArtikel: "+ artikel.getIdArtikel());
                antwoord.add("naam: "+ artikel.getNaam());
                antwoord.add("prijs: "+ artikel.getPrijs());
                antwoord.add("voorraad " + artikel.getVoorraad());
                antwoord.add("************************");
                
            }
        }
        
        model.addAttribute("antwoord", antwoord);
        // 
        // bestellingService.existsByIdKlantIdAccount(idKlant, idAccoun);
        // bestelArtikelService.readByIdBestelling(idBestelling); list<BestelArtikel>
        //  if (!bestellingService.isIdBestellingIdAccount(idBestelling, idAccount))
        
        
        //accounttypeservice.create(Integer.parseInt(id), type);
        //saccountservice.create(Integer.parseInt(idAccount), gebruikersnaam, wachtwoord, Integer.parseInt(accounttype_id));
        return "answers/toonbestellingen";
        
    }    
    
    
}










