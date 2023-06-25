#include <iostream>
#include <ctime>
#include <string>

using namespace std;

class Bank
{
	private:
	
		string userDetails[1000][5];//name, age, contactNumber, userName, pin
		int accountsAvailable = 1000, temporaryAccountNumber = 0, accountDetails[1000][4];//sl no., account number, balance, last transaction 
		
	public:
	
		Bank()
		{
			srand((unsigned)time(0));
		}
		
		bool newAccount(string name, int age, long contactNumber, string userName, string pin)
		{
			
			if(age >= 18 && contactNumber >= 1000000000 && contactNumber <= 9999999999 && pin.length() == 4)
			{
				userDetails[1000 - accountsAvailable][0] = name;
				userDetails[1000 - accountsAvailable][1] = to_string(age);
				userDetails[1000 - accountsAvailable][2] = to_string(contactNumber);
				userDetails[1000 - accountsAvailable][3] = userName;
				userDetails[1000 - accountsAvailable][4] = pin;
				accountDetails[1000 - accountsAvailable][0] = (1000000 - accountsAvailable) + 1;
				accountDetails[1000 - accountsAvailable][2] = 0;
				accountDetails[1000 - accountsAvailable][3] = 0;
				
				while(temporaryAccountNumber == 0 || to_string(temporaryAccountNumber).length() != 8 || to_string(temporaryAccountNumber)[0] == '0')
				{
					temporaryAccountNumber = rand()%100000000;
				}
				accountDetails[1000 - accountsAvailable][1] = temporaryAccountNumber;
				
				accountsAvailable -= 1;
				
				return true;
			}
			
			else
			{
				return false;
			}
		}
		
		string getAccountDetails(string userName, string pin)
		{
			bool correctDetails = false;
			string details = "";
			for(int i = 1000;i > accountsAvailable;i--)
			{
				if(userDetails[1000 - i][3] == userName)
				{
					if(userDetails[1000 - i][4] == pin)
					{
						correctDetails = true;
						details += "Name             : " + userDetails[1000 - i][0] + "\n";
						details += "Age              : " + userDetails[1000 - i][1] + "\n";
						details += "Contact Number   : " + userDetails[1000 - i][2] + "\n";
						details += "Account Number   : " + to_string(accountDetails[1000 - i][1]) + "\n";
						details += "Account Balance  : " + to_string(accountDetails[1000 - i][2]) + "\n";
						if(accountDetails[1000 - i][3] > 0)
						{
							details += "Last Transaction : Deposit of " + to_string(accountDetails[1000 - i][3]) + "\n";
						}
						else if(accountDetails[1000 - i][3] < 0)
						{
							details += "Last Transaction : Withdrawal of " + to_string(0 - accountDetails[1000 - i][3]) + "\n";
						}
						else
						{
							details += "Last Transaction : No recent transactions\n";
						}
						break;
					}
				}
			}
			return details;
		}
		
		bool deposit(string userName, string pin, int depositAmount)
		{
			if(depositAmount > 0)
			{
				for(int i = 1000;i > accountsAvailable;i--)
				{
					if(userDetails[1000 - i][3] == userName)
					{
						if(userDetails[1000 - i][4] == pin)
						{
							accountDetails[1000 - i][2] += depositAmount;
							accountDetails[1000 - i][3] = depositAmount;
							return true;
						}
					}
				}
			}
			return false;
		}
		
		bool withdraw(string userName, string pin, int withdrawalAmount)
		{
			if(withdrawalAmount > 0)
			{
				for(int i = 1000;i > accountsAvailable;i--)
				{
					if(userDetails[1000 - i][3] == userName)
					{
						if(userDetails[1000 - i][4] == pin)
						{
							if(accountDetails[1000 - i][2] >= withdrawalAmount)
							{
								accountDetails[1000 - i][2] -= withdrawalAmount;
								accountDetails[1000 - i][3] = 0 - withdrawalAmount;
								return true;
							}
							else
							{
								break;
							}
						}
					}
				}
			}
			return false;
		}
		
		bool transferToUser(string userName1, string pin1, string userName2, int transferAmount)
		{
			if(transferAmount > 0)
			{
				for(int i = 1000;i > accountsAvailable;i--)
				{
					if(userDetails[1000 - i][3] == userName1)
					{
						if(userDetails[1000 - i][4] == pin1)
						{
							for(int j = 1000;j > accountsAvailable;j--)
							{
								if(userDetails[1000 - j][3] == userName2)
								{
									if(accountDetails[1000 - i][2] >= transferAmount)
									{
										accountDetails[1000 - i][2] -= transferAmount;
										accountDetails[1000 - i][3] = 0 - transferAmount;
										accountDetails[1000 - j][2] += transferAmount;
										accountDetails[1000 - j][3] = transferAmount;
										return true;
									}
									else
									{
										return false;
									}
								}
							}
						}
					}
				}
			}
			return false;
		}
		
};

