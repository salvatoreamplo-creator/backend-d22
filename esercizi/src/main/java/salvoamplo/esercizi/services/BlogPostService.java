package salvoamplo.esercizi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salvoamplo.esercizi.entities.Author;
import salvoamplo.esercizi.entities.BlogPost;
import salvoamplo.esercizi.payload.BlogPostPayload;
import salvoamplo.esercizi.repositories.AuthorRepository;
import salvoamplo.esercizi.repositories.BlogPostRepository;

import java.util.List;
import java.util.UUID;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private AuthorRepository authorRepository;

    // GET /blogPosts
    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }

    // GET /blogPosts/{id}
    public BlogPost findById(UUID id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog post non trovato"));
    }

    // POST /blogPosts
    public BlogPost save(BlogPostPayload payload) {
        Author author = authorRepository.findById(payload.authorId())
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));

        BlogPost blogPost = new BlogPost(
                payload.titolo(),
                payload.contenuto(),
                payload.tempoDiLettura(),
                author
        );

        return blogPostRepository.save(blogPost);
    }

    // PUT /blogPosts/{id}
    public BlogPost update(UUID id, BlogPostPayload payload) {
        BlogPost found = findById(id);

        Author author = authorRepository.findById(payload.authorId())
                .orElseThrow(() -> new RuntimeException("Autore non trovato"));

        found.setTitolo(payload.titolo());
        found.setContenuto(payload.contenuto());
        found.setTempoDiLettura(payload.tempoDiLettura());
        found.setAuthor(author);

        return blogPostRepository.save(found);
    }

    // DELETE /blogPosts/{id}
    public void delete(UUID id) {
        BlogPost found = findById(id);
        blogPostRepository.delete(found);
    }
}