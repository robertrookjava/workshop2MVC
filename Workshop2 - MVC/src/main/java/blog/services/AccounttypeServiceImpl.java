/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;
import blog.models.*;
import blog.repositories.AccounttypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author robertrook
 */
@Service
public class AccounttypeServiceImpl implements AccounttypeService {
    
    @Autowired
    private AccounttypeRepository accounttypeRepository;
    

    @Override
    public void create(Accounttype accounttype) {
        this.accounttypeRepository.save(accounttype);
    }

    @Override
    public void create(int id, String type) {
        Accounttype accounttype = new Accounttype();
        accounttype.setId(id);
        accounttype.setTYpe(type);
        this.accounttypeRepository.save(accounttype);
    }

    @Override
    public Accounttype read(int id) {
        return this.accounttypeRepository.findOne(id);
    }

    @Override
    public boolean exists(int id) {
        return this.accounttypeRepository.exists(id);
    }

    @Override
    public List<Accounttype> read(String type) {
        return this.accounttypeRepository.readByType(type);
    }

    @Override
    public boolean exists(String type) {
        List<Accounttype> accounttypeList = read(type);
        boolean isEmpty = accounttypeList.isEmpty();
        return !isEmpty;
        
    }
    
}
