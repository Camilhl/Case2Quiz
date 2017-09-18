package Quiz;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by camhl on 9/14/2017.
 */
public class Quiz {
    private ArrayList<Question> questions = new ArrayList<>();
    private String name;
    private Scoreboard scoreboard;
    private String startTime;

    public Quiz(String name, ArrayList<Question> q, String startTime) {
        this.startTime = startTime;
        for(int i = 0; i < q.size(); i++){
            this.questions.add(q.get(i));
        }
    }

    public Quiz(){}

    public Quiz(String name, String starttime){
        this.name= name;
        this.startTime=starttime;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getName() {
        return name;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addQuestion(Question q){
        if(q != null) {
            questions.add(q);
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        String output = "";
        for(int i = 0; i < questions.size(); i++){
            output += questions.get(i).getQuestion();
        }
        return output;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public static void main(String[]args){
        Quiz q = new Quiz();
        q.addQuestion(new Question("Hva heter jeg?", 10, 0));
        System.out.println(q.toString());
    }
}
