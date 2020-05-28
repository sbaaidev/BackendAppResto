package net.sbaai.restoapp.controllers;

import net.sbaai.restoapp.dao.IOperation;
import net.sbaai.restoapp.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class FoodControllers {
    @Autowired
    IOperation io;

    @GetMapping("/foods")
    public List<Food> getFoods(){
        return io.listFoods();
    }
    @GetMapping("/foods/{id}")
    public Food getFoods(@PathVariable(value="id") Long id){
        return io.getFoodById(id);
    }


}
