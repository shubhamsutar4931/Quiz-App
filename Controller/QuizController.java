package com.shubham.QuizApp1.Controller;

import com.shubham.QuizApp1.Model.QuestionWrapper;
import com.shubham.QuizApp1.Model.Response;
import com.shubham.QuizApp1.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;


    @PostMapping("create")
    public ResponseEntity<String > createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title)
    {
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public  ResponseEntity<List<QuestionWrapper>> getQuizQuastions(@PathVariable Integer id)
    {
       return quizService.getQuizQuastions(id);
    }

    @PostMapping("submit/{id}")
    public  ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses)
    {

        return quizService.calculateResult(id,responses);
    }
}
