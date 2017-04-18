/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;
import blog.Exceptions.*;
import blog.Exceptions.ArtikelnaamLeeg;
import blog.Exceptions.ArtikelprijsNegatief;
import blog.Exceptions.VoorraadNegatief;
import blog.models.*;
import blog.repositories.ArtikelRepository;
import blog.repositories.BestelArtikelRepository;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author robertrook
 */
@Service
public class ArtikelServiceImpl implements ArtikelService {
    
    @Autowired
    private ArtikelRepository artikelRepository;
    
    @Autowired
    private BestelArtikelService bestelArtikelService;
    
    @Autowired
    private BestelArtikelRepository bestelArtikelRepository;
    
    

    @Override
    public void create(Artikel artikel) throws Exception {
       if (artikel.getVoorraad()<0) throw new VoorraadNegatief(); 
       if (artikel.getNaam().isEmpty()) throw new ArtikelnaamLeeg();
       if (artikel.getPrijs().signum()== - 1) throw new ArtikelprijsNegatief();
       artikelRepository.save(artikel);
    }

    @Override
    public void create(String naam, BigDecimal prijs, int voorraad) throws Exception {
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        artikel.setPrijs(prijs);
        artikel.setVoorraad(voorraad);
        create(artikel);
    }

    @Override
    public void delete(Artikel artikel) throws Exception {
        delete (artikel.getIdArtikel());
    }

    @Override
    public void delete(int idArtikel) throws Exception {
        if (!exists(idArtikel)) throw new idArtikelBestaatNiet();
        if (bestelArtikelService.existsByIdArtikel(idArtikel)) throw new ArtikelInBestellingen();
        artikelRepository.delete(idArtikel);
    }

    @Override
    public Artikel read(Artikel artikel) {
        return artikelRepository.findOne(artikel.getIdArtikel());
    }

    @Override
    public Artikel read(int idArtikel) {
       return artikelRepository.findOne(idArtikel);
    }

    @Override
    public List<Artikel> read(String naam) {
        return artikelRepository.readByNaam(naam);
    }

    @Override
    public List<Artikel> readAll() {
        return artikelRepository.findAll();
    }

    @Override
    public boolean exists(Artikel artikel) {
        return artikelRepository.exists(artikel.getIdArtikel());
    }

    @Override
    public boolean exists(int idArtikel) {
        return artikelRepository.exists(idArtikel);
    }

    @Override
    public boolean exists(String naam) {
        List <Artikel> artikelList = read(naam);
        boolean isEmpty = artikelList.isEmpty();
        return !isEmpty;
    }

    @Override
    public void update(Artikel artikel) throws Exception{
        if (!exists(artikel.getIdArtikel())) throw new idArtikelBestaatNiet();
        if (artikel.getVoorraad()<0) throw new VoorraadNegatief(); 
        if (artikel.getNaam().isEmpty()) throw new ArtikelnaamLeeg();
        if (artikel.getPrijs().signum()== - 1) throw new ArtikelprijsNegatief();
        Artikel artikelFound = artikelRepository.findOne(artikel.getIdArtikel());
        artikelFound.setNaam(artikel.getNaam());
        artikelFound.setPrijs(artikel.getPrijs());
        artikelFound.setVoorraad(artikel.getVoorraad());
        artikelRepository.save(artikelFound);
    }

    @Override
    public void update(int idArtikel, String naam, BigDecimal prijs, int Voorraad)  throws Exception {
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        artikel.setNaam(naam);
        artikel.setPrijs(prijs);
        artikel.setVoorraad(Voorraad);
        update(artikel);
    }

    @Override
    public void verhoogVoorraad(int idArtikel, int verhoog) throws Exception {
        Artikel artikelFound = artikelRepository.findOne(idArtikel);
        if ((artikelFound.getVoorraad()+verhoog) <0) throw new VoorraadNegatief(); 
        artikelFound.setVoorraad(artikelFound.getVoorraad()+verhoog);
        update (artikelFound);
        
    }

    @Override
    public void verlaagVoorraad(int idArtikel, int verlaag) throws Exception {
       verhoogVoorraad (idArtikel, -verlaag);
    }
    
    
}
