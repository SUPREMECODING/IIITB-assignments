/**
 * BasketBall
 */
import java.util.Random;
public class BasketBall extends Sports{
    static int seed = 0;
    static int noOfTeams;
    BasketBall(){
        super("BasketBall");
    }

    public boolean addNewTeam(String teamName){
        noOfTeams++;
        return teams.add(new Team(teamName)); // return true on success
    }
    
        /**
         * rules for scoring :
         * wining team +100
         * losing team -25
         * draw +50 to each team
        */
    @Override
    int match(Team t1, Team t2) {
        Random r = new Random(seed++);
        int result = (int) r.nextInt() * 3 - 1;
        // int result = (int)Math.random()*3 -1;  // 1 if t1 wins, 0 if draw, -1 if t2 wins
        if (result == 1) {
            t1.score += 100;
            t2.score -= 25;
        } else if (result == -1) {
            t1.score -= 25;
            t2.score += 100;
        } else {
            t1.score += 50;
            t2.score += 50;
        }
        return result;
    }
    
}