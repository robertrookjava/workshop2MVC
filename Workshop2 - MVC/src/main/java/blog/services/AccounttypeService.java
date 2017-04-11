/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;
import blog.models.*;
import java.util.List;

/**
 *
 * @author robertrook
 */
public interface AccounttypeService {
    void create (Accounttype accounttype);
    void create (int id, String type);
    Accounttype read (int id);
    List <Accounttype> read (String type);
    boolean exists (int id);
    boolean exists (String type);
}
