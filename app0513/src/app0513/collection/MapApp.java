package app0513.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 * 자바의 컬렉션 프레임 웍 중 Map을 학습한다!!
 * Map이란 Key-Value의 쌍으로 이루어진 데이터 집합... 대표적인 예 JSON
 */

public class MapApp {

	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("fruit1","apple"); //데이터 넣기
		map.put("fruit2","strawberry"); //데이터 넣기
		map.put("fruit3","pineapple"); //데이터 넣기
		
//		System.out.println(map.get("fruit3"));
		
		//직접 Iterator나 Enumeration으로 변환 할 수는 없고 Set을 한번 거쳐서 처리한다!
		//주의 - 아래의 keySet메서드는 map에 들어있는 value가 아닌, 그 value와 쌍을 이루는 key값만을 추출한다!!
		Set<String> set = map.keySet(); //fruit1,fruit2,fruit3가 순서없이 모여있게 됨
		
		Iterator<String> it = set.iterator(); //이름을 일렬로 늘어서게 함
		
		
		//반복문으로 모든 요소를 출력
		while(it.hasNext()) {
			String key = it.next(); //키를 얻었기 때문에 이 시점에 Map에 들어있는 데이터를 검색할 수있다
			String value = map.get(key); //키에 연결된 value반환
			System.out.println(value);
		}

	}

}
