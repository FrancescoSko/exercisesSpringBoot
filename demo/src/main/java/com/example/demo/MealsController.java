package com.example.demo;

import com.example.demo.Core.Meal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/esercizi-develhope")
public class MealsController {
  List<Meal> listOfMeals = new ArrayList<>();

  @GetMapping("/meals")
  public List<Meal> getListOfMeals() {
    return listOfMeals;
  }

  @GetMapping("/meal/{name}")
  public Meal getMealByName(@PathVariable String name) {
    for (Meal meal : listOfMeals) {
      if (meal.getName() == name) {
        return meal;
      }
    }
    return null;
   }

   @GetMapping("/meal/description-match/{phrase}")
  public Meal getMealByDescriptionPhrase(@PathVariable String description){
       for(Meal meal : listOfMeals){
         if (meal.getDescription() == description){
           return meal;
         }
       }
    return null;
  }

   @GetMapping("/meal/price")
   public  List<Meal> getMealByPriceRange(@RequestParam Integer min, @RequestParam Integer max){
      List<Meal> mealsInThePriceRange = new ArrayList<>();

         for(Meal meal : listOfMeals){
             if(meal.getPrice() > min && meal.getPrice() < max){
               mealsInThePriceRange.add(meal);
             }
         } return mealsInThePriceRange;
  }

}

