/**
 * 
 */
package command;

/**
 * 
 */
public class Utils {
	
	public static void printErr(String err) {
		int size = err.length()+2;
		String s = "";
		// Head
		s += "/";
		for(int i = 0; i < size; i++) {
			s+="-";
		}
		s += "\\ \n";
		// Center
		s += "| ";
		s += err;
		s += " |\n";
		//
		s += "\\";
		for(int i = 0; i < size; i++) {
			s+="-";
		}
		s += "/ \n";
		
		System.out.print(s);
	}
	
	public static void main(String[] agrs) {
		Utils.printErr("Ceci est un test");
		
	}
	
}
