package com.javaCoreBasicConcept;

import java.text.SimpleDateFormat;
import java.util.Date;



abstract class DateFormatter {
	public abstract String getFormattedCurrentDate();
	public abstract String getFormattedBeginningDate();
}

class MyFormatter3 extends DateFormatter {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	public String getFormattedCurrentDate() {
		return sdf.format(new Date());
	}

	public String getFormattedBeginningDate() {
		return sdf.format(new Date(0));
	}
}

class NewRunnable1 implements Runnable {
	DateFormatter formatter;

	public NewRunnable1(DateFormatter f) {
		this.formatter = f;
	}

	public void run() {
		System.out.println("Current Date - " + formatter.getFormattedCurrentDate());
	}
}


class NewRunnable2 implements Runnable {
	DateFormatter formatter;

	public NewRunnable2(DateFormatter f) {
		this.formatter = f;
	}

	public void run() {
		System.out.println("Beginning Date - " + formatter.getFormattedBeginningDate());
	}
}

public class WithoutThreadLocal {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DateFormatter formatter3 = new MyFormatter3();
		NewRunnable1 mr1 = new NewRunnable1(formatter3);
		NewRunnable2 mr2 = new NewRunnable2(formatter3);

		for (int i = 0; i < 3; i++) {
			Thread t1 = new Thread(mr1);
			Thread t2 = new Thread(mr2);
			t1.start();
			t2.start();
			
			
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
