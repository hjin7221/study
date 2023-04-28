package ch15_file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {

	public static void main(String[] args) {
		// 파일 읽기
		String filePath = "/home/pc25/today/test.txt";
		// 파일 쓰기
		String copyPath = "/home/pc25/today/copy.txt";
		
		try (FileReader reader = new FileReader(filePath);
				FileWriter writer = new FileWriter(copyPath)){
			
			char[] box = new char[1];
			
			while(true) {
				int size = reader.read(box);
				
				if(size == -1) {
					break;
				}
				
				// char[] -> String 변환
				String result = new String(box);
				System.out.print(result);
				
				// char[]로 파일 쓰기(write)
				writer.write(box);
				
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
