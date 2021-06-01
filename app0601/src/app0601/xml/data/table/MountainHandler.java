package app0601.xml.data.table;

import java.util.Vector;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MountainHandler extends DefaultHandler{
	Vector<Mountain> mtList; //산 VO를 여러개 담게될 컬렉션

	boolean isItems;
	boolean isItem;
	boolean isMntiadd;
	boolean isMntidetails;
	boolean isMntihigh;
	boolean isMntilistno;
	boolean isMntiname;
	
	Mountain mt;
	
	public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
		if(tag.equals("items")) {
			isItems = true;
			mtList = new Vector<Mountain>(); //컬렉션 생성
		}else if(tag.equals("item")) {
			isItem= true;
			mt = new Mountain(); //Empty상태의 VO생성
		}else if(tag.equals("mntiadd")) {
			isMntiadd = true;
		}else if(tag.equals("mntidetails")) {
			isMntidetails = true;
		}else if(tag.equals("mntihigh")) {
			isMntihigh = true;
		}else if(tag.equals("mntilistno")) {
			isMntilistno = true;
		}else if(tag.equals("mntiname")) {
			isMntiname = true;
		}
	}
	
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		String data = new String(ch,start,length);

		if(isMntiadd) { //주소를 지나가는 중이라면
			mt.setMntiadd(data); //VO에 주소 넣기
		}else if(isMntidetails) {
			mt.setMntidetails(data);
		}else if(isMntihigh) {
			mt.setMntihigh(data);
		}else if(isMntilistno) {
			mt.setMntilistno(Integer.parseInt(data));
		}else if(isMntiname) {
			mt.setMntiname(data);
		}
	}
	
	public void endElement(String uri, String localName, String tag) throws SAXException {
		if(tag.equals("mntiadd")) {
			isMntiadd = false;
		}else if(tag.equals("mntidetails")) {
			isMntidetails = false;
		}else if(tag.equals("mntihigh")) {
			isMntihigh = false;
		}else if(tag.equals("mntilistno")) {
			isMntilistno = false;
		}else if(tag.equals("mntiname")) {
			isMntiname = false;
		}else if(tag.equals("item")) {
			isItem = false;
			//하나의 아이템 즉 VO가 모두 채워진 시점이므로 완성된 VO를 백터에 추가하기!!
			mtList.add(mt);
		}else if(tag.equals("items")) {
			isItems = false;
		}
	}
	
	public void endDocument() throws SAXException {
		for(Mountain obj : mtList) {
			System.out.println(obj.getMntiadd()+", "+obj.getMntidetails()+", "+obj.getMntihigh()+", "+obj.getMntilistno()+", "+obj.getMntiname());
		}
	}
}
