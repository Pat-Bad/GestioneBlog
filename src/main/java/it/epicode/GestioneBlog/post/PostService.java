package it.epicode.GestioneBlog.post;

import it.epicode.GestioneBlog.Responses.CreateResponse;
import it.epicode.GestioneBlog.autori.Autore;
import it.epicode.GestioneBlog.autori.AutoreRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final AutoreRepository autoreRepository;


    public CreateResponse save(PostRequest request){
        if(postRepository.existsByTitolo(request.getTitolo())) {
            throw new EntityExistsException("Post già esistente");}
        Autore autore = autoreRepository.findById(request.getAutoreId()).get();
        Post post = new Post();
        BeanUtils.copyProperties(request, post);
        post.setAutore(autore);
        postRepository.save(post);

        CreateResponse response = new CreateResponse();
        response.setId(post.getId());
        return response;
    }

    public Post modify(Long id, PostRequest request){
        Post post = postRepository.findById(id).get();
        BeanUtils.copyProperties(request, post);
        postRepository.save(post);
        return post;
    }

    public void delete(Long id){
        Post post = postRepository.findById(id).get();
        postRepository.delete(post);
    }


//Torna una Page di tutti i Post, gli passo l'oggetto Pageable in modo che me lo configuri poi correttamente. Poi
//ovviamente deve tornare il find all di quella pageable.
    public Page<Post> findAll(Pageable pageable){
        return postRepository.findAll(pageable);
    }



    public Post findById(Long id){
        if(!postRepository.existsById(id)){
            throw new EntityNotFoundException("Post non trovato");
        }
        return postRepository.findById(id).get();
    }


}
