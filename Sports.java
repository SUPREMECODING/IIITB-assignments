import java.util.*;

abstract class Sports{
    String sportName;
    public Set<Team> teams;
    
    Sports(String name){
        sportName = name;
        teams = new HashSet<Team>();
    }
    abstract boolean addNewTeam(String teamName);
    
    // returns 1 if t1 wins, 0 if it is draw, and -1 if t2 wins
    abstract int match(Team t1, Team t2);
};