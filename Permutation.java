import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutation {

    public static void main(String[] args) {
        new Permutation().init();
    }
    private void init(){
        Scanner input= new Scanner(System.in);
        String str=input.nextLine();
        List<Character>db=new ArrayList<>();
        List<List<Character>>ans=new ArrayList<>();
        boolean[] freq=new boolean[str.length()];
        List<List<Character>>result= permutation(str.toCharArray(),db,ans,freq);
        for(List<Character> s:result) {
            System.out.println(s);
        }
    }
    private List<List<Character>> permutation(char[] ch, List<Character>db, List<List<Character>> ans, boolean[] freq){
        int n=ch.length;
                    if (db.size()==ch.length){
                        ans.add(new ArrayList<>(db));
                        return ans;
                    }
        for (int i = 0; i < n; i++) {
            if (!freq[i]){
                freq[i]=true;
                db.add(ch[i]);
                permutation(ch,db,ans,freq);
                db.remove(db.size()-1);
                freq[i]=false;
            }
        }
        return ans;
    }
}

