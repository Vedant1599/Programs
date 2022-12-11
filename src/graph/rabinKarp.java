package graph;

import java.util.ArrayList;

public class rabinKarp {
    public static final int d = 256;

    public static void main(String[] args) {
        ArrayList<Integer> ans = search("aaa", "aaaaaaaaaa", 101);

        for(int i=0; i<ans.size(); i++) System.out.print(ans.get(i)+" ");
    }
    public static ArrayList<Integer> search(String p, String t, int q){
        ArrayList<Integer> ans = new ArrayList<>();

        int m = p.length();
        int n = t.length();
        int pa=0, ta=0, h = 1;

        for(int i=0; i<m; i++) h = (h*d)%q;

        for(int i=0; i<m; i++){
            pa = (d*pa + p.charAt(i))%q;
            ta = (d*ta + t.charAt(i)%q);
        }

        for(int i=0; i<=n-m; i++){
            if(pa==ta){

                for(int j=0; j<m; j++){
                    boolean flag = true;
                    if(t.charAt(i+j)!=p.charAt(j)){
                        flag = false;
                        break;
                    }

                    if(flag) ans.add(i);

                }
            }

            if(i<n-m){
                ta = (d*(ta-t.charAt(i)*h)+t.charAt(i+m))%d;

                if(ta<0) ta+=q;
            }
        }

        return ans;
    }
}
