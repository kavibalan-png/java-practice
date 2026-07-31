public class maxavgsubarray {
  public static double findmaxavg(int[] nums,int k){
    int sum=0;
    for(int i=0;i<k;i++){
        sum+=nums[i];
    }
 intmax=sum;
for(int i=k;i<nums.length;i++){
    sum=sum-nums[i-k]+nums[i];
    max=max.max(max,sum);
} return(double)max/k; }
public staic void main(String[] args){
    int[] arr={1,12,-5,-6,50,3};
    System.out.println(findmaxqvg(arr,4));
}  
}
