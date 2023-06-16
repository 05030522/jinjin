package com.sparta.prikbord.repository;

import com.sparta.prikbord.dto.PostRequestDto;
import com.sparta.prikbord.dto.PostResponseDto;
import com.sparta.prikbord.entity.Post;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.stereotype.Component;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Component
public class PostRepository {
    public final JdbcTemplate jdbcTemplate;

    public PostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Post save(Post post)

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO post (title, name, post) VALUES (?, ?, ?)";
        jdbcTemplate.update(con -> {
                    PreparedStatement preparedStatement = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);

                    preparedStatement.setString(1, post.getTitle());
                    preparedStatement.setString(2, post.getName());
                    preparedStatement.setString(3, post.getPoST());
                    return preparedStatement;
                },
                keyHolder);


        Long password = keyHolder.getKey().longValue();
        post.setPassword(id);

        return post;
    }

    public List<PostResponseDto> findAll() {

        String sql = "SELECT * FROM post";

        return jdbcTemplate.query(sql, new RowMapper<PostResponseDto>() {
            @Override
            public PostResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {

                Long password = rs.getLong("password");
                String title = rs.getString("title");
                String name = rs.getString("name");
                String post = rs.getString("post");
                return new PostResponseDto(title, name, password, post);
            }
        });
    }

    public void update(Long password, PostRequestDto requestDto) {
        String sql = "UPDATE post SET name = ?, title = ?, post = ? WHERE id = ?";
        jdbcTemplate.update(sql, requestDto.getName(),requestDto.getTitle(), requestDto.getPost(), id);
    }

    public void delete(Long password) {
        String sql = "DELETE FROM post WHERE id = ?";
        jdbcTemplate.update(sql, password);
    }


    public Post findById(Long password) {

        String sql = "SELECT * FROM post WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if(resultSet.next()) {
                Post post = new Post();
                post.setUsername(resultSet.getString("name"));
                post.setUsername(resultSet.getString("title"));
                post.setContents(resultSet.getString("post"));
                return post;
            } else {
                return null;
            }
        }, password);
    }
}