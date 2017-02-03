package com.jp.first;

import com.algo.test.ITest;

public class add implements ITest {

	@Override
	public void PerformTest() {
		 String s="1 1 1 1 -1 -1 3 3";
		 String[] strings = s.split(" ");
		 int[] cordinate = new int[8];
		 for(int i=0; i<8;i++){
			 cordinate[i]= Integer.parseInt(strings[i]);
		 }
		 
		 int differenceAX = cordinate[0]-cordinate[2];
		 int differenceAY = cordinate[1]-cordinate[3];
		 
		 int differenceBX = cordinate[4]-cordinate[6];
		 int differenceBY = cordinate[5]-cordinate[7];
		 boolean inside =findInside(cordinate[0],cordinate[1],cordinate[2],cordinate[3],cordinate[4],cordinate[5],cordinate[6],cordinate[7]);
		 
		 boolean inside2 = findInside(cordinate[4],cordinate[5],cordinate[6],cordinate[7],cordinate[0],cordinate[1],cordinate[2],cordinate[3]);
		 
		 if(inside||inside){
			 System.out.println(true);
		 }else{
			 System.out.println(false);
		 }
	
	}
	
	boolean findInside(int xa1, int ya1, int xa2, int ya2, int xb1, int yb1, int xb2, int yb2 ){
		if(xa1>xb1&&ya1>yb1){
			 if((xa2>xb1 && ya2>yb1)||(xa2>xb2 && ya2>yb2)){
				 return true;
			 }
		}else if(xa1>xb1&&ya1<yb1){
			if((xa1>xb2 && ya2<yb2)||(xa2>xb2 && ya1<yb2)){
				 return true;
			 }
		}
		return false;
	}
	
	int calculate(int a, int b){
		int result = a^b;
		 int carry =(a&b);
		 if(carry!=0){
			 carry<<=1;
			return calculate(result, carry);
		 }
		  return result;
	}

}
