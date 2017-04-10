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
    int create (int idKlant);
    // uitzoeken hoe return generated key bij JPA repositories
    
    void delete (Bestelling bestelling);
    void delete (int idBestelling);
    
    Bestelling read (Bestelling bestelling);
    Bestelling read (int idBestelling);
    
    List<Bestelling> readAll();
    
    boolean exists (Bestelling bestelling);
    boolean exists (int idBestelling);
    
    List<Bestelling> readByIdKlant (int idKlant);
    boolean existsByIdKlant (int Klant);
    
    void update (Bestelling bestelling);
    void update (int idBestelling, int idKlant, int idAccount);
    void update (int idBestelling, int idKlant);
    
    
    
    
    
    
    
    
    
    
    
    
    

    
}
