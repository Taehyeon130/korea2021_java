package app0510.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JVM이 OS로부터 이벤트 정보를 넘겨받아 해당 이벤트에 알맞는 객체의 인스턴스를 생성하면 
//ex) 사용자 click -> OS -> jvm에게 정보전달 -> JVM은 해당이벤트 정보의 알맞는 객체의 인스턴스를 올림 즉 ActionEvent를 올림
//따라서 이 클래스에서 jvm이 넘겨준 이벤트 정보를 수신하여 원하는 이벤트 처리를 시도해보자!!

public class ActionControl implements ActionListener{

	//개발자가 구현해야 할 추상 메서드!!  이 메서드의 매개변수로는 JVM이 생성한 이벤트 객체가 전달됨
	//따라서, 이벤트 객체를 이용하여 각종 정보를 추출한 후 원하는 작업을 수행 할 수 있다
	
	//아래의 메서드는 개발자가 완성해야한다 
	//why) 이벤트 발생 시 어떤 구현을 할 지는 개발자가 결정짓는 것이기 때문에 
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e);
	}
	
}
