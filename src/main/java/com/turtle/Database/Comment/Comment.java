package com.turtle.Database.Comment;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.turtle.Database.Article.Article;
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
public class Comment {
    @Id
    private Long commentID;
    private Article article;

    private Users User;

    private String comment;

    private Date date;

}
