try:
    from webbrowser import open as OpenURL
    from wikipedia import summary
    from datetime import date as Date
    from time import localtime, strftime
    print("\033[1;32m**********\nChatbot\n**********\n")

except Exception:
	print("ERROR : required modules not downloaded in the system")

user_in = ""
result = ""
bot_status = True
answer = ""
curr_time = localtime()
curr_clock = strftime("%H:%M:%S", curr_time)
run = True

def bot(a):
	global bot_status
	print(f"BOT : {a}")
	bot_status = False
	
def user():
	global user_in
	user_in = input("USER : ")

def info_result(topic):
	global result
	bot("searching..........")
	try:
		result = summary(topic,sentences = 250)
		bot(f"{result}")
	except Exception:
		bot("Info can't be found")
	
def calculate(expression):
	global answer
	try:
		answer = eval(expression)
		bot(f"{answer}")
	except Exception:
		bot("Invalid Expression")

today2 = Date.today()		
def date():
	global date2
	date2 = today2.strftime("%B %d, %Y")
	bot(f"Today's date is {date2}")

bot("Hello! How can I help you?(Enter \"support\" for more details)")

while run:
	
	if not bot_status:
		user()
	
	if "browser" in user_in.lower():
		bot("Enter The URL")
		user()
		OpenURL(user_in)
	
	elif "quit" in user_in.lower() or "exit" in user_in.lower():
		bot("Bye")
		run = False
	
	elif "info" in user_in.lower():
		bot("Enter the topic you want to search about")
		user()
		info_result(user_in)
	
	elif "date" in user_in.lower():
		date()
	
	elif "time" in user_in.lower():
		bot(f"Current time is {curr_clock}")
	
	elif "developer" in user_in.lower() or "developed" in user_in.lower():
		bot("I was developed by Omanshu (Github username : Omanshu209)")
	
	elif "name" in user_in.lower() and "your" in user_in.lower():
		bot("My name is :)")
	
	elif "calculator" in user_in.lower() or "solve" in user_in.lower():
		bot("Enter the mathematic expression you want to solve")
		user()
		calculate(user_in)
	
	elif "game" in user_in.lower():
		bot("To play the games developed by my developer, visit \"https://github.com/Omanshu209\"")
	
	elif "open" in user_in.lower() and "youtube" in user_in.lower():
		OpenURL("https://youtube.com")
	
	elif "youtube" in user_in.lower() and "search" in user_in.lower():
		bot("What do you want to search in youtube?")
		user()
		OpenURL(f"https://m.youtube.com/results?sp=mAEA&search_query={user_in.replace(' ','+')}")
	
	elif "support" in user_in.lower():
		bot("The keywords are as follows:\n\t .Open an URL(Surf the internet) -- \"browser\"(Internet Required)\n\t .Search information about a topic -- \"info\"(Internet Required)\n\t .Calculator -- \"calculator\"\n\t .Open or surf youtube -- \"open  youtube\" OR \"search youtube\"(Internet Required)\n\t .Today's Date -- \"date\"\n\t .Current Time -- \"time\"")
	
	else:
		prev_data = user_in
		bot(f"Do want to search about \"{user_in}\" ?")
		user()
		if "yes" in user_in.lower():
			info_result(prev_data)
		else:
		    bot(f"None of the keywords matched <{user_in}>")
