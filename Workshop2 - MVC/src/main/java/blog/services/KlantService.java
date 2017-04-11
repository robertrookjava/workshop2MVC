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
public interface KlantService {
    void create (Klant klant);
    void create (String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres);
    
    void delete (Klant klant);
    void delete (int idKlant);
    
    Klant read (Klant klant);
    Klant read (int idKlant);
    List<Klant> read (String achternaam);
    
    
    Boolean exists (Klant klant);
    Boolean exists (int idKlant);
    Boolean exists (String achternaam);
    
    List <Klant> readAll();
    
    void update (Klant klant);
    void update (int idKlant, String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres);
    
    
    
    
    
    
    
}
