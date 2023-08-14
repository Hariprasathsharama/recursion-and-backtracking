import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PermutationUsingSwap {
    public static void main(String[] args) {
            new PermutationUsingSwap().init();
    }
    private void init(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the n");
        int n=input.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=input.nextInt();
        }
        List<List<Integer>>ans=new ArrayList<>();
        List<List<Integer>>result=permutation(0,arr,ans);
        for(List<Integer> i:result){
            System.out.println(i);
        }
    }
    private List<List<Integer>> permutation(int index,int[] num,List<List<Integer>> ans){
            if(index==num.length){
                List<Integer>db=new ArrayList<>();
                for (int j : num) {
                    db.add(j);
                }
                ans.add(new ArrayList<>(db));
                return  ans;
            }
        for (int i = index; i < num.length; i++) {
            swap(i,index,num);
            permutation(index+1,num,ans);
            swap(i,index,num);
        }
        return ans;
    }
    private void swap(int i,int j,int[] num){
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }
}
