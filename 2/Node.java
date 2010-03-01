public class Node implements Comparable<Node> {
	// What type of node is it?
	private char data;
	// What coordinates is this node at?
	private int[] location;
	// What path did we take to get here?
	private Node parent;
	// How far away have we come?
	private int stepsFromInitial;
	// How much further do we need to go?
	private float distance;

	public int pathLength;


	public Node(char theData, int[] theLocation, Node theParent) {
		data = theData;
		location = theLocation;
		parent = theParent;

		if (theParent != null){
			stepsFromInitial = theParent.getStepsFromInitial() + 1;
			pathLength = theParent.pathLength + 1;
		}
		else {
			stepsFromInitial = 0;
			pathLength = 0;
		}
	}

	public char getData() {
		return data;
	}

	public int[] getLocation() {
		return location;
	}

	public Node getParent() {
		return parent;
	}
	
	public int getStepsFromInitial() {
		return stepsFromInitial;
	}

	public void setStepsFromInitial(int theSteps) {
		stepsFromInitial = theSteps;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float theDistance) {
		distance = theDistance;
	}

	public int compareTo(Node other) {
        	if (distance < other.getDistance()) {
			return -1;
		}
        	else if (distance > other.getDistance()) {
			return 1;
		}
        	else {
			return 0;
		}

	}
}
