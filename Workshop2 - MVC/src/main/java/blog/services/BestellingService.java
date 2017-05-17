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
    int create (Bestelling bestelling);
    int create (int idKlant, int idAccount);
    
    // uitzoeken hoe return generated key bij JPA repositories
    
    void delete (Bestelling bestelling);
    void delete (int idBestelling);
    void delete (int idBestelling, int idAccount);
    
    Bestelling read (Bestelling bestelling);
    Bestelling read (int idBestelling);
    
    List<Bestelling> readAll();
    
    List<Bestelling> readByIdAccount(int idAccount);
    
    boolean exists (Bestelling bestelling);
    boolean exists (int idBestelling);
    
    List<Bestelling> readByIdKlant (int idKlant);
    boolean existsByIdKlant (int Klant);
    
    List<Bestelling> readByIdKlantIdAccount(int idKlant, int idAccount);
    boolean existsByIdKlantIdAccount (int idKlant, int idAccount);
    
    int getIdAccountVanIdBestelling (int idBestellint);
    boolean isIdBestellingIdAccount (int idBestelling, int idAccount);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
}
