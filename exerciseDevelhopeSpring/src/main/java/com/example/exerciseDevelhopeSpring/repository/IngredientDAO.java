package com.example.exerciseDevelhopeSpring.repository;

import com.example.exerciseDevelhopeSpring.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientDAO extends JpaRepository<Ingredient, Long> {
}
