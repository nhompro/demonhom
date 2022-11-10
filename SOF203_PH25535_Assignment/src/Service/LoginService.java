/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Repository.LoginRepo;
import Model.Account;

/**
 *
 * @author PC
 */
public class LoginService {
    private LoginRepo loginRepo;
    
    public LoginService(){
        this.loginRepo = new LoginRepo();
    }
    
    public Account account(String username, String password){
        return this.loginRepo.account(username, password);
    }
}
