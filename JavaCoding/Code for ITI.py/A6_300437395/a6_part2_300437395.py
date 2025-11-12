class Point:
    'class that represents a point in the plane'

    def __init__(self, xcoord=0, ycoord=0):
        ''' (Point,number, number) -> None
        initialize point coordinates to (xcoord, ycoord)'''
        self.x = xcoord
        self.y = ycoord

    def setx(self, xcoord):
        ''' (Point,number)->None
        Sets x coordinate of point to xcoord'''
        self.x = xcoord

    def sety(self, ycoord):
        ''' (Point,number)->None
        Sets y coordinate of point to ycoord'''
        self.y = ycoord

    def get(self):
        '''(Point)->tuple
        Returns a tuple with x and y coordinates of the point'''
        return (self.x, self.y)

    def move(self, dx, dy):
        '''(Point,number,number)->None
        changes the x and y coordinates by dx and dy'''
        self.x += dx
        self.y += dy

    def __eq__(self, other):
        '''(Point,Point)->bool
        Returns True if self and other have the same coordinates'''
        return self.x == other.x and self.y == other.y
    def __repr__(self):
        '''(Point)->str

        Returns canonical string representation Point(x, y)'''
        return 'Point('+str(self.x)+','+str(self.y)+')'
    def __str__(self):
        '''(Point)->str
        Returns nice string representation Point(x, y).
        In this case we chose the same representation as in __repr__'''
        return 'Point('+str(self.x)+','+str(self.y)+')'

class Rectangle(Point):
    'class that represents the user making a rectangle'
    def __init__(self,point1,point2,colour):
        ''' (Point,Point, str) -> None
        initialize the rectangle with top right point and bottom left point and colour'''
        
        self.p1 = point1
        self.p2 = point2
        self.colour = colour

    def get_bottom_left(self):
        '''(Point)->tuple
        Returns bottom left point'''

        return self.p1

    def get_top_right(self):
        '''(Point)->tuple
        Returns top right point'''

        return self.p2

    def get_color(self):
        '''(str)->str
        Returns the colour of the rectangle'''

        return self.colour

    def reset_color(self,newColour):
        '''(str)->none
        Changes the colour of the rectangle'''
        self.colour = newColour

    def move(self,num1,num2):
        '''(Rectangle,number,number)->None
        moves the points by num1 in x direction and by num2 in y direction'''

        x1 = self.p1.x + num1
        y1 = self.p1.y + num2

        x2 = self.p2.x + num1
        y2 = self.p2.y + num2

        self.p1 = Point(x1,y1)
        self.p2 = Point(x2,y2)

    def get_perimeter(self):
        '''(Rectangle)->int
        returns the perimeter of the rectangle'''
        
        side1 = self.p2.x - self.p1.x
        side2 = self.p2.y - self.p1.y

        return 2*side1 + 2*side2

    def get_area(self):
        '''(Rectangle)->int
        returns the area of the rectangle'''
        
        side1 = self.p2.x - self.p1.x
        side2 = self.p2.y - self.p1.y

        return side1*side2

    def contains(self,x,y):
        '''(Rectangle,x,y)->boolean 
        Returns True if point is in rectangle and False otherwise'''

        if((self.p1.x<= x <= self.p2.x) and (self.p1.y<= y <= self.p2.y)):
            return True

        else:
            return False

    def intersects(self,other):
        '''(Rectangle,Rectangle)->boolean 
        Returns True if the rectangles intercept at any point and False otherwise'''

        if((self.p1.x<=other.p1.x<=self.p2.x) or (self.p1.x<=other.p2.x<=self.p2.x)):
            incept_x1 = True

        else:
            incept_x1 = False

        if((other.p1.x<=self.p1.x<=other.p2.x) or (other.p1.x<=self.p2.x<=other.p2.x)):
            incept_x2 = True

        else:
            incept_x2 = False

        incept_x = incept_x1 or incept_x2

        if((self.p1.y<=other.p1.y<=self.p2.y) or (self.p1.y<=other.p2.y<=self.p2.y)):
            incept_y1 = True

        else:
            incept_y1 = False

        if((other.p1.y<=self.p1.y<=other.p2.y) or (other.p1.y<=self.p2.y<=other.p2.y)):
            incept_y2 = True

        else:
            incept_y2 = False

        incept_y = incept_y1 or incept_y2

        return incept_x and incept_y
        

    def __eq__(self, other):
        '''(Rectangle,Rectangle)->bool
        Returns True if self and other have the same properties'''
        return self.p1 == other.p1 and self.p2 == other.p2 and self.colour == other.colour

    def __repr__(self):
        '''(Rectangle)->str
        Returns canonical string representation of Rectangle(p1,p2)'''

        return f"Rectangle({self.p1},{self.p2},'{self.colour}')"
    
        
    def __str__(self):
        '''(Rectangle)->str
        Returns nice string representation of the basics of the rectangle
        '''
        return 'I am a '+self.get_color()+'rectangle with bottom left corner at ('+str(self.p1.x)+','+str(self.p1.y)+') and top right corner at ('+str(self.p2.x)+','+str(self.p2.y)+').'
    

class Canvas(Rectangle):
    'class that represents a canvas of rectangles'

    def __init__(self):
        '''(canvas)->none
        Initalizes the canvas'''
        self.body = []
   
    def add_one_rectangle(self,newRect):
        '''(canvas,Rectangle)->none
        Adds a rectangle to the canvas'''

        self.body.append(newRect)

    def count_same_color(self,colour):
        '''(canvas,str)->int
        Returns the amount of rectangles that have the given colour'''

        count = 0
        for i in self.body:
            if(i.colour == colour):
                count += 1

        return count

    def total_perimeter(self):
        '''(canvas)->int
        Returns the total perimeter of all the rectangles in the canvas'''

        t_perimeter = 0

        for i in self.body:
            t_perimeter += i.get_perimeter()

        return t_perimeter

    def min_enclosing_rectangle(self):
        '''(canvas)->int
        Returns the minimum rectangle that covers all the rectangles in the canvas'''

        x = []
        y = []
    
        
        for i in self.body:
            x.append(i.p1.x)
            x.append(i.p2.x)
            y.append(i.p1.y)
            y.append(i.p2.y)
            
        min_x = min(x)
        max_x = max(x)

        min_y = min(y)
        max_y = max(y)


        return Rectangle(Point(min_x,min_y),Point(max_x,max_y),"red")

    def common_point(self):
        '''(canvas)->boolean
        Returns True if there is a common point on the canvas and Flase othersise'''
        
        for i in self.body:
            for j in self.body:
                if(i != j):
                    if(i.intersects(j) == True):
                        pass

                    else:
                        return False

                else:
                    pass

        return True
                    
                      
    def __len__(self):
        '''(Canvas)->int
        Returns how many rectangles are in the canvas'''

        return len(self.body)

    def __repr__(self):
        '''(Canvas)->str
        Returns canomical string representation of Canvas'''

        return f"Canvas({self.body})"
    



        
