import java.util.*;
import java.lang.Math;

public class Main{
    public static abstract class student{
        private String name;
        private String rollNo;
        private String type;
        private int per_of_reg;
        public student(String type,String rollNo,String name,int per_of_reg){
            this.name=name;
            this.rollNo=rollNo;
            this.type=type;
            this.per_of_reg=per_of_reg;
        }
        String getname(){
            return name;
        }
        String getrollNo(){
            return rollNo;
        }
        String gettype(){
            return type;
        }
        int getper_of_reg(){
            return per_of_reg;
        }
        abstract public void show();
    }

    public static class ug extends student{
        private String dept;

        public ug(String type,String rollNo,String name,String dept,int per_of_reg){
            super(type,rollNo,name,per_of_reg);
            this.dept=dept;
        }
        String getdept(){
            return dept;
        }
        public void show(){
            System.out.print(this.getrollNo()+" "+this.getname()+" "+this.gettype()+" "+this.getdept());
        }
    }

    public static class pg extends ug{
        private String spec;
        private String thesisArea;
        public pg(String type,String rollNo,String name,String dept,String spec,int per_of_reg,String thesisArea){
            super(type,rollNo,name,dept,per_of_reg);
            this.spec=spec;
            this.thesisArea=thesisArea;
        }
        String getspec(){
            return spec;
        }
        String getthesisArea(){
            return thesisArea;
        }
        public void show(){
            System.out.print(this.getrollNo()+" "+this.getname()+" "+this.gettype()+" "+this.getdept()+" "+this.getspec());
        }
    }

    public static class ugPg extends pg{
        private int year_of_pg;
        public ugPg(String type,String rollNo,String name,String dept,String spec,int per_of_reg,String thesisArea,int year_of_pg){
            super(type,rollNo,name,dept,spec,per_of_reg,thesisArea);
            this.year_of_pg=year_of_pg;
        }
        int year_of_pg(){
            return year_of_pg;
        }
        public void show(){
            System.out.print(this.getrollNo()+" "+this.getname()+" "+this.gettype()+" "+this.getdept()+" "+this.getspec());
        }
    }

    public static class phd extends student{
        private String thesis;
        public phd(String type,String rollNo,String name,int per_of_reg,String thesis){
            super(type,rollNo,name,per_of_reg);
            this.thesis=thesis;
        }
        String getthesis(){
            return thesis;
        }
        public void show(){
            System.out.print(this.getrollNo()+" "+this.getname()+" "+this.gettype());
        }
    }

    public static class pgPhd extends phd{
        private int year_of_doc;
        public pgPhd(String type,String rollNo,String name,int per_of_reg,String thesis,int year_of_doc){
            super(type,rollNo,name,per_of_reg,thesis);
            this.year_of_doc=year_of_doc;
        }
        int getyear_of_doc(){
            return year_of_doc;
        }
        public void show(){
            System.out.print(this.getrollNo()+" "+this.getname()+" "+this.gettype());
        }
    }

    public static class course{
        private String courseID;
        private String rollNo;
        private int credits;
        private int attnd;
        private String grade;
        public course(String courseID,int credits,String rollNo,int attnd,String grade){
            this.courseID=courseID;
            this.rollNo=rollNo;
            this.credits=credits;
            this.attnd=attnd;
            this.grade=grade;
        }
        String getcourseID(){
            return courseID;
        }
        String getrollNo(){
            return rollNo;
        }
        int getcredits(){
            return credits;
        }
        int getattnd(){
            return attnd;
        }
        int getgrade(){
            if(grade.equals("A+"))
                return 10;
            else if (grade.equals("A"))
                return 9;
            else if (grade.equals("B+"))
                return 8;
            else if (grade.equals("B"))
                return 7;
            else if (grade.equals("C"))
                return 6;
            else if (grade.equals("D"))
                return 5;
            else if (grade.equals("E"))
                return 4;
            else return 0;

        }
    }

