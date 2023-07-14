package bank;

import java.util.Scanner;

class BankAccount{
	double bal;
	double prevTrans;
	String customerName;
	String customerID;
		
	BankAccount (String customerName, String customerID)
	{
		this.customerName=customerName;
		this.customerID=customerID;
	}	
	void deposit(double amount)
	{
		if(amount!=0)
		{
			bal+=amount;
			prevTrans=amount;
		}
	}
	void withdraw(double amt) 
	{
		if(amt!=0 && bal>=amt)
		{
			bal-=amt;
			prevTrans=-amt;
		}
		else if(bal<amt)
		{
			System.out.println("Bank balance insufficient");
		}
	}
	void getprevTrans() 
	{
		if(prevTrans>0) 
		{
			System.out.println("Deposited:"+prevTrans);
		}
		else if(prevTrans<0) {
			System.out.println("Withdraw:"+Math.abs(prevTrans));
		}
		else 
		{
			System.out.println("No Transaction occured");
		}
	}
	void menu() 
	{
		char option;
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome"+customerName);
		System.out.println("Your ID"+customerID);
		System.out.println("\n");
		System.out.println("a) Check Balance");
		System.out.println("b) Deposit Amount");
		System.out.println("c) Withdraw Amount");
		System.out.println("d) Previous Transaction");
		System.out.println("e) Exit");
			
		do
		{
			System.out.println("************************");
			System.out.println("Choose an Option:");
			option=sc.next().charAt(0);
			System.out.println("\n");
			
			switch (option)
			{
				case 'a':
					System.out.println(".......................");
					System.out.println("Balance:"+bal);
					System.out.println(".......................");
					System.out.println("\n");
					break;
				case 'b':
					System.out.println(".......................");
					System.out.println("Enter the amount to deposit: ");
					System.out.println(".......................");
					double amt=sc.nextDouble();
					deposit(amt);
					System.out.println("\n");
					break;
				case 'c':
					System.out.println(".......................");
					System.out.println("Enter the amount withdraw: ");
					System.out.println(".......................");
					double amtW=sc.nextDouble();
					withdraw(amtW);
					System.out.println("\n");
					break;
				case 'd':
					System.out.println(".......................");
					System.out.println("Enter the amount withdraw: ");
					System.out.println(".......................");
					getprevTrans();
					System.out.println("\n");
					break;
				case 'e':
					System.out.println(".......................");
					break;
				default:
					System.out.println("Choose correct option: ");
					break;					
			}				
		}
		while(option!='e');
		System.out.println("Thank you for Using our banking");
	}	
}
public class Bank 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your 'Name' and 'CustomerId' to access the account");
		String name=sc.nextLine();
		String customerID=sc.nextLine();
		BankAccount obj1=new BankAccount(name,customerID);
		obj1.menu();
	}
}

