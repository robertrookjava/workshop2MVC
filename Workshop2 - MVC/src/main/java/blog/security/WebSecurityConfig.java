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
    protected void configure(HttpSecurity http) throws Exception {
	http
	.csrf().disable();
}
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("Robert2: in Global");
        
        
        // even hardgecodeerd facken omdat het zoeken in de database niet lukt voordat je ingelogd bent omdat
        //@Autowired dan nog niet werkt waardoor ik mijn JPARepositories niet kan gebruiken
        auth.inMemoryAuthentication().
                withUser("Robert Rook").
                        password("Geheim").roles("USER").and()
                .withUser("Jeroen Rook").
                        password("Welkom").roles("User");

        // als @Autowired wel werkt dan onderstaande regel gebruiken
        //auth.userDetailsService(new UserDetailsServiceImpl());
       
        
    }
}
