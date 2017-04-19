/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;

import blog.Exceptions.*;
import blog.models.Bestelling;
import blog.repositories.*;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author robertrook
 */
@Service
public class BestellingServiceImpl implements BestellingService {
    
    @Autowired
    private BestellingRepository bestellingRepository;
    
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private KlantService klantService;
            
       
    
    
    

    @Override
    public int create(Bestelling bestelling) throws Exception {
        if (!klantService.exists(bestelling.getIdKlant())) throw new idKlantBestaatNiet();
        if (!accountService.exists(bestelling.getIdAccount())) throw new idAccountBestaatNiet();
        bestelling.setDatum_Bestelling(new Date());
        Bestelling save = bestellingRepository.save(bestelling);
        return save.getIdBestelling();
    }

    @Override
    public int create(int idKlant, int idAccount) throws Exception {
        Bestelling bestelling = new Bestelling();
        bestelling.setIdKlant(idKlant);
        bestelling.setIdAccount(idAccount);
        return (create(bestelling));
        
    }


    @Override
    public void delete(Bestelling bestelling) {
       delete(bestelling.getIdBestelling());
    }

    @Override
    public void delete(int idBestelling) {
        bestellingRepository.delete(idBestelling);
    }

    @Override
    public Bestelling read(Bestelling bestelling) {
        return read (bestelling.getIdBestelling());
    }

    @Override
    public Bestelling read(int idBestelling) {
        return bestellingRepository.findOne(idBestelling);
    }

    @Override
    public List<Bestelling> readAll() {
        return bestellingRepository.findAll();
    }

    @Override
    public boolean exists(Bestelling bestelling) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exists(int idBestelling) {
         return bestellingRepository.exists(idBestelling);
    }

    @Override
    public List<Bestelling> readByIdKlant(int idKlant) throws Exception {
        if (!klantService.exists(idKlant)) throw new idKlantBestaatNiet();
        return bestellingRepository.readByIdKlant(idKlant);
    }

    @Override
    public boolean existsByIdKlant(int idKlant) throws Exception {
        List<Bestelling> bestellingList = readByIdKlant(idKlant);
        return(!bestellingList.isEmpty());
    }

    @Override
    public List<Bestelling> readByIdKlantIdAccount(int idKlant, int idAccount) throws Exception {
        if (!klantService.exists(idKlant)) throw new idKlantBestaatNiet();
        if (!accountService.exists(idAccount)) throw new idAccountBestaatNiet();
        return bestellingRepository.readByIdKlantAndIdAccount(idKlant, idAccount);
    }

    @Override
    public boolean existsByIdKlantIdAccount(int idKlant, int idAccount) throws Exception {
        List<Bestelling> bestellingList = readByIdKlantIdAccount(idKlant,idAccount);
        boolean isEmpty = bestellingList.isEmpty();
        return !isEmpty;
    }

    @Override
    public List<Bestelling> readByIdAccount(int idAccount) {
       return bestellingRepository.readByIdAccount(idAccount);
    }

    

    
    
}
