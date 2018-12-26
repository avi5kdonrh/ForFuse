
public class TestClass1 {

	public static void main(String[] args) {
		String line = "This is the next century where the universe is free";
		char first = line.charAt(0);
		char last  = line.charAt(line.length()-1);
		System.out.println(first+line.substring(1, line.length()-2).replaceAll("|", "_^_")+last);
	}
}
