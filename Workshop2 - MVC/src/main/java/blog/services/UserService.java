package blog.services;


import blog.models.*;
import java.util.List;

public interface UserService {
    boolean authenticate(String username, String password);
    int getIdAccount (String username, String password);
    Account getAccount (String username, String password);
    String getPassword (String username);
    int getIdAccount (String username);
    Account getAccount (String username);
    
}
