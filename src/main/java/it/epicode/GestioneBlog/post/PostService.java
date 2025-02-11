package it.epicode.GestioneBlog.post;

import it.epicode.GestioneBlog.Responses.CreateResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public CreateResponse save(PostRequest request){
        if(postRepository.existsByTitolo(request.getTitolo())) {
            throw new EntityExistsException("Post già esistente");}
        Post post = new Post();
        BeanUtils.copyProperties(request, post);
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

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findById(Long id){
        if(!postRepository.existsById(id)){
            throw new EntityNotFoundException("Post non trovato");
        }
        return postRepository.findById(id).get();
    }
}
