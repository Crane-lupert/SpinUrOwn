package spmem.VO;

import java.util.*;

public class test {

	public static int[] solution(int[] progresses, int[] speeds) {
        int [] progresse  = progresses;
		for(int k = 0;k<speeds.length;k++) {
        	progresse[k] = (100-progresse[k]);
        	if(progresse[k]%speeds[k]==0) {
        		progresse[k]/=speeds[k];
        	}else {
        		progresse[k]/=speeds[k];
        		progresse[k]++;
        	}
        }
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int rel = 1;
        for(int j = 0;j<speeds.length;j++) {
        	System.out.println(progresse[j]);
        	//막타 직전도 아닌데 뒤에 것보다 시간이 오래 걸렸다?
        	if((j<speeds.length-1)&&(progresse[j]>=progresse[j+1])){
        		System.out.println(j+"는 지나간");
        		rel++;
        	}else if((j<speeds.length-1)&&(progresse[j]<progresse[j+1])) {
        		System.out.println(j+"는 발표가 됨");
        		ar.add(rel);
        		rel=1;
        	}else if(j==speeds.length-1) {//막타
        		System.out.println(j+"는 마지막");
        		ar.add(rel);
        	}
        }
        int [] answer =new int[ar.size()];
        for(int l = 0;l<ar.size();l++) {
        	answer[l]=ar.get(l);
        }
        return answer;
    }
	public static void main(String[] args) {
		int [] pro = {93,30,55};
		int [] sp = {1,30,5};
		System.out.println("답 : "+solution(pro, sp)[1]);
	}
}
