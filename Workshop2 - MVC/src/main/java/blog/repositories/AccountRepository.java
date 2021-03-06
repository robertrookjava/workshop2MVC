/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.repositories;
import blog.models.Account;
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
public interface AccountRepository extends JpaRepository<Account, Integer> {
    List<Account> readByGebruikersnaamAndWachtwoord(String gebruikersnaam, String wachtwoord);
    List<Account> readByGebruikersnaam(String gebruikersnaam);
}
