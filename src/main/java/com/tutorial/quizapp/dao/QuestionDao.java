package com.tutorial.quizapp.dao;
import com.tutorial.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {  // Jpa takes table name and primary key (id) datatype & Jpa handles all the query from DB

    List<Question> findByCategory( String category);

    @Query(value="Select * from question q where q.category=:category ORDER By RANDOM() LIMIT :noQ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int noQ);
}
