# Course: IT1 1120
# Assignment 0
# Kaern, Nikolas
# 300437395

import turtle
s = turtle.Screen()
t = turtle.Turtle()


#Start by building the first circle
t.circle(10)

#Putting the turtle into position 

t.penup()
t.goto(0,-60)
t.pendown()

#Second circle
t.circle(70)


#Putting the turtle into position 

t.penup()
t.goto(0,-100)
t.pendown()

#Thrid circle
t.circle(110)


#Putting the turtle into position 

t.penup()
t.goto(0,-150)
t.pendown()

#Fourth circle
t.circle(160)

#Back to middle
t.penup()
t.goto(0,10)
t.pendown()

#Drawing first line horizontaly 
t.goto(350,10)
t.goto(-350,10)

#Back to middle
t.penup()
t.goto(0,10)
t.pendown()

#Drawing second line vertically  
t.goto(0,350)
t.goto(0,-350)

#Back to middle
t.penup()
t.goto(0,10)
t.pendown()

#Drawing thrid line hortizontaly at 45 degrees
t.setheading(45)
t.forward(350)
t.setheading(-135)
t.forward(700)

#Back to middle
t.penup()
t.goto(0,10)
t.pendown()

#Drawing thrid line hortizontaly at 45 degrees
t.setheading(135)
t.forward(350)
t.setheading(-45)
t.forward(700)

