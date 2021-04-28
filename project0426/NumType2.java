/*
	실수 자료형에 대해 학습한다
	소수점을 표현할 수있는 숫자형 자료형
	float : 4byte
	double : 8byte
*/

class  NumType2{
	//main메서드를 우리가 직접 호출한 적은 없다
	//java.exe 프로그램에 의해 자동호출
	public static void main(String[] args) {
		//double x = 27496.345; //float으로 설정하면 에러 발생
		float x = 27496.345f; //실수는 디폴트 값이 double이기때문에 개발자가 디폴트를 무시하려면 float를 명시한다는 의미로 'f'를 명시한다
	}
}
