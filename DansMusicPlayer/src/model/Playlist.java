package model;

import java.io.File;

public class Playlist{
	
	private File[] files;
	
	public File[] getPlaylist(){
		File folder = new File("media/audio");
		files = folder.listFiles();
		System.out.println("Files in the folder: " + files);
		return files;
	}

}