package Quiz;

import java.util.ArrayList;

/**
 * Created by camhl on 9/14/2017.
 */
public class Question {
    private String question;
    private String[] answers = new String[4];
    private int rightAnswerIndex;
    private int timeLimit;

    public Question(String q, int timeLimit,
                    //ArrayList<String> a,
                    int rightAnswerIndex){
        this.question = q;
        this.rightAnswerIndex = rightAnswerIndex;
        this.timeLimit = timeLimit;
        /*for(int i=0; i<answers.length(); i++){
            answers[i] = answers.get(i);
        }*/
    }

    public Question(){}

    public int getRightAnswerIndex() {
        return rightAnswerIndex;
    }

    public String getQ() {
        return question;
    }

    public String[] getA() {
        return answers;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setRightAnswerIndex(int rightAnswerIndex) {
        this.rightAnswerIndex = rightAnswerIndex;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
}
