package Tries;

public class Trie {

    //Implementaion of trie
    boolean flag=false;
    Trie[] options;

    public Trie() {
        flag=false;
        options = new Trie[26];
    }

    public void insert(String word) {
        Trie temp=this;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(temp.options[c-'a']==null) temp.options[c-'a']=new Trie();
            temp=temp.options[c-'a'];
        }
        temp.flag=true;
    }

    public boolean search(String word) {
        Trie temp = this;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(temp.options[c-'a']==null) return false;
            temp=temp.options[c-'a'];
        }
        return temp.flag==true;
    }

    public boolean startsWith(String prefix) {
        Trie temp = this;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            if(temp.options[c-'a']==null) return false;
            temp=temp.options[c-'a'];
        }
        return true;
    }

}
