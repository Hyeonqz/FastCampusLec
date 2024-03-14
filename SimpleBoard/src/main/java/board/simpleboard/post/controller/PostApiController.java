package board.simpleboard.post.controller;

import board.simpleboard.post.db.PostEntity;
import board.simpleboard.post.model.PostRequestDTO;
import board.simpleboard.post.model.PostViewRequest;
import board.simpleboard.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/post")
@RestController
public class PostApiController {
    private final PostService postService;
    @PostMapping
    public PostEntity create(
        @Valid
        @RequestBody PostRequestDTO post
    ) {
       return postService.create(post);
    }

    @PostMapping("/view")
    public PostEntity view (
            @Valid
            @RequestBody PostViewRequest postViewRequest
            ) {
        return postService.view(postViewRequest);

    }

    @GetMapping("/all")
    public List<PostEntity> list () {
        return postService.all();
    }

    @PostMapping("/delete")
    public void delete (
            @Valid
            @RequestBody PostViewRequest postViewRequest
    ) {
        postService.delete(postViewRequest);
    }
}
