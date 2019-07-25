import java.util.*;

/**
 * BasketBallTournament
 */
public class BasketBallTournament extends Tournament{
    Team winner;
    BasketBallTournament(Sports BBall){
        super(BBall);
        winner = null;
    }
    @Override
    void printResults() {
        System.out.println(winner.teamName +" is the winner of " +game.sportName+ " Tournament");
        
        Iterator it = game.teams.iterator();
        System.out.printf("ranks:\tScores:\tTeams:\n");
        int r  = 1;
        while(it.hasNext()){
            Team t = (Team)it.next();
            t.rank = r++;
            System.out.printf("%d\t%d\t%s\n",t.rank,t.score, t.teamName);
        }
        
        System.out.println("total teams : "+game.teams.size());
    }

    @Override
    void startTournament() {

        // create two groups
        Iterator<Team> it = game.teams.iterator();
        Set<Team> groupA = new HashSet<Team>();
        Set<Team> groupB = new HashSet<Team>();

        int n = game.teams.size()/2;

        while(n-- > 0 && it.hasNext())    groupA.add(it.next());
        while(it.hasNext())    groupB.add(it.next());

        // play matches within group
        playWithinGroup(groupA);
        playWithinGroup(groupB);
        
        // get the champions for Finals
        // SortedSet<Team> A = new TreeSet<Team>(new Comparator<Team>() {
        //     @Override
        //     public int compare(Team t1, Team t2) {
        //         if(t2.score - t1.score > 0) return 1;
        //         else if(t2.score - t1.score == 0)   return 0;
        //         else return -1;
        //     }
        // });
        // SortedSet<Team> B = new TreeSet<Team>(new Comparator<Team>() {
        //     @Override
        //     public int compare(Team t1, Team t2) {
        //         return t2.score - t1.score;
        //     }
        // });

        List<Team> A = new ArrayList<Team>();
        List<Team> B = new ArrayList<Team>();

        it = groupA.iterator();
        while(it.hasNext()) {
            Team t = it.next();
            A.add(t);
        }

        it = groupB.iterator();
        while(it.hasNext()) B.add(it.next());

        Collections.sort(A,new Comparator<Team>() {
            public int compare(Team t1,Team t2) {
                return t2.score - t1.score;
            }
        });
        Collections.sort(B, new Comparator<Team>() {
            public int compare(Team t1, Team t2) {
                return t2.score - t1.score;
            }
        });

        // finale
        winner = (game.match(A.get(0),B.get(0)) == 1)? A.get(0):B.get(0);

        // revert the changes to original teams dataStructure
        game.teams.clear();
        
        it = A.iterator();
        while(it.hasNext()) game.teams.add(it.next());
        
        it = B.iterator();
        while(it.hasNext()) game.teams.add(it.next());
    }
    void playWithinGroup(Set<Team> group){
        
        for (Team t1 : group) {
            for (Team t2 : group) {
                if (t1.equals(t2))
                    continue;
                game.match(t1, t2);                
            }
        }
    }
}