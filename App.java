
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;



//MAIN CLASS
public class App {
    public static void main(String[] args) throws IOException, idException {
        System.out.println("\t\t\t\t\t\t\tWelcome to my Personal Management Program");
        Scanner sc = new Scanner(System.in);
       //Array to stores Persons(students,falculty,staff,etc)
       Person[] arr = new Person[100];
        int i=0;
        
        System.out.println("Choose one of the options:");
       
        String ch;
        do{
            
            // menu
            System.out.println("\n1- Enter the information of the faculty");
            System.out.println("2- Enter the information of the two students");
            System.out.println("3- Print tution invoice");
            System.out.println("4- Print faculty information");
            System.out.println("5- Enter the information of the staff member");
            System.out.println("6- Print the information of the staff member");
            System.out.println("7- Exit Program");

            System.out.print("\n\tEnter your selection: ");
            ch = sc.next();


            //print menu if invalid entry
            while ((ch.charAt(0) >= 'a' && ch.charAt(0) <= 'z') || (ch.charAt(0) >= 'A' && ch.charAt(0) <= 'Z') || Integer.parseInt(ch) > 7 ){
                System.out.println("\nInvalid entry- please try again");
                System.out.println("\n1- Enter the information of the faculty");
                System.out.println("2- Enter the information of the two students");
                System.out.println("3- Print tution invoice");
                System.out.println("4- Print faculty information");
                System.out.println("5- Enter the information of the staff member");
                System.out.println("6- Print the information of the staff member");
                System.out.println("7- Exit Program");
                System.out.print("\n\tEnter your selection: ");
                ch = sc.next();
            }

            switch (Integer.parseInt(ch)){
                case 1:
                    System.out.println("\nEnter faculty info: ");
                    System.out.print("\t\tName of the faculty: ");
                    sc.nextLine();
                    String fname = null;
                    
                    //do {
                    	 //System.out.print("\tName of the faculty: ");
                    	 fname=sc.nextLine();
                         //try {
                        	// if(!isValidname(fname)) throw new idException("\tName of the faculty: ");
                       //  }
                         //catch(idException e) {
                        	 //System.out.print(e);
                         //}
                   // }while(!isValidname(fname));
                   
                    String fid = null;
                    boolean f1=true;
                    
                    
                    do {
                    	System.out.print("\t\tID: ");
                    	
                         fid = sc.nextLine();
                         if(arr[0]==null) {
                        	// System.out.print(arr.length);
                    		 f1=true;
                    	 }
                         else {
                        	 f1=true;
                        	 
                         for(int j=0; j<i;j++) {
                        	 
                        	if(arr[j].ID.equals(fid)) {
                        		
                    			f1=false;
                    			break;
                    		 }
                         }
                         }
                    try {
                 
                    if(!isValidId(fid)) throw new idException("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit ");
                    
                    }
                    
                    catch(idException e) {
                    	System.out.println(e);
                    }
                    try {
                        
                        
                        if(f1==false) throw new idException("ID already exist. Try Again!");
                        }
                        
                        catch(idException a) {
                        	System.out.println(a);
                        }
                    
                    }while((!isValidId(fid))||f1!=true);
                    
                    System.out.print("\t\tRank: ");
                    String rank = sc.nextLine();
                    String ranklowercase = rank.toLowerCase();
                    while (ranklowercase.equals("professor") == false && ranklowercase.equals("adjunct") == false){
                        System.out.println("\t\t\t \""  +rank+"\"" + " is invalid");
                        System.out.print("\t\tRank: ");
                        rank = sc.nextLine();
                        ranklowercase = rank.toLowerCase();
                    };
                    System.out.print("\t\tDepartment: ");
                    String department = sc.next();
                    String departmentlower = department.toLowerCase();
                    while (departmentlower.equals("engineering") == false &&  departmentlower.equals("mathematics") == false && departmentlower.equals("arts") == false && departmentlower.equals("sciences") == false){
                    	 System.out.println("\t\t\t \""  +department+"\"" + " is invalid");
                        System.out.print("\t\tDepartment: ");
                        department = sc.nextLine();
                        departmentlower = department.toLowerCase();
                    };
                    arr[i]=new Faculty(fname,fid,departmentlower,rank);
                    i++;
                    System.out.println("\nFaculty added!\n");
   
                    break;

                case 2:
 	               System.out.println("\n\nEnter the student info:");
 	               System.out.print("\t\tName of Student: ");
 	               sc.nextLine();
 	               String name = sc.nextLine();
 	               
 	               String id;
 	              boolean f2=true;
                  
                  
                  do {
                  	System.out.print("\t\tID: ");
                  	
                       id = sc.nextLine();
                       if(arr[0]==null) {
                      	// System.out.print(arr.length);
                  		 f2=true;
                  	 }
                       else {
                      	 f2=true;
                      	 
                       for(int j=0; j<i;j++) {
                      	 
                      	if(arr[j].ID.equals(id)) {
                      		
                  			f2=false;
                  			break;
                  		 }
                       }
                       }
                  try {
               
                  if(!isValidId(id)) throw new idException("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit ");
                  
                  }
                  
                  catch(idException e) {
                  	System.out.println(e);
                  }
                  try {
                      
                      
                      if(f2==false) throw new idException("ID already exist. Try Again!");
                      }
                      
                      catch(idException a) {
                      	System.out.println(a);
                      }
                  
                  }while((!isValidId(id))||f2!=true);
 	              
 	              double gpa=-1;
 	             //Handles gpa exceptions
 	             System.out.print("\t\tGpa: ");
 	             do {
 	                try {
 	                	//System.out.print("\t\tGpa: ");
 	                       gpa = sc.nextDouble();
 	                       if(gpa <0){
 	                            throw new Exception("\t\tGpa: ");
 	                       }
 	                   } catch (InputMismatchException e) {
 	                         System.out.print("\t\tGpa: ");
 	                   } catch (Exception e) {
 	                          System.out.print(e.getMessage());
 	                 }
 	                 sc.nextLine();
 	            } while (gpa <0);
 	               
 	               System.out.print("\t\tCredit hours: ");
 	               int numHours = sc.nextInt();
 	               arr[i] = new Student(name, id, gpa, numHours);
 	               i++;
 	               System.out.println("\nStudent added!");
 	               break;
 	               
                case 3:
                	System.out.print("\nEnter the student's id: ");
 	               	sc.nextLine();
 	               	boolean flag = false;
 	               	String sidd = sc.nextLine();
 	               	for (int j = 0; j < i; j++) {
 	                   if (sidd.equals(arr[j].getId())) {
 	                       arr[j].print();
 	                       flag = true;
 	                   }
 	               }
 	               	if (!flag) {
 	                   System.out.println("\nNo Student matched!");
 	               }
 	               	break;
                case 4:
                	System.out.print("\nEnter the Faculty's id: ");
 	               	sc.nextLine();
 	               	boolean flag2 = false;
 	               	String ffid = sc.nextLine();
 	               	for (int j = 0; j < i; j++) {
 	                   if (ffid.equals(arr[j].getId())) {
 	                       arr[j].print();
 	                       flag2 = true;
 	                   }
 	               }
 	               	if (!flag2) {
 	                   System.out.println("\nNo Falculty matched!");
 	               }
                    break;
                case 5:
                	System.out.println("\nEnter Staff info:");
                    System.out.print("\tName of the staff member: ");
                    sc.nextLine();
                    
                    String sname = sc.nextLine();
                    String sid;
                    boolean f3=true;
                    
                  
                    do {
                    	System.out.print("\tEnter the Id: ");
                    	
                         sid = sc.nextLine();
                         if(arr[0]==null) {
                        	// System.out.print(arr.length);
                    		 f3=true;
                    	 }
                         else {
                        	 f3=true;
                        	 
                         for(int j=0; j<i;j++) {
                        	 
                        	if(arr[j].ID.equals(sid)) {
                        		
                    			f3=false;
                    			break;
                    		 }
                         }
                         }
                    try {
                 
                    if(!isValidId(sid)) throw new idException("Invalid ID format. Must be LetterLetterDigitDigitDigitDigit ");
                    
                    }
                    
                    catch(idException e) {
                    	System.out.println(e);
                    }
                    try {
                        
                        
                        if(f3==false) throw new idException("ID already exist. Try Again!");
                        }
                        
                        catch(idException a) {
                        	System.out.println(a);
                        }
                    
                    }while((!isValidId(sid))||f3!=true);
                    
                    
                    System.out.print("\tDepartment: ");
                    String departmentStaff = sc.nextLine();
                    String departmentStafflower = departmentStaff.toLowerCase();
                    while (departmentStafflower.equals("engineering") == false &&  departmentStafflower.equals("mathematics") == false && departmentStafflower.equals("sciences")==false){
                    	System.out.println("\t \""  +departmentStaff+"\"" + " is invalid");
                        System.out.print("\tDepartment: ");
                        departmentStaff = sc.nextLine();
                        departmentStafflower = departmentStaff.toLowerCase();
                    };
                    System.out.print("\tStatus Enter P for part time or Enter F for Full time: ");
                    String status = sc.nextLine();
                    String statuslowercase = status.toLowerCase();
                    while (statuslowercase.equals("f") == false && statuslowercase.equals("p") == false){
                    	 System.out.println("\t \""  +status+"\"" + " is invalid");
                        System.out.print("\tStatus Enter P for part time or Enter F for Full time: ");
                        status = sc.nextLine();
                        statuslowercase=status.toLowerCase();
                    }
                    if(statuslowercase.equals("f"))
                    	status="Full Time";
                    else if(statuslowercase.equals("p"))
                    	status="Part Time";
                   
                    arr[i] = new Staff(sname, sid, departmentStaff.toLowerCase(), status);
                    i++;
                    System.out.println("\nStaff member added!\n");
                    
                    break;
                    
                case 6:
                	System.out.print("\nEnter the Staff's id: ");
 	               	sc.nextLine();
 	               	boolean flag3 = false;
 	               	String stid = sc.nextLine();
 	               	for (int j = 0; j < i; j++) {
 	                   if (stid.equals(arr[j].getId())) {
 	                       arr[j].print();
 	                       flag3 = true;
 	                   }
 	               }
 	               	if (!flag3) {
 	                   System.out.println("\nNo Staff member matched!");
 	               }
 	               	break;
                					
                default:
                    break;
            }

        }while (Integer.parseInt(ch) != 7);
        //System.out.println("\n\nGoodbye!");
        
        
        System.out.print("Would you like to create the report? (Y/N): " );
       
    	String choice=sc.next();
    	choice=choice.toLowerCase();
    	if(choice.equals("y")) {
    		 System.out.print("Report created and saved on hard drive!");
    		int fc=1, stc=1, stfc=1;
    		
    		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    	    //get current date time with Date()
    	    Date date = new Date();
    	 
    	    String header ="\t\tReport created on " +dateFormat.format(date)+"\r\n"
    	      		+ "\t\t*********************** ";
    	    String filename="report.txt";
    	    saveTofile(filename,header,false);
    	    String fheader="\n\nFaculty Members \r\n" + "------------------------";
    	    saveTofile(filename,fheader,true);
    	    
    	    for(Person f:arr) {
    	    	if(f instanceof Faculty) {
    	    		saveTofile(filename,"\t"+fc +"."+f.toString(),true);
    	    		fc++;
    	    	}
    	    }
    	    String sheader="\nStaff Members \r\n" + "------------------------";
    	    saveTofile(filename,sheader,true);
    	    for(Person f:arr) {
    	    	if(f instanceof Staff) {
    	    		saveTofile(filename,"\t"+stc +"."+f.toString(),true);
    	    		stc++;
    	    	}
    	    }
    	    String stheader="\nStudents \r\n" + "------------------------";
    	    saveTofile(filename,stheader,true);
    	    for(Person f:arr) {
    	    	if(f instanceof Student) {
    	    		saveTofile(filename,"\t"+stfc +"."+f.toString(),true);
    	    		stfc++;
    	    	}
    	    }
    	    
    	      
    	}
    	System.out.print("\nGoodbye!");
    	  System.exit(0);
        
    }
    
