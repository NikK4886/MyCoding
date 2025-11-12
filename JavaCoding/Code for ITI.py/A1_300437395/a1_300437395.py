# Course: IT1 1120
# Assignment 1
# Kaern, Nikolas
# 300437395


import math

################################################################### 
# Question 1
###################################################################
def mh2kh(s):
    '''(number)-> number
    Returns the speed entered in mph converted to kph
    Precondition: the entered speed is a non-negative number
    '''

    
    ans = s*1.609344
    return ans

################################################################### 
# Question 2
###################################################################
def pythagorean_pair(a,b):
    '''(number,number) - > boolean
    Returns a boolean true or false if the given numbers are a pythagorean pair
    Precondition: None'''
    c = math.sqrt(a*a + b*b)
    return((c%1) == 0)

################################################################### 
# Question 3
###################################################################
def in_out(xs,ys,side):
    '''(number, number, number) -> boolean
    Returns a booleas true or false if the inputed x and y values are inside the box
    Precondition: None'''
    x = float(input("Put a number for an x value: "))
    y = float(input("Put a number for a y value: "))
    ans1 = xs<=x<=(xs+side)
    ans2 = ys<=y<=(ys+side)

    return(ans1 and ans2)

################################################################### 
# Question 4
###################################################################
def safe(n):
    '''(number)-> boolean
    Returns a boolean true or faslse if the given number has a 9 in it or is
    divisable by 9
    Precondition: None'''
    test1 = ( n!=9 and (n%9) != 0)
    test2 = ( (n%10) != 9 and (n//10) != 9)

    return(test1 and test2)

################################################################### 
# Question 5
###################################################################
def quote_maker(quote, name, year):
    '''(string,string,number) -> string
    Returns a sentance of strings based on the given strings and numbers
    Precondition: year is a non-negative number'''
    ans = ("In " + str(year) + ", a person called "+ name +" said: "+ quote)
    return(ans)

################################################################### 
# Question 6
###################################################################
def quote_displayer():
    '''()-> string
    Returns a sentace of strings by calling the function quote_maker, and asking
    the user to add in their own quote, name, and year
    Precondition: year is a non-negative number'''
    quote = str(input("Add your quote: "))
    name = str(input("Add your name: "))
    year = str(input("Add the year: "))

    return(quote_maker(quote,name,year))

################################################################### 
# Question 7
###################################################################
def rps_winner():
    '''()-> string
    Returns two sentances with boolean true or false describing if player 1 won
    or not and if it was a tie
    Precondition: Players choices must be in lower case and must be one of the
    options listed
    '''
    print("What choice did player 1 make?")
    P1 = str(input("Type one of the following options: rock, paper, scissors: "))

    print("What choice did player 2 make?")
    P2 = str(input("Type one of the following options: rock, paper, scissors: "))

    total = len(P1) - len(P2)

    P1WIN = (total == -4 or total == 1 or total == 3)
    tie = (total != 0)

    print("Player 1 wins. That is "+str(P1WIN))
    print("It is a tie. That is not "+str(tie))

################################################################### 
# Question 8
###################################################################
def fun(x):
    '''(number)-> number
    Returns the number given after it has been put through an equation
    Precondition: None'''
    y = (math.log((int(x)+3),10))/4
    return(y)

################################################################### 
# Question 9
###################################################################
def ascii_name_plaque(name):
    '''(string)-> none
    Prints the name given with ascii art
    Precondition: None'''
    blanks = " "*(len(name)+5)
    print("*"*(len(name)+8))
    print("*" + blanks + " *")
    print("* __"+name+"__ *")
    print("*" + blanks + " *")
    print("*"*(len(name)+8))

################################################################### 
# Question 10
###################################################################
import turtle

def draw_court():
    '''()-> none
    Draws a basketball court using turtle graphics
    Preconditions: none'''
    s = turtle.Screen()
    t = turtle.Turtle()
    s.bgcolor("orange")

    t.penup()
    t.goto(0,-40)
    t.pendown()

    t.fillcolor("brown")
    t.begin_fill()
    t.circle(40)
    t.end_fill()

    
    t.goto(0,150)
    t.goto(0,-150)

    t.goto(325,-150)
    t.goto(325,150)
    t.goto(-325,150)
    t.goto(-325,-150)
    t.goto(0,-150)

    t.up()
    t.setpos(-325,-65)
    t.down()

    t.goto(-175,-65)
    t.goto(-175,65)
    t.goto(-325,65)

    
    t.up()
    t.setpos(-325,-40)
    t.down()

    t.fillcolor("yellow")
    t.begin_fill()
    t.goto(-175,-40)
    t.goto(-175,40)
    t.goto(-325,40)
    t.end_fill()

    t.up()
    t.setpos(325,-65)
    t.down()

    t.goto(175,-65)
    t.goto(175,65)
    t.goto(325,65)

    t.up()
    t.setpos(325,-40)
    t.down()

    t.fillcolor("yellow")
    t.begin_fill()
    t.goto(175,-40)
    t.goto(175,40)
    t.goto(325,40)
    t.end_fill()

    t.up()
    t.setpos(175,-40)
    t.down()

    t.circle(40)

    t.up()
    t.pencolor("yellow")
    t.pensize(5)
    t.setpos(180,0)
    t.down()

    t.forward(40)

    t.up()
    t.pencolor("yellow")
    t.pensize(5)
    t.setpos(180,0)
    t.down()

    t.setheading(30)
    t.forward(40)

    t.up()
    t.pencolor("yellow")
    t.pensize(5)
    t.setpos(180,0)
    t.down()

    t.setheading(60)
    t.forward(40)

    t.up()
    t.pencolor("yellow")
    t.pensize(5)
    t.setpos(180,0)
    t.down()

    t.setheading(-30)
    t.forward(40)

    t.up()
    t.pencolor("yellow")
    t.pensize(5)
    t.setpos(180,0)
    t.down()

    t.setheading(-60)
    t.forward(40)

    t.pencolor("black")

    t.up()
    t.setpos(325,125)
    t.down()

    t.pensize(1)
    t.goto(250,125)
    t.setheading(-180)
    t.circle(125,180)
    t.forward(75)

    
    t.up()
    t.setpos(300,-15)
    t.down()

    t.pencolor("white")
    t.pensize(4)
    t.setheading(90)
    t.forward(30)

    t.up()
    t.setpos(300,0)
    t.down()

    t.setheading(180)
    t.forward(10)
    t.dot(12,"white")

    t.pencolor("black")
    
    t.up()
    t.pensize(1)
    t.setpos(-175,40)
    t.down()

    t.circle(40)

    t.up()
    t.setpos(-180,0)
    t.pensize(5)
    t.down()

    t.pencolor("yellow")
    t.forward(40)

    t.up()
    t.setpos(-180,0)
    t.down()

    t.setheading(210)
    t.forward(40)

    t.up()
    t.setpos(-180,0)
    t.down()

    t.setheading(240)
    t.forward(40)

    t.up()
    t.setpos(-180,0)
    t.down()

    t.setheading(150)
    t.forward(40)

    t.up()
    t.setpos(-180,0)
    t.down()

    t.setheading(120)
    t.forward(40)

    t.pencolor("black")

    t.up()
    t.setpos(-325,-125)
    t.down()

    t.pensize(1)
    t.goto(-250,-125)
    t.setheading(0)
    t.circle(125,180)
    t.forward(75)

    t.goto(-325,-40)

    t.up()
    t.setpos(-300,-15)
    t.down()

    t.pencolor("white")
    t.pensize(4)
    t.setheading(90)
    t.forward(30)

    t.up()
    t.setpos(-300,0)
    t.down()

    t.setheading(0)
    t.forward(10)
    t.dot(12,"white")

    t.up()
    t.setpos(0,0)
    t.down()


################################################################### 
# Question 11
###################################################################
def alogical(n):
    '''(number)-> number
    Returns the amount of times that the given number can be divided by 2 until
    it is less the one
    Precondition: Given number must be greater the one'''
    ans = math.log(n,2)
    ans = math.ceil(ans)
    return(ans)

################################################################### 
# Question 12
###################################################################
def cad_cashier(price,payment):
    '''(number,number)-> number
    Returns the exact change to the custmer, including how the canadien system
    works by rounding to the nearest 0.05 when giving back change
    Precondition: Given numbers must be non-negative'''
    change = float(payment) - float(price)
    dolla = change//1
    cents = round((change-dolla),2)
    ans = round((cents*2),1)/2
    
    return dolla + ans
    
    
################################################################### 
# Question 13
###################################################################
def min_CAD_coins(price,payment):
    '''(number,number)-> number
    Returns how much canadien coins are needed to give exact change,
    references the cad_cashier function
    Precondition: Given numbers must be non-negative '''
    change = cad_cashier(price,payment)
    dolla = change//1
    
    TotalCents = round(dolla*60 + (change-dolla)*100)
    

    t = TotalCents//120
    TotalCents = TotalCents - t*120

    l = TotalCents//60
    TotalCents = TotalCents - l*60

    q = TotalCents//25
    TotalCents = TotalCents - q*25

    d = TotalCents//10
    TotalCents = TotalCents - d*10

    n = TotalCents//5
    TotalCents = TotalCents - n*5

    return(int(t),int(l),int(q),int(d),int(n))
    




    
    

    
    
    

    
  
    

    

    

    







