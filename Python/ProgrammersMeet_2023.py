from random import randint

UPPER_VALUE = 100
LOWER_VALUE = 0

# a function to compare the number guesed by the user with the actual number
def COMPARE(ACTUAL_NUM, GUESSED_NUM):
	if GUESSED_NUM > ACTUAL_NUM:
		return "The number is HIGHER than the actual number"
	elif GUESSED_NUM < ACTUAL_NUM:
		return "The number is LOWER than the actual number"
	else:
		return "EQUAL"

def game():
	while True:
		WON = False
		TRIALS = int(input("Enter the number of trials the user will take to guess the number : "))#number of trials
		ACTUAL_NUM = randint(LOWER_VALUE, UPPER_VALUE)
		GUESS = LOWER_VALUE - 1#assigned the value to be -ve so that the guess is not equal to the actual number at the start of the game itself
		
		while COMPARE(ACTUAL_NUM, GUESS) != "EQUAL" and TRIALS > 0:
			GUESS = int(input("Your GUESS : "))
			while GUESS > UPPER_VALUE or GUESS < LOWER_VALUE:
				GUESS = int(input(f"Enter a number between {LOWER_VALUE} and {UPPER_VALUE} : "))
				
			if COMPARE(ACTUAL_NUM, GUESS) != "EQUAL":
				TRIALS -= 1
				print(COMPARE(ACTUAL_NUM, GUESS))
				print(f"{TRIALS} trials left")
			else:
				print("YOU WON!")
				WON = True
				break
		
		if not WON:
			print("Sorry, You lose(0 trials left)!")
			
		PLAY_AGAIN = input("Do you want to play again?(y/n) : ")
		
		if PLAY_AGAIN.lower() == 'n':
			break
			
game()