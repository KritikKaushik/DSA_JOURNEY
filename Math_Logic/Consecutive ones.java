import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();
        StringBuilder bin=new StringBuilder();
        while(n>0){
            int rem=n%2;
            bin.insert(0,rem);
            n=n/2;
        }
        int count=0;
        int res=0;
        for(int i=0;i<bin.length();i++){
            if(bin.charAt(i)=='1'){
                count++;
            }else{
                count=0;
            }
            res=Math.max(count,res);
        }
        System.out.println(res);
    }
}
