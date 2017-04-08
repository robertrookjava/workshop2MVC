/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.controllers;

import blog.Exceptions.Exception1;
import blog.Exceptions.Exception2;
import blog.Exceptions.Exception3;
import blog.Exceptions.Exception4;
import blog.Exceptions.Exception5;
import blog.Exceptions.Exception6;
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
public class HomeController {
    
@RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexGet(Model model, HttpServletRequest request) {
        
        return "index";
    }
    
    /**
     *
     * @param model
     * @param request
     * @return
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
        
        if (invoer1.equals("")) throw new Exception();
        if (invoer1.equals("1")) throw new Exception1();
        if (invoer1.equals("2")) throw new Exception2();
        if (invoer1.equals("3")) throw new Exception3();
        if (invoer1.equals("4")) throw new Exception4();
        if (invoer1.equals("5")) throw new Exception5();
        if (invoer1.equals("6")) throw new Exception6();
        
        return "answers/answer1";
    }    
    
    
}










