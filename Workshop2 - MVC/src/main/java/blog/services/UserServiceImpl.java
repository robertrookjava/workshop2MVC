package blog.services;
import blog.models.User;
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
         // Provide a sample password check: username == password
         //return Objects.equals(username, password);
         return accountService.exists(username, password);
    }
}
