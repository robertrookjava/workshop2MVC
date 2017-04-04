/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.controllers;

import blog.forms.LoginForm;
import blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import blog.services.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;


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
    
@RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexGet(Model model) {
        
        return "index";
    }
    
@RequestMapping(value = "/", method = RequestMethod.POST)
    public String indexPost(Model model) {
        
        return "index";
    }    
    
    
}










