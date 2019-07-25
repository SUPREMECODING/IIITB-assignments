/**
 * TheMain
 */
public class TheMain {

    public static void main(String[] args) {
        Sports bball = new BasketBall();
        bball.addNewTeam("Golden State Warriors");
        bball.addNewTeam("Boston Celtics");
        bball.addNewTeam("Houston Rockets");
        bball.addNewTeam("Philadelphia 76ers");
        bball.addNewTeam("Oklahoma City Thunder");
        bball.addNewTeam("Utah Jazz");
        bball.addNewTeam("Los Angeles Lakers");
        bball.addNewTeam("Toronto Raptors");

        Tournament bTournament = new BasketBallTournament(bball);
        bTournament.startTournament();
        bTournament.printResults();

        
    }
}