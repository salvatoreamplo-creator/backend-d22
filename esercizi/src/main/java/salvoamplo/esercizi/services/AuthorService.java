package salvoamplo.esercizi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salvoamplo.esercizi.entities.Author;
import salvoamplo.esercizi.payload.AuthorPayload;
import salvoamplo.esercizi.repositories.AuthorRepository;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    // GET /authors
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    // GET /authors/{id}
    public Author findById(UUID id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));
    }

    // POST /authors
    public Author save(AuthorPayload payload) {
        Author author = new Author(
                payload.nome(),
                payload.cognome(),
                payload.email()
        );
        return authorRepository.save(author);
    }

    // PUT /authors/{id}
    public Author update(UUID id, AuthorPayload payload) {
        Author found = findById(id);

        found.setNome(payload.nome());
        found.setCognome(payload.cognome());
        found.setEmail(payload.email());

        return authorRepository.save(found);
    }

    // DELETE /authors/{id}
    public void delete(UUID id) {
        Author found = findById(id);
        authorRepository.delete(found);
    }
}

