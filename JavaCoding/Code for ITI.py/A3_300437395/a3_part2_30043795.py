import math
from decimal import Decimal 

##############################################
#Question 2.1
##############################################
def sum_odd_divisors(n):
    '''(number)->number
    Returns the sum of the odd divisors of the given number
    Precondition: n must be integer
    '''
    ans = 0

    if(n<0):
        n = n*-1
    
    if(n == 0):
        return None

    else:
        for i in range(n+1):
            if((i%2 == 1) and (n%i == 0)):
                ans = ans + i

        return ans
    
##############################################
#Question 2.2
##############################################
def series_sum():
    '''()-> number
    Prompts the user for a non negative number, then returns 1000 + 1/1^2 + 1/2^2 ... 1/n^2
    Precondition: None'''
    ans = 1000
    n = int(input("Please enter a non negative integer: "))

    if(n < 0):
        return None

    else:
        for i in range(n+1):
            if i == 0:
                pass

            else:
                ans = ans + (1/(i**2))

        return ans

##############################################
#Question 2.3
##############################################
def pell(n):
    '''(number)->number
    Returns the nth Pell number
    Precondition: n must be an integer'''
    ans = 0
    if(n < 0):
        return None

    else:
        ans = ((1+math.sqrt(2))**(n) - (1-math.sqrt(2))**(n))/(2*math.sqrt(2))
        ans = round(ans)
        return ans

#Ask her about this on wednesday

##############################################
#Question 2.4
##############################################
def countMembers(s):
    '''(string)->number
    Returns a number based on how many times an extraordinary character is in the string
    Precondition: s must be a string'''

    ans = 0

    for i in range(len(s)):
        
        if((s[i] == 'e') or (s[i] == 'f') or (s[i] == 'g') or (s[i] == 'h') or (s[i] == 'i') or (s[i] == 'j') or (s[i] == 'F') or (s[i] == 'G') or (s[i] == 'H') or (s[i] == 'I') or (s[i] == 'J') or (s[i] == 'K') or (s[i] == 'L') or (s[i] == 'M') or (s[i] == 'N') or (s[i] == 'P') or (s[i] == 'Q') or (s[i] == 'R') or (s[i] == 'S') or (s[i] == 'T') or (s[i] == 'U') or (s[i] == 'V') or (s[i] == 'W') or (s[i] == 'X') or (s[i] == '2') or (s[i] == '3') or (s[i] == '4') or (s[i] == '5') or (s[i] == '6') or (s[i] == '!') or (s[i] == ',') or (s[i] == '\\')):
            ans += 1


    return ans

##############################################
#Question 2.5
##############################################
def casual_number(s):
    '''(string)-> number
    Returns an integer representing an interpertation of the string s
    Precondition: s must be a string
    '''

    neg = False
    count = 0
    ans = 0
    s = s.replace(",","")

    for i in range(len(s)):
        if(s[i] == '-'):
            count += 1

        elif(False == ((s[i] == '0') or (s[i] == '1') or (s[i] == '2') or (s[i] == '3') or (s[i] == '4') or (s[i] == '5') or (s[i] == '6') or (s[i] == '7') or (s[i] == '8') or (s[i] == '9'))):
            return None


        elif((s[i] == '0') or (s[i] == '1') or (s[i] == '2') or (s[i] == '3') or (s[i] == '4') or (s[i] == '5') or (s[i] == '6') or (s[i] == '7') or (s[i] == '8') or (s[i] == '9')):
            ans = ans + int(s[i])*(10**((len(s)-1)-i))


    if(ans == 0 or count > 1):
        return None

    elif(count == 1):
        return ans*-1

    else:
        return ans

##############################################
#Question 2.6
##############################################
def alienNumbers(s):
    '''(string)->number
    Returns a nuber bassed on how the sum of the aien symbols in the string
    Precondition: All characters must be in the given set of characters'''

    return((s.count('T'))* 1024 + (s.count('y'))*598 + (s.count('!'))*121 + (s.count('a'))*42 + (s.count('N'))*6 + (s.count('U'))*1)
    
##############################################
#Question 2.7
##############################################
def alienNumbersAgain(s):
    '''(string)->number
    Returns a nuber bassed on how the sum of the aien symbols in the string, no string methods
    Precondition: All characters must be in the given set of characters'''   

    ans = 0
    T = 0
    y = 0
    v = 0
    a = 0
    N = 0
    U = 0

    for i in range(len(s)):
        if(s[i] == 'T'):
            T += 1

        elif(s[i] == 'y'):
            y += 1

        elif(s[i] == '!'):
            v += 1

        elif(s[i] == 'a'):
            a += 1

        elif(s[i] == 'N'):
            N += 1

        else:
            U += 1

    return (T*1024 + y*598 + v*121 + a*42 + N*6 + U*1)

##############################################
#Question 2.8
##############################################
def encrypt(s):
    '''(string)->string
    Returns a string that is an encrypted version of the given string
    Precondition: s must be a string'''

    ans = ""
    RevS = ""
    x = 0
    y = 0
    for i in range(len(s)):
        RevS = s[i] + RevS

    for i in range(len(s)):
        if((i+1)%2 == 1):
            ans = ans + RevS[x]
            x += 1

        else:
            ans = ans + s[y]
            y += 1

        


    return ans

##############################################
#Question 2.9
##############################################
def oPify(s):
    '''(string)->string
    Returns a string that has op inserted between each char
    Precondition: s must be a string'''

    ans = ""
    
    if len(s) < 2: return s
    
    for i in range(len(s)):
        if((i+1)==len(s)):
            ans = ans+s[i]

        elif((s[i].isalpha() == False) or (s[i+1].isalpha()==False)):
            ans = ans + s[i]

        else:
            if(s[i].isupper() == True):
                ans = ans + s[i] + 'O'

            else:
                ans = ans + s[i] + 'o'

            if(s[i+1].isupper() == True):
                ans = ans + 'P'  

            else:
                ans = ans + 'p'

            


    return ans

##############################################
#Question 2.10
##############################################
def nonrepetitive(s):
    '''(string)-> boolean
    Returns True or False if the given string is nonrepetitive
    Precondition: s must be a string'''

    check1 = ""
    if(len(s)<2): return True

    for x in range(len(s)):
        for z in range(len(s)):
            if(s[x:(z+x+1)]== s[(z+x+1):(z+x+1)+len(s[x:(z+x+1)])]):
               return False

    return True
           
        

    
        
    
    
















            
            
