package salvoamplo.esercizi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salvoamplo.esercizi.entities.Author;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}