import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RWTools {

	/* this method writes to the course database using
	 * the required arguments 
	 */
	public void writeToCourse(String courseName, String courseID,
			String courseProgram, Object courseLvl, String courseInstructor, String coursePreReq,
			ArrayList courseDays, String startTime, String finishTime, Object courseCredit)
	{
		File file = new File("courseDB.txt");
		try{
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter br = new BufferedWriter(fw);
		br.write(String.format("\n\nCOURSE NAME: %s%s", courseName, courseLvl + courseID));
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
	/*this method writes to the 
	 * program database using the required arguments
	 */
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
	/*method to write to the department database
	 * using the required arguments and writing them into
	 the text file
	 */
	public void writeToDepartment(String departName, String departDescription, String departCode)
	{
		File file = new File("departmentDB.txt");
		try{
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter br = new BufferedWriter(fw);
		br.write(String.format("\n\nDEPARTMENT NAME: %s", departName));
		br.write(String.format("\nDEPARTMENT DESCRIPTION: %s", departDescription));
		br.write(String.format("\nDEPARTMENT CODE: %s", departCode));
		
		
		br.close();
		fw.close();
		
		}
		catch(IOException f){
			System.out.println("File Not found");
		}
	}
	
	/*method to write to the user database*/
	
	public void writeToUser(String userID, String passWord, String firstName, String lastName){
		File file = new File("staffDB.txt");
		try{
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fw);
			br.write(String.format("\n\nFULL NAME: %s %s", firstName, lastName));
			br.write(String.format("\nUSER ID: %s", userID));
			br.write(String.format("\nPassword: %s", passWord));
			
			br.close();
			fw.close();
		}
		catch(IOException f){
			System.out.println("File not found");
		}
	}
	/*this method is used to retrieve courses with a specific 
	 * course program, will return courses with the under the 
	 * program specified in the argument
	 */
	
	public ArrayList getCourseName(String program){
		ArrayList courses = new ArrayList<String>();
		File file = new File("courseDB.txt");
		try{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String text;
		while ((text = br.readLine()) != null){
			if (text.contains(program)){
				int index = text.indexOf(":");
				text = text.substring(index + 1);
				courses.add(text);
			}
		}
		br.close();
		fr.close();
		}
		catch(IOException f){
			System.out.println("File not found");
		}
		
		return courses;
	}
	
	/*this method is used to retrieve
	 * all programs in the database when called
	 */
	
	public ArrayList getPrograms(){
		ArrayList programs = new ArrayList<String>();
		File file = new File("programDB.txt");
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String text;
			while((text = br.readLine()) != null){
				if (text.contains("PROGRAM NAME")){
					int index = text.indexOf(":");
					programs.add(text.substring(index + 2));
				}
			}
			br.close();
			fr.close();
		}
		
		catch(IOException f){
			System.out.println("File not found");
		}
		return programs;
	}
	
	
	/*getting department names that are 
	 * added to the system
	 */
	
	public ArrayList getDepartment()
	{
		ArrayList departments = new ArrayList<String>();
		File file = new File("departmentDB.txt");
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				if (line.contains("DEPARTMENT NAME")){
					int index = line.indexOf(":");
					departments.add(line.substring(index + 2));
					}
			}
			br.close();
			fr.close();
		}
		catch(IOException f)
		{
			System.out.println("File not found");
		}
		
		return departments;
	}
	
	/* getting department information
	 * to display to users in the GUI
	 */
	
	
	public ArrayList getDepartmentInfo(String department)
	{
		ArrayList departInfo = new ArrayList<String>();
		File file = new File("departmentDB.txt");
		try{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null){
			if (line.contains("DEPARTMENT NAME: " + department)){
				String departmentDesc = br.readLine();
				int index = departmentDesc.indexOf(":");
				departInfo.add(departmentDesc.substring(index + 2));
				String departmentCode = br.readLine();
				int index1 = departmentCode.indexOf(":");
				departInfo.add(departmentCode.substring(index1 + 2));
				return departInfo;
			}
		}
		}
		catch(IOException f){
			System.out.print("File not found");
		}
		return null;
	}
	
	
	/*verification process to make
	 * sure the user has logged in with the correct
	 * information
	 */
	
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
			br.close();
			fr.close();
		}catch(IOException f){
			System.out.println("File not found");
		}
		
		
		return false;
	}
	
}
