package blockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Represents a single block in the blockchain.
 */
public class Block {

    private int id;
    private String data;
    private String previousHash;
    private String currentHash;
    private Block next;

    public Block(int id, String data, String previousHash) {
        this.id = id;
        this.data = data;
        this.previousHash = previousHash;
        this.currentHash = calculateHash();
        this.next = null;
    }

    public String calculateHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String input = id + data + previousHash;
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder hex = new StringBuilder();
            for (byte b : hashBytes) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not available");
        }
    }

    public void updateHash() {
        this.currentHash = calculateHash();
    }

    public void printBlock() {
        System.out.println("\nBlock ID: " + id);
        System.out.println("Data: " + data);
        System.out.println("Previous Hash: " + previousHash);
        System.out.println("Current Hash: " + currentHash);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Block getNext() {
        return next;
    }

    public void setNext(Block next) {
        this.next = next;
    }
}
