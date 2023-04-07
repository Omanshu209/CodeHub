#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

class Monster
{
	private:
		
		const string name;
		int hp;
		
	public:
		
		int moves[3][4];//[Move1-[Attack,Heal,Self-Damage,Probability],Move2-........]
		
		Monster(string name,int hp,int m1a,int m1h,int m1sd,int m1p,int m2a,int m2h,int m2sd,int m2p,int m3a,int m3h,int m3sd,int m3p):name(name),hp(hp)
		{
			moves[0][0] = m1a;moves[0][1] = m1h;moves[0][2] = m1sd;moves[0][3] = m1p;
			moves[1][0] = m2a;moves[1][1] = m2h;moves[1][2] = m2sd;moves[1][3] = m2p;
			moves[2][0] = m3a;moves[2][1] = m3h;moves[2][2] = m3sd;moves[2][3] = m3p;
			
			srand((unsigned)time(0));
		}
		
		int getHP()
		{
			return hp;
		}
		
		string getName()
		{
			return name;
		}
		/*int getMoves()
		{
			return moves;
		}*/
		
		bool Move1(Monster &obj)
		{
			if(moves[0][3] >= rand()%100+1)
			{
				obj.hp -= moves[0][0];
				hp += moves[0][1];
				hp -= moves[0][2];
				return true;
			}
			else
			{
				return false;
			}
		}
		
		bool Move2(Monster &obj)
		{
			if(moves[1][3] >= rand()%100+1)
			{
				obj.hp -= moves[1][0];
				hp += moves[1][1];
				hp -= moves[1][2];
				return true;
			}
			else
			{
				return false;
			}
		}
		
		bool Move3(Monster &obj)
		{
			if(moves[2][3] >= rand()%100+1)
			{
				obj.hp -= moves[2][0];
				hp += moves[2][1];
				hp -= moves[2][2];
				return true;
			}
			else
			{
				return false;
			}
		}
};

//create as many monsters as you want!
Monster Monsters[] = {Monster("Pikachu",250,80,0,0,80,35,10,0,90,50,0,20,100),Monster("Charizard",400,75,0,10,60,125,0,40,40,90,5,0,20),Monster("Greninja",325,20,20,0,80,85,0,15,65,45,5,0,35)};//All the monsters should be inside this string data type array

