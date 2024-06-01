package com.turtle.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turtle.Database.Meal.Meal;
import com.turtle.Database.Meal.MealRepository;
import com.turtle.Database.User.Users;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class MealService {
    @Autowired
    private  MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public Flux<Meal> getMeals(Users user , Date date) {
        return mealRepository.findByUserAndDate(user , date);
    }


    public Mono<Meal> saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }


    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }
}
