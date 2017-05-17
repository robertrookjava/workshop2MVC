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
    public void create(BestelArtikel bestelArtikel){
        create (bestelArtikel.getIdBestelling(),bestelArtikel.getIdArtikel(),bestelArtikel.getAantal());
    }

    @Override
    public void create(int idBestelling, int idArtikel, int aantal){
        System.out.println("Robert 1: in create van bestelArtikel");
        if (!bestellingService.exists(idBestelling)) throw new idBestellingBestaatNiet();
        System.out.println("Robert 2: in create van bestelArtikel");
        if (!artikelService.exists(idArtikel)) throw new idArtikelBestaatNiet();
        System.out.println("Robert 3: in create van bestelArtikel");
        
      
        BestelArtikel bestelArtikel = new BestelArtikel();
        bestelArtikel.setIdBestelling(idBestelling);
        bestelArtikel.setIdArtikel(idArtikel);
        bestelArtikel.setAantal(aantal);
        artikelService.verlaagVoorraad(idArtikel, aantal);
        bestelArtikelRepository.save(bestelArtikel);
        System.out.println("Robert 4: in create van bestelArtikel");
        
        System.out.println("Robert 5: in create van bestelArtikel");
    }
    
    @Override
    public void create (int idBestelling, int idArtikel, int aantal, int idAccount){
        if (!bestellingService.isIdBestellingIdAccount(idBestelling, idAccount)) throw new idBestellingNietBijIngelogdeAccount();
        create (idBestelling, idArtikel, aantal);
    }

    @Override
    public void delete(BestelArtikel bestelArtikel){
        delete (bestelArtikel.getIdBestelling(), bestelArtikel.getIdArtikel());
    }

    @Override
    public void delete(int idBestelling, int idArtikel){
        if (!bestellingService.exists(idBestelling)) throw new idBestellingBestaatNiet();
        if (!artikelService.exists(idArtikel)) throw new idArtikelBestaatNiet();
        BestelArtikelPK bestelArtikelPK = new BestelArtikelPK();
        bestelArtikelPK.setIdBestelling(idBestelling);
        bestelArtikelPK.setIdArtikel(idArtikel);
        artikelService.verhoogVoorraad(idArtikel, aantal(idBestelling,idArtikel));
        bestelArtikelRepository.delete(bestelArtikelPK);
        
    }
    
    @Override
    public void delete(int idBestelling, int idArtikel, int idAccount){
        if (!bestellingService.isIdBestellingIdAccount(idBestelling, idAccount)) throw new idBestellingNietBijIngelogdeAccount();
        delete (idBestelling, idArtikel);
   
    }

    @Override
    public BestelArtikel read(BestelArtikel bestelArtikel) {
        return read (bestelArtikel.getIdBestelling(),bestelArtikel.getIdArtikel());
    }

    @Override
    public BestelArtikel read(int idBestelling, int idArtikel) {
        BestelArtikelPK bestelArtikelPK = new BestelArtikelPK();
        bestelArtikelPK.setIdBestelling(idBestelling);
        bestelArtikelPK.setIdArtikel(idArtikel);
        return bestelArtikelRepository.findOne(bestelArtikelPK);
    }

    @Override
    public List<BestelArtikel> readByIdBestelling(int idBestelling) {
        return bestelArtikelRepository.readByIdBestelling(idBestelling);
    }

    @Override
    public List<BestelArtikel> readByIdArtikel(int idArtikel) {
       return bestelArtikelRepository.readByIdArtikel(idArtikel);
    }

    @Override
    public boolean exists(BestelArtikel bestelArtikel) {     
        return exists (bestelArtikel.getIdBestelling(),bestelArtikel.getIdArtikel());
    }

    @Override
    public boolean exists(int idBestelling, int idArtikel) {
        BestelArtikelPK bestelArtikelPK = new BestelArtikelPK();
        bestelArtikelPK.setIdBestelling(idBestelling);
        bestelArtikelPK.setIdArtikel(idArtikel);
        return bestelArtikelRepository.exists(bestelArtikelPK);
    }

    @Override
    public boolean existsByIdBestelling(int idBestelling) {
        List<BestelArtikel> bestelArtikelList = readByIdBestelling (idBestelling);
        boolean isEmpty = bestelArtikelList.isEmpty();
        return !isEmpty;
    }

    @Override
    public boolean existsByIdArtikel(int idArtikel) {
       List<BestelArtikel> bestelArtikelList = readByIdArtikel (idArtikel);
       boolean isEmpty = bestelArtikelList.isEmpty();
       return !isEmpty;    
    }

    @Override
    public int aantal(int idBestelling, int idArtikel){
        BestelArtikel bestelArtikel = read(idBestelling, idArtikel);
        return bestelArtikel.getAantal();
    }

    
    
}
