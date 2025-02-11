package it.epicode.GestioneBlog.post;

import it.epicode.GestioneBlog.Responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/blogPosts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/blogPosts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping("/blogPosts")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody PostRequest request) {
        return postService.save(request);
    }

    @PutMapping("/blogPosts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post modify(@PathVariable Long id, @RequestBody PostRequest request) {
        return postService.modify(id, request);
    }

    @DeleteMapping("/blogPosts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        postService.delete(id);
    }
}
