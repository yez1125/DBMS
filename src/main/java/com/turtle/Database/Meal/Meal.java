package com.turtle.Database.Meal;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
public class Meal {
    @Id

    private Long mealID;

    private Users user;

    private Long foodID;

    private String type;

    private Date date;

}
