package leet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class sortCharByFq {
    static class alpa{
        int fq;
        int al;

        alpa(int al) {
            this.al = al;
            this.fq = 0;
        }
    }

    static class alpacom implements Comparator<alpa>{
        public int compare(alpa a1, alpa a2){
            if(a1.fq==a2.fq) return 0;
            if(a1.fq>a2.fq) return -1;
            return 1;
        }
    }

    public static String frequencySort(String s) {
        ArrayList<alpa> ls = new ArrayList<>();
        for(int i=0; i<26; i++){
            ls.add(new alpa(i));
        }
        for(int i=0; i<s.length(); i++){
            ls.get(s.charAt(i)-97).fq++;
        }

        Collections.sort(ls, new alpacom());
        String ans = "";
        for(int i=0; ls.get(i).fq!=0; i++){
            int fq = ls.get(i).fq;
            int c = ls.get(i).al + 97;
            char q = (char) c;
            for(int j=0; j<fq; j++) ans += q;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
