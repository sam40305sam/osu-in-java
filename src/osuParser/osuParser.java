package osuParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class osuParser {
	private String file_name = "";
	private String file_data = "";
	private String file_data_file_format = "";
	private String file_all_HitObjects = "";
	private ArrayList<String> HitObjects = new ArrayList<String>();
	private int file_data_nOfcircles = 0;
	private int file_data_nOfsliders = 0;
	private int file_data_nOfspinners = 0;

	public osuParser(String name){
		file_name=name;
		try {
	      File myObj = new File(file_name);
		  Scanner myReader = new Scanner(myObj);
		  int type=0;//HitObjects=8
	      while (myReader.hasNextLine()) {
			String data = myReader.nextLine();
			if(data!=""){
				if(data.contains("General")){
					type=1;
				}else if(data.contains("Editor")){
					type=2;
				}else if(data.contains("Metadata")){
					type=3;
				}else if(data.contains("Difficulty")){
					type=4;
				}else if(data.contains("Events")){
					type=5;
				}else if(data.contains("TimingPoints")){
					type=6;
				}else if(data.contains("Colours")){
					type=7;
				}else if(data.contains("HitObjects")){
					type=8;
				} 
				if(data.charAt(0)!='['){
					if(type==0){
						String file_format[] = data.split(" ");
						file_data_file_format=file_format[file_format.length-1];
					}else if(type==8){
						file_all_HitObjects+=data+"\n";
						HitObjects.add(data);
						String[] data_Split = data.split(",");
						if(data_Split.length==6){
							file_data_nOfcircles+=1;
						}else if(data_Split.length==11||data_Split.length==8){
							file_data_nOfsliders+=1;
						}else if(data_Split.length==7){
							file_data_nOfspinners+=1;
						}
					}
				}
			}
			file_data+=data+"\n";
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    }
	}

	public String get_file_format() {
		return file_data_file_format;
	}

	public List<String> get_HitObjects() {
		return HitObjects;
	}

	public String get_all_HitObjects() {
		return file_all_HitObjects;
	}

	public int get_nOfcircles() {
		return file_data_nOfcircles;
	}

	public int get_nOfsliders() {
		return file_data_nOfsliders;
	}

	public int get_nOfspinners() {
		return file_data_nOfspinners;
	}
}
