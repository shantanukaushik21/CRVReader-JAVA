package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class crsReader {

	
	public static void main(String[] args) throws IOException {
		String line="";
		int rows=6;
		//pincodeMap pm=new pincodeMap();
		Map<String,String> map=new HashMap<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/resources/addresses.csv"));
			while((line=br.readLine())!=null) {
				//System.out.println(line);
				System.out.println("*************************");
				String[] arr= split(line,rows);
				map.put(arr[3], arr[5]);
				for(int i=0;i<arr.length;i++) {
					System.out.print(arr[i]+" /");
				}
				System.out.println();
//				String[] rows=line.split(",");
//				for(int i=0;i<rows.length;i++) {
//					System.out.println(rows[i]);
//				}
//				System.out.println("no. of rows = "+rows.length);
//				System.out.println("*****************************");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		System.out.println(map.toString());
	}
	
	public static String[] split(String line,int n) {
		String[] rows=new String[n];
		int pointer=0;
		int start=0;
		int end=0;
		int quotesCount=0;
		for(int i=0;i<line.length();i++) {
			if(line.charAt(i)=='"') {
				quotesCount++;
			}
			if((line.charAt(i)==',')&& (quotesCount%2==0)) {
				rows[pointer]=line.substring(start, end+1);
				pointer++;
				start=i+1;
				end=i;
				
			}
			end++;
		}
		rows[n-1]=line.substring(start);
		return rows;
	}
}
