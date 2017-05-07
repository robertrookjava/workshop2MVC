/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.security;

import blog.services.UserService;
import blog.services.UserServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author robertrook
 */
@Component
public class UserFinderImpl implements UserFinder {
    
    @Autowired
    private UserService userService;

    @Override
    public User findByUserName (String username){
        if (username.equals("admin")){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            String password = "admin";
            System.out.println("Hallo in FindByUserName, User gevonden");
            return new User(username,password,authorities); 
            
        }
        else {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            System.out.println("Robert5: username = "+ username);
            String password =userService.getPassword(username);
            System.out.println("Robert7: password = "+ password);
            return new User(username,password,authorities); 
            
        }
      
    }
    
}
