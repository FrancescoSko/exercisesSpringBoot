package com.example.exerciseDevelhopeSpring.repository;


import com.example.exerciseDevelhopeSpring.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public interface MealDAO extends JpaRepository<Meal, Long> {
}