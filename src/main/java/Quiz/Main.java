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
     * Using POST in rest/quizzes/ to add a new Quiz to the site
     * @param quiz
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuiz(Quiz quiz) {
        quizzes.put(quiz.getName(), quiz);

    }


    /**
     * Using PUT in rest/quizzes/{quizName}/ to update a spesific quiz with a new question with four answer-alternatives
     * @param quizName
     * @param question
     */
    @POST
    @Path("{quizName}/questions")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addQuestion(@PathParam("quizName") String quizName, Question question) {
        quizzes.get(quizName).addQuestion(question);

    }


    /**
     * Using GET in rest/quizzes/ to gett ALL the quizzes on the site
     * @return Collection<Quiz>
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Quiz> getQuizzes() {
        return quizzes.values();
    }

    /**
     * Using GET in rest/quizzes/{quizname}/questions to get ALL the questions in a quiz
     * @param quizName
     * @return ArrayList<Question>
     */
    @GET
    @Path("/{quizName}/questions")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Question> getQuestions(@PathParam("quizName") String quizName) {
        if (quizzes.size() == 0) return null;
        return quizzes.get(quizName).getQuestions();

    }

    /**
     * Using POST in rest/quizzes/{quizname}/players to add a nick to a quiz
     * @param quizName
     * @param nick
     */
    @POST
    @Path("/{quizName}/players")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setPlayer(@PathParam("quizName") String quizName, Nick nick) {
        quizzes.get(quizName).addToScoreboard(nick);
        //quizzes.get(quizName).addToScoreboard(nick);
    }

    /**
     * Using GET in rest/quizzes/{quizname}/players to get all the players/nicks that is registered on a quiz.
     * Array with nicks is sorted with highest score first.
     * @param quizName
     * @return ArrayList<Nick>
     */
    @GET
    @Path("/{quizName}/players")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Nick> getNicks(@PathParam("quizName") String quizName) {
        return quizzes.get(quizName).getPlayers();
    }

    /**
     * Using PUT in rest/quizzes/{quizName}/players/{nickname} to add a point to a player in a quiz
     * @param quizName
     * @param nickname
     */
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


    /**
     * Using GET in rest/quizzes/{quizName}/players/{nickname} to get the spesific nick/player
     * @param quizName
     * @param nickname
     * @return Nick
     */
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


