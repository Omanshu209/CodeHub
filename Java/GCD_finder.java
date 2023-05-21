import java.util.Scanner;

public class Main{
	
	// a function to find the GCD of 2 numbers
	public static int GCD(int N1,int N2){
		int ANS = 1;
		for(int i = Math.min(N1,N2) ; i>0 ; i--){
			if(N1%i == 0 && N2%i == 0){
				ANS = i;
				break;
			}
		}
		return ANS;
	}
	
	// the main function
	public static void main(String[] args){
		Scanner SC = new Scanner(System.in);
		System.out.print("--------------------\nEnter 1st number : ");
		int NUM1 = SC.nextInt();
		System.out.print("Enter 2st number : ");
		int NUM2 = SC.nextInt();
		System.out.println("--------------------");
		System.out.println("GCD of the numbers "+NUM1+" and "+NUM2+" is "+GCD(NUM1,NUM2)+".\n--------------------");
	}

}