package it.epicode.GestioneBlog.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.epicode.GestioneBlog.autori.Autore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String categoria;
    private String titolo;
    private String cover = "https://picsum.photos/200/300";
    private String contenuto;
    private int tempoDiLettura;

    @JsonIgnoreProperties("postPubblicati")
    @ManyToOne
    private Autore autore;

}
