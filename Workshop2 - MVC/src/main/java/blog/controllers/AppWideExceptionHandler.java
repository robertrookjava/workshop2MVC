/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.controllers;
import blog.Exceptions.*;
import blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import blog.services.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author robertrook
 */
@ControllerAdvice
public class AppWideExceptionHandler {
    
    @ExceptionHandler(Exception.class)
    public String generalExceptionHandler(){
        return "exceptions/exception";
    }
    
    @ExceptionHandler(VoorraadNegatief.class)
    public String ExceptionHandler1 (){
        return "exceptions/vooraadNegatief";
    }
    
    @ExceptionHandler(ArtikelnaamLeeg.class)
    public String ExceptionHandler2 (){
        return "exceptions/artikelnaamLeeg";
    }
    
    @ExceptionHandler(ArtikelprijsNegatief.class)
    public String ExceptionHandler3 (){
        return "exceptions/artikelprijsNegatief";
    }
    
    @ExceptionHandler(KlantAchternaamLeeg.class)
    public String ExceptionHandler4 (){
        return "exceptions/klantAchternaamLeeg";
    }
    
    @ExceptionHandler(KlantVoornaamLeeg.class)
    public String ExceptionHandler5 (){
        return "exceptions/klantVoornaamLeeg";
    }
    
    @ExceptionHandler(EmailadresOngeldig.class)
    public String ExceptionHandler6 (){
        return "exceptions/emailadresOngeldig";
    }
    
    
    @ExceptionHandler(ArtikelInBestellingen.class)
    public String ExceptionHandler7 (){
        return "exceptions/artikelInBestellingen";
    }
    
    @ExceptionHandler(KlantHeeftBestellingen.class)
    public String ExceptionHandler8 (){
        return "exceptions/klantHeeftBestellingen";
    }
       
    
    @ExceptionHandler(NietGeheel.class)
    public String ExceptionHandler10 (){
        return "exceptions/nietGeheel";
    }
    
    @ExceptionHandler(NietNumeriek.class)
    public String ExceptionHandler11 (){
        return "exceptions/nietNumeriek";
    }
    
    @ExceptionHandler(idKlantBestaatNiet.class)
    public String ExceptionHandler12 (){
        return "exceptions/idKlantBestaatNiet";
    }
    
    @ExceptionHandler(idAccountBestaatNiet.class)
    public String ExceptionHandler13 (){
        return "exceptions/idAccountBestaatNiet";
    }
    
    @ExceptionHandler(idAccounttypeBestaatNiet.class)
    public String ExceptionHandler14 (){
        return "exceptions/idAccounttypeBestaatNiet";
    }
    
    @ExceptionHandler(idArtikelBestaatNiet.class)
    public String ExceptionHandler15 (){
        return "exceptions/idArtikelBestaatNiet";
    }
    
    @ExceptionHandler(idBestellingNietBijIngelogdeAccount.class)
    public String ExceptionHandler16 (){
        return "exceptions/idBestellingNietBijIngelogdeAccount";
    }
    
    @ExceptionHandler(idBestellingBestaatNiet.class)
    public String ExceptionHandler17 (){
        return "exceptions/idBestellingBestaatNiet";
    }
    
    
    
}
