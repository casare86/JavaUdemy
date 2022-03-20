import java.util.ArrayList;
//transforming a class in generic Type T, means Java will decide in execution time what kind of object it will accepts
//preventing insertion of different types of objects, only the specified ones,
//but it comes with a price, you need to add some casting to methods

//public class Team<T extends Player & Interface1 & Interface2 ...> {
public class Team<T extends Player> {
    private String name;
    int playerdGames = 0;
    int won = 0;
    int lost =0;
    int tied = 0;
    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public boolean addPlayer(T player){
        if (members.contains(player)){
            //cast to Player, if you use extends wont need to cast
            //System.out.println(((Player) player).getName() + " is already on this team");
            System.out.println(player.getName() + " is already on this team");
            return false;
        }
        members.add(player);
        System.out.println(player.getName() + " was picked for team " + this.name);
        return true;
    }

    public int numPlayers(){
        return this.members.size();
    }
}
