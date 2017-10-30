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
        private String type;
        private String courseID;
        private String rollNo;
        private int credits;
        private int total;
        public course(String type,String courseID,int credits,String rollNo){
            this.courseID=courseID;
            this.type=type;
            this.rollNo=rollNo;
            this.credits=credits;
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
        String gettype(){
            return type;
        }
        int gettotal(){
            return total;
        }
    }

    public static class theory extends course{
        private int attnd;
        private int midsem;
        private int endsem;
        private int assng;
        private int quiz;
        private int assm;
        private int att;
        public theory(String type,String courseID,int credits,String rollNo,int attnd,int midsem,int endsem,int assng,int quiz,int assm,int att){
            super(type,courseID,credits,rollNo);
            this.attnd=attnd;
            this.midsem=midsem;
            this.endsem=endsem;
            this.assng=assng;
            this.quiz=quiz;
            this.assm=assm;
            this.att=att;
        }
        int getattnd(){
            return attnd;
        }
        int getmidsem(){
            return midsem;
        }
        int getendsem(){
            return endsem;
        }
        int getassng(){
            return assng;
        }
        int getquiz(){
            return quiz;
        }
        int getassm(){
            return assm;
        }
        int getatt(){
            return att;
        }

    }
    public static class lab extends course{
        private int attnd;
        private int midsem;
        private int endsem;
        private int viva;
        private int att;
        private int assm;
        public lab(String type,String courseID,int credits,String rollNo,int attnd,int midsem,int endsem,int viva,int att,int assm){
            super(type,courseID,credits,rollNo);
            this.attnd=attnd;
            this.midsem=midsem;
            this.endsem=endsem;
            this.viva=viva;
            this.assm=assm;
            this.att=att;
        }
        int getattnd(){
            return attnd;
        }
        int getmidsem(){
            return midsem;
        }
        int getendsem(){
            return endsem;
        }
        int getviva(){
            return viva;
        }
        int getassm(){
            return assm;
        }
        int getatt(){
            return att;
        }
    }
    public static class project extends course{
        private int sup;
        private int sum1;
        private int sum2;
        public project(String type,String courseID,int credits,String rollNo,int sup,int sum1,int sum2){
            super(type,courseID,credits,rollNo);
            this.sup=sup;
            this.sum1=sum1;
            this.sum2=sum2;
        }
        int getsup(){
            return sup;
        }
        int getmid(){
           return sum1;
        }
        int getend(){
            return sum2;
        }

    }

    public static class evaluate{
        private int i;
        private int j;
        private int n;
        private int k;
        private int m;
        private int ctr;
        private int c;
        private double cgpa[];
        private int flag[];
        private int credits[];
        private double total[];
        private int flag2[];
        private student[] stud=new student[n];
        private course[] cs=new course[m];
        private String[] name;
        public evaluate(int n,int m,student[] stud,course[] cs){
            this.n=n;
            this.i=0;
            this.j=0;
            this.k=0;
            this.ctr=0;
            this.c=0;
            this.m=m;
            this.stud=stud;
            this.cs=cs;
            this.cgpa=new double[n];
            this.credits=new int[n];
            this.flag=new int[n];
            this.total=new double[m];
            this.flag2=new int[m];
            this.name=new String[m];
        }
        public void display(){
            for(i=0;i<n;i++){
                for(j=0;j<m;j++){
                    if(cs[j].getrollNo().equals(stud[i].getrollNo())){
                        if(cs[j].gettype().equals("T")){
                            theory th=(theory)cs[j];
                            total[j]=(th.getmidsem()+th.getendsem()+th.getquiz()+th.getassm()+th.getatt()+th.getassng())/150.0;
                            if(total[j]*150.0>=40.0 && th.getattnd()>=75){
                                flag2[j]=1;
                                credits[i]+=cs[j].getcredits();
                                cgpa[i]+=total[j]*cs[j].getcredits();
                            }
                        }
                        else if(cs[j].gettype().equals("L")){

                            lab lb=(lab)cs[j];
                            total[j]=(lb.getmidsem()+lb.getendsem()+lb.getviva()+lb.getassm()+lb.getatt())/100.0;
                            if(total[j]*100.0>=40.0 && (lb.getmidsem()+lb.getendsem())!=0 && lb.getattnd()>=75){
                                flag2[j]=1;
                                credits[i]+=cs[j].getcredits();
                                cgpa[i]+=total[j]*cs[j].getcredits();
                            }
                        }
                        else if(cs[j].gettype().equals("P")){
                            project pr=(project)cs[j];
                            total[j]=(pr.getsup()+pr.getmid()+pr.getend())/100.0;
                            if(pr.getsup()>=13 && (pr.getmid()+pr.getend())>=37.5){
                                flag2[j]=1;
                                credits[i]+=cs[j].getcredits();
                                cgpa[i]+=total[j]*cs[j].getcredits();
                            }
                        }
                    }
                }
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
                        System.out.println(" "+Math.round(cgpa[i]*100.0/credits[i]));
                    for(j=0;j<m;j++){
                        if(cs[j].getrollNo().equals(stud[i].getrollNo()) && flag2[j]==1){
                            name[c]=cs[j].getcourseID();
                            c++;
                        }
                    }
                    Arrays.sort(name,0,c);
                    for(j=0;j<c;j++){
                        System.out.print(name[j]+" ");
                    }
                    c=0;
                    System.out.println();
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        int i=0;
        while(t>0){
            int n=sc.nextInt();
            student[] stud=new student[n];
            for(i=0;i<n;i++){
                String type=sc.next();
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
                    int dummy1=sc.nextInt();
                    int dummy2=sc.nextInt();
                    String thesis=sc.next();
                    int year_of_doc=sc.nextInt();
                    stud[i]=new pgPhd(type, rollNo, name, per_of_reg, thesis, year_of_doc);
                }
            }
            int m=sc.nextInt();
            course[] cs=new course[m];
            evaluate eva=new evaluate(n,m,stud,cs);
            for(i=0;i<m;i++){
                String type1=sc.next();
                String courseID=sc.next();
                int credits=sc.nextInt();
                String rollNo=sc.next();

                if(type1.equals("T")){
                    int attnd=sc.nextInt();
                    int midsem=sc.nextInt();
                    int endsem=sc.nextInt();
                    int assng=sc.nextInt();
                    int quiz=sc.nextInt();
                    int assm=sc.nextInt();
                    int att=sc.nextInt();
                    cs[i]=new theory(type1,courseID,credits,rollNo,attnd,midsem,endsem,assng,quiz,assm,att);
                }
                else if(type1.equals("L")){
                    int attnd=sc.nextInt();
                    int midsem=sc.nextInt();
                    int endsem=sc.nextInt();
                    int viva=sc.nextInt();
                    int att=sc.nextInt();
                    int assm=sc.nextInt();
                    cs[i]=new lab(type1,courseID,credits,rollNo,attnd,midsem,endsem,viva,att,assm);
                }
                else if(type1.equals("P")){
                    int sup=sc.nextInt();
                    int p=sc.nextInt();
                    int[] panelmid=new int[p];
                    int sum1=0;
                    int sum2=0;
                    int[] panelend=new int[p];
                    for(int j=0;j<p;j++){
                        panelmid[j]=sc.nextInt();
                        sum1+=panelmid[j];
                    }
                    for(int j=0;j<p;j++){
                        panelend[j]=sc.nextInt();
                        sum2+=panelend[j];
                    }
                    sum1=sum1/3;
                    sum2=sum2/3;
                    cs[i]=new project(type1,courseID,credits,rollNo,sup,sum1,sum2);
                }
            }
            eva.display();
            t--;
        }
    }
}
