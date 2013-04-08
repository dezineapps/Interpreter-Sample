package com.jitendra.hopprtest1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ScopeTest {

	public static void scopeChecker(Scanner mScanInput, HashMap<String, Integer> oldMap) {
		
		HashMap<String, Integer> hashMap = null;
		
		if (oldMap == null)
			hashMap = new HashMap<String, Integer>();
		else
			hashMap = new HashMap<String, Integer>(oldMap);
		
		while (mScanInput.hasNext()) {
			
			String s = mScanInput.nextLine();
			
			if (s.startsWith("[")) {
				scopeChecker(mScanInput, hashMap);
				continue;
			}
			
			if (s.startsWith("]")) {
				break;
			}
			
			String[] split = s.split(" ");
			
			if (s.startsWith("print")) {
				System.out.println(hashMap.containsKey(split[1]) ? hashMap.get(split[1]) : 0);
				continue;
			}
			
			int x = 0;
			try {
				x = Integer.parseInt(split[1]);
			} catch (Exception e) {
				x = hashMap.containsKey(split[1]) ? hashMap.get(split[1]) : 0;
			}
			
			hashMap.put(split[0], x);
		}
	}

	public static void main(String[] args) {

		Scanner scanInput = null;
		try {
			File sendFile = new File("raw/input1.txt");
			scanInput = new Scanner(new FileInputStream(sendFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scopeChecker(scanInput, null);
	}

}
