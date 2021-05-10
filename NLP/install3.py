import pandas as pd
import csv
#행렬의 인덱스 생성
from textblob import TextBlob
from textblob.formats import CSV
from numpy import result_type
from _curses import raw
from pandas.core.dtypes.cast import convert_dtypes
from certifi.__main__ import args
from _operator import index
from builtins import set

#USVIDEO에 있는 ID대로 데이터를 분해한 걸 각각 분석돌려준다.
f = open('USVIDEO_DATA_TABLE.csv','r')
rdr = csv.reader(f)

cnt=0
dummy = []
fff = open('Pytest/wordlist.csv' , 'w', newline='\n')
wr = csv.writer(fff)
for line in rdr:
    if(line[0]=='VIDEO_ID'):
        continue
    print(line[0])
    ff = open('csvres/'+line[0]+'_pss'+'.csv','r', newline='\n')
    rd = csv.reader(ff)
    obj = ''
    print(cnt)
    cnt+=1
    for lin in rd:#CSV 파일을 열어서 리스트를 한덩어리로
        if(len(lin[0])>30):#처리에 실패한 것으로 간주
            continue
        obj +=' '+lin[0].lower()#합체!
        #print(type(obj))#str이 나와야 한다 obj하면 지옥문 오픈^^
        #print(cnt)
    
    adj = obj.split(' ')#합체된걸 다시 list로 나눈다.
    newd = dummy#비교대조용 데이터 가져오기
    dummy.append(adj)
    survive=''#네녀석...[생존]한것이냐! 믿구있었다구 젠장!

    for v in adj:
        #print(v)
        if v not in dummy:
            dummy.append(v)
            wr.writerow([v])
    
print('끝났다? 과연?')