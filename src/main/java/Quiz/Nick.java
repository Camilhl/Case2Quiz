package Quiz;

/**
 * Created by camhl on 9/14/2017.
 */
public class Nick {
    private String nickname;
    private int score = 0;

    public Nick() {

    }

    public Nick(String nickname, int score){
        this.nickname = nickname;
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public String getNickname() {
        return nickname;
    }

    public void addPoint(){
        score += 1;
    }
}


