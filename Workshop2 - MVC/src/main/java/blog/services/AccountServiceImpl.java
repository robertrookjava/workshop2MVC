/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;
import blog.models.Account;
import blog.repositories.*;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import blog.Exceptions.*;

/**
 *
 * @author robertrook
 */
@Service
public class AccountServiceImpl implements AccountService{
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private AccounttypeRepository accounttypeRepository;

    @Override
    public void create(Account account){
        if (!accounttypeRepository.exists(account.getAccountype_id())) throw new idAccounttypeBestaatNiet();
        account.setDatum_Aanmaak(new Date());
        this.accountRepository.save(account);
     
    }
    
    @Override
    public void create(int idAccount, String gebruikersnaam, String wachtwoord, int accountype_id) {
       Account account = new Account();
       account.setIdAccount(idAccount);
       account.setGebruikersnaam(gebruikersnaam);
       account.setWachtwoord(wachtwoord);
       account.setAccountype_id(accountype_id);
       create(account);
       
       
    }

    
    @Override
    public Account read(int idAccount) {
       return this.accountRepository.findOne(idAccount); 
    }

    @Override
    public Account read(Account account) {
        return this.accountRepository.findOne(account.getIdAccount());
    }
    
    @Override
    public List<Account> read(String gebruikersnaam, String wachtwoord) {
         return this.accountRepository.readByGebruikersnaamAndWachtwoord(gebruikersnaam, wachtwoord);
    }
    
    @Override
    public List<Account> read(String gebruikersnaam) {
        System.out.println("Robert 11: gebruikersnaam = " + gebruikersnaam);
        return this.accountRepository.readByGebruikersnaam(gebruikersnaam);
    }

    @Override
    public boolean exists(Account account) {
        return this.accountRepository.exists(account.getIdAccount());
    }

    @Override
    public boolean exists(int idAccount) {
        return this.accountRepository.exists(idAccount);
    }

    @Override
    public boolean exists(String gebruikersnaam, String wachtwoord) {
       List <Account> accountlist = read (gebruikersnaam, wachtwoord);
       boolean isEmpty = accountlist.isEmpty();
       return !isEmpty;
    }

    

    

    

    
    
    
    
    
}
