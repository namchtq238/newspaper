package com.ptit.newspaper.repository;

import com.ptit.newspaper.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<Article, Long> {
}
