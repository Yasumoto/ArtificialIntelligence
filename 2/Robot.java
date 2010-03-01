public class Robot{
	public static void main(String[] args){
		if (args.length != 1) {
			System.out.println("Please enter the filename to check as input.");
			System.exit(1);
		}
		
		Parser parseShiz = new Parser(args[0]);

		Graph graph;

		System.out.println("Euclidean Distance!");
		graph = new Graph(parseShiz, 0);

		System.out.println("Manhattan Distance!");
		graph = new Graph(parseShiz, 1);

		System.out.println("Cost + Euclidean Distance!");
		graph = new Graph(parseShiz, 2);

		System.out.println("Cost + Manhattan Distance!");
		graph = new Graph(parseShiz, 3);

	}
}
