console.log("--------------------\n\nTic Tac Toe\n\n--------------------\n\nEnter a number(from 1 to 9)\n\nThe board is labelled as follow :\n   1   |   2   |   3\n   4   |   5   |   6\n   7   |   8   |   9\n\n--------------------");

const prompt = require("prompt-sync")();

let pTurn = 1;
let userIn = '';
let Retry = true;
let [b1,b2,b3,b4,b5,b6,b7,b8,b9] = [' ',' ',' ',' ',' ',' ',' ',' ',' '];
const winCases = [[1,2,3],[1,7,4],[4,6,5],[7,8,9],[2,5,8],[3,9,6],[1,5,9],[3,5,7]];

//let board = `   ${b1}   |   ${b2}   |   ${b3}\n   ${b4}   |   ${b5}   |   ${b6}\n   ${b7}   |   ${b8}   |   ${b9}`;

const displayXO = () => {
    userIn = prompt(`Player ${pTurn} : `);
    while(userIn <= 0 || userIn >=10)
    {
        userIn = prompt(`Player ${pTurn} : `);
    }
    if(userIn >= 1 && userIn <= 9)
    {
        if(eval(`b${userIn}`) == ' ')
          if(pTurn == 1)
          {
              eval(`b${userIn} = 'X'`);
              pTurn = 2;
              console.log(`--------------------\n\n   ${b1}   |   ${b2}   |   ${b3}\n   ${b4}   |   ${b5}   |   ${b6}\n   ${b7}   |   ${b8}   |   ${b9}\n\n--------------------`);
          }
          else
          {
              eval(`b${userIn} = 'O'`);
              pTurn = 1;
              console.log(`--------------------\n\n   ${b1}   |   ${b2}   |   ${b3}\n   ${b4}   |   ${b5}   |   ${b6}\n   ${b7}   |   ${b8}   |   ${b9}\n\n--------------------`);
          }
    }
}

const checkResult = () => {
    for(let i = 0;i<8;i++)
    {
      if(eval(`b${winCases[i][0]} == b${winCases[i][1]} && b${winCases[i][0]} == b${winCases[i][2]} && b${winCases[i][1]} == b${winCases[i][2]} && b${winCases[i][0]} != ' ' && b${winCases[i][1]} != ' ' && b${winCases[i][2]} != ' '`))
      {
          console.log(eval(`b${winCases[i][0]}`)+" Wins !\n--------------------");
          [b1,b2,b3,b4,b5,b6,b7,b8,b9] = [' ',' ',' ',' ',' ',' ',' ',' ',' '];
          Retry = prompt("Do you want to play again ?(y/n) : ");
          console.log("--------------------");
          while(true)
          {
	          if(Retry == 'y')
	          {
	              Retry = true;
	              break;
	          }
	          else if(Retry == 'n')
	          {
	              Retry = false;
	              break;
	          }
            else
            {
                Retry = prompt("Do you want to play again ?(y/n) : ");
            }
          }
          break;
      }
  }
  if(b1 != ' ' && b2 != ' ' && b3 != ' ' && b4 != ' ' && b5 != ' ' && b6 != ' ' && b7 != ' ' && b8 != ' ' && b9 != ' ')
      {
          console.log("Draw !\n--------------------");
          [b1,b2,b3,b4,b5,b6,b7,b8,b9] = [' ',' ',' ',' ',' ',' ',' ',' ',' '];
          Retry = prompt("Do you want to play again ?(y/n) : ");
          console.log("--------------------");
          while(true)
          {
	          if(Retry == 'y')
	          {
	              Retry = true;
	              break;
	          }
	          else if(Retry == 'n')
	          {
	              Retry = false;
	              break;
	          }
            else
            {
              Retry = prompt("Do you want to play again ?(y/n) : ");
            }
          }
      }
}

const game = () => {
    while(Retry)
    {
        displayXO();
        checkResult();
    }
}

game();
