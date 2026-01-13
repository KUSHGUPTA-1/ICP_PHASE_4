import java.util.*;
public class Find_The_Index_Of_First_Occurrence_In_A_String {
    public static void main(String[] aargs){
        Scanner sc=new Scanner(System.in);
        String haystack=sc.nextLine();
        String needle=sc.nextLine();
        System.out.println(strStr(haystack, needle));
    }
     public static int strStr(String haystack, String needle) {
        //Optimal O(M*N)
        // if(needle.length()==0) return 0;
        // else{
        //     return haystack.indexOf(needle);
        // }
        
        //Optimal using O(N) for Average case.
        int n=haystack.length();
        int m=needle.length();
        if(needle.length()==0) return 0;
        for(int i=0;i<=n-m;i++){
            if(haystack.substring(i,i+m).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
