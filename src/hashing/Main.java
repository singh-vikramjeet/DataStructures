package hashing;

public class Main {
    public static void main(String[] args) {
//        DirectChaining directChaining = new DirectChaining(15);
//        directChaining.insertHashTable("The");
//        directChaining.insertHashTable("quick");
//        directChaining.insertHashTable("brown");
//        directChaining.insertHashTable("fox");
//        directChaining.insertHashTable("over");
//        directChaining.displayHashTable();
//        // Search method testing
//        //directChaining.searchHashTable("ox");
//        // Delete method testing
//        directChaining.deleteKeyHashTable("The");
//        directChaining.displayHashTable();

        // Linear Probing
        LinearProbing linearProbing = new LinearProbing(13);
        linearProbing.insertInHashTable("The");
        linearProbing.insertInHashTable("quick");
        linearProbing.insertInHashTable("brown");
        linearProbing.insertInHashTable("fox");
        linearProbing.insertInHashTable("over");
        linearProbing.displayHashTable();
        linearProbing.searchHashTable("fox");
        linearProbing.deleteKeyHashTable("fox");
        linearProbing.deleteKeyHashTable("over");
        linearProbing.displayHashTable();

        // Quadratic Probing
//        QuadraticProbing quadraticProbing = new QuadraticProbing(13);
//        quadraticProbing.insertKeyInHashTable("The");
//        quadraticProbing.insertKeyInHashTable("quick");
//        quadraticProbing.insertKeyInHashTable("brown");
//        quadraticProbing.insertKeyInHashTable("fox");
//        quadraticProbing.insertKeyInHashTable("over");
//        quadraticProbing.insertKeyInHashTable("lazy");
//        quadraticProbing.displayHashTable();


    }
}
