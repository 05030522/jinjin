package com.sparta.prikbord.service;

import com.sparta.prikbord.dto.PostRequestDto;
import com.sparta.prikbord.dto.PostResponseDto;
import com.sparta.prikbord.entity.Post;
import com.sparta.prikbord.repository.PostRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {

        this.postRepository = postRepository;
    }

    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        Post savePost = postRepository.save(post);
        PostResponseDto postResponseDto = new PostResponseDto(post);
        return postResponseDto;
    }

    public List<PostResponseDto> getPosts() {
        return postRepository.findAll().stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    public PostResponseDto getPost(Long id) {
        Post post = postRepository.findById(id);
        if (post == null) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }
        return new PostResponseDto(post);
    }



    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id);
        if (post == null) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }
        // 사용자 검사 로직 추가
        // ...
        post.update(requestDto);
        postRepository.update(post);
        return new PostResponseDto(post);
    }

    public void deletePost(Long id) {
        Post post = postRepository.findById(id);
        if (post == null) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다.");
        }
        // 사용자 검사 로직 추가
        // ...
        postRepository.delete(id);
    }
}
