package Quiz;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by camhl on 9/14/2017.
 */
public class Quiz {
    private ArrayList<Question> questions = new ArrayList<>();
    private String name;
    private String startTime;
    private static Map<String,Nick> players = new HashMap<>();
    private Nick[] scoreboard = new Nick[10];


   /* public Quiz(String name, ArrayList<Question> q, String startTime) {
        this.startTime = startTime;
        for(int i = 0; i < q.size(); i++){
            this.questions.add(q.get(i));
        }
    }*/

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

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        try{
            Date date = (Date)formatter.parse(startTime);
        }catch(Exception e){
            System.out.println(e.toString() + "Ikke en dato!!!!!!");
        }
        this.startTime = startTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nick[] getScoreboard() {
        return scoreboard;
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


    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public Question getQuestion(int index){
        return questions.get(index);
    }

    public void addNick(Nick nick){
        players.put(nick.getNickname(), nick);

    }

    public Map<String,Nick> getNicks(){
        return players;
    }

    public boolean addToScoreboard(Nick nick){
        String name = nick.getNickname();
        int points = nick.getScore();

        for(int i = 0; i < scoreboard.length; i++){
            if(scoreboard[i] == null){
                scoreboard[i] = new Nick(nick.getNickname(), nick.getScore());
                innsettingssort();
                return true;
            }
            else if(scoreboard[i].getScore() < points){
                scoreboard[scoreboard.length - 1] = new Nick(nick.getNickname(), nick.getScore());
                innsettingssort();
                return true;
            }

        }
        return false;
    }

    /**
     * Sorterer listene med nicknames og tilhørende poeng
     */
    public void innsettingssort(){

        for (int j = 1; j < scoreboard.length; ++j) {
            Nick byttNick = scoreboard[j];

            //sett t[j] på rett plass:
            int i = j - 1;
            while (i >= 0 && scoreboard[i] !=null && scoreboard[j] != null && scoreboard[i].getScore() < byttNick.getScore()) {

                scoreboard[i + 1] = scoreboard[i];
                i--;
            }
            scoreboard[i + 1] = byttNick;

        }
    }

    public static void main(String[]args){
        Quiz q = new Quiz();
        String[] s = {"line", "camilla", "sara", "trude"};
        q.addQuestion(new Question("Hva heter jeg?", 10, s, 1));
        System.out.println(q.toString());
        System.out.println(q.getQuestions().get(0).getAnswers()[0]);
        System.out.println(q.getQuestions().get(0).getAnswers()[1]);
        System.out.println(q.getQuestions().get(0).getAnswers()[2]);
        System.out.println(q.getQuestions().get(0).getAnswers()[3]);
        System.out.println(q.getQuestions().get(0).getTimeLimit());
        System.out.println(q.getQuestions().get(0).getRightAnswerIndex());
    }
}
