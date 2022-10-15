/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.challenge.end.Repository.CrudRepository;


import com.challenge.end.Model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Usuario
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
    
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA, Date fechaB);
    
    public List<Reservation> findAllByStatus(String status);
    
//    public List<Reservation> findAllByStatusAndIdReservation(String status, int id);
    
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> getTotalReservationsByClient();
}
