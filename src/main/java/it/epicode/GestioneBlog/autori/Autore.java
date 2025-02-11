package it.epicode.GestioneBlog.autori;

import it.epicode.GestioneBlog.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autori")

public class Autore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar = "https://ui-avatars.com/api/?name=Mario+Rossi";

    @OneToMany (mappedBy = "autore")
    private List<Post> postPubblicati;

}
