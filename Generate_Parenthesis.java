Question: 
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

1. Goal: add string until the length of this string reaches n*2; (Base case)
   Constrains: matching "(" with ")" in certain order
   Method: add "(" or ")" into a string (recursively)
2. Always add open "(" before close ")"
3. Add ")" only when the number of ")" is less than the number of open "("
4. Add "(" when the number of "(" is less than max (which is int n)

Example (Pseudo-Code):
//Base Case:
if(string length == 2*n) { add(string);     return;}
//Recursive Case:
if(number of “(“s < n) {add a “(“ }


public List<String> generateParenthesis (int n) {
  List <String> list = new ArrayList< > ();
  backtrack(list, "", 0, 0, n);
  return list;
}
public void backtrack (List<String> list, String str, int open, int close, int max){
  //Base Case
  if (str.length() == max*2)
  //Or: if(open == max && close == max)
  {
    list.add(str);
    return;
  }
  //Recursive Case
  if (open < max){
    backtrack(list, str + "(", open+1, close, max);
  }
  if (close < open){
    backtrack(list, str +")", open, close+1, max);
  }
}

                                                          
/* StringBuilder objects are like String objects, but they can be modified(length & contents). StringBuilder objects are like 
variable-length array containing characters. Usually, we should always use string, but in some cases when we need to 
concatenate large number of strings, we can use StringBuilder for appending efficiently. */
Example:
// Creates empty builder, capacity 16(default), constructor
StringBuilder sb = new StringBuilder();
// Adds 9 character string at beginning
sb.append("Greetings");
// One of its methods
sb.toString(); 
