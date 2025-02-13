package it.epicode.GestioneBlog.autori;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutoreRequest {
    @NotBlank(message="Il campo nome non può essere vuoto")
    private String nome;
    @NotBlank(message="Il campo cognome non può essere vuoto")
    private String cognome;
    @NotBlank(message="Il campo email non può essere vuoto")
    @Email(message="Inserisci un indirizzo email valido")
    private String email;
    private LocalDate dataDiNascita;
}
