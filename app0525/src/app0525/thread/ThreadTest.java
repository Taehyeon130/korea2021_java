package app0525.thread;

/*하나의 프로그램 즉 하나의 스로세스 내에서 각각 독립적으로 실행될수 있는 세부실행 단위를 가리켜 쓰레드라 한다!!
 * Thread는 java.lang패키지에서 지원하기 때문에 import가 필요없다
 * 개발자는 자신만의 Thread를 커스텀마이징하여 독립수행될 단위를 생성및 실행할 수 있다.
 * */


public class ThreadTest {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("☆"); //분신 1개 생성
		MyThread t2 = new MyThread("★"); //분신 1개 생성
		
		t1.start(); //run()을 호출
		t2.start(); 
	}
}
