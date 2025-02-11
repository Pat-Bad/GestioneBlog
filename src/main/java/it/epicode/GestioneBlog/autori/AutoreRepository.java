package it.epicode.GestioneBlog.autori;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AutoreRepository extends JpaRepository<Autore, Long> {
    public Autore findByNome(String nome);

    boolean existsByEmail(String email);
}