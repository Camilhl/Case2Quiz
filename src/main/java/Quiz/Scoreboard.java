package Quiz;

import java.util.ArrayList;

/**
 * Created by camhl on 9/14/2017.
 */
public class Scoreboard {
    private String[] sNames = new String[10];
    private int[] sPoints = new int[10];

    /**
     * @param name
     * @param points
     * @return true if name and points added to the scoreboard
     * @return false if not added to the scoreboard(not hight enough score)
     */

    public boolean addToScoreboard(String name, int points){
        int value = -1;
        for(int i = 0; i < sNames.length; i++) {

            if (sNames[i] == null){
                sNames[i] = name;
                sPoints[i] = points;
                innsettingssort();
                return true;
            } else if(sPoints[i] < points){
                sNames[sNames.length - 1] = name;
                sPoints[sPoints.length -1] = points;
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
        for(int j = 1; j <sPoints.length; ++j){
            int bytt = sPoints[j];
            String byttS = sNames[j];
            //sett t[j] på rett plass:
            int i = j-1;
            while(i >= 0 && sPoints[i] < bytt){
                sPoints[i + 1] = sPoints[i];
                sNames[i + 1] = sNames[i]; //sorterer Names på samme måte slik at indes navn og points alltid henger sammen
                i--;
            }
            sPoints[i+1] = bytt;
            sNames[i+1] = byttS;

        }
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < sPoints.length; i++){
            if(sNames[i] != null){
                s += "Name: " + sNames[i] + ", Points: " + sPoints[i] + "\n";
            }
        }
        return s;
    }

    public static void main(String[]args){
        /*Scoreboard sb = new Scoreboard();
        sb.addToScoreboard("Camilla", 5);
        System.out.println(sb.toString());
        sb.addToScoreboard("Line", 3);
        System.out.println(sb.toString());
        sb.addToScoreboard("Elise", 7);
        System.out.println(sb.toString());
        sb.addToScoreboard("Ronja", 6);
        System.out.println(sb.toString());
        sb.addToScoreboard("Marthe", 4);
        System.out.println(sb.toString());*/


    }

}
