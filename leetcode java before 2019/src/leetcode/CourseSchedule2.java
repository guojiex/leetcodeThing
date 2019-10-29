package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result=new int[numCourses];
        int[] inDegree=new int[numCourses];
        List<Integer>[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        int count=0;
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0)
                result[count++]=i;
        }
        if(count==0)    return new int[0];//every one's indegree is more than 0
        List<Integer> tmp;
        int j=0;
        while(count<numCourses){
            tmp=graph[result[j++]];
            for(int node:tmp){
                if(--inDegree[node]==0){
                    result[count++]=node;
                }
            }
            if(count==j)
                return new int[0];
        }
        return result;
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
