package app0531.xml.jtable;

import java.util.ArrayList;
import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

//Pet.xml을 파싱할 핸들러
public class PetHandler extends DefaultHandler{
	Vector<Pet> petList; //동기화 처리가 되어 있지 않아서 무겁지않음 >> 빠름
	
	boolean isPets;
	boolean isPet;
	boolean isType;
	boolean isName;
	boolean isAge;
	
	Pet pet; //VO준비
	
	//시작 태그 만나면
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		if(tag.equals("pets")) {
			isPets = true;
			petList = new Vector<Pet>(); //컬렉션 생성
		}else if(tag.equals("pet")) {
			isPet = true;
			pet = new Pet(); //VO생성
		}else if(tag.equals("type")) {
			isType = true;
		}else if(tag.equals("name")) {
			isName=true;
		}else if(tag.equals("age")) {
			isAge = true;
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch,start,length);
		if(isType) {
			pet.setType(data);
		}else if(isName) {
			pet.setName(data);
		}else if(isAge) {
			pet.setAge(Integer.parseInt(data));
		}
	}
	
	//닫는 태그 만나면
	public void endElement(String uri, String localName, String tag) throws SAXException {
		if(tag.equals("type")) {
			isType = false;
		}else if(tag.equals("name")) {
			isName = false;
		}else if(tag.equals("age")) {
			isAge = false;
		}else if(tag.equals("pet")) {
			isPet = false;
			//리스트에 VO추가
			petList.add(pet);
		}else if(tag.equals("pets")) {
			isPets = false;
		}
	}
	
	public void endDocument() throws SAXException {
		//문서 종료 시 ArrayList에 VO들이 담겨졌는지 체크해보자
		for(Pet obj:petList) {
			System.out.println(obj.getType()+", "+obj.getName()+", "+obj.getAge());
		}
	}
}
