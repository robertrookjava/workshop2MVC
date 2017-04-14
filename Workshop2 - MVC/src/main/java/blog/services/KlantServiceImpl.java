/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;

import blog.Exceptions.EmailadresOngeldig;
import blog.Exceptions.KlantAchternaamLeeg;
import blog.Exceptions.KlantVoornaamLeeg;
import blog.format.CheckFormat;
import blog.models.Klant;
import blog.repositories.KlantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author robertrook
 */
@Service
public class KlantServiceImpl implements KlantService {
    
    @Autowired
    private KlantRepository klantRepository;
    
    @Autowired 
    private CheckFormat checkFormat;

    @Override
    public void create(Klant klant) throws Exception {
        if (klant.getVoornaam().isEmpty()) throw new KlantVoornaamLeeg();
        if (klant.getAchternaam().isEmpty()) throw new KlantAchternaamLeeg();
        if (!checkFormat.isEmailAdresOfLeeg((klant.getEmailadres()))) throw new EmailadresOngeldig();
        klantRepository.save(klant);
        
        
    }

    @Override
    public void create(String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres) throws Exception {
        Klant klant = new Klant();
        klant.setVoornaam(voornaam);
        klant.setAchternaam(achternaam);
        klant.setTussenvoegsel(tussenvoegsel);
        klant.setTelefoonnummer(telefoonnummer);
        klant.setEmailadres(emailadres);
        create (klant);
        
    }

    @Override
    public void delete(Klant klant) throws Exception {
       klantRepository.delete(klant);
    }

    @Override
    public void delete(int idKlant) throws Exception {
        klantRepository.delete(idKlant);
    }

    @Override
    public Klant read(Klant klant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Klant read(int idKlant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Klant> read(String achternaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(Klant klant) {
        return exists (klant.getIdKlant());
    }

    @Override
    public Boolean exists(int idKlant) {
        return klantRepository.exists(idKlant);
    }

    @Override
    public Boolean exists(String achternaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Klant> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Klant klant) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(int idKlant, String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
