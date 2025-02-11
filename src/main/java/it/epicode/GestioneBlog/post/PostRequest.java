package it.epicode.GestioneBlog.post;

import it.epicode.GestioneBlog.autori.Autore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    private String categoria;
    private String titolo;
    private String contenuto;
    private int tempoDiLettura;
    private Long autoreId;
}
