from random import choice

class Password_Generator:
	
	def __init__(self):
		self.choices=[]
		self.characters=['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','@','#','₹','_','&','-','+','*',':',';','!','?','~']
		self.password=""
	
	def GenerateRandomPassword(self,length=10):
		for i in range(length):
			self.password+=choice(self.characters)
		password=self.password
		self.password=""
		return password
		
	def GenerateCustomCharacterPassword(self,custom,length=10):
		for i in range(len(custom)):
			self.choices.append(custom[i])
		for i in range(length):
			self.password+=choice(self.choices)
		password=self.password
		self.password=""
		self.choices=[]
		return password 

	def GenerateNumericalPassword(self,length=10):
		for i in range(length):
			self.password+=choice(['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'])
		password=self.password
		self.password=""
		return password 
	
	def GenerateAlphabeticalPassword(self,length=10,lower=False,upper=False):
		alphabets=['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
		for i in range(length):
			if lower and upper != True:
				self.password+=choice(alphabets).lower()
			elif upper and lower != True:
				self.password+=choice(alphabets)
			else:
				self.password+=choice(['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'])
		password=self.password
		self.password=""
		return password 
		
	def GenerateSpecialCharacterPassword(self,length=10):
		for i in range(length):
			self.password+=choice(['@','#','₹','_','&','-','+','*',':',';','!','?','~'])
		password=self.password
		self.password=""
		return password 
		

PasswordGenerator=Password_Generator()