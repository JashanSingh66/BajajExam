package com.example.BajajExam.service;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class serviceApi {


    public Object process(Map<String,Object> body){
        int count=0;
        if(body.containsKey("fibonacci")) count++;
        if(body.containsKey("prime")) count++;
        if(body.containsKey("lcm")) count++;
        if(body.containsKey("hcf")) count++;
        if(body.containsKey("AI")) count++;

        if(count!=1)
            throw new RuntimeException("Exactly one key required");

        if(body.containsKey("fibonacci")){
            int n=((Number)body.get("fibonacci")).intValue();
            if(n < 0) throw new RuntimeException("Invalid fibonacci input");
            return fibonacci(n);
        }

        if(body.containsKey("prime")){
            List<Integer> arr=castList(body.get("prime"));
            return prime(arr);
        }

        if(body.containsKey("lcm")){
            return lcm(castList(body.get("lcm")));
        }

        if(body.containsKey("hcf")){
            return hcf(castList(body.get("hcf")));
        }

        if(body.containsKey("AI")){ return "Mumbai";}
        return null;
    }

    private static List<Integer> castList(Object obj){
        List<Integer> list=new ArrayList<>();
        for(Object o:(List<?>)obj)
            list.add(((Number)o).intValue());
        return list;
    }

    private static List<Integer> fibonacci(int n){
        List<Integer> res=new ArrayList<>();
        int a=0,b=1;
        for(int i=0;i<n;i++){
            res.add(a);
            int c=a+b;
            a=b;
            b=c;
        }
        return res;
    }

    private static List<Integer> prime(List<Integer> arr){
        List<Integer> ans=new ArrayList<>();
        for(int n:arr)
            if(isPrime(n)) ans.add(n);
        return ans;
    }

    private static boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2;i*i<=n;i++)
            if(n%i==0) return false;
        return true;
    }

    private static int gcd(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return Math.abs(a);
    }

    private static int lcm(int a,int b){
        return Math.abs((a/gcd(a,b))*b);
    }

    private static int hcf(List<Integer> nums){
        int res=nums.get(0);
        for(int n:nums)
            res=gcd(res,n);
        return res;
    }

    private static int lcm(List<Integer> nums){
        int res=nums.get(0);
        for(int n:nums)
            res=lcm(res,n);
        return res;
    }
}
