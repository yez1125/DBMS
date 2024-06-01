package com.turtle.Database.Workout;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.turtle.Database.Exercise.Exercise;
import com.turtle.Database.User.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Workout {
    @Id
    private Long ID;
    private Exercise exercise;
    private Users user;
    private int time;
    private int cal;
    private Date date;
    
   
}
