package blog.services;


import blog.models.*;
import java.util.List;

public interface UserService {
    boolean authenticate(String username, String password);
    int idAccount (String username, String password);
    Account account (String username, String password);
}
