###################################
#5.16
###################################
def indexes(word,char):
    '''(string,string)-> list of strings
    Returns a list of all the indexs where char appeares in the word
    Precondition: Must both br string input'''

    indx = []

    for i in range(len(word)):
        if(word[i] == char):
            indx.append(i)

    return indx

###################################
#5.17
###################################
def doubles(nums):
    '''(list of nums)->none
    Prints a number if it is double the last num
    Precondition: input must be a list of numbers'''

    for i in range(len(nums)):

        if(i != len(nums)-1):

            x = nums[i+1]
            y = nums[i]
            
            if( x == 2*y):
                print(x)

###################################
#5.18
###################################
def four_letter(words):
    '''(list of strings)->list of strings
    Returns a list of all 4 letter words in the given list
    Precondition: must be a list'''

    sublist = []

    for i in words:
        if(len(i) == 4):
            sublist.append(i)

    return sublist

###################################
#5.19
###################################
def inBoth(nums1,nums2):
    ans = False

    for i in range(len(nums1)):
        for j in range(len(nums2)):
            if(nums1[i] == nums2[j]):
                ans = True

    return ans

###################################
#5.20
###################################
def intersect(nums1,nums2):
    ans = []

    for i in range(len(nums1)):
        for j in range(len(nums2)):
            if(nums1[i] == nums2[j]):
                ans.append(nums1[i])

    return ans

###################################
#5.21
###################################
def pair(nums1,nums2,n):

    for i in range(len(nums1)):
        for j in range(len(nums2)):
            if((nums1[i] + nums2[j])==n):
                print(str(nums1[i]) + " " + str(nums2[j]))

###################################
#5.22
###################################
def pairSum(nums1,n):

    for i in range(len(nums1)):
        for j in range(len(nums1)):
            if(i > j):
                pass
            elif((nums1[i] + nums1[j])==n):
                print(str(i)+" "+str(j))

###################################
#5.29
###################################
def lastfirst(words):

    FirstNames = []
    LastNames = []
    l = []
    
    for i in words:
        x = i.split() # split(',')
        
        LastNames.append(x[0].replace(',',''))

        FirstNames.append(x[1])

    l.append(FirstNames)
    l.append(LastNames)

    return l
###################################
#5.31
###################################
def subsetSum(nums,n):
    for i in nums:
        for j in nums:
            for y in nums:
                if((i+j+y) == n):
                    return True

    return False

###################################
#5.33
###################################
def mystery(n):
    count = 0
    while n > 1:
        n = n//2
        count+=1
    return count

###################################
#5.48
###################################
def sublist(nums1,nums2):

    l = []
    
    for i in nums1:
        for j in nums2:
            if(i == j):
                l.append(nums2.index(j))

    if(len(l) < len(nums1)):
        return False

    for i in range(len(l)):
        if(i == len(l)-1):
            pass

        elif(l[i] > l[i+1]):
            return False

    return True
        

    

            
        





