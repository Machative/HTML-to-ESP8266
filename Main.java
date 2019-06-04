package me.aidan.esp8266;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
	public static final String htmlFileLoc = "<ABSOLUTE PATH OF HTML FILE>";
	public static ArrayList<String> lines = new ArrayList<String>();
	public static void main(String[] args) throws IOException{
		File document = new File(htmlFileLoc);
		try {
			BufferedReader br = new BufferedReader(new FileReader(document));
			String line = br.readLine();
			while(line!=null){
				lines.add(line.replace("\\","\\\\").replace("\"","\\\""));
				line=br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("HTML file not found.");
			System.exit(1);
		}
		for(int i=0;i<lines.size();i++){
			System.out.println("client.println(\""+ lines.get(i)+"\");");
		}
	}
}
