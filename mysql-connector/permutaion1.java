package mysql-connector;

public class permutaion1 {
    public static boolean checkinclusion(String s1,String s2){
        int[] count=new int[26];
        for(char c:s1.toCharArray())
        count[c-'a']++;
    int left=0;right=0,need=s.length();
    while(right<s2.length()){
        if(count[s2.charAt(right)-'a']>0)
            need--;
        count[s2.charAt(right)-'a']--;
        right++;
        IF(NEED==0)
        return true;
        if(right-left==s1.length()){
            if(count[s2.charAt(left)-'a']>=0)
                need++;
            count
        }
    }
    }
}
