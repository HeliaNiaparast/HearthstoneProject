package game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LogWriter {

	public static void write(Player player, String eventType, String event) {
		String dir = System.getProperty("user.dir") + "/src/main/resources/Logs/Bodies/" + player.getUsername() + "-" + player.getUserID() + ".txt";
		try {
			FileWriter writer = new FileWriter(dir, true);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String logText = eventType + " " +  timestamp + " " + event + "\r\n";
			writer.write(logText);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void save(Player player) {
		String headPath = System.getProperty("user.dir") + "/src/main/resources/Logs/Headers/" + player.getUsername() + "-" + player.getUserID() + ".txt";
		String bodyPath = System.getProperty("user.dir") + "/src/main/resources/Logs/Bodies/" + player.getUsername() + "-" + player.getUserID() + ".txt";
		String logPath = System.getProperty("user.dir") + "/src/main/resources/Logs/" + player.getUsername() + "-" + player.getUserID() + ".txt";
		write(player, "Exit", "");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jProfile = gson.toJson(player);
		String profilePath = System.getProperty("user.dir") + "/src/main/resources/Profiles/" + player.getUsername() + ".json";
				
		try {
			File head = new File(headPath);
			String headText = "";
			Scanner logScanner = new Scanner(head);
			while(logScanner.hasNext()) 
				headText += logScanner.nextLine() + "\r\n";
			logScanner.close();
			File body = new File(bodyPath);
			String bodyText = "";
			logScanner = new Scanner(body);
			while(logScanner.hasNext())
				bodyText += logScanner.nextLine() + "\r\n";
			logScanner.close();
			String log = headText + "\r\n" + bodyText;
			FileWriter writer = new FileWriter(logPath);
			writer.write(log);
			writer.close();
			
			writer = new FileWriter(profilePath);
			writer.write(jProfile);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void create(Player player) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jProfile = gson.toJson(player);
		String path = System.getProperty("user.dir") + "/src/main/resources";
		try {
			FileWriter writer = new FileWriter(path + "/Profiles/" + player.getUsername() + ".json");
			writer.write(jProfile);
			writer.close();
	
			String logName = player.getUsername() + "-" + player.getUserID() + ".txt";
			writer = new FileWriter(path + "/Logs/Headers/" + logName);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String logText = "Username: " + player.getUsername() + "\r\n" + "Created at: " + 
			timestamp + "\r\n" + "Password: " + player.getPassword();
			logText += "\r\n" + "\r\n";
			writer.write(logText);
			writer.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
