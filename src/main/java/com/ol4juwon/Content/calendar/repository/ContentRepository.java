package com.ol4juwon.Content.calendar.repository;

import com.ol4juwon.Content.calendar.models.Content;
import com.ol4juwon.Content.calendar.models.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByTitleContainingIgnoreCase(String keyword);

    @Query("""
            SELECT * FROM content
            WHERE status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);
}
