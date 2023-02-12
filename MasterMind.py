from random import choice

class MasterMind:
	
	def __init__(self,length=4,alphabets="R G B A S E O",attempts=10,delimeter=' '):
		self.codeLength=length 
		self.alphabets=alphabets
		self.letters=alphabets.split(' ')#['R','G','B','A','S','E','O']
		self.code=[]
		self.guess=[]
		self.attempts=attempts 
		self.M_attempts=attempts
		self.delimeter=delimeter 
		self.win=False 
		self.correctPos=0
		self.incorrectPos=0
		self.letterCount={}
		for l in self.letters:
			if l not in self.letterCount:
				self.letterCount[l]=0
		
	def start(self):
		print(f"Welcome to mastermind! In this game you have to guess a {self.codeLength} letter code,each seperated by \'{self.delimeter}\'.You have {self.attempts} attempts.\nPossible letters in the code :\t{self.alphabets}")
		
	def generate_code(self):
		for i in range(self.codeLength):
			self.code.append(choice(self.letters))
		for l in self.code:
			self.letterCount[l]+=1
	def play(self):
		self.start()
		self.generate_code()
		while self.attempts>0 and self.win==False:
			self.guess=input("Your Guess : ").split(self.delimeter)
			while len(self.guess)!=self.codeLength:
				print(f"ER : Your input should contain {self.codeLength} letters, each seperated by \'{self.delimeter}\'\n********************")
				self.guess=input("Your Guess : ").split(self.delimeter)
			for l in self.guess:
				if l not in self.letters:
					print(f"ER : Invalid letter {l}\n********************")
					self.guess=input("Your Guess : ").split(self.delimeter)
					break
			self.logic()
			self.attempts-=1
			if self.attempts<=0:
				print('You Lose ! ')

		
	def logic(self):
		if self.guess[0]!=self.code[0] or self.guess[1]!=self.code[1] or self.guess[2]!=self.code[2] or self.guess[3]!=self.code[3]:
			self.correctPos=0
			self.incorrectPos=0
			for i in range(self.codeLength):
				if self.guess[i] in self.code:
					if self.guess[i]==self.code[i]:
						self.correctPos+=1
						self.letterCount[self.guess[i]]-=1
					else:
						if self.letterCount[self.guess[i]]>0:
							self.incorrectPos+=1
			print(f"Correct Positions : {self.correctPos}   |   Incorrect Positions : {self.incorrectPos}\nAttempts left : {self.attempts-1}\n********************")
		else:
			print(f'You Win !\nAttempts used : {(self.M_attempts - self.attempts)+1}\n********************')
			self.win=True 
			
if __name__=='__main__':
	Game=MasterMind()
	Game.play()