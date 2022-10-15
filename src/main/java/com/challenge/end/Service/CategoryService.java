/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.challenge.end.Service;





import com.challenge.end.Model.Category;
import com.challenge.end.Repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return (List<Category>) categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
    
        return categoryRepository.getCategory(id);
    }
     
    public Category save(Category category){
         if(category.getId() == null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> categoryFound = categoryRepository.getCategory(category.getId());
            if(categoryFound.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
    
    public Category update(Category category){
        if(category.getId() != null){
            Optional<Category> categoryFound = categoryRepository.getCategory(category.getId());
            if(!categoryFound.isEmpty()){
                if(category.getName() != null){
                    categoryFound.get().setName(category.getName());
                }
                if(category.getDescription() != null){
                    categoryFound.get().setDescription(category.getDescription());
                }
                return categoryRepository.save(categoryFound.get());
            }
        }
        return category;
    }
    
    public boolean deleteCategory(int CategoryId){
        Boolean result = getCategory(CategoryId).map(categoryToDelete ->{
            categoryRepository.delete(categoryToDelete);
            return true;
        }).orElse(false);
        return result;
    }
    
}
