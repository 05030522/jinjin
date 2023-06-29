package com.sparta.prikbord.controller;

import com.mysql.cj.x.protobuf.MysqlxExpr;
import com.sparta.prikbord.dto.PostRequestDto;
import com.sparta.prikbord.dto.PostResponseDto;
import com.sparta.prikbord.entity.Post;
import com.sparta.prikbord.service.PostService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.sparta.prikbord.dto.SignupRequestDto;
import com.sparta.prikbord.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import io.jsonwebtoken.Jwts;


import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {


    private final PostService postService;
    private final String secretKey;
    private MysqlxExpr.Array Jwts;

    public PostController(PostService postService, @Value("${jwt.secret}") String secretKey) {
        this.postService = postService;
        this.secretKey = secretKey;
    }

    @PostMapping("/posts")
    public PostResponseDto createPost(@RequestBody PostRequestDto requestDto, @RequestHeader("Authorization") String token) {
        validateToken(token);
    }

    private void validateToken(String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.");
        }
        String jwtToken = token.substring(7);
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(jwtToken);
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 토큰입니다.");
        }
    }



    @GetMapping("/posts")
    public List<PostResponseDto> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    // PostController.java
    @PutMapping("/posts/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto, @RequestHeader("Authorization") String token) {
        validateToken(token);
            String jwtToken = token.substring(7);
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(jwtToken)
                    .getBody();
            String username = claims.getSubject();
            // 사용자 검사 로직
            PostResponseDto post = postService.getPost(id);
            if (!post.getName().equals(username)) {
                throw new IllegalArgumentException("권한이 없습니다.");
            }
        }



    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        validateToken(token);
        postService.deletePost(id);
        return new ResponseEntity<>("게시글이 삭제되었습니다.", HttpStatus.OK);
    }
}
