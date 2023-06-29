package com.sparta.prikbord.dto;

import com.sparta.prikbord.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private String title;
    private String name;
    private Long id;
    private String post;
    private Long createdAt;


    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.name = post.getName();
        this.post = post.getPost();
        this.createdAt = post.getCreatedAt();
    }

    public PostResponseDto(String title, String name, Long id, String post, Long createdAt) {
        this.title= title;
        this.name= name;
        this.id = id;
        this.post= post;
        this.createdAt=createdAt;
    }

}
