package music;
//���� ����, mp3���� ����

/*�߻�Ŭ������ ��ӹްԵǴ� �ڽ��� �θ� �ҿ����ϰ� ���ܳ��� �������� �ҿ��� �޼��带 �ϼ��� �ǹ��� ����...�� ���� ������ ������ϰ� �ȴ�
	�� �θ𼼴뿡�� �ϼ����� ���� ���� �ڽļ��뿡�� �ϼ��� ���� ���ѱ� ����
	���) �߻�Ŭ������ ��ӹ��� �ڽ��� �θ� �ϼ����� ���� �߻�޼��带 �������̵� �ؾ��Ѵ�.
*/
import riding.Roller;
import aircraft.ZetWing;

//�ڹٿ����� ���� ����� �����ϰ� ���� ��, �ڽ� Ŭ������ Ư�� Ŭ������ �θ�� �дٸ� ���̻� �ٸ� Ŭ������ �߰��ؼ� �θ�� ������ ������.
//�� ����θ�� �ϳ��̴�!!!

public class MP3Player extends MusicPlayer implements Roller,ZetWing{
	public void setVolume(){
		System.out.println("��������");
	}
	public void openMP3(){
		System.out.println("MP3���� ����");
	}
	public void roll(){
		System.out.println("�Ѹ� ��� ����");
	}
	public void fly(){
		System.out.println("������ ������ �ϴ��� ���ư�");
	}
}