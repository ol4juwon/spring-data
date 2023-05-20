package com.ol4juwon.Content.calendar.repository;

import com.ol4juwon.Content.calendar.models.Content;
import com.ol4juwon.Content.calendar.models.Status;
import com.ol4juwon.Content.calendar.models.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }


    public void save(Content content) {
        contentList.add(content);
//        return HttpStatus.CREATED;
    }

    public void update(Content content){
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public Boolean existsById(Integer id){
       return  contentList.stream().filter(c-> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id){
        contentList.removeIf(c -> c.id().equals(id));
    }
    @PostConstruct
    private void init(){
        Content c = new Content(
                 1,
                "JS Spring",
                "GI",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
                );
        contentList.add(c);
    }
}
