import java.util.*;

class student{
    private String rollNo;
    private String type;
    private String[] TA;
    private int[] actualMarks;
    private int[] TAmarks;
    private ta[] tas;
    private int n;
    private int q;
    private int[] maxMarks;

    public student(String rollNo,String type,int q,int[] max,ta[] tas,int n) { 
        this.q = q;
        this.maxMarks=max;
        this.rollNo=rollNo;
        this.type = type;
        this.TA = new String[q];
        this.actualMarks = new int[q];
        this.TAmarks = new int[q];
        this.tas=tas;
        this.n=n;
    }

    public void setTA(int i,String TA) {
        this.TA[i] = TA;
    }

    public void setActualMarks(int i,int actualMarks) {
        this.actualMarks[i] = actualMarks;
    } 
    
    public void setTAmarks(){
        for(int i=0;i<q;i++){
            for(int j=0;j<n;j++){
                if(TA[i].equals(tas[j].getName())){
                    if(tas[j].getType().equals("generous")){
                        TAmarks[i]=actualMarks[i]+1;
                    }
                    else if(tas[j].getType().equals("oracle")){
                        TAmarks[i]=actualMarks[i];
                    }
                    else if(tas[j].getType().equals("dishonest")){
                        int flag=0;
                        for(int k=0;k<tas[j].getF();k++){
                            if(rollNo.equals(tas[j].getFriends(k))){
                                TAmarks[i]=actualMarks[i]+2;
                                flag=1;
                                break;
                            }
                        }
                        if(flag==1){
                            TAmarks[i]=actualMarks[i]-1;
                        }
                    }
                    tas[j].increaseDev(TAmarks[i]-actualMarks[i]);
                    tas[j].increaseQ();
                    break;
                }              
            }
        }
    }
}

class ta{
    private String name;
    private String type;
    private int f;
    private String[] friends;
    private int s;
    private int c;

    public ta(String name,String type) {
        this.type = type;
        this.name=name;
        this.f=0;
        this.s=0;
        this.c=0;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void setFriends(int i,String friends) {
        this.friends[i] = friends;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getF() {
        return f;
    }

    public String getFriends(i) {
        return friends[i];
    }
    
    public void increaseDev(int dev){
        s=s+dev;
    }
    public void increaseQ(){
        c++;
    }

    public int getS() {
        return s;
    }

    public int getC() {
        return c;
    }
    
}

class display{
    private ta[] tas;
    private student[] stud;
    private int n,m;
    
    public display(ta[] tas,student[] stud,int n,int m){
        this.tas=tas;
        this.stud=stud;
        this.n=n;
        this.m=m;
    }
    
    public void show(){
        
        for(int i=0;i<m;i++){
            stud[i].setTAmarks();
        }
        for(int i=0;i<n;i++){
            System.out.println(tas[i].getS()+" "+tas[i].getC());
        }
    }
}

public class EndSemLabExam1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int q=sc.nextInt();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] max=new int[q];
        for(int i=0;i<q;i++){
            max[i]=sc.nextInt();
            
        }
        ta[] tas=new ta[n];
        for(int i=0;i<n;i++){
            String name=sc.nextLine();
            String type=sc.nextLine();
            tas[i]=new ta(name,type);
        }
        student[] stud=new student[m];
        for(int i=0;i<m;i++){
            String name=sc.nextLine();
            String type=sc.nextLine();
            int marks=sc.nextInt();
            String ta=sc.nextLine();
            stud[i]=new student(name,type,q,max,tas,n);
            stud[i].setActualMarks(i, marks);
            stud[i].setTA(i, ta);
        }
        
        display dp=new display(tas,stud,n,m);
        dp.show();
    }
    
}
