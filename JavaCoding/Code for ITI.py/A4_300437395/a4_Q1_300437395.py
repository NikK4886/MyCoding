def number_divisible(list1,n):
    '''(list,number)->int
    returns the result of how many numbers in the list are divisible by n
    Preconditions: None cause we assume that the inputer follows instruction'''
    count = 0
    pos = -1
    for i in list1:
        pos += 1
        if(list1[pos]%n == 0):
            count += 1

    return count

raw_input = input("Please input a list of numbers separated by space: ").strip().split()
raw_input = list(map(int,raw_input))
n = int(input("Please input an interger: "))

ans = number_divisible(raw_input,n)

print("The number of elements divisible by "+str(n)+" is "+str(ans))



