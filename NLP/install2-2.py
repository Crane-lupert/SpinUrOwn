import pandas as pd
import csv

from textblob import TextBlob
from textblob.formats import CSV
from numpy import result_type
from _curses import raw
from pandas.core.dtypes.cast import convert_dtypes
from certifi.__main__ import args
from _operator import index

#댓글에서 형용사만 살린다.
def get_adjectives(text):
    blob = TextBlob(text)
    return [ word for (word,tag) in blob.tags 
            if tag == 'JJ' or tag =='JJR' or tag =='JJS']
    
#USVIDEO에 있는 ID대로 데이터를 분해한 걸 각각 분석돌려준다.
f = open('USVIDEO_DATA_TABLE.csv','r')
rdr = csv.reader(f)
check = []
dummy = []
for line in rdr:
    #print('start')
    #print(dummy)
    if(line[0]=='VIDEO_ID' or line[0] in check):
        continue
    check.append([line[0]])
    #print(check)
    #print(type(line[0]))
#    print(line[0])
    ff = open('csvhell2/'+line[0]+'.csv','r', newline='\n')
    rd = csv.reader(ff)
    
    for lin in rd:
        #print('lin[0] : '+lin[0])
        obj = ' '.join(get_adjectives(lin[0]))
        #print('obj : '+obj)
        if(obj!=''):
            dummy.append([obj])    
    fff = open('csvres/'+line[0]+'_pss'+'.csv','w', newline='\n')
    wr = csv.writer(fff)
    wr.writerows(dummy)
    dummy=[]
print('못난 주인이여서 미안하다아앙')