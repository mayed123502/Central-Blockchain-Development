/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 *
 * @author ProBook
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream out = new PrintStream(new FileOutputStream("d:/output.txt"));
        System.setOut(out);
        BlockChain blockChain = new BlockChain();
        Miner miner = new Miner();

        Block genesis = new Block(0, "Genesis transaction", Stats.GENESIS);
        miner.mine(genesis, blockChain);
        Block b1 = new Block(1, "First transaction", blockChain.getBlockChain().get(blockChain.size() - 1).getHash());
        miner.mine(b1, blockChain);
        Block b2 = new Block(2, "Second transaction", blockChain.getBlockChain().get(blockChain.size() - 1).getHash());
        miner.mine(b2, blockChain);
        Block b3 = new Block(3, "Third transaction", blockChain.getBlockChain().get(blockChain.size() - 1).getHash());
        miner.mine(b3, blockChain);
        Block b4 = new Block(4, "fourth transaction", blockChain.getBlockChain().get(blockChain.size() - 1).getHash());
        miner.mine(b4, blockChain);
        Block b5 = new Block(5, "Fifth transaction", blockChain.getBlockChain().get(blockChain.size() - 1).getHash());
        miner.mine(b5, blockChain);
        System.out.println("--------------------------");
        System.out.println("Blockchain Result: \n" + blockChain);
        System.out.println("The miner reward is: " + miner.getReward());

    }

}
