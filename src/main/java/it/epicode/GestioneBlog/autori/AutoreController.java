package it.epicode.GestioneBlog.autori;

import it.epicode.GestioneBlog.Responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
public class AutoreController {
    private final AutoreService autoreService;

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public Page<Autore> findAll(@RequestParam int page, @RequestParam int size, @RequestParam String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return autoreService.findAll(pageable);
    }

    @GetMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore findById(@PathVariable Long id) {
        return autoreService.findById(id);
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateResponse save(@RequestBody AutoreRequest request) {
        return autoreService.save(request);
    }

    @PutMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autore modify(@PathVariable Long id, @RequestBody AutoreRequest request) {
        return autoreService.modify(id, request);
    }

    @DeleteMapping("/authors/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        autoreService.delete(id);
    }
}
