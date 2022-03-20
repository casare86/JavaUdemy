import mediaPlayer.*;
import java.util.*;

public class Main {
    private static final List<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Stormbringer2", 4.2);
        album.addSong("Stormbringer3", 3.59);
        album.addSong("Stormbringer4", 5.22);
        album.addSong("Stormbringer5", 4.32);
        album.addSong("Holy man", 2.2);
        album.addSong("Soldier Fortune", 3.2);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("FI put the finger on you", 5);
        album.addSong("Lets Go", 3.42);
        album.addSong("Snowball", 3.24);
        album.addSong("C.O.D", 5.44);
        album.addSong("Breaking the rules", 3.44);
        album.addSong("Demons Inside", 4.44);
        albums.add(album);

        List<Song> playList = new ArrayList<Song>();
        //List<Song> playListAlsoWorks = new Vector<>(); //Interface of Java handles the convertions of Generic objects

        albums.get(0).addToPlayList("Stormbringer", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Stormbringer3", playList);
        albums.get(0).addToPlayList("Speak out loud", playList); //doesn´t exist
        albums.get(0).addToPlayList(6, playList);
        albums.get(1).addToPlayList("Demons inside", playList);//exist but uses capital letters
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(4, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(12, playList); //there is no track 12

        play(playList);
    }

    private static void play(List<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if(playList.size() == 0){
            System.out.println("There is no songs in this playblist");
            return;
        }
        else{
            //need to use o toString() because we are using objects here
            System.out.println("Now playing " + listIterator.next().toString());
        }
        printMenu();
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action)
            {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext())
                            listIterator.next();
                        forward = true;
                    }
                    if(listIterator.hasNext())
                        System.out.println("Now playing " + listIterator.next().toString());
                    else{
                        System.out.println("We reached the end of the playblist");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious())
                            listIterator.previous();
                        forward = false;
                    }
                    if(listIterator.hasPrevious())
                        System.out.println("Now playing " + listIterator.previous().toString());
                    else{
                        System.out.println("We are at the start of the playblist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("We are at the beggining of the list");
                            forward = true;
                        }
                    }
                    else{
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        }
                        else{
                            System.out.println("We are at the end of the list");
                            forward = false;
                        }
                    }

                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0){
                        listIterator.remove();
                        if(listIterator.hasNext())
                            System.out.println("Now playing " + listIterator.next());
                        else if (listIterator.hasPrevious())
                            System.out.println("Now playing " + listIterator.previous());
                    }
                    else
                        System.out.println("The playlist is empty");
                    break;
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions: ");
        System.out.println("0 - Quit\n" +
                "1 - Next >>\n" +
                "2 - Back <<\n" +
                "3 - Replay\n" +
                "4 - Show the playlist\n" +
                "5 - Menu\n" +
                "6 - Delete current sound");
    }

    private static void printList(List<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("============ SONGS ============");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("===============================");
    }
}
