package app0525.thread;

//개발자는 자신만의 스레드를 커스텀마이징 하기 위해서는 Thread클래스를 상속받아서 해당 메서드를 재정의하면 된다

public class MyThread extends Thread{
	//개발자는 하나의 프로세스내에서 독립적으로 실행될 코드를 
	//문신으로 실행할 코드를 run메서드에서 재정의함으로써 구현
	//run메서드에 독립실행할 코드를 작성해야한다
	String star;
	
	public MyThread(String star) {
		this.star = star;
	};
	
	@Override
	public void run() {
		while(true) {
			System.out.println(star);
			try {
				Thread.sleep(1000); // 1초 뒤에 실행
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
