#include<iostream>

int main()
{
	int num1,num2;
	
	std::cout<<"Enter 1st number : ";
	std::cin>>num1;
	std::cout<<"Enter 2nd number : ";
	std::cin>>num2;
	std::cout<<"--------------------"<<std::endl;
	
	for(int i = std::min(num1,num2);i > 0;i--)
	{
		if(num1%i == 0 && num2%i == 0)
		{
			std::cout<<"The HCF of "<<num1<<" and "<<num2<<" is "<<i<<std::endl;
			std::cout<<"--------------------"<<std::endl;
			break;
		}
	}
	
	return 0;
}