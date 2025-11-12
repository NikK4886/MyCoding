def two_length_run(list1):
    '''(list)->boolean
    Returns true or false if there is a a run of length two
    Precondition: Assuming user inputs properly'''

    if len(list1) == 1: return False
    for i in range(len(list1)-1):
        
        if(list1[i] == list1[i+1]):
            return True

    return False

raw_input = input("Please input a list of numbers separated by space: ").strip().split()
raw_input = list(map(float,raw_input))

print(two_length_run(raw_input))

        
