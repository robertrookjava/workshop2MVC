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
public class HomeController4 {
    
@RequestMapping(value = "/index4", method = RequestMethod.GET)
    public String indexGet(Model model, HttpServletRequest request) {
        
        return "index4";
    }
    
    /**
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String indexPost(Model model, HttpServletRequest request) {
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
        
        return "output4";
    }    
    
    
}










