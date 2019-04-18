package com.jtarun.practice.important.string;

public class Tries {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("pqrs");
    trie.insert("pppp");
    trie.insert("pqrt");
    trie.insert("pqqr");

    System.out.println(trie.search("pqrs"));
    System.out.println(trie.search("pqr"));
    System.out.println(trie.search("pppp"));

    System.out.println(trie.findMatchingPrefix("pppppp"));
    System.out.println(trie.findMatchingPrefix("ppp"));
    System.out.println(trie.findMatchingPrefix("abc"));
  }

}


class Trie {
  private TrieNode root;

  Trie() {
    this.root = new TrieNode();
  }

  void insert(String s) {
    if (s.isEmpty()) {
      return;
    }
    TrieNode cur = root;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      TrieNode child = cur.getChild(c);
      if (child == null) {
        child = cur.addChild(c);
      }
      cur = child;
    }
    cur.setWord();
  }

  boolean search(String s) {
    if (s.isEmpty()) return true;

    TrieNode cur = root;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      cur = cur.getChild(c);
      if (cur == null) {
        return false;
      }
    }

    return cur.isWord();
  }

  String findMatchingPrefix(String s) {
    if (s.isEmpty()) return s;

    TrieNode cur = root;
    int i = 0;
    for (; i < s.length(); i++) {
      char c = s.charAt(i);
      cur = cur.getChild(c);
      if (cur == null) {
        break;
      }
    }

    return s.substring(0, i);
  }

}


class TrieNode {
  private boolean word = false;
  private TrieNode[] children = new TrieNode[26];

  void setWord() {
    word = true;
  }

  boolean isWord() {
    return word;
  }

  TrieNode addChild(char c) {
    TrieNode child = new TrieNode();
    children[c - 'a'] = child;
    return child;
  }

  TrieNode getChild(char c) {
    return this.children[c - 'a'];
  }
}


