import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RWTools {

	public void writeToCourse(File file, String courseName, String courseID,
			String courseProgram, Object courseLvl, String courseInstructor, String coursePreReq,
			ArrayList courseDays, String startTime, String finishTime, Object courseCredit)
	{
		try{
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter br = new BufferedWriter(fw);
		br.write(String.format("\n\nCOURSE NAME: %s", courseName));
		br.write(String.format("\nCOURSE COURSE ID: %s", courseProgram+ courseLvl + courseID));
		br.write(String.format("\nINSTRUCTOR: %s", courseInstructor));
		br.write(String.format("\nPREQUISITE COURSES: %s", coursePreReq));
		br.write("\nDAYS OFFERED\n");
		for (int x = 0; x < courseDays.size(); x++){
			br.write(courseDays.get(x)+ "\n");
		}
		br.write(String.format("START TIME: %s", startTime));
		br.write(String.format("\nFINISH TIME: %s" , finishTime));
		br.write(String.format("\nCOURSE CREDITS: %s", courseCredit));
		
		br.close();
		fw.close();
		}
		catch(IOException f){
			System.out.println("File Not found");
		}
	}
}
