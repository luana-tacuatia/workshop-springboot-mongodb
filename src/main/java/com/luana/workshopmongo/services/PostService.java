package com.luana.workshopmongo.services;

import com.luana.workshopmongo.domain.Post;
import com.luana.workshopmongo.domain.User;
import com.luana.workshopmongo.dto.UserDTO;
import com.luana.workshopmongo.repository.PostRepository;
import com.luana.workshopmongo.repository.UserRepository;
import com.luana.workshopmongo.services.exception.ObjectNotFoundException;
import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }
}
