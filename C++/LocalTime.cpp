#include <iostream>
using namespace std;

class LocalTime
{
	private:
		double longitude;
		
	public:
	
		LocalTime(double meridian):longitude(meridian){}
		
		~LocalTime()
		{
			longitude=0;
		}
		
		string getLocalTime()
		{
			double min = longitude*4;
			string hr=to_string(min/60.0);
			if(longitude>=0)
			{
				return "Places located at longitude "+to_string(longitude)+" is "+hr+" hours ahead of GMT";
			}
			else
			{
				return "Places located at longitude "+to_string(longitude)+" is "+hr+" hours behind of GMT";
			}
		}
};

int main()
{
	double longitude;
	cout<<"Enter the longitude of the place you want to find the local time of (longitude should be negative if the place is located in the western hemisphere, otherwise positive if it is located in the eastern hemisphere) : ";
	cin>>longitude;
	LocalTime Time(longitude);
	cout<<Time.getLocalTime()<<endl;
	return 0;
}
