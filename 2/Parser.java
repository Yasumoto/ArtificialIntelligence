import java.io.*;

public class Parser {
	private BufferedReader data;
	public Parser(String fileName){
		try {
			data = new BufferedReader(new FileReader(fileName));

			createGrid();

			data.close();
                }

                catch (IOException e) {
			System.err.println("Error opening " +fileName + " for reading");
			e.printStackTrace();
                }
        }
	
	private void createGrid() {
		try {
			int arraySize = (int)data.read() - '0';
			int count = 0;
			//ArrayList al = new ArrayList(arraySize);
			System.out.println("The size of the array will be: " + arraySize);

			//Clear the newline from the size of Array.
			data.read();

			while (data.ready()) {
				data.readLine();
				++count;
			}

			if (count != arraySize)
				System.out.println("Error!!! Count is: " + count);
		}
		
                catch (IOException e) {
			System.err.println("Error reading the IOstream");
			e.printStackTrace();
                }
	}
}
