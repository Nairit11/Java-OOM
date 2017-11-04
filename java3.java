import java.util.*;
public class Question1{
public static abstract class student{
    private String name;
    private String rollNo;
    private String type;
    private int credits;
    private int per_of_reg;
    public student(String type,String rollNo,String name,int per_of_reg,int credits){
        this.name=name;
        this.rollNo=rollNo;
        this.type=type;
        this.per_of_reg=per_of_reg;
        this.credits=credits;
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
    int getcredits(){
        return credits;
    }
    abstract public void show();
}

public static class ug extends student{
    private String dept;
    private int cgpa;

    public ug(String type,String rollNo,String name,String dept,int per_of_reg,int cgpa,int credits){
        super(type,rollNo,name,per_of_reg,credits);
        this.dept=dept;
        this.cgpa=cgpa;
    }
    String getdept(){
        return dept;
    }
    int getcgpa(){
        return cgpa;
    }
    public void show(){
        System.out.println(this.getrollNo()+" "+this.getname()+" "+this.gettype()+" "+this.getdept()+" "+this.getcgpa());
    }
}

public static class pg extends ug{
    private String spec;
    private String thesisArea;
    public pg(String type,String rollNo,String name,String dept,String spec,int per_of_reg,int cgpa,int credits,String thesisArea){
        super(type,rollNo,name,dept,per_of_reg,cgpa,credits);
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
        System.out.println(this.getrollNo()+" "+this.getname()+" "+this.gettype()+" "+this.getdept()+" "+this.getspec()+" "+this.getcgpa());
    }
}

public static class ugPg extends pg{
    private int year_of_pg;
    public ugPg(String type,String rollNo,String name,String dept,String spec,int per_of_reg,int cgpa,int credits,String thesisArea,int year_of_pg){
        super(type,rollNo,name,dept,spec,per_of_reg,cgpa,credits,thesisArea);
        this.year_of_pg=year_of_pg;
    }
    int year_of_pg(){
        return year_of_pg;
    }
    public void show(){
        System.out.println(this.getrollNo()+" "+this.getname()+" "+this.gettype()+" "+this.getdept()+" "+this.getspec()+" "+this.getcgpa());
    }
}

public static class phd extends student{
    private String thesis;
    public phd(String type,String rollNo,String name,int per_of_reg,int credits,String thesis){
        super(type,rollNo,name,per_of_reg,credits);
        this.thesis=thesis;
    }
    String getthesis(){
        return thesis;
    }
    public void show(){
        System.out.println(this.getrollNo()+" "+this.getname()+" "+this.gettype());
    }
}

public static class pgPhd extends phd{
    private int cgpa;
    private int year_of_doc;
    public pgPhd(String type,String rollNo,String name,int per_of_reg,int cgpa,int credits,String thesis,int year_of_doc){
        super(type,rollNo,name,per_of_reg,credits,thesis);
        this.cgpa=cgpa;
        this.year_of_doc=year_of_doc;
    }
    int getcgpa(){
        return cgpa;
    }
    int getyear_of_doc(){
        return year_of_doc;
    }
    public void show(){
        System.out.println(this.getrollNo()+" "+this.getname()+" "+this.gettype()+" "+this.getcgpa());
    }
}

public static class group{
    private int ctr;
    private int i;
    private int n;
    int flag[];
    private student[] gp=new student[n];
    
    public group(int n,student[] gp){
        this.ctr=0;
        this.i=0;
        this.n=n;
        this.gp=gp;
        this.flag=new int[n];
    }
    
    public void display(){
        for(i=0;i<n;i++){
            if(gp[i].gettype().equals("UG")){
                if(gp[i].getper_of_reg()<=6 && gp[i].getper_of_reg()>=4 && gp[i].getcredits()>=185)
                    {
                        flag[i]=1;
                        ctr++;
                    }
            }
            else if(gp[i].gettype().equals("PG")){
                if(gp[i].getper_of_reg()<=4 && gp[i].getper_of_reg()>=2 && gp[i].getcredits()>=80)
                    {
                        flag[i]=1;
                        ctr++;
                    }
            }
            else if(gp[i].gettype().equals("UG+PG")){
                if(gp[i].getper_of_reg()<=8 && gp[i].getper_of_reg()>=5 && gp[i].getcredits()>=265)
                    {
                        flag[i]=1;
                        ctr++;
                    }
            }
            else if(gp[i].gettype().equals("PhD")){
                if(gp[i].getper_of_reg()<=6 && gp[i].getper_of_reg()>=2 && gp[i].getcredits()>=64)
                    {
                        flag[i]=1;
                        ctr++;
                    }
            }
            else if(gp[i].gettype().equals("PG+PhD")){
                if(gp[i].getper_of_reg()<=7 && gp[i].getper_of_reg()>=4 && gp[i].getcredits()>=138)
                    {
                        flag[i]=1;
                        ctr++;
                    }
            }
        }
        System.out.println(ctr);
        for(i=0;i<n;i++){
            if(flag[i]==1)
                 gp[i].show();
        }
    }
}
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        String type;
        while(t>0){
            int n=sc.nextInt();
            student[] stud=new student[n];
            group g=new group(n,stud);
            
            for(int i=0;i<n;i++){
                type=sc.next();
                String rollNo=sc.next();
                String name=sc.next();
                if(type.equals("UG"))
                {   
                    String dept=sc.next();
                    int per_of_reg=sc.nextInt();
                    int cgpa=sc.nextInt();
                    int credits=sc.nextInt();
                    stud[i]=new ug(type, rollNo, name, dept, per_of_reg, cgpa, credits);
                }
                else if(type.equals("PG"))
                {   
                    String dept=sc.next();
                    String spec=sc.next();
                    int per_of_reg=sc.nextInt();
                    int cgpa=sc.nextInt();
                    int credits=sc.nextInt();
                    String thesis=sc.next();
                    stud[i]=new pg(type, rollNo, name, dept, spec, per_of_reg, cgpa, credits, thesis);
                }
                else if(type.equals("UG+PG"))
                {   
                    String dept=sc.next();
                    String spec=sc.next();
                    int per_of_reg=sc.nextInt();
                    int cgpa=sc.nextInt();
                    int credits=sc.nextInt();
                    String thesis=sc.next();
                    int year_of_pg=sc.nextInt();
                    stud[i]=new ugPg(type, rollNo, name, dept, spec, per_of_reg,cgpa, credits, thesis, year_of_pg);
                }
                else if(type.equals("PhD"))
                {   
                    int per_of_reg=sc.nextInt();
                    int credits=sc.nextInt();
                    String thesis=sc.next();
                    stud[i]=new phd(type, rollNo, name, per_of_reg, credits, thesis);
                }
                else if(type.equals("PG+PhD"))
                {   
                    int per_of_reg=sc.nextInt();
                    int cgpa=sc.nextInt();
                    int credits=sc.nextInt();
                    String thesis=sc.next();
                    int year_of_doc=sc.nextInt();
                    stud[i]=new pgPhd(type, rollNo, name, per_of_reg, cgpa, credits, thesis, year_of_doc);
                }
            }
            g.display();
            t--;
        }
    }
}
    