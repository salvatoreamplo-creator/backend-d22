package salvoamplo.esercizi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salvoamplo.esercizi.entities.BlogPost;

import java.util.UUID;

public interface BlogPostRepository extends JpaRepository<BlogPost, UUID> {
}