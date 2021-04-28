/*자동차 정의*/
class Car{
	String name="Jeep";
	int price = 9000;
	String color="white";

	public void setPrice(int price){
		this.price = price;
	}

	//실행부
	public static void main(String[] args){
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = c2;

		c1.setPrice(8000); //첫번재 자동차의 가격을 8000으로
		System.out.println(c2.price);//두번째 자동차가 영향을 받았는가?
		//결론 : 메모리에 올라간 인스턴스들은 서로 다른 영역의 별개의 객체들이다


		c3.setPrice(7000); //c2가 가리키고 있었던 자동차와 동일한 위치의 차를 가리키므로 즉 c2의 가격을 7000으로 변경하게됨
		System.out.println(c2.price);
	}
}