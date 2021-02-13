package play;


import jaco.mp3.player.MP3Player;

import java.io.File;

public class music {
    private long start;
    private long elapsedTimeMillis;
	private String file_name = "";
	private MP3Player music_file;
	
    public  music(String name){
        file_name=name;
        music_file = new MP3Player(new File(file_name));
    }
    
    public void play_music() {
    	music_file.play();
        start = System.currentTimeMillis();
    }
    
    private long time_count() {
    	elapsedTimeMillis = System.currentTimeMillis()-start;
        return elapsedTimeMillis;
    }
}
