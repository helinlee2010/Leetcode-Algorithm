https://leetcode.com/problems/roman-to-integer/
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.

Example 1:
Input: "III"
Output: 3

Example 3:
Input: "IX"
Output: 9

Example 4:
Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

public int romanToInt(String s) {
	Map<Character, Integer> map = new HashMap<>();
	map.put('I',1);
	map.put('V', 5);
	map.put('X', 10);
	map.put('L', 50);
	map.put('C', 100);
	map.put('D', 500);
	map.put('M', 1000);
	
	int result = 0;
	
	for(int i = 0; i<s.length(); i++){
		if(i>0){
			if(s.charAt(i-1) == 'I' && (s.charAt(i) == 'V'|| s.charAt(i) =='X')){
				result -= 2;
			}
			if(s.charAt(i-1) == 'X' && (s.charAt(i)=='L' || s.charAt(i)=='C')){
				result -= 20;
			}
			if(s.charAt(i-1) == 'C' && (s.charAt(i) == 'D' || s.charAt(i)=='M')){
				result -=200;
			}
		}
		result += map.get(s.charAt(i));
	}
	return result;
}
