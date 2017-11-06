import java.util.*;


public static class InvalidRollNoException extends Exception{
    private String str;
    InvalidRollNoException(String s){
        super(s);
        this.str=s;
    }
    @Override
    public String toString() {
        return (str);
    }
}


public static class InvalidCourseCodeException extends Exception{
    private String str;
    InvalidCourseCodeException(String s){
        super(s);
        this.str=s;
    }
    @Override
    public String toString() {
        return (str);
    }
}

public static class InvalidGradeException extends Exception{
    private String str;
    InvalidGradeException(String s){
        super(s);
        this.str=s;
    }
    @Override
    public String toString() {
        return (str);
    }
}

public static class InvalidQueryException extends Exception{
    private String str;
    InvalidQueryException(String s){
        super(s);
        this.str=s;
    }
    @Override
    public String toString() {
        return (str);
    }
}

public static class student {

    private String rollNo;
    private course[] courses;
    private int c;
    private float sum,sumcr;
    public student(String rollNo){
	String sub1=rollNo.substring(0,3);
	String sub2=rollNo.substring(6,7);
	int sub3=Integer.parseInt(rollNo.substring(7,10));
	if(sub1.equals("IIT") || sub1.equals("LIT") || sub1.equals("IIM") || sub1.equals("BIM") || sub1.equals("ICM") || sub1.equals("ISM") || 		sub1.equals("IIM") || sub1.equals("IHM") || sub1.equals("IRM") || sub1.equals("IWM")){
	    if(sub2.equals("6") || sub2.equals("5") || sub2.equals("4") || sub2.equals("3")){
		if(sub3>0 && sub3<=199){		
        	    this.rollNo=rollNo;	
		    this.sum=0.0;
	            this.sumcr=0.0;
		    return;
    	        }
	    }	
        }
	throw new InvalidRollNoException(“Incorrect Roll Number”);
    }
    void setc(int c){
	this.c=c;
	this.courses=new course[c];
    }
    String getrollNo(){
        return rollNo;
    }
    float cgpa(){
    	for(int i=0;i<c;i++){
	    sum=sum+courses[i].getCredits()*courses[i].getGrade();
	    sumcr=sumcr+courses[i].getCredits();
	}
	return sum/sumcr;
    }
    public course getCourse(int j){
	return courses[j];
    }
}

public static class Batch{

    private student stud[];
    public batch(int stud){
        this.stud=new student[stud];
    }
    public void st_assign(int i, String rollNo){
        stud[i]=new student(rollNo);
    }
    student getstudent(int i){
        return stud[i];
    }
}

public static class course{

    private String courseID;
    private String grade;
    private int credits;

    public course(String courseID) {
	String str1=coursID.substring(0,1);
	int str2=Integer.parseInt(courseID.substring(4,5));
	int str3=Integer.parseInt(courseID.substring(5,6));
	int str4=Integer.parseInt(courseID.substring(6,7));
	String str5=coursID.substring(7,8);
	if(str1.equals("S") || str1.equals("E") || str1.equals("I") || str1.equals("M")){
	    if(str2>0 && str2<=9 && str3>=0 && str3<=3 && str4>=0 && str4<=3 ){
		if(str5.equlas("C") || str5.equals("E")){
        	   this.courseID = courseID;
        	   this.credits=Integer.parseInt(courseID.substring(5,6))+Integer.parseInt(courseID.substring(6,7));
		   return ;
		}
	    }    
	}
	throw new InvalidCourseCodeException(“Wrong Course Code”);
    }
    public void setGrade(String grade){
	if (!(grade.equals("A+") || grade.equals("A") || grade.equals("B+") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("E") || grade.equals("F") || grade.equals("I")))
	    throw new InvalidGradeException(“Illegal Grade”);
	else
	    this.grade=grade;
    }

    public String getCourseID() {
        return courseID;
    }

    public int getGrade() {
        if(grade.equals("A+"))
            return 10;
        else if(grade.equals("A"))
            return 9;
        else if(grade.equals("B+"))
            return 8;
        else if(grade.equals("B"))
            return 7;
        else if(grade.equals("C"))
            return 6;
        else if(grade.equals("D"))
            return 5;
        else
            return 4;
    }

    public int getCredits(){
        return credits;
    }
}

public static class display{
	private String rollNo;	
	public display(String rollno){
		this.rollNo=rollno;
	}
}
public class Assignment4{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
	Batch bt=new Batch(n);
        for(int i=0;i<n;i++){
	    try{
            	String rollNo=sc.nextLine();
		bt.st_assign(i,rollNo);
	    }catch(InvalidRollNoException a){
		System.out.println(a);
		i--;
		continue;
	    }
	    
            int m=sc.nextInt();
	    bt.getstudent(i).setc(m);
            for(int j=0;j<m;j++){
		try{
		    String courseID=sc.nextLine();
		    bt.getstudent(i).getCourse(j)=new course(courseID);
		}catch(InvalidCourseCodeException b){
		    System.out.println(b);
 		    j--;
		    continue;
		}LABEL:		
		try{
		    String grade=sc.nextLine();
		    bt.getstudent(i).getCourse(j).setGrade(grade);
		}catch(InvalidGradeException c){
		    System.out.println(c);
		    continue LABEL;
		}
            }
        }
	int t=sc.nextInt();
	for(i=0;i<t;i++){
	    String query=sc.nextLine();
	    
    }
}
