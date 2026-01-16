import java.util.*;
public class Count_Primes{
    public static void main(String[] args) {    
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(count(n));
    }
    public static int count(int n){
        boolean isPrime[]=new boolean[n];
        if(n<=2){
            return 0;
        }
        for(int i=2;i<n;i++){
            isPrime[i]=true;
        }
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<n;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        int c=0;
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                c++;
            }
        }
        return c;
        //TC: O(nloglogn)
        //SC: O(n)
    }
}
