package music;
//불완전한 추상메서드가 하나라도 섞여있으면 이 클래스도 완전하지 못한 클래스로 간주함
//이렇게 불완전한 클래스를 가리켜 추상 클래스라 한다.

public abstract class MusicPlayer{

	//장차 이 클래스를 상속받는 객체들이 각각 어떠한 방법으로 구현될지 이 시점에는 알 수도 없고 정해놓아서도 안됨
	//따라서 부모 클래스로 기준을 세우는것까지는 좋았으나. 자식들이 구현할 메서드는 부모가 구현하면 안되고 , 자식에게 구현을 강제해야한다.
	//그러기 위해서는 아래의 메서드들은 몸체가 없는 불완전한 메서드로 정의해야한다.
	//자바에서는 이렇게 불완전한 메서드를 가리켜 몸체가 없다고 추상메서드라 한다.
	/** 
		볼륨을 조절하는 메서드 정의
	*/
	public abstract void setVolume();//추상메서드 선언!!
	/** 
		MP3파일을 지원하는 메서드 정의
	*/
	public abstract void openMP3();
}