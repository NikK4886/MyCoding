def split_tester(N, d):
    # Your code for split_tester function goes here (instead of keyword pass)
    # Your code should include  dosctrings and the body of the function
    '''(string,string)->boolean
    Returns true if the the sequence of numbers are increasing and prints the sequence of numbers seperated by ,
    Precondition: N and d must be string digits'''
    d = int(d)
    x = len(N)/d
    x = int(x)
    finalNums = ""
    ans = True
    if(len(N)%d != 0):
        return False
    
    elif(len(N) == d):
        print(int(N))
        return ans

    for i in range(x):
        y = N[i*d:d+(i*d)]
        z = N[d+(i*d):2*d+(i*d)]
        
        if(i == 0):
            finalNums = finalNums + N[:d]

        else:
            finalNums = finalNums + ", " + y

        if(len(z)>0):
            if(int(y) <= int(z)):
                pass

            else:
                ans = False
            
            
            
    print(finalNums)
    return ans

    
# you can add more function definitions here if you like       


            
# main
# Your code for the welcome message goes here, instead of name="Vida"
header = "__Welcome to my increasing-splits tester__"
print("*"*(len(header)+4))
print("*"+" "*(len(header)+2)+"*")
print("* " + header + " *")
print("*"+" "*(len(header)+2)+"*")
print("*"*(len(header)+4)+"\n")
name=input("What is your name? ")

name= name.strip()

print("*"*(len(name)+50))
print("*"+" "*(len(name)+48)+"*")
print("* __" + name + ", welcome to my increasing-splits teaster.__ *")
print("*"+" "*(len(name)+48)+"*")
print("*"*(len(name)+50)+"\n")

flag=True
check = False
while flag:
    question=input(name+", would you like to test if a number admits an increasing-split of give size? ")
    question=(question.strip()).lower()
    
    if(question != "yes"):
        if question=='no':
            flag=False
        else:
            print("Please enter yes or no. Try again.")
    #YOUR CODE GOES HERE. The next line should be elif or else.

    else:
        print("Good choice!")
        N = input("Enter a positive integer: ")
        N = N.strip()

        if((N.isdigit() == False) and ((N.count('-') < 1) or N.count('.')>0)):
            print("The input can only contain digits. Try again.")
            
        elif(int(N)<0):
            print("The input must be a positive integer. Try again.")

        else:
            d = input("Input the split. The split has to divide the length of "+ N + " i.e "+str(len(N))+"\n")
            d = d.strip()
            if(d.isdigit() == False):
                print("The split can only contain digits. Try again.")
                
            elif(((len(N))% int(d)) != 0):
                print(d+" does not divide "+ str(len(N))+". Try again.")

            else:
                ans = split_tester(N, d)
                if(ans == True):
                    print("The sequence is increasing")

                else:
                    print("The sequence is not increasing")
                
                
                
        
#finally your code goes here too.
print("")
print("*"*(len(name)+18))
print("*"+" "*(len(name)+16)+"*")
print("* __Good bye " + name + "!__ *")
print("*"+" "*(len(name)+16)+"*")
print("*"*(len(name)+18)+"\n")



















            
