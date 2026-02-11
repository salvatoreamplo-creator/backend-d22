package salvoamplo.esercizi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import salvoamplo.esercizi.entities.BlogPost;
import salvoamplo.esercizi.payload.BlogPostPayload;
import salvoamplo.esercizi.services.BlogPostService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    // GET /blogPosts
    @GetMapping
    public List<BlogPost> getBlogPosts() {
        return blogPostService.findAll();
    }

    // GET /blogPosts/{id}
    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable UUID id) {
        return blogPostService.findById(id);
    }

    // POST /blogPosts
    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPostPayload payload) {
        return blogPostService.save(payload);
    }

    // PUT /blogPosts/{id}
    @PutMapping("/{id}")
    public BlogPost updateBlogPost(
            @PathVariable UUID id,
            @RequestBody BlogPostPayload payload
    ) {
        return blogPostService.update(id, payload);
    }

    // DELETE /blogPosts/{id}
    @DeleteMapping("/{id}")
    public void deleteBlogPost(@PathVariable UUID id) {
        blogPostService.delete(id);
    }
}