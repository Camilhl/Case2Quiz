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
    private static Map<String, Quiz> quizzes = new HashMap<>();


    /**
     * Using POST in /quizzes/ to add a new Quiz to the site
     *
     * @param quiz
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuiz(Quiz quiz) {
        quizzes.put(quiz.getName(), quiz);

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
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Quiz> getQuizzes() {
        return quizzes.values();
    }


    @GET
    @Path("/{quizName}/questions")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Question> getQuestions(@PathParam("quizName") String quizName) {
        if (quizzes.size() == 0) return null;
        return quizzes.get(quizName).getQuestions();

    }

    @POST
    @Path("/{quizName}/players")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setPlayer(@PathParam("quizName") String quizName, Nick nick) {
        quizzes.get(quizName).addToScoreboard(nick);
        //quizzes.get(quizName).addToScoreboard(nick);
    }

    @GET
    @Path("/{quizName}/players")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Nick> getNicks(@PathParam("quizName") String quizName) {
        return quizzes.get(quizName).getPlayers();
    }

    @PUT
    @Path("{quizName}/players/{nickname}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void setScore(@PathParam("quizName") String quizName, @PathParam("nickname") String nickname) {
        for(int i = 0; i < quizzes.get(quizName).getPlayers().size(); i++) {
            if(quizzes.get(quizName).getPlayers().get(i).getNickname().equals(nickname)){
                quizzes.get(quizName).getPlayers().get(i).addPoint();
                quizzes.get(quizName).innsettingssort();
            }
        }
    }

    @GET
    @Path("{quizName}/players/{nickname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Nick getNick(@PathParam("quizName") String quizName, @PathParam("nickname") String nickname) {
        for(int i = 0; i < quizzes.get(quizName).getPlayers().size(); i++) {
            if(quizzes.get(quizName).getPlayers().get(i).getNickname().equals(nickname)){
                return quizzes.get(quizName).getPlayers().get(i);
            }
        }

        return null;
    }
}


