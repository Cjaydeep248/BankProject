package com.cjc.bms.Client;

import com.cjc.bms.service.*;
import com.cjc.bms.serviceimplementation.*;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {
		Rbi b = new Sbi();
		Scanner sc = new Scanner(System.in);
		boolean x = true;
		while (x) {
			System.out.println("--Select--\n" + "1 Create_Account\n" + "2 Display_All_Details\n" + "3 Deposite_Money\n"
					+ "4 With_Drawal \n" + "5 Check_Balance\n" + "6 Exit");
			System.out.println("Enter Your Choice");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				b.createAccount();
			case 2:
				b.displayAllDetails();
			case 3:
				b.depositeMoney();
			case 4:
				b.withDrawal();
			case 5:
				b.balanceCheck();
				Default: {
					x = false;
					System.out.println("Exit");

				}
			}

		}
	}
}
