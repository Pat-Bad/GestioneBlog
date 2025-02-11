package it.epicode.GestioneBlog.autori;

import it.epicode.GestioneBlog.Responses.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AutoreController {
    private final AutoreService autoreService;

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<Autore> findAll() {
        return autoreService.findAll();
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
