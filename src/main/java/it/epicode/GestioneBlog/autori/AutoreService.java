package it.epicode.GestioneBlog.autori;

import it.epicode.GestioneBlog.Responses.CreateResponse;
import it.epicode.GestioneBlog.email.EmailService;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class AutoreService {
    private final AutoreRepository autoreRepository;
    private final EmailService emailService;
    @Value("${messages.subject}")
    private String subject;
    @Value("${messages.body}")
    private String body;

    //qui devo mettere i metodi per fare le operazioni CRUD

   //salvataggio di un autore
    public CreateResponse save(@Valid AutoreRequest request){
        if(autoreRepository.existsByEmail(request.getEmail())){
            throw new EntityExistsException("Autore già esistente");}

        Autore autore = new Autore();
        BeanUtils.copyProperties(request, autore);
        autoreRepository.save(autore);

        try {
            emailService.sendEmail(request.getEmail(), subject, body + " " + autore.getNome());
        }
        catch (MessagingException e) {
            System.out.println("Errore nell'invio dell'email");
        }

        CreateResponse response = new CreateResponse();
        response.setId(autore.getId());
        return response;
    }

    //modificare un autore
    public Autore modify(Long id, AutoreRequest request){
        Autore autore = autoreRepository.findById(id).get();
        BeanUtils.copyProperties(request, autore);
        autoreRepository.save(autore);
        return autore;
    }

    //eliminare un autore
    public void delete(Long id){
        Autore autore = autoreRepository.findById(id).get();
        autoreRepository.delete(autore);
    }

    //ricerca, modificata con page e pageable
    public Page<Autore> findAll (Pageable pageable){
        return autoreRepository.findAll(pageable);
    }

    public Autore findById(Long id){
        if(!autoreRepository.existsById(id)){
            throw new EntityNotFoundException("Autore non trovato");}
        return autoreRepository.findById(id).get();
    }

}
