def digit_sum(n):
    '''(int)->int
    Returns the sum of all the digits
    Precondition: n must be non negative integer'''

    if(n<1):
        return 0
    
    x = n%10
    n = int((n-x)/10)

    
    
    return x + digit_sum(n)

def digital_root(n):
    '''(int)->int
    Returns the digital root of n
    Precondition: n must be non negative integer'''

    n = digit_sum(n)
    
    if(n<=9):
        return n

    return digital_root(n)

    
    
    