    public static boolean isValidId(String Id) throws idException {
      if (Id.length() != 6) 
        return false;
      // check first two chars to make sure they are alphabetic
      if(!Character.isLetter(Id.charAt(0)) || !Character.isLetter(Id.charAt(1)))
        return false;

      // check last 4 to make sure they are numeric/integers
      for(int i=2; i<Id.length();i++){
         if(!Character.isDigit(Id.charAt(i)))
            return false;
         
      }

      return true;
    }
    
    public static boolean isValidname(String name) throws idException {
    
        

        for(int i=0; i<name.length();i++){
           if(Character.isLetter(name.charAt(i))||Character.isWhitespace(name.charAt(i)))
              continue;
           
        }

        return false;
      }
 public static void saveTofile(String fname, String str, boolean app) throws IOException{
	 File f1= new File(fname);
	 
	 FileWriter write=new FileWriter(f1, app);
	 
	 PrintWriter print=new PrintWriter(write);
	 
	 print.println(str);
	 print.close();
	 
 }
 

}//end of MAIN class

//CLass STUDENT is a Person
 class Student extends Person  {
   
    private double GPA;
    private int creditHours;

    
    public Student(){
    	super();
    }

    
    public Student(String fullName, String ID, double GPA, int creditHours) {
        super(fullName,ID);
        this.GPA = GPA;
        this.creditHours = creditHours;
    }

    //getters and setters 
    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public double getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    
    @Override
	public void print() {
        double total = 0.0;
        double discount = 0;
        if(GPA >= 3.85){
            discount = (((creditHours * 236.45) + 52) * 0.15);
            total = ((creditHours * 236.45) + 52) - (((creditHours * 236.45) + 52) * 0.15);
        }else{
            total = ((creditHours * 236.45) + 52);
        }
        
        NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
        System.out.println("\nHere is the tuition invoice for "+getFullName()+ " :");
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println(getFullName() + "\t\t"+getId());
        System.out.println("Credit Hours: " + creditHours + "\t($236.45/credit hour)");
        System.out.println("Fees: $52\n\n");
        System.out.println("Total Payment (after discount): " + defaultFormat.format(total) + "\t\t\t\t\t\t(" + defaultFormat.format(discount) + " discount applied)");
        System.out.println("---------------------------------------------------------------------------------------------------");
    	
    }
    
    public String toString() {
    	String fullname=super.fullName;
    	String Id=super.ID;
    	
    	return fullname+ " \n\tID: "+Id+" \n\t"+"Gpa: "+ getGPA()+"\n\t"+"Credit Hours: "+getCreditHours()+"\n";
    }


}

