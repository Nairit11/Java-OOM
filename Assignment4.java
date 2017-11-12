import java.util.*;

class InvalidRollNoException extends Exception{
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


class InvalidCourseCodeException extends Exception{
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

class InvalidGradeException extends Exception{
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

class InvalidQueryException extends Exception{
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

class student {
    private String rollNo;
    private course[] courses;
    private int c;
    private double sum,sumcr;
    public student(){
	   this.sum=0.0;
	   this.sumcr=0.0;
    }
    
    public void setRollNo(String RollNo) throws InvalidRollNoException{
        int flag=0;
        if(RollNo.length()==10){
            String sub1=RollNo.substring(0,3);
            int sub2=Integer.parseInt(RollNo.substring(6,7));
	        int sub3=Integer.parseInt(RollNo.substring(7,10));
	        if(sub1.equals("IIT") || sub1.equals("LIT") || sub1.equals("IIM") || sub1.equals("BIM") || sub1.equals("ICM") || sub1.equals("ISM") || sub1.equals("IIM") || sub1.equals("IHM") || sub1.equals("IRM") || sub1.equals("IWM")){
	            if(sub2>=3 && sub2<=6){
		            if(sub3>0 && sub3<=199){		
                        this.rollNo=RollNo;	
                        flag=1;
                    }
                }	
            }
        }
        if(flag!=1){
            throw new InvalidRollNoException("Incorrect Roll Number");
        }    
    }
    
    void setc(int c){
	    this.c=c;
	    this.courses=new course[c];
	    for(int i=0;i<c;i++){
	        courses[i]=new course();
	    }
    }
    
    String getrollNo(){
        return rollNo;
    }
    
    public double getCgpa(){
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

class Batch{

    private student[] stud;
    
    public Batch(int n){
        this.stud=new student[n];
        
    }
    public void st_assign(int i, String rollNo) throws InvalidRollNoException{
        stud[i]=new student();
        stud[i].setRollNo(rollNo);
    }
    student getstudent(int i){
        return stud[i];
    }
}

class course{

    private String courseID;
    private String grade;
    private int credits;

    public course(){
	
    }
    
    public void setCourseID(String courseID) throws InvalidCourseCodeException{
        int flag=0;
        if(courseID.length()==8){    
            String str1=courseID.substring(0,1);
	        int str2=Integer.parseInt(courseID.substring(4,5));
	        int str3=Integer.parseInt(courseID.substring(5,6));
	        int str4=Integer.parseInt(courseID.substring(6,7));
	        String str5=courseID.substring(7,8);
            
            if(str1.equals("S") || str1.equals("E") || str1.equals("I") || str1.equals("M")){
                if(str2>0 && str2<=9 && str3>=0 && str3<=4 && str4>=0 && str4<=3 ){
                    if(str5.equals("C") || str5.equals("E")){
                        this.courseID = courseID;
                        this.credits=Integer.parseInt(courseID.substring(5,6))+Integer.parseInt(courseID.substring(6,7));
                        flag=1;
                    }
                }    
            }
        }
        if(flag!=1){
	        throw new InvalidCourseCodeException("Wrong Course Code");
        }
    }
    
    public void setGrade(String grade) throws InvalidGradeException{
	    if (!(grade.equals("A+") || grade.equals("A") || grade.equals("B+") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("E") || grade.equals("F") || grade.equals("I")))
	        throw new InvalidGradeException("Illegal Grade");
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

class display{
	private int query;
	private int n;
	Batch bt;
	public display(int n,Batch bt){
	    this.n=n;
	    this.bt=bt;
	}
	void setQuery(String rollNo) throws InvalidQueryException{
	    int i;
		for(i=0;i<n;i++){
		    if(bt.getstudent(i).getrollNo().equals(rollNo))
			break;
		}
		if(i==n){
		    throw new InvalidQueryException("Roll Number not found");
		    
		}
		this.query=i;
	}
	void show(){
	    int scale = (int) Math.pow(10, 1);
	    double value=bt.getstudent(query).getCgpa();     
	    System.out.println((double) Math.round(value * scale) / scale);

	}
}
public class Main{
    public static void main(String args[]){
        int i,flag=0;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String rollNo=sc.nextLine();
	    Batch bt=new Batch(n);
        for(i=0;i<n;i++){
            while(true){
	            try{
                    rollNo=sc.nextLine();
		            bt.st_assign(i,rollNo);
		            break;
	            }catch(InvalidRollNoException a){
		            System.out.println(a);
	            }
            }
            int m=sc.nextInt();
            String courseID=sc.nextLine();
	        bt.getstudent(i).setc(m);
            for(int j=0;j<m;j++){
                while(true){
		            try{
		                courseID=sc.nextLine();
		                bt.getstudent(i).getCourse(j).setCourseID(courseID);
		                break;
		            }catch(InvalidCourseCodeException b){
		                System.out.println(b);
		            }
                }
                while(true){
                    try{
                        String grade=sc.nextLine();
                        bt.getstudent(i).getCourse(j).setGrade(grade);
                        break;
                    }catch(InvalidGradeException c){
                        System.out.println(c);
                    }
                }
            }
        }
    
	    int t=sc.nextInt();
	    String query=sc.nextLine();
	    display dp=new display(n,bt);
	    for(i=0;i<t;i++){
            try{
                query=sc.nextLine();
                dp.setQuery(query);
                dp.show();   
            }catch(InvalidQueryException d){
                    System.out.println(d);
            }
            
	    }                                                                             
    }
}
