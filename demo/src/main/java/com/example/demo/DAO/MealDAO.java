package com.example.demo.DAO;

import com.example.demo.core.Meal;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class MealDAO {
    List<Meal> listOfMeals = new ArrayList<>();
    public List<Meal> getMeals(){
        return listOfMeals;
    }




}




