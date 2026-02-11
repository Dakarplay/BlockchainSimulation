package blockchain;

/**
 * Academic blockchain implementation using a singly linked list.
 * This simulation is mutable and not intended for real-world use.
 */
public class Blockchain {

    private Block head;
    private int size;

    public Blockchain() {
        this.head = null;
        this.size = 0;
    }

    public void addBlock(String data) {
        if (head == null) {
            head = new Block(1, data, "0");
            size = 1;
            System.out.println("Genesis block created.");
            return;
        }

        Block last = getLastBlock();
        Block newBlock = new Block(size + 1, data, last.getCurrentHash());
        last.setNext(newBlock);
        size++;
        System.out.println("Block added successfully.");
    }

    public Block findById(int id) {
        Block current = head;
        while (current != null) {
            if (current.getId() == id) return current;
            current = current.getNext();
        }
        return null;
    }

    public Block findByHash(String hash) {
        Block current = head;
        while (current != null) {
            if (current.getCurrentHash().equals(hash)) return current;
            current = current.getNext();
        }
        return null;
    }

    public void updateBlock(int id, String newData) {
        Block block = findById(id);
        if (block == null) {
            System.out.println("Block not found.");
            return;
        }

        block.setData(newData);
        recalculateFrom(block);
        System.out.println("Block updated and hashes recalculated.");
    }

    public void deleteBlock(int id) {
        if (head == null) return;

        if (head.getId() == id) {
            head = head.getNext();
            reorganizeChain();
            size--;
            System.out.println("Block deleted.");
            return;
        }

        Block current = head;
        while (current.getNext() != null) {
            if (current.getNext().getId() == id) {
                current.setNext(current.getNext().getNext());
                reorganizeChain();
                size--;
                System.out.println("Block deleted.");
                return;
            }
            current = current.getNext();
        }

        System.out.println("Block not found.");
    }

    private void reorganizeChain() {
        Block current = head;
        String previousHash = "0";
        int id = 1;

        while (current != null) {
            current.setId(id++);
            current.setPreviousHash(previousHash);
            current.updateHash();
            previousHash = current.getCurrentHash();
            current = current.getNext();
        }
    }

    private void recalculateFrom(Block start) {
        Block current = start;
        while (current != null) {
            current.updateHash();
            if (current.getNext() != null) {
                current.getNext().setPreviousHash(current.getCurrentHash());
            }
            current = current.getNext();
        }
    }

    public boolean isChainValid() {
        Block current = head;
        while (current != null && current.getNext() != null) {
            if (!current.getNext().getPreviousHash().equals(current.getCurrentHash())) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    public void printIntegrityReport() {
        System.out.println("Blockchain valid: " + isChainValid());
    }

    public void displayChain() {
        Block current = head;
        while (current != null) {
            current.printBlock();
            current = current.getNext();
        }
        System.out.println("\nTotal blocks: " + size);
    }

    private Block getLastBlock() {
        Block current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
