#include <iostream>
#include <chrono>
#include <thread>
#include <cstdlib>
#include <ctime>

using namespace std;

class Monster
{
	private:
		
		const string name;
		int hp;
		
	public:
		
		int moves[3][4], MaxHP;//[Move1-[Attack,Heal,Self-Damage,Probability],Move2-........]
		
		Monster(string name,int hp,int m1a,int m1h,int m1sd,int m1p,int m2a,int m2h,int m2sd,int m2p,int m3a,int m3h,int m3sd,int m3p):name(name),hp(hp)
		{
			moves[0][0] = m1a;moves[0][1] = m1h;moves[0][2] = m1sd;moves[0][3] = m1p;
			moves[1][0] = m2a;moves[1][1] = m2h;moves[1][2] = m2sd;moves[1][3] = m2p;
			moves[2][0] = m3a;moves[2][1] = m3h;moves[2][2] = m3sd;moves[2][3] = m3p;
			MaxHP = hp;
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
		
		//The function below generate an error
		/*int getMoves()
		{
			return moves;
		}*/
		
		void setHPtoMax()
		{
			hp = MaxHP;
		}
		
		bool Move1(Monster &obj)
		{
			hp -= moves[0][2];
			
			if(moves[0][3] >= rand()%100+1)
			{
				obj.hp -= moves[0][0];
				hp += moves[0][1];
				return true;
			}
			
			else
			{
				return false;
			}
			
		}
		
		bool Move2(Monster &obj)
		{
			hp -= moves[1][2];
			
			if(moves[1][3] >= rand()%100+1)
			{
				obj.hp -= moves[1][0];
				hp += moves[1][1];
				return true;
			}
			
			else
			{
				return false;
			}
			
		}
		
		bool Move3(Monster &obj)
		{
			hp -= moves[2][2];
			
			if(moves[2][3] >= rand()%100+1)
			{
				obj.hp -= moves[2][0];
				hp += moves[2][1];
				return true;
			}
			
			else
			{
				return false;
			}
			
		}
};

//create as many monsters as you want!
Monster Monsters[] = {
	Monster("Pikachu",250,80,0,20,80,35,10,0,90,50,0,20,100),
	Monster("Charizard",400,75,0,30,60,125,0,50,40,90,5,0,20),
	Monster("Greninja",325,20,20,0,80,85,0,35,65,45,5,10,35),
	Monster("Blaziken",375,100,0,50,25,0,50,0,40,55,5,15,50),
	Monster("Bisharp",300,200,0,100,40,10,10,0,90,150,0,50,35),
	Monster("Hoopa",500,1000,0,400,45,0,100,0,20,25,15,0,55),
	Monster("Alakazam",275,25,25,0,95,190,0,100,75,65,0,15,70),
	Monster("Gyarados", 450, 90, 0, 30, 70, 120, 0, 50, 50, 70, 0, 0, 15),
	Monster("Dragonite", 500, 90, 10, 20, 40, 120, 0, 60, 60, 115, 0, 200, 100),
	Monster("Mewtwo", 600, 100, 0, 50, 70, 130, 0, 50, 45, 20, 0, 5, 100),
	Monster("Snorlax", 700, 80, 50, 0, 17, 0, 100, 5, 15, 250, 0, 300, 80),
	Monster("Gengar", 350, 40, 0, 0, 90, 90, 0, 30, 65, 0, 50, 0, 30),
	Monster("Tyranitar", 600, 120, 0, 50, 50, 100, 0, 50, 30, 80, 0, 20, 72),
	Monster("Lucario", 400, 80, 20, 0, 10, 90, 0, 5, 25, 70, 0, 80, 40),
	Monster("Salamence", 500, 100, 0, 200, 100, 120, 0, 13, 25, 70, 10, 30, 65),
	Monster("Metagross", 550, 110, 0, 60, 50, 90, 0, 50, 55, 70, 0, 80, 90),
	Monster("Haxorus", 550, 60, 0, 20, 60, 70, 0, 50, 50, 80, 0, 80, 60),
	Monster("Hydreigon", 600, 110, 0, 2, 10, 120, 0, 25, 35, 70, 0, 20, 60),
	Monster("Zoroark", 400, 40, 0, 20, 80, 70, 0, 10, 40, 100, 0, 1, 10),
	Monster("Volcarona", 450, 0, 20, 3, 70, 110, 0, 80, 75, 80, 0, 15, 35),
	Monster("Chandelure", 400, 40, 0, 0, 25, 110, 0, 40, 55, 70, 0, 10, 30),
	Monster("Galvantula", 350, 70, 0, 100, 90, 60, 0, 0, 10, 60, 0, 20, 45),
	Monster("Krookodile", 450, 100, 0, 20, 30, 70, 0, 70, 85, 80, 0, 20, 55),
	Monster("Excadrill", 500, 100, 0, 50, 50, 120, 0, 120, 75, 80, 0, 0, 10),
	Monster("Froslass", 350, 20, 0, 0, 80, 80, 0, 5, 40, 60, 0, 0, 25)
};//All the monsters should be inside this string data type array

void game()
{
	//Attacking other monster -- Monster1.Move1/Move2/Move3(Monster2);
	bool undefeated = true;
	char printMonstersAgain = 'y';
	int MatchesWon = 0, MatchesPlayed = 0, user_monster, computer_monster, user_move, computer_move;
	
	//Game starts
	cout<<"--------------------\nMONSTER BATTLE !\n-------------------\n\n-------------------\nNOTE : \n\t1) Game will end if you lose a battle.\n\t2) You score +1 for every win and -1 for every draw.\n\t4) Every monster has 3 moves.\n\t3) Monsters's HP will get self-damaged even if the move misses\n\t4) Computers's monster will be different from yours.\n-------------------\n"<<endl;
	
	while(undefeated)
	{
		cout<<"\n-------------------\nMatch "<<MatchesPlayed+1<<" starts in : "<<endl;
		//Countdown
		for(int i = 10;i > 0;i--)
		{
			cout<<"\t"<<i<<endl;
			this_thread::sleep_for(chrono::seconds(1));
		}
		
		cout<<"\n--------------------\nMatch "<<MatchesPlayed+1<<"\n--------------------\n"<<endl;
		this_thread::sleep_for(chrono::seconds(2));
		
		if(printMonstersAgain == 'y')
		{
			cout<<"\nMonsters Available -- \n\n"<<endl;
			this_thread::sleep_for(chrono::seconds(1));
			
			for(int i = 0;i<sizeof(Monsters) / sizeof(Monsters[0]);i++)
			{
				cout<<i+1<<") "<<Monsters[i].getName()<<"\n\n"<<"\tMove 1 - \n\t\tAttack -- "<<Monsters[i].moves[0][0]<<"\n\t\tHeal -- "<<Monsters[i].moves[0][1]<<"\n\t\tSelf-Damage -- "<<Monsters[i].moves[0][2]<<"\n\t\tProbability -- "<<Monsters[i].moves[0][3]<<"\n\tMove 2 - \n\t\tAttack -- "<<Monsters[i].moves[1][0]<<"\n\t\tHeal -- "<<Monsters[i].moves[1][1]<<"\n\t\tSelf-Damage -- "<<Monsters[i].moves[1][2]<<"\n\t\tProbability -- "<<Monsters[i].moves[1][3]<<"\n\tMove 3 - \n\t\tAttack -- "<<Monsters[i].moves[2][0]<<"\n\t\tHeal -- "<<Monsters[i].moves[2][1]<<"\n\t\tSelf-Damage -- "<<Monsters[i].moves[2][2]<<"\n\t\tProbability -- "<<Monsters[i].moves[2][3]<<endl;
				this_thread::sleep_for(chrono::milliseconds(500));
			}
			
		}
		
		computer_monster = rand()%(sizeof(Monsters) / sizeof(Monsters[0]));
		cout<<"\n--------------------\n\nChoose Your Monster (Integer Input Only) : ";
		cin>>user_monster;
		
		while(true)
		{
			
			if(user_monster > 0 && user_monster <=sizeof(Monsters) / sizeof(Monsters[0]))
			{
				cout<<"\n\n--------------------\nYou Choosed "<<Monsters[user_monster-1].getName()<<"\n--------------------"<<endl;
				this_thread::sleep_for(chrono::seconds(1));
				
				while(computer_monster == user_monster-1)
				{
					computer_monster = rand()%(sizeof(Monsters) / sizeof(Monsters[0]));
				}
				
				cout<<"\n\n--------------------\n"<<Monsters[computer_monster].getName()<<" (Opponent) Appeared !\n--------------------"<<endl;
				this_thread::sleep_for(chrono::seconds(1));
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
				cout<<"--------------------\nYour HP : "<<Monsters[user_monster-1].getHP()<<"\n"<<Monsters[computer_monster].getName()<<"'s (Opponent) HP : "<<Monsters[computer_monster].getHP()<<"\n--------------------"<<endl;
				cout<<"--------------------\nYour("<<Monsters[user_monster-1].getName()<<") Moves -- "<<"\n\n"<<"\tMove 1 - \n\t\tAttack -- "<<Monsters[user_monster-1].moves[0][0]<<"\n\t\tHeal -- "<<Monsters[user_monster-1].moves[0][1]<<"\n\t\tSelf-Damage -- "<<Monsters[user_monster-1].moves[0][2]<<"\n\t\tProbability -- "<<Monsters[user_monster-1].moves[0][3]<<"\n\tMove 2 - \n\t\tAttack -- "<<Monsters[user_monster-1].moves[1][0]<<"\n\t\tHeal -- "<<Monsters[user_monster-1].moves[1][1]<<"\n\t\tSelf-Damage -- "<<Monsters[user_monster-1].moves[1][2]<<"\n\t\tProbability -- "<<Monsters[user_monster-1].moves[1][3]<<"\n\tMove 3 - \n\t\tAttack -- "<<Monsters[user_monster-1].moves[2][0]<<"\n\t\tHeal -- "<<Monsters[user_monster-1].moves[2][1]<<"\n\t\tSelf-Damage -- "<<Monsters[user_monster-1].moves[2][2]<<"\n\t\tProbability -- "<<Monsters[user_monster-1].moves[2][3]<<"\n--------------------"<<endl;
				this_thread::sleep_for(chrono::seconds(1));
				cout<<"Choose Your Move(integer only) : ";
				cin>>user_move;
				
				while(true)
				{
					
					if(user_move > 0 && user_move <= 3)
					{
						cout<<"\n--------------------\nYou Choosed Move "<<user_move<<" !\n--------------------"<<endl;
						this_thread::sleep_for(chrono::seconds(1));
						
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
								
								this_thread::sleep_for(chrono::seconds(1));
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
								
								this_thread::sleep_for(chrono::seconds(1));
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
								
								this_thread::sleep_for(chrono::seconds(1));
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
				cout<<"\n--------------------\n"<<Monsters[computer_monster].getName()<<" (Opponent) Choosed Move "<<computer_move<<" !\n--------------------"<<endl;
				this_thread::sleep_for(chrono::seconds(1));
				
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
							
							this_thread::sleep_for(chrono::seconds(1));
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
							
							this_thread::sleep_for(chrono::seconds(1));
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
							
							this_thread::sleep_for(chrono::seconds(1));
							break;
							
					}
			}
			
			else
			{
				
				if(Monsters[computer_monster].getHP() <= 0 && Monsters[user_monster-1].getHP() <= 0)
				{
					cout<<"\n--------------------\nDRAW !\n--------------------"<<endl;
					MatchesWon -= 1;
					MatchesPlayed += 1;
					this_thread::sleep_for(chrono::seconds(1));
					Monsters[computer_monster].setHPtoMax();
					Monsters[user_monster-1].setHPtoMax();
					break;
				}
				
				else if(Monsters[computer_monster].getHP() <= 0)
				{
					cout<<"\n--------------------\nYOU WIN !\n--------------------"<<endl;
					this_thread::sleep_for(chrono::seconds(1));
					MatchesWon += 1;
					MatchesPlayed += 1;
					Monsters[computer_monster].setHPtoMax();
					Monsters[user_monster-1].setHPtoMax();
					cout<<"\n--------------------\nDo want to get the details of all the monsters for your next match? (y/n) : ";
					try
					{
						cin>>printMonstersAgain;
					}
					
					catch(...)
					{
						
						while(printMonstersAgain != 'y' || printMonstersAgain != 'n')
						{
							cout<<"\nError\n--------------------\nDo want to get the details of all the monsters for your next match? (y/n) : ";
							cin>>printMonstersAgain;
						}
						
					}
					
					break;
				}
				
				else if(Monsters[user_monster-1].getHP() <= 0)
				{
					cout<<"\n--------------------\nYOU LOSE !\n--------------------"<<endl;
					this_thread::sleep_for(chrono::seconds(1));
					Monsters[computer_monster].setHPtoMax();
					Monsters[user_monster-1].setHPtoMax();
					undefeated = false;
					break;
				}
				
			}
			
		}
	}
	cout<<"\n--------------------\nSCORE : "<<MatchesWon<<"\n--------------------"<<endl;
}

int main()
{
	game();
	return 0;
}
//Developed By Omanshu