import string

def del_punct(fp):
    '''(file object)->file object
    Removes all the punctuation from a given file object
    Precondition: fp must be a file object'''
    
    punct = string.punctuation
    for i in punct:
        fp = fp.replace(i,"")

    return fp.lower()

def is_valid_word(fp):
    '''(file object)->file object
    Removes all words that contain non alphabetic chars
    Precondition: fp must be a file object'''
    
    words = fp.split(" ")

    for i in words:
        if(not(i.isalpha)):
            fp = fp.replace(" "+i+" "," ")
            
        elif(len(i)< 2):
            fp = fp.replace(" "+i+" "," ")

    return fp

def is_word_in_dict(fp, query):
    '''(file object, string)->string
    Returns query after looping until query is an acceptale
    Precondition: fp must be a file object and query a string'''
    cont = True
    fp = fp.split(" ")
    return_val = ""
    
    while(cont):
        if(query == "q"):
            return query
        count = 0
        return_val = ""
        return_val_non = []
        query = query.split()
        for i in query:
            if(len(i) > 1):
                add = del_punct(i)
            else:
                add = i
            
            if add in fp:
                return_val = return_val + add +" "
                count += 1

            else:
                return_val_non.append(i)

        
        if(count == len(query)):
           cont = False

        else:
            val = del_punct(return_val_non[0])
            print("Word '"+val.strip()+"' not in the file.")
            query=input("Enter one or more words separated by spaces, or 'q' to quit: ").strip().lower()

    return return_val
    
def add_all_words(fp):
    '''(file object)->dict
    Removes a dict of all different words in the file object with their pair value being an empty list
    Precondition: fp must be a file object'''

    dict_obj = {}
    words = fp.split(" ")
    words = set(words)
    for i in words:
        if(not("\n" in i)):
            dict_obj.update({i:set()})

    return dict_obj
    
    

def open_file():
    '''None->file object
    See the assignment text for what this function should do'''
    # YOUR CODE GOES HERE

    cont = True
    file_obj = ""
    while(cont):
        try:
            file = input("Enter the name of the file: ")
            file = file.strip()
            f = open(file, 'r')
            file_obj = f.read()
            f.close()
            cont = False
        except FileNotFoundError:
            print("There is no file with that name. Try again.")

    file_obj = del_punct(file_obj)
    file_obj = is_valid_word(file_obj)

    return file_obj
            
def read_file(fp):
    '''(file object)->dict
    See the assignment text for what this function should do'''
    # YOUR CODE GOES HERE
    text_dict = add_all_words(fp)
    fp = fp.splitlines()
    lines = len(fp)

    for i in range(lines):
        words = fp[i]
        words = words.split(" ")
        if("" in words):
            words.remove("")
        add = str(i+1)
        for j in words:
            rep_words = text_dict.keys()
            if(j in rep_words):
                add_line = text_dict[j]
                add_line.add(add)
                
    return text_dict
    

def find_coexistance(D, query):
    '''(dict,str)->list
    See the assignment text for what this function should do'''
    # YOUR CODE GOES HERE
    
    query = query.split(" ")
    if("" in query):
        query.remove("")
    query = set(query)

    coexist_list = []
    all_nums = []

    for i in query:
        sorted_list = sorted(D[i])
        all_nums = all_nums + sorted_list

    for i in all_nums:
        count_nums = all_nums.count(i)
        if(count_nums == len(query)):
            if(not(i in coexist_list)):
                coexist_list.append(i)
            else:
                pass

    return coexist_list
    
                             
    

##############################
# main
##############################
file=open_file()
d=read_file(file)
query=input("Enter one or more words separated by spaces, or 'q' to quit: ").strip().lower()
# YOUR CODE GOES HERE
if(query == "q"):
    cont = False
else:
    cont = True
while(cont):
    query = is_word_in_dict(file,query)
    if(query == "q"):
        coexistance = ""
        cont = False
    else:
        coexistance = find_coexistance(d,query)
    if(len(coexistance) > 0):
        print("The one or more words you entered coexisted in the following lines of the file:")
        print(coexistance)
    elif(coexistance != ""):
        print("The one or more words you entered does not coexist in a same line of the file.")
        
    if(query != "q"):
        query=input("Enter one or more words separated by spaces, or 'q' to quit: ").strip().lower()
    



