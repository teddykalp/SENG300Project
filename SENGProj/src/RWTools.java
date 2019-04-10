import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
* RWTools class handles read and write to databases
* @author	Teddy Kalp, SheilaCubid (added antireqs and coreqs)
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
	* @param    courseDescription
	* @exception	IOException for file handling
	* @return	N/A
	*/
	public void writeToCourse(String courseName, String courseID,
			String courseProgram, Object courseLvl, String courseInstructor, String coursePreReq,
			String courseAntiReq, String courseCoReq, 
			ArrayList courseDays, String startTime, String finishTime, Object courseCredit, 
			String courseDescription, String programCode, String program)
	{
		File file = new File("courseDB.txt");
		try{
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter br = new BufferedWriter(fw);
		br.write(String.format("\n\nCOURSE NAME: %s", courseName));
		br.write(String.format("\nCOURSE CODE: %s", programCode + courseLvl + courseID));
		br.write(String.format("\nINSTRUCTOR: %s", courseInstructor));
		br.write(String.format("\nPREQUISITE COURSES: %s", coursePreReq));
		br.write(String.format("\nANTIREQUISITE COURSES: %s", courseAntiReq));
		br.write(String.format("\nCOREQUISITE COURSES: %s", courseCoReq));
		br.write("\nDAYS OFFERED\n");
		for (int x = 0; x < courseDays.size(); x++){
			br.write(courseDays.get(x)+ "\n");
		}
		br.write(String.format("START TIME: %s", startTime));
		br.write(String.format("\nFINISH TIME: %s" , finishTime));
		br.write(String.format("\nCOURSE CREDITS: %s", courseCredit));
		br.write(String.format("\nCOURSE DESCRIPTION: %s", courseDescription));
		br.write(String.format("\nPROGRAM: %s", program));
		
		br.close();
		fw.close();
		}
		catch(IOException f){
			System.out.println("1");
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
			Object programLvl, Object programType, String reqGPA, String programCode)
	{
		File file = new File("programDB.txt");
		try{
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter br = new BufferedWriter(fw);
		br.write(String.format("\n\nPROGRAM NAME: %s", programName));
		br.write(String.format("\nPROGRAM CODE: %s", programCode));
		br.write(String.format("\nPROGRAM DESCRIPTION: %s", programDescription));
	    br.write(String.format("\nDEPARTMENT: %s", programDepart));
		br.write(String.format("\nPROGRAM LEVEL: %s", programLvl));
		br.write(String.format("\nPROGRAM TYPE: %s", programType));
		br.write(String.format("\nRequired GPA: %s", reqGPA));
		
		br.close();
		fw.close();
		
		}
		catch(IOException f){
			System.out.println("2");
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
			System.out.println("3");
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
			System.out.println("4");
		}
	}
	
	/* getCourseName method is used to retrieve courses with a specific 
	 * course program, will return courses with the under the program specified in the argument
	 * @param	program
	 * @exception	IOException for file handling
	 * @return	courses
	 */
	
	public ArrayList getCourseName(String programCode){
		ArrayList courses = new ArrayList<String>();
		File file = new File("courseDB.txt");
		try{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String text;
		while ((text = br.readLine()) != null){
			if (text.contains(programCode)){
				int index = text.indexOf(":");
				text = text.substring(index + 1);
				courses.add(text);
			}
		}
		br.close();
		fr.close();
		}
		catch(IOException f){
			System.out.println("5");
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
			System.out.println("6");
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
			System.out.println("7");
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
			System.out.print("8");
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
			System.out.println("9");
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
			System.out.println("10");
		}
		return false;
	}
	
	/*
	 * method to obtain the program code using the program name as argument
	 */
	
	public String getProgramCode(String programName){
		File file = new File("programDB.txt");
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				if (line.equals("PROGRAM NAME: " + programName)){
					String code = br.readLine();
					int index = code.indexOf(":");
					return code.substring(index + 2);
				}
			}
		}catch(IOException E){
			System.out.println("11");
		}
		
		
		return null;
	}
	

	
	
	/*
	 * Get course names to display to 
	 * users in GUI
	 */
	
	public ArrayList getCourses()
	{
		ArrayList courses = new ArrayList<String>();
		File file = new File("courseDB.txt");
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null){
				if (line.contains("COURSE NAME")){
					int index = line.indexOf(":");
					courses.add(line.substring(index + 2));
					}
			}
			br.close();
			fr.close();
		}
		catch(IOException f)
		{
			System.out.println("12");
		}
		
		return courses;
	}
	
	/*
	 * Get course info to display
	 * to users to the GUI
	 */
	
	public ArrayList getCourseInfo(String course)
	{
		ArrayList courseInfo = new ArrayList<String>();
		File file = new File("courseDB.txt");
		try{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while ((line = br.readLine()) != null){
			if (line.contains("COURSE NAME: " + course)){
				String courseCode = br.readLine();
				int index = courseCode.indexOf(":");
				courseInfo.add(courseCode.substring(index + 2));
				
				String courseInstr = br.readLine();
				int index1 = courseInstr.indexOf(":");
				courseInfo.add(courseInstr.substring(index1 + 2));
				
				String prereqCourses = br.readLine();
				int index2 = prereqCourses.indexOf(":");
				courseInfo.add(prereqCourses.substring(index2 + 2));
				
				String antireqCourses = br.readLine();
				int index3 = antireqCourses.indexOf(":");
				courseInfo.add(antireqCourses.substring(index3 + 2));
				
				String coreqCourses = br.readLine();
				int index4 = coreqCourses.indexOf(":");
				courseInfo.add(coreqCourses.substring(index4 + 2));
				
				String offeredDays = br.readLine();
				String next = br.readLine();
				ArrayList<String> daysOffered = new ArrayList<String>();
				while(next.contains("day") )
				{
					daysOffered.add(next);
					next = br.readLine();
				}
				StringBuilder days = new StringBuilder();
				for (String st : daysOffered) {
					days.append(st);
					days.append(",");
				}
				courseInfo.add(days.toString());
				int index5 = next.indexOf(":");
				courseInfo.add(next.substring(index5 + 2));
				
				String endTime = br.readLine();
				int index6 = endTime.indexOf(":");
				courseInfo.add(endTime.substring(index6 + 2));
				
				String courseCreds = br.readLine();
				int index7 = courseCreds.indexOf(":");
				courseInfo.add(courseCreds.substring(index7 +2));
				
				String courseDescr = br.readLine();
				int index8 = courseDescr.indexOf(":");
				courseInfo.add(courseDescr.substring(index8 + 2));
				
				String courseProgram = br.readLine();
				int index9 = courseProgram.indexOf(":");
				courseInfo.add(courseProgram.substring(index9 + 2));
				return courseInfo;
			}
		}
		}
		catch(IOException f){
			System.out.print("13");
		}
		return null;
	}
		
	/* getProgramtInfo method is used to retrieve program info to display in GUI
	 * @param	program
	 * @exception	IOException for file handling
	 * @return	null
	 */
	
	public ArrayList getProgramInfo(String program) {
		
		ArrayList programInfo = new ArrayList<String>();
		File file = new File("programDB.txt");
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("PROGRAM NAME: " + program)) {
					String programCode = br.readLine();
					int index = programCode.indexOf(":");
					programInfo.add(programCode.substring(index + 2));
					String programDesc = br.readLine();
					int index1 = programDesc.indexOf(":");
					programInfo.add(programDesc.substring(index1 + 2));
					String programDep = br.readLine();
					int index2 = programDep.indexOf(":");
					programInfo.add(programDep.substring(index2 + 2));
					String programLvl = br.readLine();
					int index3 = programLvl.indexOf(":");
					programInfo.add(programLvl.substring(index3 + 2));
					String programType = br.readLine();
					int index4 = programType.indexOf(":");
					programInfo.add(programType.substring(index4 + 2));
					String reqGPA = br.readLine();
					int index5 = reqGPA.indexOf(":");
					programInfo.add(reqGPA.substring(index5 +2));
					return programInfo;
				}
			}
		}
		catch(IOException f){
			System.out.print("14");
		}
		return null;
	}
	
	/*
	 * Edits program info from user input in GUI
	 */
	
	public void editDB(String oldString, String newString, String filename)
    {
        File fileToBeModified = new File(filename);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replace(oldString, newString);
             
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                reader.close(); 
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

}
