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
	* @param    courseDescription
	* @exception	IOException for file handling
	* @return	N/A
	*/
	public void writeToCourse(String courseName, String courseID,
			String courseProgram, Object courseLvl, String courseInstructor, String coursePreReq,
			ArrayList courseDays, String startTime, String finishTime, Object courseCredit, String courseDescription, String programCode)
	{
		File file = new File("courseDB.txt");
		try{
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter br = new BufferedWriter(fw);
		br.write(String.format("\n\nCOURSE NAME: %s", courseName));
		br.write(String.format("\nCOURSE CODE: %s", programCode + courseLvl + courseID));
		br.write(String.format("\nINSTRUCTOR: %s", courseInstructor));
		br.write(String.format("\nPREQUISITE COURSES: %s", coursePreReq));
		br.write("\nDAYS OFFERED\n");
		for (int x = 0; x < courseDays.size(); x++){
			br.write(courseDays.get(x)+ "\n");
		}
		br.write(String.format("START TIME: %s", startTime));
		br.write(String.format("\nFINISH TIME: %s" , finishTime));
		br.write(String.format("\nCOURSE CREDITS: %s", courseCredit));
		br.write(String.format("\nCOURSE DESCRIPTION: %s", courseDescription));
		
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
			System.out.println("FIle not found");
		}
		
		
		return null;
	}
	

	public void editDepartment(String oldString, String newString)
	    {
	        File fileToBeModified = new File("departmentDB.txt");
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
			System.out.println("File not found");
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
				int index3 = next.indexOf(":");
				courseInfo.add(next.substring(index3 + 2));
				String endTime = br.readLine();
				int index4 = endTime.indexOf(":");
				courseInfo.add(endTime.substring(index4 + 2));
				String courseCreds = br.readLine();
				int index5 = courseCreds.indexOf(":");
				courseInfo.add(courseCreds.substring(index5 +2));
				String courseDescr = br.readLine();
				int index6 = courseDescr.indexOf(":");
				courseInfo.add(courseDescr.substring(index6 + 2));
				return courseInfo;
			}
		}
		}
		catch(IOException f){
			System.out.print("File not found");
		}
		return null;
	}
	
	/*
	 * Currently still has bugs, but
	 * edits info of course
	 */
	public void editCourse(String oldString, String newString)
    {
        File fileToBeModified = new File("courseDB.txt");
        String oldContent = "";
        BufferedReader br = null;
        FileWriter fw = null;
         
        try
        {
            br = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = br.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                line = br.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);
            
            //Rewriting the input text file with newContent
            fw = new FileWriter(fileToBeModified);
            fw.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
                fw.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

}
