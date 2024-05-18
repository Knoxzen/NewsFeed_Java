package NewsFeed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args)throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int totalNumberOfRequests = Integer.parseInt(br.readLine().trim());assert totalNumberOfRequests < 1;
        Newsfeed newsfeed = new Newsfeed();
        String arr[];
        while(totalNumberOfRequests-- > 0){
            arr = br.readLine().split(" ");
            switch(arr[0]){
                case "storeNewsfeedEntity":
                    newsfeed.storeNewsfeedEntity(arr[1], arr[2]);
                    break;
                case "getLatestNewsfeedEntities":
                    NewsfeedEntity[] res = (arr.length == 3) ?
                            newsfeed.getLatestNewsfeedEntities(Integer.parseInt(arr[1]), arr[2]) :
                            newsfeed.getLatestNewsfeedEntities(Integer.parseInt(arr[1]));
                    Arrays.stream(res).forEach((e) -> System.out.print((e == null)? "null " : (e.id + " ")));
                    System.out.print("\n");
                    break;
                default:
                    throw new Exception("Invalid input");
            }
        }
        out.flush();
        out.close();
    }
}

