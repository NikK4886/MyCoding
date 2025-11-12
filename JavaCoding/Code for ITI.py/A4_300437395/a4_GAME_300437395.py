# In this implementation a card (that is not a 10) is represented
# by a 2 character string, where the 1st character represents a rank and the 2nd a suit.
# Each card of rank 10 is represented as a 3 character string, first two are the rank and the 3rd is a suit.

import random

def wait_for_player():
    '''()->None
    Pauses the program until the user presses enter
    '''
    try:
         input("\nPress enter to continue. ")
         print()
    except SyntaxError:
         pass


def make_deck():
    '''()->list of str
        Returns a list of strings representing the playing deck,
        with one queen missing.
    '''
    deck=[]
    suits = ['\u2660', '\u2661', '\u2662', '\u2663']
    ranks = ['2','3','4','5','6','7','8','9','10','J','Q','K','A']
    for suit in suits:
        for rank in ranks:
            deck.append(rank+suit)
    deck.remove('Q\u2663') # remove a queen as the game requires
    return deck

def shuffle_deck(deck):
    '''(list of str)->None
       Shuffles the given list of strings representing the playing deck    
    '''
    random.shuffle(deck)

#####################################

def deal_cards(deck):
    
    
    '''(list of str)-> tuple of (list of str,list of str)

     Returns two lists representing two decks that are obtained
     after the dealer deals the cards from the given deck.
     The first list represents dealer's i.e. computer's deck
     and the second represents the other player's i.e user's list.
     '''
    dealer = []
    other=[]

     # COMPLETE THE BODY OF THIS FUNCTION ACCORDING TO THE DESCRIPTION ABOVE
     # YOUR CODE GOES HERE

    for i in range(len(deck)-1):
        if(i%2 == 0):
            other.append(deck[i])

        else:
            dealer.append(deck[i])

    return (dealer, other)
 


def remove_pairs(l):
    '''
     (list of str)->list of str

     Returns a copy of list l where all the pairs from l are removed AND
     the elements of the new list shuffled

     Precondition: elements of l are cards represented as strings described above

     Testing:
     Note that for the individual calls below, the function should
     return the displayed list but not necessarily in the order given in the examples.

     >>> remove_pairs(['9♠', '5♠', 'K♢', 'A♣', 'K♣', 'K♡', '2♠', 'Q♠', 'K♠', 'Q♢', 'J♠', 'A♡', '4♣', '5♣', '7♡', 'A♠', '10♣', 'Q♡', '8♡', '9♢', '10♢', 'J♡', '10♡', 'J♣', '3♡'])
     ['10♣', '2♠', '3♡', '4♣', '7♡', '8♡', 'A♣', 'J♣', 'Q♢']
     >>> remove_pairs(['10♣', '2♣', '5♢', '6♣', '9♣', 'A♢', '10♢'])
     ['2♣', '5♢', '6♣', '9♣', 'A♢']
    '''

    no_pairs=[]

    # COMPLETE THE BODY OF THIS FUNCTION ACCORDING TO THE DESCRIPTION ABOVE
    # YOUR CODE GOES HERE


    check = ""
    for i in range(len(l)):
        check= check + l[i]

    for card in l:
        if len(card) == 3:
            num = card[:2]

        else:
            num = card[0]

        if((check.count(num))%2 != 0):
            no_pairs.append(card)

        check = check.replace(num,"")
        
    
    random.shuffle(no_pairs)
    return no_pairs

def print_deck(deck):
    '''
    (list)-None
    Prints elements of a given list deck separated by a space
    '''

    # COMPLETE THE BODY OF THIS FUNCTION ACCORDING TO THE DESCRIPTION ABOVE
    # YOUR CODE GOES HERE
    cards = ""
    for i in range(len(deck)):
        cards = cards + " " + deck[i]

    print("\n"+cards+"\n")

    
def get_valid_input(n):
    '''
     (int)->int
     Returns an integer given by the user that is at least 1 and at most n.
     Keeps on asking for valid input as long as the user gives integer outside of the range [1,n]
     
     Precondition: n>=1
    '''

     # COMPLETE THE BODY OF THIS FUNCTION ACCORDING TO THE DESCRIPTION ABOVE
     # YOUR CODE GOES HERE
    num = int(input("Give me a number between 1 and "+str(n)+": "))
    while( num > n or num < 1):
         num = int(input("Invalid number. Please enter integer between 1 and "+str(n)+":"))

    return num
def play_game():
    '''()->None
     This function plays the game
    '''
    
    deck=make_deck()
    shuffle_deck(deck)
    tmp=deal_cards(deck)

    dealer=tmp[0]
    human=tmp[1]

    print("Hello. My name is Robot and I am the dealer.")
    print("Welcome to my card game!")
    print("Your current deck of cards is:")
    print_deck(human)
    print("Do not worry. I cannot see the order of your cards")

    print("Now discard all the pairs from your deck. I will do the same.")
    wait_for_player()
     
    dealer=remove_pairs(dealer)
    human=remove_pairs(human)

    # COMPLETE THE play_game function HERE
    # YOUR CODE GOES HERE
    while (len(dealer)>0 or len(human)>0):
        print("*"*20)
        print("Your current deck of cards is:")
        
        print_deck(human)

        print("I have "+str(len(dealer))+ " cards. If 1 stands for my first card and\n"+str(len(dealer))+ " for my last card, which of my cards would you like?")
        x = get_valid_input(len(dealer))
        print("You have asked for my "+str(x)+"th card.")
        print("Here it is. It is "+dealer[x-1]+"\n")
        print("With "+dealer[x-1]+" added your current deck is:")
        human.append(dealer[x-1])
        print_deck(human)
        if(len(dealer)==0 or len(human)==0):
            break
        dealer.remove(dealer[x-1])
        print("And after discrading pairs and shuffling your deck is:")
        human = remove_pairs(human)
        print_deck(human)

        wait_for_player()
        print("*"*20)
        print("My turn.\n")
        rand = random.randint(1,len(human))
        print("I took your "+str(rand)+" card.")
        dealer.append(human[rand-1])
        if(len(dealer)==0 or len(human)==0):
            break
        human.remove(human[rand-1])
        
        dealer = remove_pairs(dealer)

        wait_for_player()

    if(len(dealer)== 0):
        print("Ups. I do not have any more cards \nYou lost! I, Robot, win")


    else:
        print("Ups. You do not have any more cards \nCongratulations! You, Human, win")

	

# main
play_game()
