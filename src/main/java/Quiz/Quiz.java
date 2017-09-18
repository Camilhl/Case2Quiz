package Quiz;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by camhl on 9/14/2017.
 */
public class Quiz {
    private ArrayList<Question> questions;
    private String name;
    private Scoreboard scoreboard;
    private String startTime;

    public Quiz(String name, ArrayList<Question> q, String startTime) {
        this.startTime = startTime;
        for(int i = 0; i < q.size(); i++){
            this.questions.add(q.get(i));
        }
    }

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

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
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

}
