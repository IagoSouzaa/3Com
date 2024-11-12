public abstract class HashTable {
    protected int size;
    protected String[] table;
    protected int collisionCount;

    public HashTable(int size) {
        this.size = size;
        this.table = new String[size];
        this.collisionCount = 0;
    }

    // Método abstrato para a função hash
    protected abstract int hash(String key);

    // Insere uma chave na tabela
    public void insert(String key) {
        int index = hash(key);
        if (table[index] != null) {
            collisionCount++;
        }
        table[index] = key;
    }

    // Busca uma chave na tabela
    public boolean search(String key) {
        int index = hash(key);
        return table[index] != null && table[index].equals(key);
    }

    // Retorna o número de colisões
    public int getCollisionCount() {
        return collisionCount;
    }

    // Distribuição das chaves na tabela
    public int[] getDistribution() {
        int[] distribution = new int[size];
        for (String s : table) {
            if (s != null) {
                int index = hash(s);
                distribution[index]++;
            }
        }
        return distribution;
    }
}