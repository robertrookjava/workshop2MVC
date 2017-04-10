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
    
    void create(Artikel artikel);
    void create (String naam, BigDecimal prijs, int voorraad);
    
    void delete (Artikel artikel);
    void delete (int idArtikel);
    
    void read (Artikel artikel);
    void read (int idArtikel);
    public List<Artikel> read (String naam);
    
    List<Artikel> readAll();
    
    boolean exists (Artikel artikel);
    boolean exists (int idArtikel);
    boolean exists (String naam);
    
    void update (Artikel artikel);
    void update (int idArtikel, String naam, BigDecimal prijs, int Voorraad);
    
    
    
    
    
}
