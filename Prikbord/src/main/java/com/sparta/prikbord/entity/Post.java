package com.sparta.prikbord.entity;

import com.sparta.prikbord.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Post {
    private String title;
    private String name;
    private Long id;
    private String post;
    //시간을 안넣었음!

    public Post(PostRequestDto reqeustDto) {
        this.title= reqeustDto.getTitle();
        this.name= reqeustDto.getName();
        this.id = reqeustDto.getId();
        this.post= reqeustDto.getPost();
        //시간도 받아와야함
    }

    public void update(PostRequestDto reqeustDto) {
        this.title= reqeustDto.getTitle();
        this.name= reqeustDto.getName();
        this.post= reqeustDto.getPost();
    }
}
