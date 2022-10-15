/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.end.Service;


import com.challenge.end.Model.Admin;
import com.challenge.end.Repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return (List<Admin>) adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int id){
    
        return adminRepository.getAdmin(id);
    }
    
    public Admin save(Admin admin){
        if(admin.getIdAdmin()== null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> adminFound = adminRepository.getAdmin(admin.getIdAdmin());
            if(adminFound.isEmpty()){
                return adminRepository.save(admin);
            }else{
                return admin;
            }
        }
    }
    
    public Admin update(Admin admin){
        if(admin.getIdAdmin() != null){
            Optional<Admin> adminFound = adminRepository.getAdmin(admin.getIdAdmin());
            if(!adminFound.isEmpty()){
                if(admin.getPassword() != null){
                    adminFound.get().setPassword(admin.getPassword());
                }
                if(admin.getName() != null){
                    adminFound.get().setName(admin.getName());
                }
                return adminRepository.save(adminFound.get());
            }
        }
        return admin;
    }
    
    public boolean deleteAdmin(int adminId){
        Boolean result = getAdmin(adminId).map(adminToDelete ->{
            adminRepository.delete(adminToDelete);
            return true;
        }).orElse(false);
        return result;
    }
    
}
