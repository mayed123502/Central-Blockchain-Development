package assignment2;

import java.util.Date;

public class Block {

    private int id;
    private int nonce;
    private long timeStamp;
    private String hash;
    private String prevHash;
    private String transaction;

    public Block(int id, String transaction, String prevHash) {
        this.id = id;
        this.transaction = transaction;
        this.prevHash = prevHash;
        this.timeStamp = new Date().getTime();
        generateHash();
    }

    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevHash() {
        return this.prevHash;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public void incrementNonce() {
        this.nonce++;
    }

    public void generateHash() {
        String dataToHash = Integer.toString(id) + prevHash + Long.toString(timeStamp) + Integer.toString(nonce) + transaction.toString();
        String hashValue = SHA256.generateHash(dataToHash);
        this.hash = hashValue;
    }

    @Override
    public String toString() {
        return "( number " + this.id + ")" + this.transaction + " | " + this.hash + " | " + this.prevHash + " | ";
    }
}
