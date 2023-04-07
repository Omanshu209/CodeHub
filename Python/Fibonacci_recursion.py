data={}
def fibonacci(n):
	if n<=2:
		return 1
	if n in data:
		return data[n]
	else:
		num= fibonacci(n-1)+fibonacci(n-2)
		data[n]=num
		return num
		
fib=int(input("Enter The n(th) Fibonacci Number You Want To Find:: "))	
print("n(th) Fibonacci Number:: ",fibonacci(fib))
