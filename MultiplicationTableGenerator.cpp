#include <iostream>
using namespace std;

int main(){
	cout<<"********************"<<endl;
	cout<<"Multiplication Table!"<<endl;
	cout<<"********************"<<endl;
	double num,prod;
	while(true){
	    cout<<"Enter The Number : ";
	    cin>>num;
	    cout<<"********************"<<endl;
	    for(int i=1;i<=10;i++){
	    	prod=i*num;
	    	cout<<num<<'x'<<i<<'='<<prod<<endl;
	    }
	    cout<<"********************"<<endl;
	}
	return 0;
}