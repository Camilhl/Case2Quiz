package Quiz;

import java.util.ArrayList;

/**
 * Created by camhl on 9/14/2017.
 * Class Question has a lot of information about a spesific question in a quiz and only get - and set - methods
 */
public class Question {
    private String question;
    private String[] answers = new String[4];
    private int rightAnswerIndex;
    private int timeLimit;
    private String url;

    public Question(String question, int timeLimit,
                    String[] a,
                    int rightAnswerIndex){
        this.question = question;
        this.rightAnswerIndex = rightAnswerIndex;
        this.timeLimit = timeLimit;
        for(int i=0; i<answers.length; i++){
            answers[i] = a[i];
        }
    }

    public Question(){}

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if(url.equals("")){
            this.url = null;
        } else {
            this.url = url;
        }
    }

    public int getRightAnswerIndex() {
        return rightAnswerIndex;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public String getQuestion() {
        return question;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setRightAnswerIndex(int rightAnswerIndex) {
        this.rightAnswerIndex = rightAnswerIndex;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getAnswer(int i){
        return answers[i];
    }
}
