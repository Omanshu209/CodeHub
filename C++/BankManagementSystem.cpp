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
		
		bool newAccount(string name, int age, int contactNumber, string userName, string pin)
		{
			
			if(age >= 18 && to_string(contactNumber).length() == 10 && pin.length() == 4)
			{
				userDetails[1000 - accountsAvailable][0] = name;
				userDetails[1000 - accountsAvailable][1] = to_string(age);
				userDetails[1000 - accountsAvailable][2] = to_string(contactNumber);
				userDetails[1000 - accountsAvailable][3] = userName;
				userDetails[1000 - accountsAvailable][4] = pin;
				accountDetails[1000 - accountsAvailable][0] = (1000000 - accountsAvailable) + 1;
				accountDetails[1000 - accountsAvailable][2] = 0;
				accountDetails[1000 - accountsAvailable][3] = 0;
				
				while(temporaryAccountNumber == 0 || to_string(temporaryAccountNumber).length() != 8 || to_string(temporaryAccountNumber)[0] == 0)
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
			string details;
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
	Bank BANK;
	BANK.newAccount("User1",19,1111029189,"user1","1234");
	BANK.newAccount("User2",19,2111028189,"user2","4321");
	BANK.deposit("user1","1234",100);
	BANK.deposit("user1","1234",400);
	BANK.withdraw("user1","1234",400);
	BANK.transferToUser("user1","1234","user2",100);
	cout<<BANK.getAccountDetails("user1","1234")<<"--------------------\n"<<BANK.getAccountDetails("user2","4321");
	return 0;
}