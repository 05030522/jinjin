package com.sparta.prikbord.repository;

import com.sparta.prikbord.dto.PostRequestDto;
import com.sparta.prikbord.dto.PostResponseDto;
import com.sparta.prikbord.entity.Post;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Component
public class PostRepository {
    public final JdbcTemplate jdbcTemplate;

    public PostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Post save(Post post) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO post (title, name, post) VALUES (?, ?, ?)";
        jdbcTemplate.update(con -> {
                    PreparedStatement preparedStatement = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);

                    preparedStatement.setString(1, post.getTitle());
                    preparedStatement.setString(2, post.getName());
                    preparedStatement.setString(3, post.getPost());
                    return preparedStatement;
                },
                keyHolder);


        Long id = keyHolder.getKey().longValue();
        post.setId(id);

        return post;
    }


    public List<PostResponseDto> findAll() {

        String sql = "SELECT * FROM post";

        return jdbcTemplate.query(sql, new RowMapper<PostResponseDto>() {
            @Override
            public PostResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {

                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String name = rs.getString("name");
                String post = rs.getString("post");
                return new PostResponseDto(title, name, id, post, createdAt);
            }
        });
    }

    public Post getPost(Long id) {
        return postRepository.findById(id);
    }

    public void update(Long id, PostRequestDto requestDto) {
        String sql = "UPDATE post SET name = ?, title = ?, post = ? WHERE id = ?";
        jdbcTemplate.update(sql, requestDto.getName(), requestDto.getTitle(), requestDto.getPost(), id);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM post WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


    public Post findById(Long id) {

        String sql = "SELECT * FROM post WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
                    if (resultSet.next()) {
                        Post post = new Post();
                        post.setName(resultSet.getString("name"));
                        post.setTitle(resultSet.getString("title"));
                        post.setPost(resultSet.getString("post"));
                        return post;
                    } else
                        return null;
                }
                , id);
    }

    public void update(Post post) {
        String sql = "UPDATE post SET title = ?, name = ?, post = ?, created_at = ? WHERE id = ?";
        jdbcTemplate.update(sql, post.getTitle(), post.getName(), post.getPost(), post.getCreatedAt(), post.getId());
    }
}