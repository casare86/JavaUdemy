public class Main {
    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer ney = new SoccerPlayer("Ney");

        //this way you can add multiple types of players to a team - wrong
        Team ffc = new Team("FFC");
        ffc.addPlayer(joe);
        ffc.addPlayer(pat);

        Team<SoccerPlayer> fefece = new Team<>("Fernandopolis Football Club");
        fefece.addPlayer(ney);

        System.out.println(ffc.numPlayers());
        System.out.println(fefece.numPlayers());
    }
}
