// Import the FileWriter class
import java.io.FileWriter;

// Import the IOException class for handling errors
import java.io.IOException;

public class Write_file {
	public static void main(String[] args)
	{
		try {
			FileWriter Writer
				= new FileWriter("myfile.txt");
			Writer.write(
				"Files in Java are seriously good!!");
			Writer.close();
			System.out.println("Successfully written.");
		}
		catch (IOException e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
	}
}
