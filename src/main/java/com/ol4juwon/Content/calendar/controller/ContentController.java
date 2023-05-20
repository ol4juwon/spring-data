package com.ol4juwon.Content.calendar.controller;

import com.ol4juwon.Content.calendar.models.Content;
import com.ol4juwon.Content.calendar.models.Status;
import com.ol4juwon.Content.calendar.models.Type;
import com.ol4juwon.Content.calendar.repository.ContentCollectionRepository;
import com.ol4juwon.Content.calendar.repository.ContentJdbcTemplateRepository;
import com.ol4juwon.Content.calendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/content")
@CrossOrigin
public class ContentController {
//    private ContentCollectionRepository repository;
//
    private ContentRepository repository;
    public ContentController(ContentRepository repository){
//        repository = new ContentCollectionRepository();
        this.repository = repository;
    }

    @GetMapping("")
    public List<Content> findAll(){
        System.out.println("findall");
        return repository.findAll();
//        return repository.getAllContent();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
//        return repository.getContent(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void save (@Valid @RequestBody Content content){
        repository.save(content);
//        repository.createContent(content.title(),
//                content.desc(),
//                content.status().toString(),
//                content.contentType().toString(),
//                content.url());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update (@RequestBody Content content, @PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.save(content);
//        repository.updateContent(id, content.title(),content.desc(), content.status().toString(), content.contentType().toString(),content.url());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        repository.deleteById(id);
//        repository.deleteContent(id);
    }
}
