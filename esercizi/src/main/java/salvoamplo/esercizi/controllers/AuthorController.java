package salvoamplo.esercizi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import salvoamplo.esercizi.entities.Author;
import salvoamplo.esercizi.payload.AuthorPayload;
import salvoamplo.esercizi.services.AuthorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    // GET /authors
    @GetMapping
    public List<Author> getAuthors() {
        return authorService.findAll();
    }

    // GET /authors/{id}
    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable UUID id) {
        return authorService.findById(id);
    }

    // POST /authors
    @PostMapping
    public Author createAuthor(@RequestBody AuthorPayload payload) {
        return authorService.save(payload);
    }

    // PUT /authors/{id}
    @PutMapping("/{id}")
    public Author updateAuthor(
            @PathVariable UUID id,
            @RequestBody AuthorPayload payload
    ) {
        return authorService.update(id, payload);
    }

    // DELETE /authors/{id}
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable UUID id) {
        authorService.delete(id);
    }
}