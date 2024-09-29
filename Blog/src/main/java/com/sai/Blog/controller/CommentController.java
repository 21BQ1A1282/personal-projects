package com.sai.Blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sai.Blog.model.BlogPost;
import com.sai.Blog.model.Comment;
import com.sai.Blog.service.BlogPostService;
import com.sai.Blog.service.CommentService;

@Controller
@RequestMapping("/blog")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogPostService blogPostService;

    @PostMapping("/view/{postId}/comment")
    public String addComment(@PathVariable Long postId, @ModelAttribute Comment comment) {
        BlogPost post = blogPostService.getPostById(postId);
        if (post != null) {
            comment.setBlogPost(post);
            commentService.saveComment(comment);
        }
        return "redirect:/blog/view/" + postId;
    }
}

