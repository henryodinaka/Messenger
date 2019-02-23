package com.leo.henry.messenger.repository;

import com.leo.henry.messenger.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessegerRepo extends JpaRepository<Message,Long> {
}
