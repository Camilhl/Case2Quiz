package Quiz;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by camhl on 9/14/2017.
 */
public class Quiz {
    private ArrayList<Question> q;
    private Scoreboard scoreboard;
    private Date startTime;

    public Quiz(ArrayList<Question> q, Date startTime) {
        this.startTime = startTime;
        for(int i = 0; i < q.size(); i++){
            this.q.add(q.get(i));
        }
    }
}
