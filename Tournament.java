/**
 * Tournament
 */
abstract public class Tournament {

    // int noOfGroups;
    // int noOfMatchesPerGroup;
    // int noOfTeamsQualifiedForKnockout;

    Sports game;    // get an game

    Tournament(Sports game){
        this.game = game;
        // noOfGroups = 2;
        // noOfMatchesPerGroup = game.teams.size()/noOfGroups -1;
        // noOfTeamsQualifiedForKnockout = noOfGroups*2;   // 2 teams from each group
    }
    abstract void printResults();
    abstract void startTournament();
}