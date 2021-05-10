import pandas as pd
import csv

from textblob import TextBlob
from textblob.formats import CSV
from numpy import result_type
from _curses import raw
from pandas.core.dtypes.cast import convert_dtypes
from certifi.__main__ import args
from _operator import index

# f = open('USCOMMENTS_DATA_TABLE.csv','r')
# rdr = csv.reader(f)
# 
# print("==========")
# 
# for line in rdr:
#     print(line[2])

f = open('USVIDEO_DATA_TABLE.csv','r')
rdr = csv.reader(f)

print("==========")

for line in rdr:
    print(line[0]+'\t'+line[10])
# print("==========")
# 
# df=pd.read_csv('./USCOMMENTS_DATA_TABLE.csv')
# #print(df.axes[1].item())
# print(df.items())
# res = df[df.axes[0].item()]
# #print(type(res))
# print(res)
# print("===========")
# #blob = TextBlob(res[0])
# 
# 
#     
# def get_adjectives(text):
#     blob = TextBlob(text)
#     print(blob.tags)
#     print(type(blob.tags))
#     return [ word for (word,tag) in blob.tags if tag == 'JJ' or tag =='JJR' or tag =='JJS']
# 
# #res = get_adjectives("bob")
# #print(type(res))
# 
# dict=()
# #print(df.to_latex(index=False))
# #print(pd.Series([get_adjectives("cry and hurt like painful feeling")]))
# print("=======")
# #print(get_adjectives("cry and hurt like painful feeling"))
# df = df.apply(pd.Series([get_adjectives(res.to_string())]),
#              convert_dtypes=False, args=dict)

#print(df)

#for re in res:
    #print(re)
    
    

#df.to_csv('dataadj.csv', index=False)
