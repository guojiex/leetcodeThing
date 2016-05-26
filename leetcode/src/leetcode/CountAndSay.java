package leetcode;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n<=0)    return "";
        String result="1";
        for(int i=1;i<n;++i){
            StringBuilder sb=new StringBuilder();
            int count=0;
            Character lastChar=result.charAt(0);
            for(int j=0;j<result.length();++j){
                if(result.charAt(j)!=lastChar){
                    sb.append(String.valueOf(count)).append(lastChar);
                    lastChar=result.charAt(j);
                    count=1;
                }else{
                    count++;
                }
            }
            sb.append(String.valueOf(count)).append(lastChar);
            result=sb.toString();
        }
        return result;
    }
    public static void main(String[] args){
        CountAndSay test=new CountAndSay();
        System.out.println(test.countAndSay(5));
    }
}
