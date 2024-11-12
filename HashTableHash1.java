// HashTableHash1.java

public class HashTableHash1 extends HashTable {
    public HashTableHash1(int size) {
        super(size); // Chama o construtor da classe pai (HashTable) com o tamanho da tabela
    }

    @Override
    protected int hash(String key) {
        int hash = 7;
        for (int i = 0; i < key.length(); i++) {
            hash = hash * 31 + key.charAt(i);
        }
        return Math.abs(hash) % size;
    }
}