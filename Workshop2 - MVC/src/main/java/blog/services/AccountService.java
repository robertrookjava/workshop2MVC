/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;
import blog.models.*;
import java.util.List;

/**
 *
 * @author robertrook
 */
public interface AccountService {
    void create (Account account);
    Account read (Account account);
    boolean exists (Account account);
    boolean exists (int idAccount);
    boolean exists (String gebruikersnaam, String password);
    
    
}
