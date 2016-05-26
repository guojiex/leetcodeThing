package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
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
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(ValidParentheses.isValid("()]{}"));
        
    }

}
