package app0513.collection;

import java.util.ArrayList;

/*자바의 컬렉션 프레임 웍 중 List에 대해 학습한다
 * 
 * */

public class ListApp {

	public static void main(String[] args) {
		//리스트는 배열과 모습이 같다, 단지 다루려는 대상이 객체 한정
		
		//제너릭(Generic)타입으로 명시된 컬렉션 프레임 웍 객체는 해당 객체만을 받아들인다
		//컴파일 타임에 잡아낸다
		
		ArrayList<String> list = new ArrayList<String>();  
		list.add("Apple"); //자바에서 지원하는 모든 자료형을 다 넣을 수 있다.
		list.add("Apple"); 
		list.add("Apple");
		
		//들어있는 데이터 출력하기
		int length = list.size();
		System.out.println("리스트에 들어간 데이터의 수는 "+length);
		//list[1] = "사과";
		//list.get(1); //접근
		list.set(1, "사과");
		System.out.println(list.get(1));

		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		//jdk 5부터 개선된 for loop지원 다른 언어에서으 ㅣfor each문과 비슷
		for(String item:list) { //우측형의 집합 수 만큼 반봅
			System.out.println("리스트"+item);
		}
	}

}
