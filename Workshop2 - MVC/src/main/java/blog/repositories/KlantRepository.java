/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.repositories;
import blog.models.Klant;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author robertrook
 */
@Repository
public interface KlantRepository extends JpaRepository<Klant, Integer> {
    List<Klant> readByAchternaam(String naam);
}
