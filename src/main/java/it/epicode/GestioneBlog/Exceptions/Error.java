package it.epicode.GestioneBlog.Exceptions;

import lombok.Data;

@Data
public class Error {
    private String message;
    private String details;
    private String status;
}
