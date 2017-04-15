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
public interface ArtikelService {
    
    void create(Artikel artikel) throws Exception;
    void create (String naam, BigDecimal prijs, int voorraad) throws Exception;
    
    void delete (Artikel artikel) throws Exception;
    void delete (int idArtikel) throws Exception;
    
    Artikel read (Artikel artikel);
    Artikel read (int idArtikel);
    public List<Artikel> read (String naam);
    
    List<Artikel> readAll();
    
    boolean exists (Artikel artikel);
    boolean exists (int idArtikel);
    boolean exists (String naam);
    
    void update (Artikel artikel) throws Exception;
    void update (int idArtikel, String naam, BigDecimal prijs, int Voorraad) throws Exception;
    
    void verhoogVoorraad (int idArtikel, int verhoog) throws Exception;
    void verlaagVoorraad (int idArtikel, int verlaag) throws Exception;
    
    
    
}
