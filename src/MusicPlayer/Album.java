package MusicPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public Album(){

    }

    //return type is song cos we are checkn for d song
    public Song findSong(String title){
        for (Song checkingSong : songs){
            if (checkingSong.getTitle().equalsIgnoreCase(title))
                return checkingSong;
        }
        return null;
    }

    public boolean addSong(String title, double duration ){
        if (findSong(title) == null){
            songs.add(new Song(title, duration));
            System.out.println(title + "Successfully added to the list");
            return true;
        }
        else {
            System.out.println("Song with name" + title + "already exist in the list");
            return false;
        }
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber - 1;
        if (index > 0 && index <= this.songs.size()){
            playList.add(this.songs.get(index));
            return true;
        }
        System.out.println("this album does not have song with tracknumber" + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList){
        for(Song checkedSong : this.songs){
            if (checkedSong.getTitle().equalsIgnoreCase(title)){
                playList.add(checkedSong);
                return true;
            }
        }
        System.out.println(title + "there is no such song in album");
        return false;
    }
}
