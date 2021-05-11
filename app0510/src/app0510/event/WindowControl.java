package app0510.event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//윈도우 이벤트를 감지하는 WindowListener를 재정의
public class WindowControl implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Window Open");
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosing");	
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");			
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");			
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");			
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");			
	}

}
