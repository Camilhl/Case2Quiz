package Quiz;

import java.util.ArrayList;

/**
 * Created by camhl on 9/14/2017.
 */
public class Main {
    private ArrayList<Quiz> quizzes;


    public ArrayList<Quiz> getQuizzes(){
        return quizzes;
    }

    public void addQuiz(Quiz quiz){
        if(quiz != null) {
            quizzes.add(quiz);
        }
    }
}


