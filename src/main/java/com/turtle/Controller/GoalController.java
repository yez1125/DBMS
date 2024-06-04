package com.turtle.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turtle.Database.Goal.Goal;
import com.turtle.Database.User.Users;
import com.turtle.Service.GoalService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/goal")
public class GoalController {
    @Autowired
    private GoalService goalService;

    @PostMapping("/update")
    public Mono<Goal> set(Goal goal){
        return goalService.saveGoal(goal);
    }

    @GetMapping("/get")
    public Mono<Goal> get(Users user){
        return goalService.getGoal(user.getUserID());
    }
}
