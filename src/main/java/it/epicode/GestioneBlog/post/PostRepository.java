package it.epicode.GestioneBlog.post;

import it.epicode.GestioneBlog.autori.Autore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    public Post findByAutore(Autore autore);
    public boolean existsByTitolo(String titolo);


}
