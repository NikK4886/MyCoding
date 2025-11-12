def longest_run(n):
    '''(list)->number
    Returns the length of the longest run in the given list
    Precondition: Assume that user inputs correctly'''

    if len(n) == 0: return 0

    longest = 0
    count = 0

    for i in range(len(n)-1):
        if(n[i] == n[i+1]):
            count += 1

        else:
            if count > longest:
                longest = count

            count = 0

    return longest+1




raw_input = input("Please input a list of numbers separated by space: ").strip().split()
raw_input = list(map(float,raw_input))

print(longest_run(raw_input))
