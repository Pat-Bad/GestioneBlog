package it.epicode.GestioneBlog.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    @NotBlank(message="Il campo categoria non può essere vuoto")
    private String categoria;
    @NotBlank(message="Il campo titolo non può essere vuoto")
    private String titolo;
    @NotBlank(message="Il campo contenuto non può essere vuoto")
    private String contenuto;
    @NotBlank(message="Il campo cover non può essere vuoto")
    @Positive(message="Il campo tempo di lettura deve essere maggiore di zero")
    private int tempoDiLettura;
    @Positive(message="L'id dell'autore deve essere maggiore di zero")
    @NotBlank(message="L'id dell'autore non può essere vuoto")
    private Long autoreId;
}