void game()
{
	//Attacking other monster -- Monster1.Move1/Move2/Move3(Monster2);
	cout<<"--------------------\nMONSTER BATTLE !\n-------------------\n\nMonsters Available -- \n\n"<<endl;
	for(int i = 0;i<sizeof(Monsters) / sizeof(Monsters[0]);i++)
	{
		cout<<i+1<<") "<<Monsters[i].getName()<<"\n\n"<<"\tMove 1 - \n\t\tAttack -- "<<Monsters[i].moves[0][0]<<"\n\t\tHeal -- "<<Monsters[i].moves[0][1]<<"\n\t\tSelf-Damage -- "<<Monsters[i].moves[0][2]<<"\n\t\tProbability -- "<<Monsters[i].moves[0][3]<<"\n\tMove 2 - \n\t\tAttack -- "<<Monsters[i].moves[1][0]<<"\n\t\tHeal -- "<<Monsters[i].moves[1][1]<<"\n\t\tSelf-Damage -- "<<Monsters[i].moves[1][2]<<"\n\t\tProbability -- "<<Monsters[i].moves[1][3]<<"\n\tMove 3 - \n\t\tAttack -- "<<Monsters[i].moves[2][0]<<"\n\t\tHeal -- "<<Monsters[i].moves[2][1]<<"\n\t\tSelf-Damage -- "<<Monsters[i].moves[2][2]<<"\n\t\tProbability -- "<<Monsters[i].moves[2][3]<<endl;
	}
	int user_monster, computer_monster = rand()%(sizeof(Monsters) / sizeof(Monsters[0])), user_move, computer_move;
	cout<<"\n--------------------\n\nChoose Your Monster (Integer Input Only) : ";
	cin>>user_monster;
	
	while(true)
	{
		if(user_monster > 0 && user_monster <=sizeof(Monsters) / sizeof(Monsters[0]))
		{
			cout<<"\n\n--------------------\nYou Choosed "<<Monsters[user_monster-1].getName()<<"\n--------------------"<<endl;
			while(computer_monster == user_monster-1)
			{
				computer_monster = rand()%(sizeof(Monsters) / sizeof(Monsters[0]));
			}
			cout<<"\n\n--------------------\nComputer Choosed "<<Monsters[computer_monster].getName()<<"\n--------------------"<<endl;
			break;
		}
		
		else
		{
			cout<<"ERROR : Try Again !"<<endl;
			cout<<"\n--------------------\n\nChoose Your Monster (Integer Input Only) : ";
			cin>>user_monster;
		}
	}
	
	while(true)
	{
		
		if(Monsters[user_monster-1].getHP() > 0 && Monsters[computer_monster].getHP() > 0)
		{
			cout<<"--------------------\nYour HP : "<<Monsters[user_monster-1].getHP()<<"\nComputer's HP : "<<Monsters[computer_monster].getHP()<<"\n--------------------"<<endl;
			cout<<"--------------------\nYour("<<Monsters[user_monster-1].getName()<<") Moves -- "<<"\n\n"<<"\tMove 1 - \n\t\tAttack -- "<<Monsters[user_monster-1].moves[0][0]<<"\n\t\tHeal -- "<<Monsters[user_monster-1].moves[0][1]<<"\n\t\tSelf-Damage -- "<<Monsters[user_monster-1].moves[0][2]<<"\n\t\tProbability -- "<<Monsters[user_monster-1].moves[0][3]<<"\n\tMove 2 - \n\t\tAttack -- "<<Monsters[user_monster-1].moves[1][0]<<"\n\t\tHeal -- "<<Monsters[user_monster-1].moves[1][1]<<"\n\t\tSelf-Damage -- "<<Monsters[user_monster-1].moves[1][2]<<"\n\t\tProbability -- "<<Monsters[user_monster-1].moves[1][3]<<"\n\tMove 3 - \n\t\tAttack -- "<<Monsters[user_monster-1].moves[2][0]<<"\n\t\tHeal -- "<<Monsters[user_monster-1].moves[2][1]<<"\n\t\tSelf-Damage -- "<<Monsters[user_monster-1].moves[2][2]<<"\n\t\tProbability -- "<<Monsters[user_monster-1].moves[2][3]<<"\n--------------------"<<endl;
			cout<<"Choose Your Move(integer only) : ";
			cin>>user_move;
			
			while(true)
			{
				if(user_move > 0 && user_move <= 3)
				{
					cout<<"\n--------------------\nYou Choosed Move "<<user_move<<" !\n--------------------"<<endl;
					switch(user_move)
					{
						case 1:
							if(Monsters[user_monster-1].Move1(Monsters[computer_monster]))
							{
								cout<<"\n--------------------\nHIT !\n--------------------"<<endl;
							}
							else
							{
								cout<<"\n--------------------\nMISS !\n--------------------"<<endl;
							}
							break;
						case 2:
							if(Monsters[user_monster-1].Move2(Monsters[computer_monster]))
							{
								cout<<"\n--------------------\nHIT !\n--------------------"<<endl;
							}
							else
							{
								cout<<"\n--------------------\nMISS !\n--------------------"<<endl;
							}
							break;
						case 3:
							if(Monsters[user_monster-1].Move3(Monsters[computer_monster]))
							{
								cout<<"\n--------------------\nHIT !\n--------------------"<<endl;
							}
							else
							{
								cout<<"\n--------------------\nMISS !\n--------------------"<<endl;
							}
							break;
					}
					break;
				}
				else
				{
					cout<<"\nError\n--------------------\nChoose Your Move(integer only) : ";
					cin>>user_move;
				}
			}
			computer_move = rand()%3+1;
			cout<<"\n--------------------\nComputer Choosed Move "<<computer_move<<" !\n--------------------"<<endl;
			switch(computer_move)
				{
					case 1:
						if(Monsters[computer_monster].Move1(Monsters[user_monster-1]))
						{
							cout<<"\n--------------------\nHIT !\n--------------------"<<endl;
						}
						else
						{
							cout<<"\n--------------------\nMISS !\n--------------------"<<endl;
						}
						break;
					case 2:
						if(Monsters[computer_monster].Move2(Monsters[user_monster-1]))
						{
							cout<<"\n--------------------\nHIT !\n--------------------"<<endl;
						}
						else
						{
							cout<<"\n--------------------\nMISS !\n--------------------"<<endl;
						}
						break;
					case 3:
						if(Monsters[computer_monster].Move3(Monsters[user_monster-1]))
						{
							cout<<"\n--------------------\nHIT !\n--------------------"<<endl;
						}
						else
						{
							cout<<"\n--------------------\nMISS !\n--------------------"<<endl;
						}
						break;
				}
		}
		
		else
		{
			
			if(Monsters[computer_monster].getHP() <= 0)
			{
				cout<<"\n--------------------\nYou Win !\n--------------------"<<endl;
				break;
			}
			
			if(Monsters[user_monster-1].getHP() <= 0)
			{
				cout<<"\n--------------------\nYou Lose !\n--------------------"<<endl;
				break;
			}
			
		}
		
	}
	
}

int main()
{
	game();
	return 0;
}
