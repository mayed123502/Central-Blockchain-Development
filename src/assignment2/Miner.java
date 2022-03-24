package assignment2;

public class Miner {

    private double reward;

    public void mine(Block block, BlockChain blockChain) {
        while (notGoldenHash(block)) {
            block.generateHash();
            block.incrementNonce();
        }

        System.out.println("Block: " + block + " has just mined.");
        System.out.println("Hash is: " + block.getHash());

        blockChain.addBlock(block);
        reward += Stats.REWARD;
    }

    public boolean notGoldenHash(Block block) {
        String leadingZeros = new String(new char[Stats.DIFFICULTY]).replace('\0', '0');
        return !block.getHash().substring(0, Stats.DIFFICULTY).equals(leadingZeros);
    }

    public double getReward() {
        return this.reward;
    }
}
