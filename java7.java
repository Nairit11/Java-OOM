import java.util.*;
 
public class questionSix{
    
    public static class student {   // class to store student details
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
    public static class batch{       // class which creates object of student class for each student in a batch
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
 
    
    public static class typeZero {   //class to store details of assignment of type0
        private String chk;
        private String notes;
        private int tmarks;
        private String aid;
 
        public typeZero(String chk,String notes,int tmarks,String aid){
            this.chk=chk;
            this.notes=notes;
            this.tmarks=tmarks;
            this.aid=aid;
        }
 
        int gettmarks(){
            return tmarks;
        }
        String getaid(){
            return aid;
        }
    }
 
    public static class typeOne {     //class to store details of assignment of type1
        private int cr;
        private int incr;
        private String aid;
 
        public typeOne(int cr,int incr,String aid){
            this.cr=cr;
            this.incr=incr;
            this.aid=aid;
        }
        int getcr(){
            return cr;
 
        }
        int getincr(){
            return incr;
        }
        String getaid(){
            return aid;
        }
    }
 
    public static class typeTwo {   //class to store details of assignment of type2
        private int time;
        private int pen;
        private String lang;
        private int marks;
        private String aid;
 
        public typeTwo(int time,int pen,String lang,int marks,String aid){
            this.lang=lang;
            this.marks=marks;
            this.pen=pen;
            this.time=time;
            this.aid=aid;
        }
        int getpen(){
            return pen;
        }
        int getmarks(){
            return marks;
        }
 
        String getaid(){
            return aid;
        }
 
    }
    public static class typeNull{  //class to store details of any assignment
        private int marks;
        private String aid;
        public typeNull(int marks,String aid){
            this.marks=marks;
            this.aid=aid;
        }
        int getmarks(){
            return marks;
        }
        String getaid(){
            return aid;
        }
    }
 
    
 
        public static void main(String args[]) {
 
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            int i;
 
            while (t > 0) {
                int total=0;
                
                int m=sc.nextInt();
                batch bt=new batch(m);
                for(int j=0;j<m;j++){           // taking input for student details
                    String roll = sc.next();
                    String name = sc.next();
                    bt.st_assign(j, name,roll);
                }
                for(int j=0;j<m;j++){          
                    int n = sc.nextInt();
                    typeZero arr0[]=new typeZero[n];
                    typeOne arr1[]=new typeOne[n];
                    typeTwo arr2[]=new typeTwo[n];
                    typeNull arr[]=new typeNull[n];
                    int n1=0,n2=0,n3=0,n4=0;
                    while (n > 0) {            // taking input for assignment details
                        String aid = sc.next();
                        int atype= sc.nextInt();
                        if (atype == 0) {
                            String chk = sc.next();
                            String notes = sc.next();
                            int tmarks = sc.nextInt();
                            arr0[n1]=new typeZero(chk,notes,tmarks,aid);
                            n1++;
                            arr[n4]=new typeNull(tmarks,aid);
                            n4++;
                        } 
                        else if (atype == 1) {
                            int cr = sc.nextInt();
                            int incr = sc.nextInt();
                            arr1[n2]=new typeOne(cr,incr,aid);
                            n2++;
                            arr[n4]=new typeNull(cr*4-incr,aid);
                            n4++;
                        } 
                        else {
                            int time = sc.nextInt();
                            int pen = sc.nextInt();
                            String lang = sc.next();
                            int marks = sc.nextInt();
                            arr2[n3]=new typeTwo(time,pen,lang,marks,aid);
                            n3++;
                            arr[n4]=new typeNull(marks-pen,aid);
                            n4++;
                        }
 
                        n--;
                    }
                    // printing required details and total marks of all assignments of similar type
                    System.out.println(bt.getstudent(j).getname()+" "+bt.getstudent(j).getrollNo());
                    for (i = 0; i < n1; i++) {
                        total +=arr0[i].gettmarks();
                    }
                    for (i = 0; i < n2; i++) {
                        total +=arr1[i].getcr()*4-arr1[i].getincr();
                    }
                    for (i = 0; i < n3; i++) {
                        total +=arr2[i].getmarks()-arr2[i].getpen();
                    }
                    System.out.println(total);
                    total=0;
                    for(i=0;i<n4;i++){
                        System.out.println(arr[i].getaid()+" "+arr[i].getmarks());
                    }
                }
                t--;
            }
        }

}
