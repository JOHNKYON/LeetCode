package questions.leetcode208;

import java.util.HashMap;

public class MyTrie {
    HashMap<Character, MyTrie> map;

    public MyTrie(){
        map  = new HashMap<>();
    }

    public void insert(String word){
        word = word + "$";
        int length = word.length();
        MyTrie node = this;


        for (int i=0; i<length; i++){
            Character ch = word.charAt(i);

//            If exist
            if (node.map.containsKey(ch)){node = node.map.get(ch);}
//            Not exist
            else {
                MyTrie newNode = new MyTrie();
                node.map.put(ch, newNode);
                node = newNode;
            }
        }
    }

    public boolean search(String word){
        word = word + "$";

        return startsWith(word);
//        int length = word.length();
//        MyTrie node = this;
//
//        for (int i = 0; i<length; i++){
//            Character ch = word.charAt(i);
//
//            if (node.map.containsKey(ch)){node = map.get(ch);}
//            else {return false;}
//        }
//        return true;
    }

    public boolean startsWith(String prefix){
        int length =prefix.length();
        MyTrie node = this;

        for (int i=0; i<length; i++){
            Character ch = prefix.charAt(i);

            if (node.map.containsKey(ch)){node = node.map.get(ch);}
            else {return false;}
        }
        return true;
    }
}
