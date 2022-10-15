/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.end.Repository;


import com.challenge.end.Model.Client;
import com.challenge.end.Model.DTOs.TotalAndClient;
import com.challenge.end.Model.Reservation;
import com.challenge.end.Repository.CrudRepository.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
    
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation reservation){
    
        return reservationCrudRepository.save(reservation);
    }
    
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    
    //Reto 5
    
    public List<Reservation> getReservationsBetweenDates(Date fechaA, Date fechaB){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA, fechaB);
    }
    
    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }
    
    public List<TotalAndClient> getTopClients(){
        List<TotalAndClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationCrudRepository.getTotalReservationsByClient();
        for(int i=0; i<reporte.size(); i++){
            respuesta.add(new TotalAndClient( (Long) reporte.get(i)[1], (Client) reporte.get(i)[0]) );
        }
        return respuesta;
    }
    
}
