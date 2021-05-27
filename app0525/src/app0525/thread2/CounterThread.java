package app0525.thread2;

//무한 루프로 숫자를 증가시키는 실행단위
public class CounterThread extends Thread{
	int count = 0;
	//개발자는 독립적으로 즉 쓰레드로 실행시키고픈 로직을 run메서드에 정의한다
	public void run() {
		while(true) {
			count++;
			System.out.println(count);
		}
	}
}
