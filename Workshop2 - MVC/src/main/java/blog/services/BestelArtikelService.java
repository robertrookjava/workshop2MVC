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
public interface BestelArtikelService {
    void create (BestelArtikel bestelArtikel);
    void create (int idBestelling, int idArtikel, int aantal);
    void create (int bestelling, int idartikel, int aantal, int idAccount);
    
    void delete (BestelArtikel bestelArtikel);
    void delete (int idBestelling, int idArtikel);
    void delete (int idBestelling, int idArtikel, int idAccount);
    
    BestelArtikel read (BestelArtikel bestelArtikel);
    BestelArtikel read (int idBestelling, int idArtikel);
    
    List<BestelArtikel> readByIdBestelling (int idBestelling);
    List<BestelArtikel> readByIdArtikel (int idArtikel);
    
    int aantal (int idBestelling, int idArtikel);
    
    
    
    boolean exists(BestelArtikel bestelArtikel);
    boolean exists(int idBestelling, int idArtikel);
    
    boolean existsByIdBestelling (int idBestelling);
    boolean existsByIdArtikel (int idArtikel);
    
    
    
    
    
}
