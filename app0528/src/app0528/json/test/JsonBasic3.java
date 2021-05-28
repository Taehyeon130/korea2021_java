package app0528.json.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonBasic3 {
	FileReader reader; //파일을 대상으로 한 문자기반 스트림
	BufferedReader buffr;
	String path;
	
	public JsonBasic3() {
		try {
			URL url =this.getClass().getClassLoader().getResource("pet.json");
			//System.out.println(url);
			URI uri = url.toURI();
			buffr = new BufferedReader(reader = new FileReader(new File(uri)));
			
			//스트링으로 연결된 파일의 내용을 실행중인 자바 프로그램으로 읽어와 보자!!
			String data = null;
			StringBuilder sb = new StringBuilder();
			while(true) {
				data = buffr.readLine();//한줄 읽기
				if(data==null)break;
				//System.out.println(data);
				sb.append(data); //문자열 모으기!! why?)파싱 하려고
			}
			//문자열이 다 모아졌기때문에 최종적으로 모아진 데이터를 확인
			//System.out.println(sb.toString());
			
			//모아진 데이터를 대상으로 파싱을 진행함!!!
			JSONParser jsonParser = new JSONParser();
			JSONObject obj = (JSONObject)jsonParser.parse(sb.toString());
			
			JSONArray petArray = (JSONArray)obj.get("pet");
			for(int i=0;i<petArray.size();i++) {
				JSONObject pet= (JSONObject)petArray.get(i);
				String type = (String)pet.get("type");
				String gender = (String)pet.get("gender");
				String name = (String)pet.get("name");
				
				System.out.println(type+", "+gender+", "+name+"\n");
			}
			
		}  catch (URISyntaxException e) {
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally {
			if(buffr!=null) {
				try {
					buffr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new JsonBasic3();
	}
}
