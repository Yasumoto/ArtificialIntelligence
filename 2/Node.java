public class Node{
	// What type of node is it?
	private char data;
	// What coordinates is this node at?
	private int[] location;
	// What path did we take to get here?
	private Node parent;
	// How far away have we come?
	private int stepsFromInitial;
	// How much further do we need to go?
	private int manhattanDistance;
	// For some of us, this isn't very far...
	private int straightDistance;


	public Node(char theData, int[] theLocation, Node theParent) {
		data = theData;
		location = theLocation;
		parent = theParent;

		if (theParent != null){
			stepsFromInitial = theParent.getStepsFromInitial() + 1;
		}
		else {
			stepsFromInitial = 0;
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

	public int getManhattanDistance() {
		return manhattanDistance;
	}

	public void setManhattanDistance(int theDistance) {
		manhattanDistance = theDistance;
	}

	public int getStraightDistance() {
		return straightDistance;
	}

	public void setStraightDistance(int theDistance) {
		straightDistance = theDistance;
	}
}
