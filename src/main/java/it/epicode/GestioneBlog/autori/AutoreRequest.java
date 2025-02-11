package it.epicode.GestioneBlog.autori;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreRequest {
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataDiNascita;
}
