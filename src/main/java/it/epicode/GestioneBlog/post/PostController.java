package it.epicode.GestioneBlog.post;

import it.epicode.GestioneBlog.Responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blogPosts")
public class PostController {
    private final PostService postService;

 // cambio il tipo di ritorno
//torna una page di tutti i post, richiamo il metodo creato nel service e gli passo i parametri con requestparam
//creo una pageable a cui assegno i parametri
//ritorno il pageable con il metodo
//patricamente con pageable gli dico come li voglio vedere
    @GetMapping("/blogPosts")
    @ResponseStatus(HttpStatus.OK)
    public Page<Post> findAll(@ParameterObject Pageable pageable) {
        return postService.findAll(pageable);
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
