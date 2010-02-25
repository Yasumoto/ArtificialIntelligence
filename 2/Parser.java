import java.io.*;

public class Parser {
	private BufferedReader data;
	private char[][] arr;
	private int[] initialPosition;
	private int[] goalPosition;
	private int arraySize;

	public Parser(String fileName){
		try {
			data = new BufferedReader(new FileReader(fileName));

			createGrid();
			System.out.println("The Initial Position should be at: (" + initialPosition[0] + ", " + initialPosition[1] + ")");
			System.out.println("The Goal Position should be at: (" + goalPosition[0] + ", " + goalPosition[1] + ")");

			data.close();
                }

                catch (IOException e) {
			System.err.println("Error opening " +fileName + " for reading");
			e.printStackTrace();
                }
        }
	
	private void createGrid() {
		try {
			arraySize = (int)data.read() - '0';
			initialPosition = new int[2];
			goalPosition = new int[2];
			System.out.println("The size of the array will be: " + arraySize);
			arr = new char[arraySize][arraySize];

			//Clear the newline from the size of Array.
			data.read();

			for(int i = 0; i < arraySize; ++i){
				for (int j = 0; j < arraySize; ++j){
					arr[i][j] = (char)data.read();
					//Determine Initial Position
					if (arr[i][j] == 'i'){
						initialPosition[0] = i;
						initialPosition[1] = j;
					}

					// Determine Goal Position
					if (arr[i][j] == 'g'){
						goalPosition[0] = i;
						goalPosition[1] = j;
					}

				}
				data.read();
			}

			gridPrint(arr, arraySize);
		}
		
                catch (IOException e) {
			System.err.println("Error reading the IOstream");
			e.printStackTrace();
                }

	}

	public char[][] getGrid(){
		return arr;
	}

	public int[] getInitial(){
		return initialPosition;
	}

	public int[] getGoal(){
		return goalPosition;
	}

	public int getArraySize(){
		return arraySize;
	}

	public void gridPrint(char[][] arr, int arraySize){
		// Used for Grid Reading validation
		for(int i = 0; i < arraySize; ++i){
			for (int j = 0; j < arraySize; ++j){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
