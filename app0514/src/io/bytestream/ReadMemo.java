/*
	�������� �ڹ� ���α׷����� �޸��� ������ ������ �о���� = �Է�
	�ڹ��� java.io��Ű���� io���� Ŭ������ ������
*/
package io.bytestream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;

public class ReadMemo{
	//InputStream is; //�߻� Ŭ����
	FileInputStream fis; //�Է� ��Ʈ�� �� ������ ��������� �Է� ��Ʈ��
	FileOutputStream fos; //��� ��Ʈ�� �� ������ ��������� ��� ��Ʈ��
	
	public ReadMemo(){
		//�Ʒ��� �ڵ�� ���������� ������ ������, ���� �����ڰ� ���ϸ��� �߸� ������ ��� 
		//������ ��(�� runtime)������ �߻��Ͽ� ���α׷��� ������ ���ᰡ �ǹ�����.
		//����ó���� ����? ������������ ����!!
		try{
			fis = new FileInputStream("C:/korea202102_javaworkspace/app0514/res/memo.txt");
			System.out.println("���Ͽ� ���� ��Ʈ�� ���� ����!");
			
			fos = new FileOutputStream("C:/korea202102_javaworkspace/app0514/res/meme_copy.txt"); //����ִ� ���� ������

			//���� ������ ���������Ƿ� ��� �ڿ����κ��� �����͸� 1byte�� ���̸�����!!
			while(true){
				int data = fis.read(); //1byte �о����!!
				if(data==-1)break;
				fos.write(data);
				System.out.print((char)data);
			}
		}catch(FileNotFoundException e){
			//���� try�� ������ �����ߴ� ����� �߻��� ���, ���α׷��� ������ ����Ǵ� ���� �ƴ϶� 
			//����ΰ� catch������ �����ϰ� �ȴ�...
			//������ ������ ã�Ƴ� ���ִ� �α�, ����ڿ��� ����(�̸���,sms),�ȳ� �޽�����
			System.out.println("�ش� ������ ã�� �� �����ϴ�");
		}catch(IOException e){
			System.out.println("���� �б� ����");
		}
	}

	public static void main(String args[]){
		new ReadMemo();
	}
}
