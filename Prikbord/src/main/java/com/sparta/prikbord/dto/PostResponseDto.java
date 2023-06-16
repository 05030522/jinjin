package com.sparta.prikbord.dto;

import com.sparta.prikbord.entity.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private String title;
    private String name;
    private Long id;
    private String post;

    public PostResponseDto(Post post) {
        this.title = post.getTitle();
        this.name = post.getName();
        this.id = post.getId();
        this.post = post.getPost();
    }

    public PostResponseDto(String title, String name, Long id, String post) {
        this.title= title;
        this.name= name;
        this.id = id;
        this.post= post;
    }
}
