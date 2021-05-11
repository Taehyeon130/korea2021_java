package util;

public class ObjectTest{
	String name="Test";

	//부모가 가진 toString메서드가 정말로 동작하는지 이 시점에 알아보기
	public String toString(){
		String name = this.getClass().getName();

	}

}