/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.format;

import java.math.BigDecimal;
import org.apache.commons.validator.routines.*;
import org.springframework.stereotype.Component;

/**
 *
 * @author robertrook
 */
@Component
public class CheckFormatImpl implements CheckFormat {
    
    @Override
    public boolean isInteger (String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
   
    
    @Override
    public boolean isBigDecimal (String str) {
        try {
            BigDecimal bigdecimal = new BigDecimal (str);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
     
    /*public static Integer isInteger (String str) {
        IntegerValidator validator = IntegerValidator.getInstance();
        Integer fooInteger = validator.validate(str );
        return fooInteger;
    }
*/
    
    /*public static boolean isBigDecimal (String str) {
     
        BigDecimalValidator validator = BigDecimalValidator.getInstance();
        BigDecimal fooBigDecimal = validator.validate(str );
        return (fooBigDecimal != null);
       
    }
*/
    
    @Override
    public boolean isEmailAdres (String str){
        EmailValidator validator = EmailValidator.getInstance();
        return (validator.isValid(str));
    }

    @Override
    public boolean isEmailAdresOfLeeg(String str) {
        return ((str.isEmpty())|| isEmailAdres(str));
    }
    
   
    
}
