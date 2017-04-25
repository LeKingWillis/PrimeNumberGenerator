import java.util.ArrayList;
import java.util.Scanner;
public class PrimeMain {
	public static void main(String[] args){
		//do scanner
		Scanner sc = new Scanner(System.in);
		System.out.print("How many ranges do you wish to search? ");
		//do math and threads
		int range = Integer.parseInt(sc.nextLine());
		ArrayList<PrimeCalculator> pc = new ArrayList<PrimeCalculator>();
		//start for loop
		for (int i = 1; i<=range;i++){
			System.out.print("Enter range "+i+" low value: ");
			int low = Integer.parseInt(sc.nextLine());
			System.out.print("Enter range "+i+" high value: ");
			int high = Integer.parseInt(sc.nextLine());
			pc.add(new PrimeCalculator(low,high));
		}
		//start threads
		for (PrimeCalculator calc: pc){
			calc.start();
		}
		//make sure threads all stop
		for (PrimeCalculator calc: pc){
			try {
				calc.join();
			} catch (InterruptedException e) {				
			}
		}		
		//print array list
		for (PrimeCalculator calc: pc){
			System.out.println("number primes in range [" + calc.low + " - "+ calc.high +"] is "+calc.numPrime);
		}
		System.out.print("done");
	}
}
