package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    HashMap<Character, String> charMap = new HashMap<>();

    public LetterCombinations() {
        charMap.put('2', "abc");
        charMap.put('3', "def");
        charMap.put('4', "ghi");
        charMap.put('5', "jkl");
        charMap.put('6', "mno");
        charMap.put('7', "pqrs");
        charMap.put('8', "tuv");
        charMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()){
            return res;
        }
        return helper(res, digits, 0);
    }

    public List<String> helper(List<String> result, String digits, int index) {
        if (index >= digits.length()) {
            return result;
        } else {
            List<String> newRes=new ArrayList<>();
            Character first = digits.charAt(index);
            String candidates=charMap.get(first);
            for(Character ch:candidates.toCharArray()){
                if(result.isEmpty()){
                    result.add("");
                }
                for(String s:result){
                    newRes.add(s+ch);
                }
            }
            //result=newRes;
            return helper(newRes,digits,index+1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc=new LetterCombinations();
        System.out.println(lc.letterCombinations("23"));
    }

}
