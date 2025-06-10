package arreglos;

public class ForEach {

	public static void main(String[] args) {
		String [] nombres= {"Alejandro","Luis","Maria"};
		for (String string : nombres) {
			if(string.equals("Maria"))
			System.out.println(string);
		}
	}

}
