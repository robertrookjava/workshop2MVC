/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.controllers;

import blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import blog.services.*;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author robertrook
 */
@Controller
public class PostsController {
    @Autowired
    private PostService postService;
    
    @Autowired
        private NotificationService notifyService;
      
    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        Post post = postService.findById(id);
        if (post == null) {
                notifyService.addErrorMessage("Cannot find post #" + id);
                return "redirect:/";
            }
        model.addAttribute("post", post);
        return "posts/view";
    }
}
