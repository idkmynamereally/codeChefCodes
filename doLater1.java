package javaTemp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//https://www.codechef.com/START64D/problems/RANGEASSIGN
//Huge Space Complexity
//Possible fix to only store first and last appearence

public class JavaTemp2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 0; test < t; test++) {
			int n = sc.nextInt();
			HashMap <Integer, List<Integer>> map = new HashMap <Integer, List<Integer>>();
			List<Integer> arr = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				arr.add(sc.nextInt());
				map.putIfAbsent(arr.get(i), new ArrayList<Integer>());
				map.get(arr.get(i)).add(i);
			}
			if (n <= 1) {
				System.out.println("YES");
				continue;
			}
			
			if (map.size() == n) {
				System.out.println("NO");
				continue;
			}
			
			if (map.size() <= 2) {
				System.out.println("YES");
				continue;
			}
			
			for (int i = 0; i < n; i++) {
				
				if (map.get(arr.get(i)).size() == 1)
					continue;
				int value = arr.get(i);
				int firstApp = map.get(arr.get(i)).get(0);
				int s = map.get(arr.get(i)).size();
				int lastApp = map.get(arr.get(i)).get(s-1);
				if (lastApp-firstApp == 1) {
					
				}
				List<Integer> temp = new ArrayList<Integer>();
				
				for (int j = 0; j < firstApp; j++) {
					temp.add(arr.get(j));
				}
				temp.add(value);
				for (int j = lastApp + 1; j < n; j++) {
					temp.add(arr.get(j));
				}
				arr = temp;
				System.out.println(arr);
				n = n - (lastApp - firstApp);
				System.out.println("N : " + n);
				map.clear();
				for (int z = 0; z < n; z++) {
					map.putIfAbsent(arr.get(z), new ArrayList<Integer>());
					map.get(arr.get(z)).add(z);
				}
			}
			if (arr.size() > 2) 
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}
