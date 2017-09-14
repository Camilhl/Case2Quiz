package Quiz;

import java.util.ArrayList;

/**
 * Created by camhl on 9/14/2017.
 */
public class Question {
    private String q;
    private ArrayList<String> a;
    private int rightAnswerIndex;
    private int timeLimit;

    public Question(String q, int timeLimit, ArrayList<String> a, int rightAnswerIndex){
        this.q = q;
        this.rightAnswerIndex = rightAnswerIndex;
        this.timeLimit = timeLimit;
        for(int i=0; i<a.size(); i++){
            this.a.add(a.get(i));
        }
    }

    public int getRightAnswerIndex() {
        return rightAnswerIndex;
    }

    public String getQ() {
        return q;
    }

    public ArrayList<String> getA() {
        return a;
    }
}
