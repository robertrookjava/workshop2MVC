/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.format;

/**
 *
 * @author robertrook
 */
public interface CheckFormat {
    
    boolean isInteger (String str);
    boolean isBigDecimal (String str);
    boolean isEmailAdres (String str);
    
    
}
