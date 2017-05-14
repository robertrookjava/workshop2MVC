/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;
import blog.models.*;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author robertrook
 */
public interface BestellingService {
    int create (Bestelling bestelling) throws Exception;
    int create (int idKlant, int idAccount) throws Exception;
    
    // uitzoeken hoe return generated key bij JPA repositories
    
    void delete (Bestelling bestelling)throws Exception;
    void delete (int idBestelling)throws Exception;
    void delete (int idBestelling, int idAccount) throws Exception;
    
    Bestelling read (Bestelling bestelling)throws Exception;
    Bestelling read (int idBestelling)throws Exception;
    
    List<Bestelling> readAll();
    
    List<Bestelling> readByIdAccount(int idAccount);
    
    boolean exists (Bestelling bestelling);
    boolean exists (int idBestelling);
    
    List<Bestelling> readByIdKlant (int idKlant) throws Exception;
    boolean existsByIdKlant (int Klant) throws Exception;
    
    List<Bestelling> readByIdKlantIdAccount(int idKlant, int idAccount) throws Exception;
    boolean existsByIdKlantIdAccount (int idKlant, int idAccount) throws Exception;
    
    int getIdAccountVanIdBestelling (int idBestellint);
    boolean isIdBestellingIdAccount (int idBestelling, int idAccount);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
}
