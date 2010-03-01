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

		//System.out.println("We have the created grid!");

		//parseShiz.gridPrint(arr, arraySize);

		queue = new PriorityQueue(arraySize * arraySize);

		Node init = new Node(arr[initialPosition[0]][initialPosition[1]], initialPosition, null);

		//System.out.println("The initial node has data of: " + init.getData());

		Node potential = findNeighbors(init, arr);

		int count = 0;
		try {
			//System.out.println("Count: " + count++);
		while(potential.getData() != 'g') {
			//System.out.println("Count: " + count++);
			potential = findNeighbors((Node)queue.poll(), arr);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

		potential = potential.getParent();

		while (potential.getParent() != null) {
			int[] wellPlayed = potential.getLocation();
			arr[wellPlayed[0]][wellPlayed[1]] = 'o';
			potential = potential.getParent();
		}


		parseShiz.gridPrint(arr, arraySize);

	}

	Node findNeighbors(Node theNode, char[][] arr) {
		int[] loc = theNode.getLocation();
		Node newOne;

		int i = 0;
		int j = -1;
				// Don't go to blocked nodes (walls) or out of bounds areas
				if (loc[0]+i >= 0 && loc[1]+j >= 0 && loc[0]+i < arraySize && loc[1]+j < arraySize && arr[loc[0]+i][loc[1]+j] != '+' ) {
					int []theLocation={loc[0]+i, loc[1]+j};
					// Create the new node object with its data, location, and parent
					newOne = new Node(arr[loc[0]+i][loc[1]+j], theLocation, theNode);
					// Add the new node to the priority queue
					if (x.add(Integer.toString(newOne.getLocation()[0]) + Integer.toString(newOne.getLocation()[1]))) {
						//System.out.println("(" + (newOne.getLocation())[0] + ", " + (newOne.getLocation())[1] + ")");
						queue.add((Node)newOne);
						// if this is the goal, then we return because we're good to roll
						if (arr[loc[0]+i][loc[1]+j] == 'g'){
							return newOne;
						}
					}
				}

		i = 0;
		j = 1;
				// Don't go to blocked nodes (walls) or out of bounds areas
				if (loc[0]+i >= 0 && loc[1]+j >= 0 && loc[0]+i < arraySize && loc[1]+j < arraySize && arr[loc[0]+i][loc[1]+j] != '+' ) {
					int[] locationTwo = { loc[0]+i, loc[1]+j};
					// Create the new node object with its data, location, and parent
					newOne = new Node(arr[loc[0]+i][loc[1]+j], locationTwo, theNode);
					// Add the new node to the priority queue
					if (x.add(Integer.toString(newOne.getLocation()[0]) + Integer.toString(newOne.getLocation()[1]))) {
						//System.out.println("(" + (newOne.getLocation())[0] + ", " + (newOne.getLocation())[1] + ")");
						queue.add((Node)newOne);
						// if this is the goal, then we return because we're good to roll
						if (arr[loc[0]+i][loc[1]+j] == 'g'){
							return newOne;
						}
					}
				}

		j = 0;
		i = -1;
				// Don't go to blocked nodes (walls) or out of bounds areas
				if (loc[0]+i >= 0 && loc[1]+j >= 0 && loc[0]+i < arraySize && loc[1]+j < arraySize && arr[loc[0]+i][loc[1]+j] != '+' ) {
					int[] locationThree = { loc[0]+i, loc[1]+j};
					// Create the new node object with its data, location, and parent
					newOne = new Node(arr[loc[0]+i][loc[1]+j], locationThree, theNode);
					// Add the new node to the priority queue
					//if (x.add(newOne.getLocation()[0]) || y.add(newOne.getLocation()[1])) {
					if (x.add(Integer.toString(newOne.getLocation()[0]) + Integer.toString(newOne.getLocation()[1]))) {
						//System.out.println("(" + (newOne.getLocation())[0] + ", " + (newOne.getLocation())[1] + ")");
						queue.add((Node)newOne);
						// if this is the goal, then we return because we're good to roll
						if (arr[loc[0]+i][loc[1]+j] == 'g'){
							return newOne;
						}
					}
				}

		j = 0;
		i = 1;
				// Don't go to blocked nodes (walls) or out of bounds areas
				if (loc[0]+i >= 0 && loc[1]+j >= 0 && loc[0]+i < arraySize && loc[1]+j < arraySize && arr[loc[0]+i][loc[1]+j] != '+' ) {
					int[] locationFour = { loc[0]+i, loc[1]+j};
					// Create the new node object with its data, location, and parent
					newOne = new Node(arr[loc[0]+i][loc[1]+j], locationFour, theNode);
					// Add the new node to the priority queue
					//if (x.add(newOne.getLocation()[0]) || y.add(newOne.getLocation()[1])) {
					if (x.add(Integer.toString(newOne.getLocation()[0]) + Integer.toString(newOne.getLocation()[1]))) {
						//System.out.println("(" + (newOne.getLocation())[0] + ", " + (newOne.getLocation())[1] + ")");
						queue.add((Node)newOne);
						// if this is the goal, then we return because we're good to roll
						if (arr[loc[0]+i][loc[1]+j] == 'g'){
							return newOne;
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
			theNode.setDistance(theNode.pathLength + euclidean_distance(theNode.getLocation(), goalPosition));
		}
		else if (situation == 3) {
			theNode.setDistance(theNode.pathLength + manhattan_distance(theNode.getLocation(), goalPosition));
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

