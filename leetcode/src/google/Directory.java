package google;

import java.util.Stack;

public class Directory {
    public static int getDirectory(String s) {
        String[] entries = s.split("\n");
        int maxLength = 0;
        int curPathLength = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < entries.length;i++) {
            int level = 0;
            for (int j = 0; j < entries[i].length(); j++) {
                if (entries[i].charAt(j) == ' ') {
                    level++;
                } else {
                    break;
                }
            }
            String fileName = entries[i].substring(level);
            while(level<stack.size()){
                String tempname = stack.pop();
                curPathLength-=(tempname.length()+1);
            }
            if(fileName.contains(".jpeg")||fileName.contains(".png")||fileName.contains(".gif")) {
                maxLength +=curPathLength; 
            }
            curPathLength+=fileName.length()+1;
            stack.push(fileName);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(getDirectory("dir1\n dir11\n dir12\n  picture.jpeg\ndir2\n  file2.gif"));
        System.out.println(getDirectory("dir1\n dir11\n dir12\n  picture.txt\ndir2\n  file2.tt"));
    }

}
