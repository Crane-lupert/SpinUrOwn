import pandas as pd
import csv
import numpy as np
from IPython.display import display

# df = pd.DataFrame(data=np.array([["Awful", "Poor", "OK"], ["OK", "Acceptable", "Perfect"], ["Poor", "Poor", "OK"]]), columns=['A', 'B', 'C'])
# display(df)

test =[]
test.append("A")
test.append("B")
test.append("C")
test_df = pd.DataFrame(index=test, columns=test, data=0)
display(pd.DataFrame(test_df))
print('===========')

obj = 'A B A B A A B AA C AB D D D A'
adj = obj.split(' ')
print(adj)
for ad in adj:
    print('ad : '+ad)
    #print(type(ad))
    for a in adj:
        print('a :'+a)
        #print(type(a))
        if (ad in test) and (a in test):
            test_df[ad][a]+=1
display(pd.DataFrame(test_df))