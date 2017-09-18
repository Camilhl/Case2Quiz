package Quiz;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that the html-JS referes to on GET, POST ect.
 * Created by camhl on 9/14/2017.
 */

@Path("/quizzes/")
public class Main {
    private static Map<String,Quiz> quizzes = new HashMap<>();
    private String testString;


    /**
     * Using POST in /quizzes/ to add a new Quiz to the site
     * @param quiz
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuiz(Quiz quiz) {
        quizzes.put(quiz.getName(), quiz);
        testString = quiz.getName();

    }

    /**
     * Using PUT in /quizzes/{quizName}/ to update a spesific quiz with a new question with four answer-alternatives
     */
    @POST
    @Path("{quizName}/questions")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuestion(@PathParam("quizName") String quizName, Question question) {
        quizzes.get(quizName).addQuestion(question);

    }


    /**
     * Using GET in /quizzes/ to gett ALL the quizzes on the site
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Quiz> getQuizzes() {
        return quizzes.values();
    }


    /**
     * Using GET in /{quizName}/scores to list all elements in the scoreBoard for the Quiz
     * @param quizName
     * @return
     */
    @GET
    @Path("/{quizName}/scores")
    @Produces(MediaType.APPLICATION_JSON)
    public Scoreboard getScoreboard(@PathParam("quizName") String quizName) {
        return quizzes.get(quizName).getScoreboard();
    }
}


