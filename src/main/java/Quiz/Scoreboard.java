package Quiz;

import java.util.ArrayList;

/**
 * Created by camhl on 9/14/2017.
 */
public class Scoreboard {

    private Nick[] nicks = new Nick[3];

    public Scoreboard(){

    }

    public Nick[] getNicks() {
        return nicks;
    }

    public void setNicks(Nick[] nicks) {
        this.nicks = nicks;
    }

    /**
     * @param nick
     *
     * @return true if name and points added to the scoreboard
     * @return false if not added to the scoreboard(not hight enough score)
     */

    /*public boolean addToScoreboard(Nick nick){
        String name = nick.getNickname();
        int points = nick.getScore();

        for(int i = 0; i < nicks.length; i++){
            if(nicks[i] == null){
                nicks[i] = new Nick(nick.getNickname(), nick.getScore());
                innsettingssort();
                return true;
            }
            else if(nicks[i].getScore() < points){
                nicks[nicks.length - 1] = new Nick(nick.getNickname(), nick.getScore());
                innsettingssort();
                return true;
            }

        }
        return false;
    }*/

    /**
     * Sorterer listene med nicknames og tilhørende poeng
     */
   /* public void innsettingssort(){


            for (int j = 1; j < nicks.length; ++j) {
                Nick byttNick = nicks[j];

                //sett t[j] på rett plass:
                int i = j - 1;
                while (i >= 0 && nicks[i] !=null && nicks[j] != null && nicks[i].getScore() < byttNick.getScore()) {

                    nicks[i + 1] = nicks[i];
                    i--;
                }
                nicks[i + 1] = byttNick;

            }
    }*/

    public String toString(){
        String s = "";
        for(int i = 0; i < nicks.length; i++){
            if(nicks[i] != null){
                s += "Name: " + nicks[i].getNickname() + ", Points: " + nicks[i].getScore() + "\n";
            }
        }
        return s;
    }

    public static void main(String[]args){
        /*Nick nick1 = new Nick("Camilla", 10);
        Nick nick2 = new Nick("Nora", 5);
        Nick nick3 = new Nick("Kimia", 7);


        Scoreboard sb = new Scoreboard();

        System.out.println(sb.addToScoreboard(nick1));
        System.out.println(sb.toString());
        System.out.println(sb.addToScoreboard(nick2));
        System.out.println(sb.toString());
        System.out.println(sb.addToScoreboard(nick3));
        System.out.println(sb.toString());*/
    }

}
