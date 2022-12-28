//Made By Omanshu

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int i,n,m;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Number Of Students appeared in the examination:");
        int y=sc.nextInt();
        System.out.println("********************");
        int[] marks=new int[y];
        System.out.println("Enter Marks Of Each Student(Press Enter after you input the marks of each student):\n********************");
        for(i=0;i<marks.length;i++){
            n=i+1;
            System.out.println("Marks Of Student No. "+n);
            marks[i]=sc.nextInt();
            System.out.println("********************");
        }
        System.out.println("********************");
        System.out.println("Enter the marks of the student you want to find:");
        int x=sc.nextInt();
        System.out.println("********************");
        for(i=0;i<marks.length;i++){
            if(marks[i]==x){
                m=i+1;
                System.out.println("Student No. : "+m+" got "+x+" marks");}
                }
        System.out.println("********************");
        System.out.println("Made By Omanshu");
    }
    
}