//class FACULTY is an EMPLOYEE
class Faculty extends Employee{
   
    private String rank;

    public Faculty() {
    	super();
    }

    
    public Faculty(String fullName, String ID, String department, String rank) {
       super(fullName,ID,department);
        this.rank = rank;
    }
    
    //getters and setters
   
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
    
    public String toString() {
    	String fullname=super.fullName;
    	String Id=super.ID;
    	String department =super.getDepartment();
    	return fullname+ " \n\tID: "+Id+" \n\t"+ getRank()+" ,"+department+"\n";
    }
    /*
    public static boolean isValidId(String Id)
    {
      if (Id.length() != 6)
        return false;
      // check first two chars to make sure they are alphabetic
      if(!Character.isLetter(Id.charAt(0)) || !Character.isLetter(Id.charAt(1)))
        return false;

      // check last 4 to make sure they are numeric/integers
      for(int i=2; i<Id.length();i++){
         if(!Character.isDigit(Id.charAt(i))){
            return false;
         }
      }

      return true;
    }
*/
    //prints faculty info
    public void print() {
	       System.out.println("----------------------------------------------------------------");
	       super.print();
	       System.out.println(cap(getDepartment())+" Department, "+cap(getRank()));
	       System.out.println("----------------------------------------------------------------");
	   }

}
//class STAFF is a EMPLOYEE
class Staff extends Employee {
   
