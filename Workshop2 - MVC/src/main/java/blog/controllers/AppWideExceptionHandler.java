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
    
    @ExceptionHandler(Exception1.class)
    public String ExceptionHandler1 (){
        return "exceptions/exception1";
    }
    
    @ExceptionHandler(Exception2.class)
    public String ExceptionHandler2 (){
        return "exceptions/exception2";
    }
    
    @ExceptionHandler(Exception3.class)
    public String ExceptionHandler3 (){
        return "exceptions/exception3";
    }
    
    @ExceptionHandler(Exception4.class)
    public String ExceptionHandler4 (){
        return "exceptions/exception4";
    }
    
    @ExceptionHandler(Exception5.class)
    public String ExceptionHandler5 (){
        return "exceptions/exception5";
    }
    
    @ExceptionHandler(Exception6.class)
    public String ExceptionHandler6 (){
        return "exceptions/exception6";
    }
    
    
}
