package com.sai.Blog.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.Blog.model.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
