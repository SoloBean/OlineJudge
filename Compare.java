package compareResult;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang.StringUtils;

public class Compare {
	public void ConvertStringFile(String name){
		File t = new File(name);
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(t));
			BufferedReader br = new BufferedReader(reader);
			String outputname = "out" + name;
			System.out.println(outputname);
			File write = new File(outputname);
			write.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(write));
			String line = "";
			line = br.readLine();
			String concat = "";
			while(line != null){
				String[] word = line.split(",");
				for(int i = 0; i < word.length; i++){
					word[i] = StringUtils.substringBefore(word[i], "]");
					word[i] = word[i].substring(1, word[i].length());
				}
				for(int i = 0; i < word.length; i++){
					out.write(word[i]+"\r\n");
					System.out.println(word[i]);
				}
				line = br.readLine();
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
//		String t = "[\"compilations\"],[\"bewailed\"],[\"horology\"],[\"map\"]";
//		System.out.println(t);
//		String[] result = t.split(",");
//		for(int i = 0; i < result.length; i++){
//			result[i] = StringUtils.substringBefore(result[i], "]");
//			result[i] = result[i].substring(1, result[i].length());
//			System.out.println(result[i]);
//		}
		Compare t = new Compare();
		t.ConvertStringFile("input2.txt");
	}
}
