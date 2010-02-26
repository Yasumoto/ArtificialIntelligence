import java.util.PriorityQueue;

public class Fringe{
	private PriorityQueue queue;

	public Fringe(Parser parseShiz){
                char[][] arr = parseShiz.getGrid();
		int[] initialPosition = parseShiz.getInitial();
		int[] goalPosition = parseShiz.getGoal();
		int arraySize = parseShiz.getArraySize();

		System.out.println("We have the created grid!");

		parseShiz.gridPrint(arr, arraySize);

		queue = new PriorityQueue(arraySize * arraySize);
	}

	void calculateDistance(Node theNode, int[] initialPosition, int[] goalPosition){
		//theNode.setManhattanDistance() = theNode.()
	}
}

