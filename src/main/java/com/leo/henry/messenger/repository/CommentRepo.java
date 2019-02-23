package com.leo.henry.messenger.repository;

import com.leo.henry.messenger.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Long> {
//    @Query("select c from Comment c where c.message.id = :messageId")
    List<Comment> findAllByMessage_Id(Long messageId);
    Page<Comment> findAllByMessage_Id(Long messeageId, Pageable pageable);
}
