/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.security;
import blog.models.*;
import blog.repositories.AccounttypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author robertrook
 */
public interface IngelogdeGebruiker {
    
    String getGebruikersnaamIngelogdeGebruiker();
    Account getIngelogdeGebruiker();
    int getIdAccountIngelogdeGebruiker();
    
}
