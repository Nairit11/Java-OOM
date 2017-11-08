import java.util.*;

public class Question3 {

    public static class student{  //class to store student details
        private String rollNo;
        private String name;
        private int intl;
        private int type;
        
        public student(String RollNo, String Name, int intl,int type){  //constructor of the class
            this.rollNo=RollNo;
            this.name=Name;
            this.intl=intl;
            this.type=type;
        }
        String getname(){
            return name;
        }
        String getrollNo(){
            return rollNo;
        }
        int getintl(){
            return intl;
        }
        int gettype(){
            return type;
        }
    }

    public static class assignment{      //class to store details of each assignment
        private String assignId;
        private String courseId;
        private int baseMarks;
        private int diff;
        private date dos;
        
        public assignment(String AssignId, String CourseId, int BaseMarks, int Diff, int Day, int Month, int Year){       //constructor of the class
            this.assignId=AssignId;
            this.courseId=CourseId;
            this.baseMarks=BaseMarks;
            this.diff=Diff;
            this.dos = new date(Day, Month, Year);
        }
        String getassignId(){
            return assignId;
        }
        String getcourseId(){
            return courseId;
        }
        int getbaseMarks(){
            return baseMarks;
        }
        int getdiff(){
            return diff;
        }
        int getday(){
            return dos.getday();
        }
        int getmonth(){
            return dos.getmonth();
        }
        int getyear(){
            return dos.getyear();
        }
    }

       public static class date{   //class to store deadline of each assinment
            private int day;
            private int month;
            private int year;
        
            public date(int Day, int Month, int Year){       //constructor of the class
                this.day=Day;
                this.month=Month;
                this.year=Year;
            }
            int getday(){
                return day;
            }
            int getmonth(){
                return month;
            }
            int getyear(){
                return year;
            }
        }

        public static class batch{    //class to create object of student class for each student in a batch
            student stud[];
            public batch(int stud){         //constructor of the class
                this.stud=new student[stud];
            }
            public void st_assign(int i, String rollNo, String name, int intl, int type){
                stud[i]=new student(rollNo, name, intl, type);
            }
            student getstudent(int i){
                return stud[i];
            }
        }
        
        public static class plagarism{     //class to store details of students accused of plagarism
            private String rollNo;
            private String courseId;
            public plagarism(String rollNo,String courseId){        //constructor of the class
                this.rollNo=rollNo;
                this.courseId=courseId;
            }
            String getrollNo(){
                return rollNo;
            }
            String getcourseId(){
                return courseId;
            }
        }

    public static class assignComparator0 implements Comparator<assignment>{        //comparator class to sort assignment array based on date of submission
        public int compare(assignment a, assignment b){
            if(a.getyear()<b.getyear())
                return -1;
            else if(a.getyear()>b.getyear())
                return 1;
            else{
                if(a.getmonth()<b.getmonth())
                    return -1;
                else if(a.getmonth()>b.getmonth())
                    return 1;
                else{
                    if(a.getday()<b.getday())
                        return -1;
                    else if(a.getday()>b.getday())
                        return 1;
                    else{
                        if(Character.isLetter(a.getassignId().charAt(0))){
                            if(a.getassignId().charAt(0)<b.getassignId().charAt(0))
                                return -1;
                            else if(a.getassignId().charAt(0)>b.getassignId().charAt(0))
                                return 1;
                            else{
                                String s1=a.getassignId().substring(1);
                                String s2=b.getassignId().substring(1);
                                int r1=Integer.parseInt(s1);
                                int r2=Integer.parseInt(s2);
                                if(r1<r2)
                                    return -1;
                                else
                                    return 1;
                            }
                        }
                        else{
                            int r1=Integer.parseInt(a.getassignId());
                            int r2=Integer.parseInt(b.getassignId());
                            if(r1<r2)
                                return -1;
                            else
                                return 1;
                        }
                    }
                }
            }
        }     
    }

