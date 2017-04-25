public class PrimeCalculator extends Thread {
	protected int low;
	protected int high;
	protected int numPrime;
	public PrimeCalculator(int low, int high) {
		this.low = low;
		this.high = high;
	}
	@Override
	public void run(){	
		//walk through values from low to high, call is prime with i
		for(int i = low; i<high; i++){
			if(isPrime(i)){
				System.out.println("Prime in range [" + low + " - "+ high +"] is "+ i);
				numPrime++;
			}
		}
	}
	private boolean isPrime(int i) {
		//made one-liners for concision purposes
		for(int j = 2; j<high/2; j++){
			if (i<2)	return false;
			if (i%j ==0)	return false;
		}
		return true;
	}
}
