package com.turtle.Database.Article;


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
public class Article {
    @Id

    private Long ID;

    private String title;

    private String content;

    private Users user;

    private Date date;

    

}
