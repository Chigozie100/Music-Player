package MusicPlayer;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<>();

        Album album1 = new Album("Love Damini", "Burna Boy");
        album1.addSong("Science", 3.5);
        album1.addSong("common sense", 2.8);
        album1.addSong("Jegele", 3.0);
        albums.add(album1);

        Album album2 = new Album("Championship", "Meek Mill");
        album2.addSong("Get Rich", 4.0);
        album2.addSong("Love", 3.0);
        album2.addSong("D money", 5.0);
        albums.add(album2);

        LinkedList<Song> playList = new LinkedList<>();

        albums.get(0).addToPlaylist("Love Damini", playList);
        albums.get(1).addToPlaylist("Champoinship", playList);
        play(playList);

    }

    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0){
            System.out.println("This playlist have no song");
        } else{
            System.out.println("now playing" + listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing" + listIterator.next().toString());
                    }else {
                        System.out.println("no song avaliable, reached to the end of the list");
                        forward=false;
                    }
                    break;
                case 2:
                    if (forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing" + listIterator.previous().toString());
                    } else{
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if (forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing" + listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing" + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reach to the end of the list");
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
                        if(listIterator.hasNext()){
                            System.out.println("Now playing" + listIterator.next().toString());
                        } else{
                            if(listIterator.hasPrevious())
                                System.out.println("Now playing" + listIterator.previous().toString());
                        }
                    }
            }
        }
    }

    private static void printMenu(){
        System.out.println("Avaliable options\n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list of all songs\n" +
                "5 - print all available options\n" +
                "6 - delete current song\n");
    }

    private static void printList(LinkedList<Song> playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("_____________________");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("_______________________");
    }


}
