package model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

public class Model extends Observable{
	
	private int index;
	private int playlistLength;
	private String nowPlaying;
	private ArrayList<String> names;
	
	private Playlist playlist;
	private Song[] songs;
	
	public Model(){
		index = 0;
		playlist = new Playlist();
		playlistLength = playlist.getPlaylist().length;
		songs = new Song[playlistLength];
		
		names = new ArrayList<String>();
		
		for (int i = 0; i < playlistLength; i++){
			songs[i] = new Song(playlist.getPlaylist()[i]);
			names.add(songs[i].file.getName());
		}
		
		nowPlaying = names.get(index);
		
	}
	
	public void begin(){
		setChanged();
		notifyObservers("1");
	}
	
	public void play(){
		songs[index].play();
		setChanged();
		notifyObservers("2");
	}
	
	public void pause(){
		songs[index].stop();
		setChanged();
		notifyObservers("3");
	}
	
	public void prev(){
		songs[index].stop();
		index--;
		if (index < 0) index = playlistLength - 1;
		nowPlaying = names.get(index);
		songs[index].rewind();
		songs[index].play();
		setChanged();
		notifyObservers("4");
	}
	
	public void next(){
		songs[index].stop();
		index++;
		if (index > playlistLength - 1) index = 0;
		nowPlaying = names.get(index);
		songs[index].rewind();
		songs[index].play();
		setChanged();
		notifyObservers("5");
	}
	
	public void shuffle(){
		songs[index].stop();
		index = getRandom();
		if (index < 0) index = playlistLength - 1;
		else if (index > playlistLength - 1) index = 0;
		nowPlaying = names.get(index);
		songs[index].rewind();
		songs[index].play();
		setChanged();
		notifyObservers("6");
	}
	
	//================================================
	
	private int getRandom(){
		Random rand = new Random();
		int number = rand.nextInt(playlistLength); // [0 to playlistLength - 1]
		return number;
	}
	
	public String getNowPlaying(){
		return nowPlaying;
	}
	
	public ArrayList<String> getNames(){
		return names;
	}

}
