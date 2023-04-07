import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double a,b,d,e,f,g,h;
		char c;
		
		System.out.println("********************");
		System.out.println("Enter First Number: ");
		a=sc.nextDouble();
		System.out.println("********************");
		System.out.println("Enter Second Number: ");
		b=sc.nextDouble();
		System.out.println("********************");
		System.out.println("Enter An Operator[+,-,* or ×,/ or ÷,%]: ");
		c=sc.next().charAt(0);
		System.out.println("********************");
		
		if(c=='+'){
		    d=a+b;
		    System.out.println("The Sum Is: "+d);
		    System.out.println("********************");}
		else if(c=='-'){
		    e=a-b;
		    System.out.println("The Difference Is: "+e);
		    System.out.println("********************");}
		else if(c=='*'||c=='x'){
		    f=a*b;
		    System.out.println("The Product Is: "+f);
		    System.out.println("********************");}
		else if(c=='/'||c=='÷'){
		    g=a/b;
		    System.out.println("The Quotient Is: "+g);
		    System.out.println("********************");}
		else if(c=='%'){
		    h=a%b;
		    System.out.println("The Remainder Is: "+h);
		    System.out.println("********************");}
		else{
		    System.out.println("INVALID INPUT");
		    System.out.println("********************");}
		 System.out.println("#MADE BY OMANSHU#");
		 System.out.println("********************");
	}
}
