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
    private ArrayList<Nick> players = new ArrayList<>();
    private int totalTime = 0;
    private String theme;
    //private String[] ages = new String[5];


    public Quiz(){}

    public Quiz(String name, String starttime){
        this.name= name;
        this.startTime=starttime;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    //public String[] getAges() {return ages;}

   /* public void setAges(String[] ages) {
        if(ages.length == 5){
            this.ages = new String[1];
            this.ages[0] = "All ages!";
        }
        else{
            this.ages = ages;
        }
    }*/

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {

        Date today = new Date();
        startTime = startTime.replace("T", " ");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        try {
            return format.parse(startTime);
        }catch(Exception e){

        }
        return null;
    }


    public String getName() {
        return name;
    }

    public int getTotalTime() {
        return totalTime;
    }

    /*public void setStartTime(String startTime) {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        try{
            Date date = (Date)formatter.parse(startTime);
            this.startTime = date;
        }catch(Exception e){
            System.out.println(e.toString() + "Ikke en dato!!!!!!");
        }

    }*/

    public void setName(String name) {
        this.name = name;
    }

    public boolean addQuestion(Question q){
        if(q != null) {
            questions.add(q);
            this.totalTime += q.getTimeLimit();
            return true;
        }
        else {
            return false;
        }
    }

    /* public String toString() {
        String output = "";
        for(int i = 0; i < questions.size(); i++){
            output += questions.get(i).getQuestion();
        }
        return output;
    }*/


    public ArrayList<Nick> getPlayers() {
        return players;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public Question getQuestion(int index){
        return questions.get(index);
    }

    /**
     * Adds player to the scoreboard/array of nicks.
     * @param nick
     */
    public void addToScoreboard(Nick nick){
        String name = nick.getNickname();
        int points = nick.getScore();
        players.add(new Nick(nick.getNickname(), nick.getScore()));
        innsettingssort();
    }

    /**
     * Sorting the scoreboard-array, nicks with highest score comes first
     */
    public void innsettingssort(){


        for (int j = 1; j < players.size(); ++j) {
            Nick byttNick = players.get(j);

            //sett t[j] på rett plass:
            int i = j - 1;
            while (i >= 0 && players.get(i) !=null && players.get(j) != null && players.get(i).getScore() < byttNick.getScore()) {
                players.remove(i+1);
                players.add(i+1, players.get(i));
                i--;
            }
            players.remove(i+1);
            players.add(i + 1, byttNick);

        }
    }


    public String toString(){
        String s = "";
        for(int i = 0; i < players.size(); i++){
            if(players.get(i) != null){
                s += "Name: " + players.get(i).getNickname() + ", Points: " + players.get(i).getScore() + "\n";
            }
        }
        return s;
    }

    public static void main(String[]args){
        Quiz q = new Quiz();
        /*String[] s = {"line", "camilla", "sara", "trude"};
        q.addQuestion(new Question("Hva heter jeg?", 10, s, 1));
        System.out.println(q.getQuestions().get(0).getAnswers()[0]);
        System.out.println(q.getQuestions().get(0).getAnswers()[1]);
        System.out.println(q.getQuestions().get(0).getAnswers()[2]);
        System.out.println(q.getQuestions().get(0).getAnswers()[3]);
        System.out.println(q.getQuestions().get(0).getTimeLimit());
        System.out.println(q.getQuestions().get(0).getRightAnswerIndex());*/

       /* Nick nick1 = new Nick("Camilla", 10);
        Nick nick2 = new Nick("Nora", 5);
        Nick nick3 = new Nick("Kimia", 7);
        Nick nick4 = new Nick("line", 3);
        Nick nick5 = new Nick("dina", 13);
        Nick nick6 = new Nick("olivia", 8);

        System.out.println(q.addToScoreboard(nick1));
        System.out.println(q.toString());
        System.out.println(q.addToScoreboard(nick2));
        System.out.println(q.toString());
        System.out.println(q.addToScoreboard(nick3));
        System.out.println(q.toString());
        System.out.println(q.addToScoreboard(nick4));
        System.out.println(q.toString());
        System.out.println(q.addToScoreboard(nick5));
        System.out.println(q.toString());
        System.out.println(q.addToScoreboard(nick6));
        System.out.println(q.toString());
        q.getPlayers().get(1).addPoint();
        q.getPlayers().get(3).addPoint();
        q.getPlayers().get(3).addPoint();
        q.innsettingssort();
        System.out.println(q.toString());*/

    }
}
