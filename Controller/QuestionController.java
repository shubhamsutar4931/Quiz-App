package com.shubham.QuizApp1.Controller;

import com.shubham.QuizApp1.Model.Question;
import com.shubham.QuizApp1.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>getQuestionByCategory(@PathVariable String category)
    {
        return questionService.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }
    @DeleteMapping("delete/{Id}")
    public String deleteQuestion(@PathVariable int Id)
    {
        return questionService.deleteQuestion(Id);
    }
    @PutMapping("update")
    public String updateQuestion(@RequestBody Question question)
    {
        return questionService.updateQuestion(question);
    }
}
