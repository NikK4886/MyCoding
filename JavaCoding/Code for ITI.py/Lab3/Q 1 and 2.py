import math

#Exercise 1
def pay(dolla,hours):
    '''(number,number)->number
    Returns the amount of money earned after working the given rate at the given hours
    Precondition: dolla and hours must be non-negative values
    '''

    amnt = 0

    if(hours>60):
        amnt = 2*dolla*(hours-60)
        amnt = 1.5*dolla*((hours - (hours-60))- 40) + amnt
        amnt = amnt + dolla*40

    elif(hours<=60 and hours>40):
        amnt = 1.5*dolla*(hours - 40)
        amnt = amnt + dolla*40

    else:
        amnt = dolla*hours

    return amnt

#Exercise 2
def rps(P1ans,P2ans):
    '''(string,string)->number
    Returns 1 if player 1 won, -1 if player two won, and 0 if its a tie of rock paper scissors
    Precondition: P1ans and P2ans must be 'R', 'S', or 'P'
    '''
    ans = 0

    if((P1ans == "R" and P2ans == "S") or (P1ans == "P" and P2ans == "R") or (P1ans == "S" and P2ans == "R")):
       ans = -1

    elif((P2ans == "R" and P1ans == "S") or (P2ans == "P" and P1ans == "R") or (P2ans == "S" and P1ans == "R")):
       ans = 1

    return ans






    
