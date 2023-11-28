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
	
    public static String printLine(String msg, int n){ // n is the number of word per line wanted
        String[] msgList = msg.split(" "); 		// Splitting String with space as sep to retrieve each word
        String strres = "";
        for(int i =0; i < msgList.length; i++) {
        	if(i%n == 0 && i != 0) {
        		strres += "\n";
        	}
        	strres += msgList[i]+" ";
        }
        return strres;
        
    }
    
    
    /*
     * Print n "-"
     * */
    public static void printDash(int n) {
    	String res = "";
    	for(int i=0; i < n; i++) {
    		res += "-";
    	}
    	System.out.println(res);
    }
    

    
    /*
     * Main for testing
     */
	public static void main(String[] agrs) {
		Utils.printErr("Ceci est un test");
		String mstring = "Ceci est un test pour vérifier si on arrive bien a compter les mots ";
		System.out.print(Utils.printLine(mstring, 4));
	}
	
}
