package app0510.gugudan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

//버튼을 눌렀을 때 해당 이벤트를 청취하는 ActionListener재정의
public class GuGuAction implements ActionListener{

	JTextField t_input;
	
	//생성자
	public GuGuAction(JTextField t_input) {
		System.out.println("이벤트 클ㄹ래스 생성시 넘겨받은 값"+t_input);
		this.t_input = t_input;
		
	}
	
//	public void callMe(int x) {
//		System.out.println("넘겨받은 x는 "+x);
//	}
//	
//	public void callMe(String y) {
//		System.out.println("y는 "+y);
//	}
//	
//	public void callMe(JButton bt) {
//		System.out.println("bt는 "+bt);
//	}
//		
//	public void callMe(JTextField t_input) {
//		this.t_input = t_input;
//		System.out.println("t_input는 "+t_input);
//	}
//	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//나 아닌 다른 클래스에 존재하는 TextField값에 무엇이 들어있는지 맞추기	
		printDan();
	}
	
	public void printDan() {
		//자바에서 TextField의 값 얻어오기
		String dan = t_input.getText();
		System.out.println("입력한 단은 "+dan);
		//"5"  -->  5
		//파싱
		/*자바스크립트에서는 문자열을 정수로 변환하기 이해 parseInt()함수를 자원
		 * 자바 언어도 이와 동일한 기능을 지원하는데, 단지 API가 틀리다
		 * 즉 자바에서는 문자열인 String 즉 객체자료형을 기본 자료형으로 변경한다는 것 자체가 불가능하다
		 * Dog(객체) -> 7(기본)  - 불가능
		 * 
		 * 아래와 같이 String형에 대해서는 기본자료형과 형변환을 허용해준다
		 * 이때 사용되는 객체가 바로 Wrapper클래스이다
		 * String s="5"  -->  5  - 가능
		 * 
		 * Wrapper Class
		 * - 자바의 모든 기본 자료형에 대해서는 1:1대응하는 Wrapper클래스가 지원된다
		 * - 사용목적: (1) 기본자료형과 객체자료형간의 변환시 사용됨  "5" --> 5
		 * 				  (2) 기본자료형과 관련된 다양한 작업을 지원하기 위해 기본 자료형을 객체차원에서 지원하기 위해
		 * 						why)기본자료형을 객체형으로 변환 시 메서드, 속성을 이용할 수있기 때문에
		 * 
		 * 문자 :char
		 * 논리값 : boolean(Boolean)
		 * 숫자   정수 : byte  shrot  int       long
		 * 					Byte  Short Integer Long
		 * 			실수 : float double
		 * 					Float Double
		 * */
		
		String x="8"; //이 x값을 정수로 변환하고 싶다면?
		int a = Integer.parseInt(x);//쌍따옴표 제거하여 정수로 변환됨
		
		for(int i=1;i<10;i++) {
			System.out.println(dan+"*"+i+"="+Integer.parseInt(dan)*i);
		}
	}
}