int main()
{
	string name,userName,pin,userName2;
	int age,amount;
	long contactNumber;
		
	Bank BANK;
	
	cout<<"========== BANK OF PROGRAMMERS ==========\n"<<endl;
	
	while(true)
	{
		cout<<"BOT : How can I assist you?"<<endl;
		cout<<"\t1. Create new account"<<endl;
		cout<<"\t2. View details of existing account"<<endl;
		cout<<"\t3. Deposit money"<<endl;
		cout<<"\t4. Withdraw money"<<endl;
		cout<<"\t5. Transfer money to another user\n      [Enter the numerical value of the corresponding action you want to perform]\n"<<endl;
		cout<<"USER : ";
		
		int userInput;
		cin>>userInput;
		
		while(userInput < 1 || userInput > 5)
		{
			cout<<"\nBOT : Invalid input. Try again\n"<<endl;
			cout<<"USER : ";
			cin>>userInput;
		}
		
		switch(userInput)
		{
			case 1:
				cout<<"---------- CREATING NEW ACCOUNT ----------\n"<<endl;
				cout<<"BOT : Enter your name\n"<<endl;
				cout<<"USER : ";
				cin>>name;
				cout<<"\nBOT : Enter your age\n"<<endl;
				cout<<"USER : ";
				cin>>age;
				
				if(age < 18)
				{
					cout<<"\nBOT : Sorry, your age should be greater than or equal to 18 in order to create an account\n"<<endl;
					cout<<"--------------------"<<endl;
					break;
				}
				
				cout<<"\nBOT : Enter your contact number(it should be of 10 digits)\n"<<endl;
				cout<<"USER : ";
				cin>>contactNumber;
				cout<<"\nBOT : Enter a valid username\n"<<endl;
				cout<<"USER : ";
				cin>>userName;
				cout<<"\nBOT : Enter a valid 4-digit PIN\n"<<endl;
				cout<<"USER : ";
				cin>>pin;
				
				cout<<"--------------------"<<endl;
				
				if(BANK.newAccount(name,age,contactNumber,userName,pin))
				{
					cout<<"\nBOT : ACCOUNT SUCCESSFULLY CREATED\n"<<endl;
				}
				
				else
				{
					cout<<"\nBOT : ERROR_AccountNotCreated\n"<<endl;
				}
				
				cout<<"--------------------"<<endl;
				
				break;
				
			case 2:
				cout<<"---------- VIEWING THE DETAILS OF AN EXISTING ACCOUNT ----------\n"<<endl;
				cout<<"BOT : Enter your username\n"<<endl;
				cout<<"USER : ";
				cin>>userName;
				cout<<"\nBOT : Enter your PIN\n"<<endl;
				cout<<"USER : ";
				cin>>pin;
				
				if(BANK.getAccountDetails(userName,pin) == "")
				{
					cout<<"\nBOT : ERROR_AccountNotFound(username - "<<userName<<", PIN - "<<pin<<")\n"<<endl;
				}
				
				else
				{
					cout<<"\nBOT : Details - "<<endl;
					cout<<BANK.getAccountDetails(userName,pin)<<endl;
				}
				
				break;
			
			case 3:
				cout<<"---------- DEPOSITING MONEY ----------\n"<<endl;
				cout<<"BOT : Enter your username\n"<<endl;
				cout<<"USER : ";
				cin>>userName;
				cout<<"\nBOT : Enter your PIN\n"<<endl;
				cout<<"USER : ";
				cin>>pin;
				cout<<"\nBOT : Enter the amount you want to deposit\n"<<endl;
				cout<<"USER : ";
				cin>>amount;
				
				if(BANK.deposit(userName,pin,amount))
				{
					cout<<"\nBOT : "<<to_string(amount)<<" SUCCESSFULLY DEPOSITED\n"<<endl;
				}
				
				else
				{
					cout<<"\nBOT : ERROR_AmountNotDeposited\n"<<endl;
				}
				
				break;
			
			case 4:
				cout<<"---------- WITHDRAWING MONEY ----------\n"<<endl;
				cout<<"BOT : Enter your username\n"<<endl;
				cout<<"USER : ";
				cin>>userName;
				cout<<"\nBOT : Enter your PIN\n"<<endl;
				cout<<"USER : ";
				cin>>pin;
				cout<<"\nBOT : Enter the amount you want to withdraw\n"<<endl;
				cout<<"USER : ";
				cin>>amount;
				
				if(BANK.withdraw(userName,pin,amount))
				{
					cout<<"\nBOT : "<<to_string(amount)<<" SUCCESSFULLY WITHDRAWN\n"<<endl;
				}
				
				else
				{
					cout<<"\nBOT : ERROR_AmountNotWithdrawn(Make sure your account has sufficient balance)\n"<<endl;
				}
				
				break;
			
			case 5:
				cout<<"---------- TRANSFERRING MONEY ----------\n"<<endl;
				cout<<"BOT : Enter your username\n"<<endl;
				cout<<"USER : ";
				cin>>userName;
				cout<<"\nBOT : Enter your PIN\n"<<endl;
				cout<<"USER : ";
				cin>>pin;
				cout<<"\nBOT : Enter the username of the user you want to transfer the money to\n"<<endl;
				cout<<"USER : ";
				cin>>userName2;
				cout<<"\nBOT : Enter the amount you want to transfer\n"<<endl;
				cout<<"USER : ";
				cin>>amount;
				
				if(BANK.transferToUser(userName,pin,userName2,amount))
				{
					cout<<"\nBOT : "<<to_string(amount)<<" SUCCESSFULLY TRANSFERRED\n"<<endl;
				}
				
				else
				{
					cout<<"\nBOT : ERROR_AmountNotTransferred(Make sure your account has sufficient balance)\n"<<endl;
				}
				
				break;
		}
		
		cout<<"--------------------\n"<<endl;
		cout<<"BOT : Is there anything else which I can help you with?(y/n)\n"<<endl;
		char userIn;
		cout<<"USER : ";
		cin>>userIn;
		
		while(userIn != 'y' && userIn != 'n')
		{
			cout<<"USER : ";
			cin>>userIn;
		}
		
		if(userIn == 'n')
		{
			break;
		}
	}
	
	cout<<"\n--------------------"<<endl;
	cout<<"BOT : Thank you for using our bank"<<endl;
	cout<<"--------------------"<<endl;
	
	return 0;
}