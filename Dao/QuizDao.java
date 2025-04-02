package com.shubham.QuizApp1.Dao;

import com.shubham.QuizApp1.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
