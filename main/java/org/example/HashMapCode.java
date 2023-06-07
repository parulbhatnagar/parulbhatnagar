package org.example;

import java.util.LinkedList;

public class HashMapCode {

    static class  HashMap<K,V>{
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        private int size; // n number of key value pairs
        private LinkedList<Node> buckets[]; // N number of buckets

        public HashMap(){
            this.size = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>(); // initialized the buckets with linked list
            }
        }

        public void put (K key, V value){
            // 1. First hash the given key to identify the index of bucket you want to traverse

            key.hashCode();

            // Traverse the linked list and compare the give key with key from linked list

            // if key dosent exist

            // add the node to the linked list

            // if key exists

            // update the value of the given key
        }


    }
}
