package com.ol4juwon.Content.calendar.repository;

import com.ol4juwon.Content.calendar.models.Content;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
}
