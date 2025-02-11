package it.epicode.GestioneBlog.autori;

import it.epicode.GestioneBlog.Responses.CreateResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoreService {
    private final AutoreRepository autoreRepository;

    //qui devo mettere i metodi per fare le operazioni CRUD

   //salvataggio di un autore
    public CreateResponse save(AutoreRequest request){
        if(autoreRepository.existsByEmail(request.getEmail())){
            throw new EntityExistsException("Autore già esistente");}

        Autore autore = new Autore();
        BeanUtils.copyProperties(request, autore);
        autoreRepository.save(autore);

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

    //ricerca
    public List<Autore> findAll (){
        return autoreRepository.findAll();
    }

    public Autore findById(Long id){
        if(!autoreRepository.existsById(id)){
            throw new EntityNotFoundException("Autore non trovato");}
        return autoreRepository.findById(id).get();
    }

}
