package com.api.promptGpt.repositories;

import com.api.promptGpt.model.TextModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends JpaRepository<TextModel, Long> {
}
