package com.codeup.springblog.controllers;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repo.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

//    List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public String seeAllPosts(Model viewModel){
        List<Post> postsFromDB = postDao.searchByBodyLike("post");
        viewModel.addAttribute("posts", postsFromDB);
        // do not use a / to reference a template
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable int id, Model vModel){
        vModel.addAttribute("post", new Post("iPad", "Pro 11in"));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String viewPostForm(){
        return "You would come here to create a post.";
    }

    @PostMapping("/posts/createpost")
    @ResponseBody
    public String createPost(){
        return "You will submit your post here.";
    }


}