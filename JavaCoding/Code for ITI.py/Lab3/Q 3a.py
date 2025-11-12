import math

def is_divisible(n,m):
    '''(number,number)->number
    Returns True if n is divisbale by m and false if it is not
    Precondition: None
    '''
    if(n%m == 0):
        print(str(n)+" is divisble by "+str(m))

    else:
        print(str(n)+" is not divisble by "+str(m))


n = int(input("Enter 1st integr: "))
m = int(input("Enter 2nd integer: "))

is_divisible(n,m)
        
