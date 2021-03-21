package com.leetcode.solution;

import java.util.*;

public class RankTeams {
    public class Person implements Comparable<Person>{
        public char name;
        public int score[];

        @Override
        public int compareTo(Person o) {
            return 0;
        }
    }
    public String rankTeams(String[] votes) {
        if(votes.length == 1){
            return votes[0];
        }
        Map<Character, Person> scoreMap = new HashMap<>();
        for(int i = 0; i < votes[0].length(); i++){
            for (int j = 0 ; j < votes.length; j++){
                Character name = votes[j].charAt(i);
                Person p = scoreMap.get(name);
                if(p == null){
                    p = new Person();
                    p.name = name;
                    p.score = new int[votes[0].length()];
                    scoreMap.put(name, p);
                }
                p.score[i] ++;
            }
        }
        List<Person> all = new ArrayList<>();
        all.addAll(scoreMap.values());
        all.sort((o1, o2) -> {
            int i = 0;
            while (i < o1.score.length){
                if(o1.score[i] > o2.score[i]){
                    return -1;
                }else if(o1.score[i] == o2.score[i]){
                    i++;
                }else{
                    return 1;
                }
            }
            return o1.name - o2.name;
        });
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < all.size();i++){
            sb.append(all.get(i).name);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String res = new RankTeams().rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"});
        System.out.println(res);
    }
}
