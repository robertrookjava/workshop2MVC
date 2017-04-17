package blog.services;

import blog.models.User;
import java.util.List;

public interface UserService {
    boolean authenticate(String username, String password);
    
}
