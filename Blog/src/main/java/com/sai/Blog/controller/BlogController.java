package com.sai.Blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sai.Blog.model.BlogPost;
import com.sai.Blog.service.BlogPostService;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", blogPostService.getAllPosts());
        return "index";
    }

    @GetMapping("/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new BlogPost());
        return "createPost";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute BlogPost post) {
        blogPostService.createPost(post);
        return "redirect:/blog/";
    }

    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", blogPostService.getPostById(id));
        return "editPost";
    }

    @PostMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, @ModelAttribute BlogPost updatedPost) {
        blogPostService.updatePost(id, updatedPost);
        return "redirect:/blog/";
    }

    @GetMapping("/view/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        model.addAttribute("post", blogPostService.getPostById(id));
        return "viewPost";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        blogPostService.deletePost(id);
        return "redirect:/blog/";
    }
}
