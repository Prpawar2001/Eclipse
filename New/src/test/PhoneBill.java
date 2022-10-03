package test;

import java.util.Scanner;

abstract class Cellularpath{
	
	double rate;
	abstract void getRate();
	public void Billprocess(int min) {
		System.out.println(rate * min);
	}
	
}

class Airtel extends Cellularpath{
	public void getRate() {
		rate = 3.051;
	}
}

class Idea extends Cellularpath{
	public void getRate() {
		rate = 4.41;
	}
}

class Bsnl extends Cellularpath{
	public void getRate() {
		rate = 2.991;
	}
}

class SelectNetwork{
	public Cellularpath getPlan(String planType) {
		if(planType == null) {
			return null;
		}
		if(planType.equalsIgnoreCase("Airtel")) {
			return new Airtel();
		}else if(planType.equalsIgnoreCase("Idea")) {
			return new Idea();
		}else if(planType.equalsIgnoreCase("Bsnl")) {
			return new Bsnl();
		}
		return null;
	}
}

public class PhoneBill {

	public static void main(String[] args) {
		SelectNetwork sn = new SelectNetwork();
		System.out.println("Select the Network Type:- ");
		Scanner sc = new Scanner(System.in);
		String planName = sc.next();
		System.out.println("Enter the usage Time:- ");
		int min = sc.nextInt();
		
		Cellularpath cp = sn.getPlan(planName);
		cp.getRate();
		cp.Billprocess(min);
		
		sc.close();
	}

}
