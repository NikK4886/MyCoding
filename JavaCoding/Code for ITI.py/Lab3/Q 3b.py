import math

def is_divisible(n,m):
    '''(number,number)->number
    Returns True if n is divisbale by m and false if it is not
    Precondition: None
    '''
    if(n%m == 0):
        return True

    else:
        return False

def is_devisible23n8(x):
    '''(number)->string
    Returns 'yes' if given number is divisable by 2 or 3 but not 8, returns 'no' otherwise
    Preconditon: None
    '''

    T1 = is_divisible(x,2)
    T2 = is_divisible(x,3)
    T3 = is_divisible(x,8)
    
    if((T1 or T2) and (T3==False)):
        return("yes")

    else:
        return("no")

inpt = int(input("Enter an integer: "))

if(is_devisible23n8(inpt) == 'yes'):
    print(str(inpt)+" is divisible by 2 or 3 but not 8")

else:
    print("It is not true that " + str(inpt) + " is divisble by 2 or 3 but not 8")
