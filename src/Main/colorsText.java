package Main;

public class colorsText {
	
	public static String red(String string) {
		return "\033[0;31m" + string + "\033[0m"; 
	}
	
	public static String green(String string) {
		return "\033[0;32m" + string + "\033[0m"; 
	}
	
	public static String yellow(String string) {
		return "\033[0;33m" + string + "\033[0m"; 
	}
	
	public static String cyan(String string) {
		return "\033[0;36m" + string + "\033[0m"; 
	}
}	
