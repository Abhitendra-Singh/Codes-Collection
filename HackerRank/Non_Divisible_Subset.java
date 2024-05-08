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

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> l1) {
        int[] arr = new int[k];
        for(int j=0 ; j<k ; j++){
            for(int i=0 ; i<l1.size() ; i++){
                if(l1.get(i)%k==j){
                    ++arr[j];
                    l1.remove(i);
                    i=i-1;
                }
            }
        }
        int count =0 ;
        if(arr[0]>0) ++count ;
        int p1=1 , p2=arr.length-1;
        while(p1<p2){
            count = count + Math.max(arr[p1] , arr[p2]);
            ++p1;
            --p2;
        }   
        if(p1==p2){
            if(arr[p1]>0) ++count ;
        } 
        return count ;    
    }

}

public class Non_Divisible_Subset {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
