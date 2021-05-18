package io.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//이미지 파일을 복사해보자
class CopyImage{
	FileInputStream fis;
	FileOutputStream fos;

	public CopyImage() {
		try {
			fis = new FileInputStream("C:\\korea202102_javaworkspace\\app0514\\res\\g.jpg");
			fos = new FileOutputStream("C:\\korea202102_javaworkspace\\app0514\\res\\g_copy.jpg");
			
			//입력 스트림으로는 데이터의 1byte씩 읽어들이고 출력스트림으로는 1byte씩 출력해보자!!(복사)
			
			int data = -1;
			while(true) {
				data = fis.read(); //1byte 읽기
				if(data==-1)break;
				fos.write(data); //1byte 출력
//				System.out.println(data);				
			}
			System.out.println("복사완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("파일 읽기 실패");
		}finally {
			//아래의 코드는 객체의 생성이 성공했을 때만 수행한다
			if(fis!=null) {
				try {
					fis.close(); //스트림을 닫을 때도 IO예외가 발생할 수있다고 sun에서 정했다... 따르자 
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}			
			}
		}
	}
	
	public static void main(String[] args) {
		new CopyImage();
	}
}
