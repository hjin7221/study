package ch15_file;

import java.io.File;

public class TreasureHunter {

	public static void main(String[] args) {
		String path = "/home/pc25/today/treasure";
//		
//		File treasure = new File(path);
//		
//		File[] treasureArray = treasure.listFiles();
//		
//		for(int i = 0; i < treasureArray.length; i++) {
//			// 해당 File 객체의 풀 경로를 리턴 ( 경로 + 파일명)
//			if(treasureArray[i].isDirectory() == true) {
//				File tre2 = new File(path + "/" + i);
//				File[] tre2Array = tre2.listFiles();
//				for(int j =0; j < tre2Array.length; j++) {
//					if(tre2Array[j].isDirectory() == true) {
//						File tre3 = new File(path + "/" + i + "/" + j);
//						File[] tre3Array = tre3.listFiles();
//						for(int k = 0; k < tre3Array.length; k++) {
//							System.out.println(tre3Array[i].isDirectory());
//						}
//					}else {
//						break;
//					}
//				}
//			}else {
//				break;
//			}
//		}
//		
		
		File folder = new File(path);
		
		findFile(folder);
		
//		File[] inner = folder.listFiles();
//		for(int i = 0; i < inner.length; i++) {
//			if(inner[i].isDirectory()) {
//				// 폴더
//				File[] innerInner = inner[i].listFiles();
//				for(int k = 0; k < innerInner.length; k++) {
//					if(innerInner[k].isDirectory()) {
//						File[] innerInnerInner = innerInner[k].listFiles();
//					}else {
//						System.out.println(innerInner[k]);
//					}
//				}
//			}else {
//				// 파일
//				System.out.println(inner[i]);
//			}
//		}
		
	} // main 끝
	
	public static void findFile(File folder) {
		File[] inner = folder.listFiles();
		for(int i = 0; i < inner.length; i++) {
			if(inner[i].isDirectory()) {
				findFile(inner[i]); 
			}else {
				System.out.println(inner[i]);
			}
		}
	}
}

