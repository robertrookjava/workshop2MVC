/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;
import blog.models.*;
import blog.repositories.ArtikelRepository;
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
    
    

    @Override
    public void create(Artikel artikel) {
       artikelRepository.save(artikel);
    }

    @Override
    public void create(String naam, BigDecimal prijs, int voorraad) {
        Artikel artikel = new Artikel();
        artikel.setNaam(naam);
        artikel.setPrijs(prijs);
        artikel.setVoorraad(voorraad);
        create(artikel);
    }

    @Override
    public void delete(Artikel artikel) {
        artikelRepository.delete(artikel);
    }

    @Override
    public void delete(int idArtikel) {
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
    public void update(Artikel artikel) {
        artikelRepository.save(artikel);
    }

    @Override
    public void update(int idArtikel, String naam, BigDecimal prijs, int Voorraad) {
        Artikel artikel = new Artikel();
        artikel.setIdArtikel(idArtikel);
        artikel.setNaam(naam);
        artikel.setPrijs(prijs);
        artikel.setVoorraad(Voorraad);
        artikelRepository.save(artikel);
    }
    
}
