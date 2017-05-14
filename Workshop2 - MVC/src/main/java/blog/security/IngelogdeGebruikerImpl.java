/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.security;

import blog.models.Account;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author robertrook
 */

@Component
public class IngelogdeGebruikerImpl implements IngelogdeGebruiker {
    
    @Autowired
    private UserService userService;
    
   

    @Override
    public String getGebruikersnaamIngelogdeGebruiker() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return name;
    }

    @Override
    public Account getIngelogdeGebruiker() {
        return userService.getAccount(getGebruikersnaamIngelogdeGebruiker());
    }

    @Override
    public int getIdAccountIngelogdeGebruiker() {
       return userService.getAccount(getGebruikersnaamIngelogdeGebruiker()).getIdAccount();
    }
    
}
