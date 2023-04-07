console.log("--------------------\n\nMultiplication Table Generator\n\n--------------------");

var number;
var count;
const readline = require("readline-sync");

run = true;
while(run)
{
    number = readline.question("Enter The Number : ");
    console.log("--------------------");
    count = readline.question(`Enter the number till which you want ${number}'s multiplication table : `);
    console.log(`--------------------\n\nMultiplication table of ${number} : \n`);
    for(i=1;i<=count;i++)
    {
      console.log(`${number} x ${i} = ${number*i}\n`);
    }
    console.log("--------------------");
}
