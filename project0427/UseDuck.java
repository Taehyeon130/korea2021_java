/*현실의 사물표현위함이 아닌 단지 실행부를 두기 위한 Dummy클래스*/

class UseDuck{
	public static void main(String[] args){
		//하드디스크에 컴파일 되어있는 기계오리를 메모리에서 살아있게!
		//즉 실행해서 메모리에 올리장
		int x=7;
		Duck d1 = new Duck(); //이것만으로는 메모리에 올라가있지 않는다. 실행을 해야한함

		//@ ~어디에 at 전치사
		//자바가상머신상의 주소값을 담고 있다.
		System.out.println("d1이 담고있는 오리 인스턴스의 주소값은"+d1);

		//d1은 실제 오리 자체를 담고있는 것이 아니라 Heap영역에 생성된 오리 인스턴스의 주소값을 담고있다.
		//즉 오리를 가리키고 있다하여 (참조) reference 변수라고 한다.
	}
}