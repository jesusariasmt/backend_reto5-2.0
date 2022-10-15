/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.end.Service;

import com.challenge.end.Model.Client;
import com.challenge.end.Repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return (List<Client>) clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int id){
    
        return clientRepository.getClient(id);
    } 
    
    public Client save(Client client){
        if(client.getIdClient()== null){
            return clientRepository.save(client);
        }else{
            Optional<Client> clientFound = clientRepository.getClient(client.getIdClient());
            if(clientFound.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
    
    public Client update(Client client){
        if(client.getIdClient() != null){
            Optional<Client> clientFound = clientRepository.getClient(client.getIdClient());
            if(!clientFound.isEmpty()){
                if(client.getEmail() != null){
                    clientFound.get().setEmail(client.getEmail());
                }
                if(client.getPassword() != null){
                    clientFound.get().setPassword(client.getPassword());
                }
                if(client.getName() != null){
                    clientFound.get().setName(client.getName());
                }
                if(client.getAge() != null){
                    clientFound.get().setAge(client.getAge());
                }
                return clientRepository.save(clientFound.get());
            }
        }
        return client;
    }
    
    public boolean deleteClient(int clientId){
        Boolean result = getClient(clientId).map(clientToDelete ->{
            clientRepository.delete(clientToDelete);
            return true;
        }).orElse(false);
        return result;
    }
    
}
