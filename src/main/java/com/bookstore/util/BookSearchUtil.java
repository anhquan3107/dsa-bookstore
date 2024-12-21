package com.bookstore.util;

import java.util.*;

import com.bookstore.model.Books;

public class BookSearchUtil {
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
        List<String> bookIDs = new ArrayList<>(); 
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word, String bookId) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.isEndOfWord = true;
            node.bookIDs.add(bookId); 
        }


        private void collectBookIDs(TrieNode node, List<String> result) {
            if (node == null) return;
            if (node.isEndOfWord) {
                result.addAll(node.bookIDs);
            }
            for (TrieNode child : node.children.values()) {
                collectBookIDs(child, result);
            }
        }

        
        public List<String> autocomplete(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                node = node.children.get(c);
                if (node == null) {
                    return new ArrayList<>(); 
                }
            }
            List<String> result = new ArrayList<>();
            collectBookIDs(node, result);
            return result; 
        }
    }

    
    public static Trie buildTrieFromDatabase(List<Books> books) {
        Trie trie = new Trie();
        for (Books book : books) {
            trie.insert(book.getTitle().toLowerCase(), book.getBookId());
        }
        return trie;
    }
}