    public static class assignComparator1 implements Comparator<assignment>{           //comparator class to sort assignment array based on base marks
        public int compare(assignment a, assignment b) {
            if (a.getbaseMarks()>b.getbaseMarks()) {
                return -1;
            } 
            else if (a.getbaseMarks()<b.getbaseMarks()) {
                return 1;
            } 
            else {
                if (Character.isLetter(a.getassignId().charAt(0))) {
                    if (a.getassignId().charAt(0)<b.getassignId().charAt(0)) {
                        return -1;
                    } 
                    else if (a.getassignId().charAt(0)>b.getassignId().charAt(0)) {
                        return 1;
                    } 
                    else {
                        String s1=a.getassignId().substring(1);
                        String s2=b.getassignId().substring(1);
                        int r1=Integer.parseInt(s1);
                        int r2=Integer.parseInt(s2);
                        if(r1<r2)
                            return -1;
                        else
                            return 1;
                    }
                } 
                else {
                    int r1=Integer.parseInt(a.getassignId());
                    int r2 = Integer.parseInt(b.getassignId());
                    if(r1<r2)
                        return -1;
                    else
                        return 1;
                }
            }
        }
    }

    public static class assignComparator2 implements Comparator<assignment>{          //comparator class to sort assignment array based on courseID
        public int compare(assignment a, assignment b){
            
            if(Character.isLetter(a.getassignId().charAt(0))){
                
                if(a.getassignId().charAt(0)<b.getassignId().charAt(0))
                    return -1;
                
                else if(a.getassignId().charAt(0)>b.getassignId().charAt(0))
                    return 1;
                
                else{
                    String s1=a.getassignId().substring(1);
                    String s2=b.getassignId().substring(1);
                    int r1=Integer.parseInt(s1);
                    int r2=Integer.parseInt(s2);
                    if(r1<r2)
                        return -1;
                    else
                        return 1;
                }
            }
            
            else{
                int r1=Integer.parseInt(a.getassignId());
                int r2=Integer.parseInt(b.getassignId());
                
                if(r1<r2)
                    return -1;
                else
                    return 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t;
        int i;
        
        t=sc.nextInt();
        while(t>0){
            int totalMarks=0;
            int m=sc.nextInt();
            batch bt=new batch(m);     // instantoating the batch class
            for(i=0;i<m;i++){
            String name;
            String rollNo;
            int intl;
            int type;
            rollNo=sc.next();
            name=sc.next();
            intl=sc.nextInt();
            type=sc.nextInt();
            bt.st_assign(i,rollNo,name,intl,type);
            }
            int n=sc.nextInt();
            assignment assArr[]=new assignment[n];
            for(i=0; i<n; i++){        //accepting inputs for assignment details
                String assignId;
                String courseId;
                int day, month, year;
                int baseMarks;
                int diff;
                assignId=sc.next();
                courseId=sc.next();
                day=sc.nextInt();
                month=sc.nextInt();
                year=sc.nextInt();
                baseMarks=sc.nextInt();
                diff=sc.nextInt();
                assArr[i] = new assignment(assignId, courseId, baseMarks, diff, day, month, year);
            }
            int p=sc.nextInt();
            plagarism plagArr[]=new plagarism[p];     
            for(i=0;i<p;i++){
                String rollNo=sc.next();
                String courseId=sc.next();
                plagArr[i]=new  plagarism(rollNo,courseId);    //instantiating the plagarism class
            }
            //computing amd sorting the array based on type of student
            for(i=0;i<m;i++){
                
                if(bt.getstudent(i).gettype()==0)
                    Arrays.sort(assArr,new assignComparator0());
                else if(bt.getstudent(i).gettype()==1)
                    Arrays.sort(assArr,new assignComparator1());
                else
                    Arrays.sort(assArr,new assignComparator2());
                //printing required details and total marks obtained in all assignment for each student
                System.out.println(bt.getstudent(i).getrollNo()+" "+bt.getstudent(i).getname());
                
                    for(int j=0; j<n; j++){
                        if(bt.getstudent(i).getintl()>=assArr[j].getdiff()){
                            
                            int flag=0;
                            for(int k=0;k<p;k++){ 
                                if(plagArr[k].getcourseId().equals(assArr[j].getcourseId()) && plagArr[k].getrollNo().equals(bt.getstudent(i).getrollNo()))
                                    flag++;
                            }
                            if(flag==0){    
                                System.out.println(assArr[j].getassignId()+" "+assArr[j].getcourseId()+" "+(bt.getstudent(i).getintl()*assArr[j].getbaseMarks()));
                                totalMarks+=(bt.getstudent(i).getintl()*assArr[j].getbaseMarks());
                            }    
                            else{
                                System.out.println(assArr[j].getassignId()+" "+assArr[j].getcourseId()+" "+0);
                                totalMarks+=0;
                            }      
                            
                        }    
                    }
                System.out.println(totalMarks);
                
                totalMarks=0;
            }
            t--;
        }
    } 
}

