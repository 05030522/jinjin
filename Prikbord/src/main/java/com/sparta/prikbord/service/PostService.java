package com.sparta.prikbord.service;

import com.sparta.prikbord.dto.PostRequestDto;
import com.sparta.prikbord.dto.PostResponseDto;
import com.sparta.prikbord.entity.Post;
import com.sparta.prikbord.repository.PostRepository;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Component
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {

        this.PostRepository = postRepository;
    }

    public PostResponseDto createPost(PostRequestDto requestDto) {
        // RequestDto -> Entity
        Post post = new Post(requestDto);
        Post savePost = postRepository.save(post);

        // Entity -> ResponseDto
        PostResponseDto postResponseDto = new PostResponseDto(post);

        return postResponseDto;
    }

    public List<PostResponseDto> getPosts() {

        return postRepository.findAll();
    }

    public Long updatePost(Long id, PostRequestDto requestDto){


        // 해당 메모가 DB에 존재하는지 확인
        Post post = postRepository.findById(id);
        if(post != null) {
            // memo 내용 수정
            postRepository.update(id, requestDto);

            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }

    public Long deleteMemo(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Post post = postRepository.findById(id);

        if(post != null) {
            // memo 삭제
            postRepository.delete(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }
}
