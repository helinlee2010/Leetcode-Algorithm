Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
A string such as "word" contains only the following valid abbreviations:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".
Note: Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":
Return true.

Example 2:
Given s = "apple", abbr = "a2e":
Return false.

public static boolean wordAbbr(String str, String abbr){
	// Pointer for abbr
	int i = 0;
	// Pointer for str
	int j = 0;
	
	while( i < abbr.length()){
		if( j >= str.length()) return false;
		
		if(Character.isLetter(abbr.charAt(i))){
			if(abbr.charAt(i) != str.charAt(j)) return false; 
			i++;
			j++;
		}
		// ELSE IF (若上面if已经判execute完 那么将不再execute else if)
		else if(Character.isDigit(abbr.charAt(i))){
			if(abbr.charAt(i) == '0') return false;
			
			StringBuilder sb = new StringBuilder();
			while( i < abbr.length() && Character.isDigit(abbr.charAt(i))){
				sb.append(abbr.charAt(i));
				i++;
			}
			int count = Integer.valueOf(sb.toString());
			j += count;
		}
	}
	return j == str.length();
}
public static void main(String[] args) {
	String str = "internationalization";
	String abbr = "i12iz4n";
	boolean res1 = wordAbbr(str, abbr);
	System.out.println(res1);
	
	String str2 = "waaaaada";
	String abbr2 = "w5d2";
	boolean res2 = wordAbbr(str2, abbr2);
	System.out.println(res2);
}

