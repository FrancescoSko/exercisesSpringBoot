package com.example.demo.controllers;

import com.example.demo.Core.Meal;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/esercizi-develhope")
public class MealsController {
    List<Meal> listOfMeals = new ArrayList<>();

    //FUNZIONI DI GET
    @GetMapping("/meals")
    public List<Meal> getListOfMeals() {
        return listOfMeals;
    }

    @GetMapping("/meal/{name}")
    public Meal getMealByName(@PathVariable String name) {
        for (Meal meal : listOfMeals) {
            if (meal.getName().equals(name)) {
                return meal;
            }
        }
        return null;
    }

    @GetMapping("/meal/description-match/{phrase}")
    public Meal getMealByDescriptionPhrase(@PathVariable String description) {
        for (Meal meal : listOfMeals) {
            if (meal.getDescription().equals(description)) {
                return meal;
            }
        }
        return null;
    }

    @GetMapping("/meal/price")
    public List<Meal> getMealByPriceRange(@RequestParam Integer min, @RequestParam Integer max) {
        List<Meal> mealsInThePriceRange = new ArrayList<>();

        for (Meal meal : listOfMeals) {
            if (meal.getPrice() > min && meal.getPrice() < max) {
                mealsInThePriceRange.add(meal);
            }
        }
        return mealsInThePriceRange;

    }

    //FUNZIONI DI POST E PUT
    @PostMapping("/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal) {
        this.listOfMeals.add(meal);
        return ResponseEntity.ok("Meal added");
    }


    @PutMapping("/meal/{name}")
    public ResponseEntity<String> modifyMealName(@PathVariable String name, @RequestBody Meal updatedMeal) {

        Meal mealToUpdate = listOfMeals.stream().filter(meal -> meal.getName().equals(name)).findAny().orElse(null);

        if (mealToUpdate != null) {
            mealToUpdate.setName(updatedMeal.getName());
            return ResponseEntity.ok("Name of the meal updated");
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> modifyMealPriceByName(@PathVariable String name, @RequestBody Meal updatedMeal){
        for(Meal meal : listOfMeals){
            if (meal.getName().equals(name)){
                meal.setPrice(updatedMeal.getPrice());
                return ResponseEntity.ok("Meals price has been updated");
            }
        } return ResponseEntity.notFound().build();
    }




  //FUNZIONI DI DELETE

    @DeleteMapping("/delete-all-meals")
    public ResponseEntity<String> deleteAllMeals() {
        this.listOfMeals.clear();
        return ResponseEntity.ok("All meals have been eliminated");
    }


    @DeleteMapping("delete/meal/name/{name}")
    public ResponseEntity<String> deleteMealByName(@PathVariable String name) {

        for (Meal meal : listOfMeals) {
            if (!meal.getName().equals(name)) {
                return ResponseEntity.badRequest().body("Impossible to delete, meal with this name does not exists");
            }
        }

        Meal mealForDelete = listOfMeals.stream().filter(meal -> meal.getName().equals(name)).findAny().orElse(null);

        listOfMeals.remove(mealForDelete);
        return ResponseEntity.ok("The meal with this name " + name + " has been removed");
    }

    @DeleteMapping("delete/meal/price/{price}")
    public ResponseEntity<String> deleteMealByPriceRange(@PathVariable Double price) {
      List<Meal> mealsToDelete = new ArrayList<>();

      for(Meal meal : listOfMeals){
          if(meal.getPrice() <= price){
              mealsToDelete.add(meal);
          }
      }

       if(mealsToDelete.isEmpty()){
           return  ResponseEntity.notFound().build();
       }

       listOfMeals.removeAll(mealsToDelete);
       return ResponseEntity.ok("All meals with price above " + price + " have been eliminated");
    }



}





