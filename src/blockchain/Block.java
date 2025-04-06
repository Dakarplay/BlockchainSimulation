package blockchain;

import java.util.Objects;

public class Block {

    // Class Block Attributes
    private int blockId;
    private String transactionData;
    private int previousHash;
    private int currentHash;
    private Block nextBlock;

    // Construct Method Block
    public Block(int blockId, String transactionData, int previousHash) {
        
        this.blockId = blockId;
        this.transactionData = transactionData;
        this.previousHash = previousHash;
        this.currentHash = calculateHash();
        this.nextBlock = null;
    }

    private int calculateHash(){

        return Objects.hash(blockId, transactionData, previousHash);
    }

    public void displayBlockInfo(){

        System.out.println("Block ID: + blockId");
        System.out.println("Transcation: " + transactionData);

        
        if (previousHash == -1) {
            System.out.println("Hash anterior: None");
        } else {
            System.out.println("Hash anterior: " + previousHash);
        }

        System.out.println("Current Hash: " + currentHash);

    }

    // Getters and setters
    // ==================================
    public int getBlockId(){
        return blockId;
    }

    public void setBlock(int blockId){
        this.blockId = blockId;
    }

    // ==================================

    public String getTransactionData(){
        return transactionData;
    }

    public void setTransactionData(String transactionData){
        this.transactionData = transactionData;
    }

    // ==================================

    public int getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(int previousHash) {
        this.previousHash = previousHash;
    }

    // ==================================

    public int getCurrentHash() {
        return currentHash;
    }

    // ==================================

    public Block getNextBlock() {
        return nextBlock;
    }

    public void setNextBlock(Block nextBlock) {
        this.nextBlock = nextBlock;
    }
}