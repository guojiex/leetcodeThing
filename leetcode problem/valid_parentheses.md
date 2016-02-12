##20. Valid Parentheses My Submissions Question
Total Accepted: 92424 Total Submissions: 324336 Difficulty: Easy
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Subscribe to see which companies asked this question
###how to solve
use a map to store all possible parentheses pairs.
Use a stack to save all past inputs, once we reach a key, we push it into the stack; once we reach a value, we must pop one character from stack, and see if its value in map is the sae as what we are now inputing, if not, fail.
Remember to see if the stack is empty in the end
###solution

	public class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> parentheses=new HashMap<>();
        parentheses.put('(', ')');
        parentheses.put('[', ']');
        parentheses.put('{', '}');
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();++i){
            if(stack.isEmpty()){
                if(parentheses.get(s.charAt(i))!=null){
                stack.push(s.charAt(i));
                }else{
                    return false;
                }
            }else{
                if(parentheses.get(s.charAt(i))!=null){
                   stack.push(s.charAt(i)); 
                }else{
                    if(parentheses.get(stack.pop()).equals(s.charAt(i))){
                        
                    }else{
                        return false;
                    }
                }
            }
        }
        
        return stack.isEmpty();
    }
}

