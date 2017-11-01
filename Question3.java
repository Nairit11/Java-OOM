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

    private String name;
    private String rollNo;
    public student(String name,String rollNo){
        this.name=name;
        this.rollNo=rollNo;
    }
    String getname(){
        return name;
    }
    String getrollNo(){
        return rollNo;
    }
}

public static class batch{

    student stud[];
    public batch(int stud){
        this.stud=new student[stud];
    }
    public void st_assign(int i, String rollNo, String name){
        stud[i]=new student(name,rollNo);
    }
    student getstudent(int i){
        return stud[i];
    }
}

public static class course{

    private String courseID;
    private String grade;
    private int credits;

    public course(String courseID, String grade) {
        this.courseID = courseID;
        this.grade = grade;
        this.credits=Integer.parseInt(courseID.substring(5,6))+Integer.parseInt(courseID.substring(6,7));
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

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String rollNo=sc.nextLine();
            int m=sc.nextInt();
            for(int j=0;j<m;j++){

            }

        }
    }