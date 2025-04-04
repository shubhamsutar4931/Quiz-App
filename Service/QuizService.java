package com.shubham.QuizApp1.Service;

import com.shubham.QuizApp1.Dao.QuestionDao;
import com.shubham.QuizApp1.Dao.QuizDao;
import com.shubham.QuizApp1.Model.Question;
import com.shubham.QuizApp1.Model.QuestionWrapper;
import com.shubham.QuizApp1.Model.Quiz;
import com.shubham.QuizApp1.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
     QuizDao quizDao;
    @Autowired
     QuestionDao questionDao;


    public  ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuastions(Integer id) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Question> questionsFromDB=quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser=new ArrayList<>();
        for(Question q:questionsFromDB)//question wrapper to Question
        {
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add((qw));
        }
        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        List<Question> questions = quiz.getQuestions();
        int right = 0;

        // Check each response
        for (int i = 0; i < responses.size(); i++) {
            Response response = responses.get(i);
            if (i < questions.size() && response.getResponse().equals(questions.get(i).getRightAnswer())) {
                right++;
            }
        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
