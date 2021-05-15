//package io.bytestream;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//class CopyImage{
//	
//	FileInputStream fis;
//	FileOutputStream fos;
//
//	public CopyImage(){
//		try{
//			fis = new FileInputStream("C:/korea202102_javaworkspace/app0514/res/g.jpg");	
//			fos = new FileOutputStream("C:/korea202102_javaworkspace/app0514/res/g_copy.jpg");
//			//입력 스트림으로는 데이터의 1byte씩 읽어들이고 출력 스트립으로 데이터 1byte씩 출력해보자(복사)
//			int data = -1;
//			while(true) {
//				data = fis.read(); //1byte읽기 (입력)
//				if(data==-1) break;
//				fos.write(data); //1byte 쓰기(출력)
//			}
//		}catch(FileNotFoundException e){
//			e.printStackTrace();
//			System.out.println("파일을 찾을 수 없습니다");
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("파일을 읽을 수 없습니다");
//		}finally {
//			if(fis!=null) {
//				fis.close();
//		
//			}
//		}
//		
//		//스트림은 반드시 닫아야한다
//		//아래의 코드는 객체의 생성이 성공했을 때만 수행하라
//		fos.close();
//	}
//	public static void main(String[] args){
//		new CopyImage();
//	}
//}
