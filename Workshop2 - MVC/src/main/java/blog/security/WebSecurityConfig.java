package blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login/login")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll();
//    }

    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("Robert2: in Global");
        //auth.inMemoryAuthentication().withUser("Robert").password("Rook").roles("USER");
//       auth
//            .inMemoryAuthentication()
//                .withUser("Robert").password("Rook").roles("USER");
        // tijdelijk even met in memory authentication om configureGlobal te testen
        auth.userDetailsService(new UserDetailsServiceImpl());
       
        
    }
}
