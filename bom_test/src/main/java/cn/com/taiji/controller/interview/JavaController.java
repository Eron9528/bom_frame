package cn.com.taiji.controller.interview;

import cn.com.taiji.domain.interview.Answer;
import cn.com.taiji.domain.interview.Question;
import cn.com.taiji.dto.Result;
import cn.com.taiji.service.interview.AnswerService;
import cn.com.taiji.service.interview.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("basic")
@CrossOrigin
public class JavaController {

    @Autowired
    AnswerService answerService;
    @Autowired
    QuestionService questionService;

    @GetMapping("getBasic/{type}")
    public Result getBasicQuestion(@PathVariable("type")String type){
        List<Question> questionList = questionService.listByType(type);
        return new Result(questionList);
    }

    @PostMapping("addQuestion")
    public Result addQuestion(@RequestBody Question question){
        Question question1 = questionService.save(question);
        return new Result(question1);
    }

    @PostMapping("updateQuestion/{id}")
    public Result updateQuestion(@PathVariable("id") long id, @RequestBody Question question){
        Question question1 = questionService.updateQuestion(id, question);
        return new Result(question1);
    }

    @DeleteMapping("deleteQuestionById/{id}")
    public Result deleteQuestion(@PathVariable("id") long id){
        Question question = questionService.deleteById(id);
        return new Result(question);
    }

    @PostMapping("reply/{id}")
    public Result replyQuestion(@PathVariable("id") long id, @RequestBody Answer answer){
        Answer answer1 = answerService.replyQuestion(id, answer);
        return new Result(answer1);
    }

    @PostMapping("editReply/{id}")
    public Result editReply(@PathVariable("id") long id, @RequestBody Answer answer){
        Answer answer1 = answerService.editReply(id, answer);
        return new Result(answer1);
    }

    @DeleteMapping("deleteReplyById/{id}")
    public Result deleteReply(@PathVariable("id") long id){
        Answer answer1 = answerService.deleteById(id);
        return new Result(answer1);
    }
}