    public static class evaluate{
        private int i;
        private int j;
        private int n;
        private int m;
        private int ctr;
        private int cgpa[];
        private int flag[];
        private int credits[];
        private student[] stud=new student[n];
        private course[] cs=new course[m];
        public evaluate(int n,int m,student[] stud,course[] cs){
            this.n=n;
            this.i=0;
            this.j=0;
            this.ctr=0;
            this.m=m;
            this.stud=stud;
            this.cs=cs;
            this.cgpa=new int[n];
            this.credits=new int[n];
            this.flag=new int[n];
        }
        public void display(){
            for(i=0;i<n;i++){
                for(j=0;j<m;j++){
                    if(cs[j].getrollNo().equals(stud[i].getrollNo()) && cs[j].getattnd()>=75 && cs[j].getgrade()!=0){
                        credits[i]+=cs[j].getcredits();
                        cgpa[i]+=cs[j].getgrade()*cs[j].getcredits();
                    }
                }
                cgpa[i]=Math.round((float)cgpa[i]/credits[i]);
                if(stud[i].gettype().equals("UG")){
                    if(stud[i].getper_of_reg()<=6 && stud[i].getper_of_reg()>=4 && credits[i]>=185)
                    {
                        flag[i]=1;
                        ctr++;
                    }
                }
                else if(stud[i].gettype().equals("PG")){
                    if(stud[i].getper_of_reg()<=4 && stud[i].getper_of_reg()>=2 && credits[i]>=80)
                    {
                        flag[i]=1;
                        ctr++;
                    }
                }
                else if(stud[i].gettype().equals("UG+PG")){
                    if(stud[i].getper_of_reg()<=8 && stud[i].getper_of_reg()>=5 && credits[i]>=265)
                    {
                        flag[i]=1;
                        ctr++;
                    }
                }
                else if(stud[i].gettype().equals("PhD")){
                    if(stud[i].getper_of_reg()<=6 && stud[i].getper_of_reg()>=2 && credits[i]>=64)
                    {
                        flag[i]=1;
                        ctr++;
                    }
                }
                else if(stud[i].gettype().equals("PG+PhD")){
                    if(stud[i].getper_of_reg()<=7 && stud[i].getper_of_reg()>=4 && credits[i]>=138)
                    {
                        flag[i]=1;
                        ctr++;
                    }
                }
            }
            System.out.println(ctr);
            for(i=0;i<n;i++){
                if(flag[i]==1){
                    stud[i].show();
                    if(stud[i].gettype().equals("PhD"))
                        System.out.println();
                    else
                        System.out.println(" "+cgpa[i]);
                }

            }
        }

    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        String type;
        int i=0;
        while(t>0){
            int n=sc.nextInt();
            student[] stud=new student[n];
            for(i=0;i<n;i++){
                type=sc.next();
                String rollNo=sc.next();
                String name=sc.next();
                if(type.equals("UG"))
                {
                    String dept=sc.next();
                    int per_of_reg=sc.nextInt();
                    stud[i]=new ug(type, rollNo, name, dept, per_of_reg);
                }
                else if(type.equals("PG"))
                {
                    String dept=sc.next();
                    String spec=sc.next();
                    int per_of_reg=sc.nextInt();
                    String thesis=sc.next();
                    stud[i]=new pg(type, rollNo, name, dept, spec, per_of_reg, thesis);
                }
                else if(type.equals("UG+PG"))
                {
                    String dept=sc.next();
                    String spec=sc.next();
                    int per_of_reg=sc.nextInt();
                    String thesis=sc.next();
                    int year_of_pg=sc.nextInt();
                    stud[i]=new ugPg(type, rollNo, name, dept, spec, per_of_reg, thesis, year_of_pg);
                }
                else if(type.equals("PhD"))
                {
                    int per_of_reg=sc.nextInt();
                    String thesis=sc.next();
                    stud[i]=new phd(type, rollNo, name, per_of_reg, thesis);
                }
                else if(type.equals("PG+PhD"))
                {
                    int per_of_reg=sc.nextInt();
                    String thesis=sc.next();
                    int year_of_doc=sc.nextInt();
                    stud[i]=new pgPhd(type, rollNo, name, per_of_reg, thesis, year_of_doc);
                }
            }
            int m=sc.nextInt();
            course[] cs=new course[m];
            evaluate eva=new evaluate(n,m,stud,cs);
            for(i=0;i<m;i++){
                String courseID=sc.next();
                int credits=sc.nextInt();
                String rollNo=sc.next();
                int attnd=sc.nextInt();
                String grade=sc.next();
                cs[i]=new course(courseID,credits,rollNo,attnd,grade);
            }
            eva.display();
            t--;
        }
    }
}
