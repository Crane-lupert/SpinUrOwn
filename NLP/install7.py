import pandas as pd
import csv

from collections import Counter
from IPython.display import display

g = open('wordcountmanual.csv','r')
rgr = csv.reader(g)

inde=[]
for rg in rgr:
    inde.append(''.join(rg))

my_df = pd.DataFrame(index=inde, columns=inde, data=0)
display(pd.DataFrame(my_df))

f = open('wordrelfin.csv','r')
rdr = csv.reader(f)

for line in rdr:
    print(line)