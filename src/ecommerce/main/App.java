package ecommerce.main;

import java.io.IOException;
import ecommerce.facade.UsetInterfaceFacade;


public class App {
	public static void main(String[] args) throws IOException {
			UsetInterfaceFacade UI = new UsetInterfaceFacade();
			UI.startUI();	
	}
}
