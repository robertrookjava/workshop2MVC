/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;

import blog.Exceptions.*;
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
    
    @Autowired 
    private BestellingService bestellingService;

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
       delete (klant.getIdKlant());
    }

    @Override
    public void delete(int idKlant) throws Exception {
        if (!exists(idKlant)) throw new idKlantBestaatNiet();
        if (bestellingService.existsByIdKlant(idKlant)) throw new KlantHeeftBestellingen();
        klantRepository.delete(idKlant);
    }

    @Override
    public Klant read(Klant klant) throws Exception{
         return read (klant.getIdKlant());
    }

    @Override
    public Klant read(int idKlant) throws Exception {
        if (!exists(idKlant)) throw new idKlantBestaatNiet();
        return klantRepository.findOne(idKlant);
    }

    @Override
    public List<Klant> read(String achternaam) {
        return klantRepository.readByAchternaam(achternaam);
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
       List <Klant> klantList = read(achternaam);
        boolean isEmpty = klantList.isEmpty();
        return !isEmpty;
    }

    @Override
    public List<Klant> readAll() {
       return klantRepository.findAll();
    }

    @Override
    public void update(Klant klant) throws Exception {
       if (!exists(klant.getIdKlant())) throw new idKlantBestaatNiet();
       if (klant.getVoornaam().isEmpty()) throw new KlantVoornaamLeeg();
       if (klant.getAchternaam().isEmpty()) throw new KlantAchternaamLeeg();
       if (!checkFormat.isEmailAdresOfLeeg((klant.getEmailadres()))) throw new EmailadresOngeldig();
       Klant klantFound = klantRepository.findOne(klant.getIdKlant());
       klantFound.setVoornaam(klant.getVoornaam());
       klantFound.setAchternaam(klant.getAchternaam());
       klantFound.setTussenvoegsel(klant.getTussenvoegsel());
       klantFound.setTelefoonnummer(klant.getTelefoonnummer());
       klantFound.setEmailadres(klant.getEmailadres());
       klantRepository.save(klantFound);
       
    }

    @Override
    public void update(int idKlant, String voornaam, String achternaam, String tussenvoegsel, String telefoonnummer, String emailadres) throws Exception {
        Klant klant = new Klant();
        klant.setIdKlant(idKlant);
        klant.setVoornaam(voornaam);
        klant.setAchternaam(achternaam);
        klant.setTussenvoegsel(tussenvoegsel);
        klant.setTelefoonnummer(telefoonnummer);
        klant.setEmailadres(emailadres);
        update(klant);
    }

    
    
}
