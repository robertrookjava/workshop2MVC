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
    void create (int idAccount, String gebruikersnaam, String wachtwoord, int accountype_id);
    Account read (int idAccount);
    Account read (Account account);
    List<Account> read (String gebruikersnaam, String password);
    boolean exists (Account account);
    boolean exists (int idAccount);
    boolean exists (String gebruikersnaam, String password);
    
    
}
