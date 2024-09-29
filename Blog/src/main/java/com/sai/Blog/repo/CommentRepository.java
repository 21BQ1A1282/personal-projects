package com.sai.Blog.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.Blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

