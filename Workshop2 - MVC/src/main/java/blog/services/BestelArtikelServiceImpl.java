/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;
import blog.models.*;
import blog.repositories.BestelArtikelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import blog.Exceptions.*;

/**
 *
 * @author robertrook
 */
@Service
public class BestelArtikelServiceImpl implements BestelArtikelService{
    
    @Autowired
    private BestelArtikelRepository bestelArtikelRepository;
    
    @Autowired
    private BestellingService bestellingService;
    
    @Autowired
    private ArtikelService artikelService;
    
    
    
    
    
    
    
    

    @Override
    public void create(BestelArtikel bestelArtikel) throws Exception {
        create (bestelArtikel.getIdBestelling(),bestelArtikel.getIdArtikel(),bestelArtikel.getAantal());
    }

    @Override
    public void create(int idBestelling, int idArtikel, int aantal) throws Exception {
        if (!bestellingService.exists(idBestelling)) throw new idBestellingBestaatNiet();
        if (!artikelService.exists(idArtikel)) throw new idArtikelBestaatNiet();
        artikelService.verlaagVoorraad(idArtikel, aantal);
        BestelArtikel bestelArtikel = new BestelArtikel();
        
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        bestelArtikel.setAantal(aantal);
        bestelArtikelRepository.save(bestelArtikel);
    }

    @Override
    public void delete(BestelArtikel bestelArtikel) throws Exception{
        
    }

    @Override
    public void delete(int idBestelling, int idArtikel) throws Exception{
        
        
    }

    @Override
    public BestelArtikel read(BestelArtikel bestelArtikel) {
        return read (bestelArtikel.getIdBestelling(),bestelArtikel.getIdArtikel());
    }

    @Override
    public BestelArtikel read(int idBestelling, int idArtikel) {
        BestelArtikelPK bestelArtikelPK = new BestelArtikelPK();
        bestelArtikelPK.setIdBestelling(idBestelling);
        bestelArtikelPK.setIdBestelling(idBestelling);
        return bestelArtikelRepository.findOne(bestelArtikelPK);
    }

    @Override
    public List<BestelArtikel> readByIdBestelling(int idBestelling) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BestelArtikel> readByIdArtikel(int idArtikel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(BestelArtikel bestelArtikel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(int idBestelling, int idArtikel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsByIdBestelling(int idBestelling) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exsistsByIdArtikel(int idArtikel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