    private String status;

    
    public Staff() {
    	super();
    }

   
    public Staff(String fullName, String ID, String department, String status) {
        super(fullName,ID,department);
        this.status = status;
    }
    
    
   
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
    	
    	this.status = status;
    }
    @Override
	   public void print() {
	       System.out.println("----------------------------------------------------------------");
	       super.print();
	       System.out.println(cap(getDepartment())+" Department, "+cap(getStatus()) );
	       System.out.println("----------------------------------------------------------------");
	   }
    public String toString() {
    	String fullname=super.fullName;
    	String Id=super.ID;
    	String department =super.getDepartment();
    	return fullname+ " \n\tID: "+Id+" \n\t"+ department+" ,"+getStatus()+"\n";
    }

  
}
//SUPER CLASS
 abstract class Person {
	    protected String fullName;
	    protected String ID;
	    
	    public Person() {
		   }

		   
		   public Person(String fullName, String ID) {
		       this.fullName = fullName;
		       this.ID = ID;
		   }

		   
		   public String getFullName() {
		       return fullName;
		   }

		   
		   public String getId() {
		       return ID;
		   }

		   
		   public void setFullName(String fullName) {
		       this.fullName = fullName;
		   }

		   public void setId(String ID) {
		       this.ID = ID;
		   }
		  
		   
	   
	public abstract void print();
	public  String cap(String str) {
		return str.substring(0,1).toUpperCase()+str.substring(1);
	}
}
 //Class EMPLOYEE is a person
abstract class Employee extends Person {
   
    private String department;
    
    public Employee(){
    	super();
    }
    
    public Employee(String fullName, String ID, String department) {
    	super(fullName,ID);
    	this.department=department;
    }
    
    
    
    public String getDepartment() {
    	return department;
    }
    
    
    public void setDepartment(String department) {
    	this.department=department;
    }
    
    public void print() {
	       System.out.println(getFullName() + "\t" + getId());
	   }
}

class idException extends Exception{
	  private String message;
	  
	  public idException(String message){
	    this.message=message;
	    }
	    
	    public String getMessage(){
	      return message;
	    }
	}
