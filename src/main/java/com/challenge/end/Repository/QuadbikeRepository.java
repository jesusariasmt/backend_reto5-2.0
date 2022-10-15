/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.end.Repository;

import com.challenge.end.Model.Quadbike;
import com.challenge.end.Repository.CrudRepository.QuadbikeCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public class QuadbikeRepository {

    @Autowired
    private QuadbikeCrudRepository quadbikeCrudRepository;

    public List<Quadbike> getAll() {
        return (List<Quadbike>) quadbikeCrudRepository.findAll();
    }

    public Optional<Quadbike> getQuadbike(int id) {

        return quadbikeCrudRepository.findById(id);
    }

    public Quadbike save(Quadbike quadbike) {

        return quadbikeCrudRepository.save(quadbike);
    }

    public void delete(Quadbike quadbike) {
        quadbikeCrudRepository.delete(quadbike);
    }

}
