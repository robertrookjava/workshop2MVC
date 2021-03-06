/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author robertrook
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    // even tijdelijk omdat @Autowired niet schijnt te werken.
    //private UserFinder userFinder = new UserFinderImpl();
    
    @Autowired
    private UserFinder userFinder;
    
    public String getGebruikersnaamIngelogdeGebruiker(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        return name;
    }
    
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //User user = this.findByUserName(username);
        System.out.println("Robert1, in loadUserByUsername");
        System.out.println(userFinder==null);
        User user = userFinder.findByUserName(username);
        System.out.println("Robert2: username "+ user.getUsername());
        System.out.println("Robert3: password "+ user.getPassword());
        if (user!=null){
            System.out.println("Robert4: user gevonden");
            return user;
        }
        throw new UsernameNotFoundException(
                "User "+username+" not found"
        );
    }
    
    
}
