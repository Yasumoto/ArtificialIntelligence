import java.util.PriorityQueue;
import java.math.*;
import java.util.HashSet;

public class Graph{
	private PriorityQueue queue;
	int arraySize;
	HashSet x;
	HashSet y;

	public Graph(Parser parseShiz, int situation){
                char[][] arr = parseShiz.getGrid();
		int[] initialPosition = parseShiz.getInitial();
		int[] goalPosition = parseShiz.getGoal();
		arraySize = parseShiz.getArraySize();
		x = new HashSet(arraySize * arraySize);
		y = new HashSet(arraySize * arraySize);

		System.out.println("We have the created grid!");

		parseShiz.gridPrint(arr, arraySize);

		queue = new PriorityQueue(arraySize * arraySize);

		Node init = new Node(arr[initialPosition[0]][initialPosition[1]], initialPosition, null);

		System.out.println("The initial node has data of: " + init.getData());

		Node potential = findNeighbors(init, arr);

		int count = 0;
		while(potential.getData() != 'g') {
			System.out.println("Count: " + count++);
			potential = findNeighbors((Node)queue.poll(), arr);
		}

	}

	Node findNeighbors(Node theNode, char[][] arr) {
		int[] loc = theNode.getLocation();
		Node newOne;
		for(int i = -1; i < 2; i = i+2){
			for(int j = -1; j < 2; j = j+2){
				// System.out.println("i: " + i + " and j: " + j);
				// Don't go to blocked nodes (walls) or out of bounds areas
				//System.out.println((int)loc[0]+ i);
				if (loc[0]+i >= 0 && loc[1]+j >= 0 && loc[0]+i < arraySize && loc[1]+j < arraySize && arr[loc[0]+i][loc[1]+j] != '+' ) {
					System.out.println((int)loc[0]+ i);
					// Create the array of the node's x,y coordinates
					int[] nodePosition = { loc[0]+i, loc[1]+j };
					//System.out.println(arr[loc[0]+i][loc[1]+j]);
					// Create the new node object with its data, location, and parent
					newOne = new Node(arr[loc[0]+i][loc[1]+j], nodePosition, theNode);
					// Add the new node to the priority queue
					if (x.add(newOne.getLocation()[0]) | y.add(newOne.getLocation()[1])) {
						//System.out.println(newOne.getLocation()[0]);
						//System.out.println(newOne.getLocation()[1]);
					System.out.println("(" + (newOne.getLocation())[0] + ", " + (newOne.getLocation())[1] + ")");
					queue.add((Node)newOne);
					// if this is the goal, then we return because we're good to roll
					if (arr[loc[0]+i][loc[1]+j] == 'g'){
						System.out.println("Goal!");
						return newOne;
					}
					}
				}
			}
		}
		return (Node)queue.peek();
	}



	void calculateDistance(Node theNode,int[] goalPosition, int situation){
		if (situation == 0) {
			theNode.setDistance(euclidean_distance(theNode.getLocation(), goalPosition));
		}
		else if (situation == 1) {
			theNode.setDistance(manhattan_distance(theNode.getLocation(), goalPosition));
		}
		else if (situation == 2) {
			theNode.setDistance(euclidean_distance(theNode.getLocation(), goalPosition));
		}
		else if (situation == 3) {
			theNode.setDistance(manhattan_distance(theNode.getLocation(), goalPosition));
		}
	}

	//E((i,j),(i',j')) = sqrt[(i-i')^2+(j-j')^2])
	public float euclidean_distance(int[] current, int[] goal)
	{
		return (float) Math.sqrt( (float)Math.abs((float)(current[0] - goal[0])*(float)(current[0] - goal[0]) +
				(float)(current[1] - goal[1])*(float)(current[1] - goal[1])) );
	}

	//M((i,j),(i',j')) = |i-i'| + |j-j'|)
	public int manhattan_distance(int[] current, int[] goal)
	{
		return Math.abs(current[0] - goal[0]) + Math.abs(current[1] - goal[1]);
	}

}

