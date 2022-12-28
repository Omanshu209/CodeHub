import random

print("Rock Paper Scissor!")
com=('scissor','rock','paper')
a=random.randint(0,2)
b=com[a]
user=input('Choose -rock,paper,scissor: ')

if b=='scissor' and user=='rock':
	print('You won!')
	print("Computer: ",b)
	print('You: ',user)
	
elif b=='rock' and user=='paper':
	print('You won!')
	print("Computer: ",b)
	print('You: ',user)
	
elif b=='paper' and user=='scissor':
	print('You won!')
	print("Computer: ",b)
	print('You: ',user)
	
elif b=='paper' and user=='rock':
	print('You Lose!')
	print("Computer: ",b)
	print('You: ',user)
	
elif b=='rock' and user=='scissor':
	print('You Lose!')
	print("Computer: ",b)
	print('You: ',user)
	
elif b=='scissor' and user=='paper':
	print('You Lose!')
	print("Computer: ",b)
	print('You: ',user)
	
elif b==user:
	print('Its A Tie!')
	print("Computer: ",b)
	print('You: ',user)
	
else:
	print('INVALID INPUT')
	
	
print('Thank You For Playing(I made this code in 2 min)')
