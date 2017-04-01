/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.services;

/**
 *
 * @author robertrook
 */
public interface NotificationService {
    void addInfoMessage(String msg);
    void addErrorMessage(String msg);
}
