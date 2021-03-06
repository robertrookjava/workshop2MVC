package blog.services;
import blog.models.*;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AccountService accountService;
    
    
    
    @Override
    public boolean authenticate(String username, String password) {
         
        return accountService.exists(username, password);
    }
    
    @Override
    public int getIdAccount (String username, String password){
        // tijdelijk even 1 totdat mijn @Autowired String security probleem is opgelost
       // return 1;
        if (!authenticate(username,password)) return 0;
        List<Account> accountList = accountService.read(username, password);
        Account account = accountList.iterator().next();
        return account.getIdAccount();
    }

    @Override
    public Account getAccount(String username, String password) {
        List<Account> accountList = accountService.read(username, password);
        Account account = accountList.iterator().next();
        return account;
    }

    @Override
    public String getPassword(String username) {
        System.out.println("Robert8: in getPassword username = "+ username);
        List<Account> accountList = accountService.read(username);
        System.out.println("Robert 9: zijn we er nog?");
        Account account = accountList.iterator().next();
        return account.getWachtwoord();
    }

    @Override
    public int getIdAccount(String username) {
        Account account = getAccount(username);
        int idAccount = account.getIdAccount();
        return idAccount;
    }

    @Override
    public Account getAccount(String username) {
        List<Account> accountList = accountService.read(username);
        Account account = accountList.iterator().next();
        return account;
        
    }
}
