package app0512.graphic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MyCanvas extends Canvas{
	MoveTest moveTest; //null
	
	//이 생성자를 호출하는 자는 MoveTest의 주소값을 인수로 넘겨야한다.
	//이렇게하면 MyCanvas는 태어날때부터 MoveTest의 주소값을 보유하게된다.
	
	public MyCanvas(MoveTest moveTest) {
		this.moveTest = moveTest;
	}
	
	/*캔버스에 그려질 그림을 개발자가 주도하여 원하는 그림을 그려보자
		paint 메서드에 대하여
		특징 : 개발자가 paint메서드를 호출해서는 안된다
				why) 자바의 모든 컴포넌트는 스스로를 그린다... 
						즉 paint메서드는 시스템이 아닌 그래픽의 렌더링 시 필요에 의해 호출하게 됨
		   언제호출?) 처음의 그림과 비교해서 바뀐부분이 있다면 시스템이 알아서 다시 호출
			동작원리 : 사실 다시 그리는 과정은 내부적으로 아래의 절차를 걸친다
						 1. 기존의 그림을 지운다 (update 메서드)
						 2. 그림을 그린다 (paint 메서드)
			문제점?) 사용자가 윈도우 창의 크기를 변화시킨다거나 하는 그래픽 상의 변화를 통해 paint()메서드를 호출하는 것이 아니라
					   개발자가 원하는 시점에 프로그래밍 적으로 paint()를 호출하는 방법은 없는가..
					  	sun에서는 그래픽이 화면에 반영되는 처리는 시스템이 하기 때문에 paint메서드 호출을 원칙적으로 막아 놓음
					  	따라서 개발자는 시스템에게 paint메서드가 호출될 수있도록 간접적으로 요청을 하는 방식으로 그래픽 처리를 함
					  	이때 호출해야 할 메서드가 repaint() - 그래픽의 갱신을 요청하고 update가 호출되어 화면을 지우고 paint()
					  	repaint() -> update() -> paint()
	*/
	
	public void paint(Graphics g) {
		g.setColor(Color.yellow); //이 시점부터 노란색으로 그려짐
		g.fillOval(moveTest.x, 100, 100, 100);
	}
}
