#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

class Monster
{
	private:
		
		const string name;
		int hp;
		int moves[3][4];//[Move1-[Attack,Heal,Self-Damage,Probability],Move2-........]
		
	public:
		
		Monster(string name,int hp,int m1a,int m1h,int m1sd,int m1p,int m2a,int m2h,int m2sd,int m2p,int m3a,int m3h,int m3sd,int m3p):name(name),hp(hp)
		{
			moves[0][0] = m1a;moves[0][1] = m1h;moves[0][2] = m1sd;moves[0][3] = m1p;
			moves[1][0] = m2a;moves[1][1] = m2h;moves[2][2] = m2sd;moves[2][3] = m2p;
			moves[2][0] = m3a;moves[2][1] = m3h;moves[2][2] = m3sd;moves[2][3] = m3p;
			srand((unsigned)time(0));
		}
		
		int getHP()
		{
			return hp;
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
Monster Pikachu("Pikachu",250,80,0,0,80,35,10,0,90,50,0,20,100);
Monster Charizard("Charizard",400,75,0,10,60,125,0,40,40,90,5,0,20);
Monster Greninja("Greninja",325,20,20,0,80,85,0,15,65,45,5,0,35);
string Monsters[3] = {"Pikachu","Charizard","Greninja"};

void game()
{
	//Attacking other monster -- Monster1.Move1/Move2/Move3(Monster2);
}

int main()
{
	game();
	return 0;
}