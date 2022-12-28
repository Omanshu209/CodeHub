import turtle
import random

colours=["red","blue",'green','purple','pink','yellow','white','orange']

bg=turtle.Screen()
bg.bgcolor("black")
om=turtle.Turtle()
om.speed(0)
om.width(5)
om.color("green")

def up():
	om.setheading(90)
	om.forward(50)
	
def down():
	om.setheading(270)
	om.forward(50)
	
def right():
	om.setheading(0)
	om.forward(50)
	
def left():
	om.setheading(180)
	om.forward(50)
	
def color():
	om.color(random.choice(colours))
	
def mark():
	om.stamp()
	
turtle.listen()

turtle.onkeypress(mark,'m')
turtle.onkeypress(color,'c')
turtle.onkeypress(up,"Up")
turtle.onkeypress(down,"Down")
turtle.onkeypress(right,"Right")
turtle.onkeypress(left,"Left")

turtle.mainloop()
