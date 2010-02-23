public class Robot{
	public static void main(String[] args){
		if (args.length != 1) {
			System.out.println("Please enter the filename to check as input.");
			System.exit(1);
		}
		
		Parser parseShiz = new Parser(args[0]);
	}
}
