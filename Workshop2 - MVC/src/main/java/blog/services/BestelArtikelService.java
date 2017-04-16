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
    void create (BestelArtikel bestelArtikel) throws Exception;
    void create (int idBestelling, int idArtikel, int aantal) throws Exception;
    
    void delete (BestelArtikel bestelArtikel) throws Exception;
    void delete (int idBestelling, int idArtikel)throws Exception;
    
    BestelArtikel read (BestelArtikel bestelArtikel) throws Exception;
    BestelArtikel read (int idBestelling, int idArtikel) throws Exception;
    
    List<BestelArtikel> readByIdBestelling (int idBestelling) throws Exception;
    List<BestelArtikel> readByIdArtikel (int idArtikel) throws Exception;
    
    int aantal (int idBestelling, int idArtikel) throws Exception;
    
    
    
    boolean exists(BestelArtikel bestelArtikel);
    boolean exists(int idBestelling, int idArtikel);
    
    boolean existsByIdBestelling (int idBestelling);
    boolean exsistsByIdArtikel (int idArtikel);
    
    
    
    
    
}
