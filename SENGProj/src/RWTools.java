import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
* RWTools class handles read and write to databases
* @author	Teddy Kalp
* @version	1.0
*/

public class RWTools {

	/**
	* writeToCourse writes course info to courseDB.txt 
	* @param	courseName
	* @param	courseID
	* @param	courseProgram
	* @param	courseInstructor
	* @param	coursePrereq
	* @param	courseDays
	* @param	startTime
	* @param	finishTtime
	* @param	courseCredit
	* @exception	IOException for file handling
	* @return	N/A
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
	/**
	* writetoProgram writes program info to programDB.txt 
	* @param	programName
	* @param	programID
	* @param	programDepart
	* @param	progLvl
	* @param	programType
	* @param	reqGPA
	* @exception	IOException for file handling
	* @return	N/A
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
	/**
	* writeToDepartment writes department info to departmentDB.txt 
	* @param	departName
	* @param	departDescription
	* @param	departCode
	* @exception	IOException for file handling
	* @return	N/A
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
	
	/**
	* writeToUser writes department info to staffDB.txt 
	* @param	userID
	* @param	password
	* @param	firstName
	* @param	lastName
	* @param	email
	* @param	mailing
	* @param	department
	* @param	stafftype
	* @param	phonenumber
	* @exception	IOException for file handling
	* @return	N/A
	*/
	
	public void writeToUser(String userID, String passWord, String firstName, String lastName, String email,
			String mailing, String department, String staffType, String phoneNumber)
	{
		File file = new File("staffDB.txt");
		try{
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fw);
			br.write(String.format("\n\nFULL NAME: %s %s", firstName, lastName));
			br.write(String.format("\nUSER ID: %s", userID));
			br.write(String.format("\nPassword: %s", passWord));
			br.write(String.format("\nPHONE NUMBER: %s", phoneNumber));
			br.write(String.format("\nEMAIL ADDRESS: %s", email));
			br.write(String.format("\nMAILING ADDRESS: %s", mailing));
			br.write(String.format("\nDEPARTMENT: %s", department));
			br.write(String.format("\nSTAFF TYPE: %s", staffType));
			
			
			br.close();
			fw.close();
		}
		catch(IOException f){
			System.out.println("File not found");
		}
	}
	
	/* getCourseName method is used to retrieve courses with a specific 
	 * course program, will return courses with the under the program specified in the argument
	 * @param	program
	 * @exception	IOException for file handling
	 * @return	courses
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
	
	/* getPrograms method is used to retrieve all programs in the database when called
	 * @param	None
	 * @exception	IOException for file handling
	 * @return	programs
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
	
	/* getDepartment method is used to retrieve all departments in the database when called
	 * @param	None
	 * @exception	IOException for file handling
	 * @return	departments
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
	
	/* getDepartmentInfo method is used to retrieve department info to display in GUI
	 * @param	department
	 * @exception	IOException for file handling
	 * @return	null
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
	
	
	/* verifyUser to verify that user login is correct in staffDB.txt
	 * @param	userID
	 * @param	password
	 * @exception	IOException for file handling
	 * @return	null
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
	/* method that will be used to see if a new user
	 * is trying to enter a userID that is being used
	 */
	public boolean userFound(String user){
		File file = new File("staffDB.txt");
		
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				if (line.contains("USER ID: " + user)){
					return true;
				}
			}
			
			br.close();
			fr.close();
		}
		catch (IOException e){
			System.out.println("File not Found");
		}
		return false;
	}
}
