package google;

public class LargestNumber {
    public static int solution(int X){
        String input=String.valueOf(X);
        StringBuilder sb=new StringBuilder();
        int skipIndex=-1;
        int firstGroupEnd=findTheFirstGroupEnd(input);
        int secondGroupStart=findTheSecondGroupStart(input,firstGroupEnd+1);
        if(input.charAt(firstGroupEnd)<input.charAt(firstGroupEnd+1)){
            skipIndex=firstGroupEnd;
        }else{
            skipIndex=secondGroupStart;
        }
        for(int i=0;i<input.length();i++){
            if(i==skipIndex)
                continue;
            else
                sb.append(input.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
    public static int findTheSecondGroupStart(String s,int start){
        for(int i=start;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i+1)){
                return i;
            }
        }
        return 0;
    }
    public static int findTheFirstGroupEnd(String s){
        char lastChar=s.charAt(0);
        for(int i=1;i<s.length();i++){
            int groupStart=i-1;
            while(s.charAt(i)==lastChar){
                i++;
            }
            if(groupStart==i-1){
                lastChar=s.charAt(i);
            }else{
                return i-1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(LargestNumber.solution(22233355));
        System.out.println(LargestNumber.solution(222355));
        System.out.println(LargestNumber.solution(22155));
        System.out.println(LargestNumber.solution(221155));
        System.out.println(LargestNumber.solution(221255));
    }

}
