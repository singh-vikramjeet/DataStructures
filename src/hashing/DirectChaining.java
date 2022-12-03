package hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class DirectChaining {

    LinkedList<String>[] hashTable;
    int maxChainSize = 5;
    // We specify a maximum chain size because we don't
    // want the time complexity to become O(N)

    // Constructor
    public DirectChaining(int size){
        hashTable = new LinkedList[size];
    }

    // This Hash function takes a string word (value to be inserted in the hashtable)
    // and an integer M (M is the size of the Hashtable)
    // We sum the ASCII values of each character in word
    // We divide the total sum by M and the remainder
    // obtained is used as an index for storing values in the hashtable
    public int modASCIIHashFunction(String word, int M){
        char[] ch;
        ch = word.toCharArray();
        int i, sum;
        for(sum = 0, i = 0; i < word.length(); i++){
            sum = sum + ch[i];
        }
        return sum % M;
    }

    // This function adds a String word to the Hashtable
    public void insertHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        if(hashTable[newIndex] == null){ // Create a linked list first and then insert element
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(word);
        }
        else{ // Linked list already exists
            hashTable[newIndex].add(word);
        }
    }

    // Function to display the values in hashtable
    public void displayHashTable(){
        if(hashTable == null){
            System.out.println("\nHashTable does not exist!");
            return;
        }
        else{ // if the hashtable exists
            System.out.println("\n--------HashTable---------");
            for(int i = 0; i < hashTable.length;i++){
                System.out.println("Index " + i + ", key:" + hashTable[i]);
            }
        }
    }
    // Search method
    public boolean searchHashTable(String word){
        // Find the index where the word is located
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        // if the index exists and the index contains the word
        if(hashTable[newIndex] != null && hashTable[newIndex].contains(word)){
            System.out.println("\n" + "\"" + word + "\"" + " found in Hashtable at location: " + newIndex);
            return true;
        }else{
            System.out.println("\n" + "\"" + word + "\"" + " not found in Hashtable");
            return  false;
        }
    }
    // Delete method
    public void deleteKeyHashTable(String word){
        int newIndex = modASCIIHashFunction(word, hashTable.length);
        boolean result = searchHashTable(word);
        if(result == true){
            hashTable[newIndex].remove(word);
            System.out.println("\n" + "\"" + word + "\"" + " has been deleted from HashTable ");
        }
    }



}
