import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RWTools {

	public void writeToCourse(String courseName, String courseID,
			String courseProgram, Object courseLvl, String courseInstructor, String coursePreReq,
			ArrayList courseDays, String startTime, String finishTime, Object courseCredit)
	{
		File file = new File("courseDB.txt");
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
	
	public void writeToProgram(String programName, String programDescription, String programDepart,
			Object programLvl, Object programType, String reqGPA)
	{
		File file = new File("programDB.txt");
		try{
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter br = new BufferedWriter(fw);
		br.write(String.format("\n\nPROGRAM NAME: %s", programName));
		br.write(String.format("\nPROGRAM DESCRIPTION: %s", programDescription));
		br.write(String.format("\nDEPARTMENT: %s", programDepart));
		br.write(String.format("\nPROGRAM LEVEL %s", programLvl));
		br.write(String.format("\nPROGRAM TYPE: %s", programType));
		br.write(String.format("\nRequired GPA: %s", reqGPA));
		
		br.close();
		fw.close();
		
		}
		catch(IOException f){
			System.out.println("File Not found");
		}
	}
	
	public void writeToDepartment(String departName, String departDescription, String departCode)
	{
		File file = new File("departmentDB.txt");
		try{
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter br = new BufferedWriter(fw);
		br.write(String.format("\n\nDEPARTMENT NAME: %s %s", departName, departCode));
		br.write(String.format("\nDEPARTMENT DESCRIPTION: %s", departDescription));
		
		br.close();
		fw.close();
		
		}
		catch(IOException f){
			System.out.println("File Not found");
		}
	}
	
	public void writeToUser(String userID, String passWord, String firstName, String lastName){
		File file = new File("staffDB.txt");
		try{
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fw);
			br.write(String.format("\n\n FULL NAME: %s %s", firstName, lastName));
			br.write(String.format("\nUSER ID: %s", userID));
			br.write(String.format("\nPassword: %s", passWord));
			
		}
		catch(IOException f){
			System.out.println("File not found");
		}
	}
	
	public ArrayList getCourseName(){
		ArrayList courses = new ArrayList<String>();
		File file = new File("courseDB.txt");
		try{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String text;
		while ((text = br.readLine()) != null){
			if (text.contains("COURSE NAME")){
				int index = text.indexOf(":");
				text = text.substring(index + 1);
				courses.add(text);
			}
		}
		}
		catch(IOException f){
			System.out.println("File not found");
		}
		
		return courses;
	}
	
	public boolean verifyUser(String userID, String passWord){
		File file = new File("staffDB.txt");
		
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null){
				if (line.contains("USER ID")){
					int index = line.indexOf(":");
					if (line.substring(index + 2).equals(userID)){
						String pass = br.readLine();
						int passDex = pass.indexOf(":");
						pass = pass.substring(passDex + 2);
						if (pass.equals(passWord)){
							return true;
						}
						
					}
				}
			}
		}catch(IOException f){
			System.out.println("File not found");
		}
		
		
		return false;
	}
	
}
