import java.util.*;

public class questionFive{
    
    public static class student {   //class to store student details
        private String name;
        private String rollNo;
        public student(String name,String rollNo){    //constructor of the class
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
    public static class batch{      //class to create object for each student in a batch
            student stud[];
            public batch(int stud){  //constructor of the class
                this.stud=new student[stud];
            }
            public void st_assign(int i, String rollNo, String name){
                stud[i]=new student(name,rollNo);
            }
            student getstudent(int i){
                return stud[i];
            }
        }

    
    public static class typeZero {     //class to store details of an assignment of type 0
        private String chk;
        private String notes;
        private int tmarks;
        private String aid;

        public typeZero(String chk,String notes,int tmarks,String aid){  // constructor of the class
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

    public static class typeOne {   //class to store details of an assignment of type 1
        private int cr;
        private int incr;
        private String aid;

        public typeOne(int cr,int incr,String aid){   //construvtor of the class
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

    public static class typeTwo {      //class to store details of an assignment of type 2
        private int time;
        private int pen;
        private String lang;
        private int marks;
        private String aid;

        public typeTwo(int time,int pen,String lang,int marks,String aid){    //constructor of the class
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

    

        public static void main(String args[]) {

            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            int i;

            while (t > 0) {
                int total=0;
                
                int m=sc.nextInt();
                batch bt=new batch(m); //creating object of batch class
                for(int j=0;j<m;j++){
                    String roll = sc.next();
                    String name = sc.next();
                    bt.st_assign(j, name,roll);
                }
                for(int j=0;j<m;j++){
                    int n = sc.nextInt();
                    typeZero arr0[]=new typeZero[n];
                    typeOne arr1[]=new typeOne[n];
                    typeTwo arr2[]=new typeTwo[n];
                    int n1=0,n2=0,n3=0;
                    while (n > 0) {     // getting inputs for assignment details
                        String aid = sc.next();
                        int atype= sc.nextInt();
                        if (atype == 0) {
                            String chk = sc.next();
                            String notes = sc.next();
                            int tmarks = sc.nextInt();
                            arr0[n1]=new typeZero(chk,notes,tmarks,aid);
                            n1++;
                        } 
                        else if (atype == 1) {
                            int cr = sc.nextInt();
                            int incr = sc.nextInt();
                            arr1[n2]=new typeOne(cr,incr,aid);
                            n2++;
                        } 
                        else {
                            int time = sc.nextInt();
                            int pen = sc.nextInt();
                            String lang = sc.next();
                            int marks = sc.nextInt();
                            arr2[n3]=new typeTwo(time,pen,lang,marks,aid);
                            n3++;
                        }

                        n--;
                    }
                    //printing required details along with total marks of assignments of similar type
                    System.out.println(bt.getstudent(j).getname()+" "+bt.getstudent(j).getrollNo());
                    for (i = 0; i < n1; i++) {
                        System.out.println(arr0[i].getaid()+" "+arr0[i].gettmarks());
                        total +=arr0[i].gettmarks();

                    }
                    System.out.println(total);
                    total=0;
                    for (i = 0; i < n2; i++) {
                        System.out.println(arr1[i].getaid()+" "+(arr1[i].getcr()*4-arr1[i].getincr()));
                        total +=arr1[i].getcr()*4-arr1[i].getincr();
                    }
                    System.out.println(total);
                    total=0;
                    for (i = 0; i < n3; i++) {
                        System.out.println(arr2[i].getaid()+" "+(arr2[i].getmarks()-arr2[i].getpen()));
                        total +=arr2[i].getmarks()-arr2[i].getpen();
                    }
                    System.out.println(total);
                    total=0;
                }
                t--;
            }
        }



}