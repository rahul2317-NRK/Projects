package com.servlets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

public class Block {
	
	
	    private Object index;
	    private long timestamp;
	    private String previousHash;
	    private String hash;
	    private String data;
	    private int nonce;

	    public Block(Object object, String previousHash, String data) {
	        this.index = object;
	        this.timestamp = new Date().getTime();
	        this.previousHash = previousHash;
	        this.data = data;
	        this.nonce = 0;
	        this.hash = calculateHash();
	    }

	    

	    public void mineBlock(int difficulty) {
	        String target = new String(new char[difficulty]).replace('\0', '0');
	        while (!hash.substring(0, difficulty).equals(target)) {
	            nonce++;
	            hash = calculateHash();
	        }
	        System.out.println("Block mined: " + hash);
	    }

		
			


		private String calculateHash() {
			// TODO Auto-generated method stub
			return null;
		}



		public String getHash() {
			// TODO Auto-generated method stub
			return null;
		}

		public String getIndex() {
			// TODO Auto-generated method stub
			return null;
		}

		public static Object getChain() {
			// TODO Auto-generated method stub
			return null;
		}

		public static Block getLatestBlock() {
			// TODO Auto-generated method stub
			return null;
		}

		public static void addBlock(Block block) {
			// TODO Auto-generated method stub
			
		}

	    // Getters and setters (optional)
	}

	class Block1 {
	    public ArrayList<Object> chain;
	    public int difficulty;
		private static Block blockchain;

	    public Block1(int difficulty) {
	        this.difficulty = difficulty;
	        this.setChain(new ArrayList<>());
	        // Create the genesis block
	        getChain().add(new Block(0, "0", "Genesis Block"));
	    }

	  

		public Block getLatestBlock() {
	        return getChain().get(getChain().size() - 1);
	    }

	    public void addBlock(Block newBlock) {
	        newBlock.mineBlock(difficulty);
	        getChain().add(newBlock);
	    }

		public ArrayList<Block> getChain() {
			return null;
		}

		public void setChain(ArrayList<Object> arrayList) {
			this.chain = arrayList;
		}

	    // Validation methods (optional)

	

	
	    public static void main(String[] args) {
	        int difficulty = 4; // Adjust difficulty level as needed
	        blockchain = new Block(difficulty, null, null);

	      System.out.println("Mining Genesis Block...");
	        //((Blockchain) blockchain).addBlock(new Block(1, blockchain.getLatestBlock().getHash(), "Transaction 1"));
	        System.out.println("Mining Block 1...");
	       // blockchain.addBlock(new Block(2, blockchain.getLatestBlock().getHash(), "Transaction 2"));
	        System.out.println("Mining Block 2...");

	        // Print the blockchain
	      //  for (Block block : blockchain.getChain()) {
	           // System.out.println("Block " + block.getIndex() + " Hash: " + block.getHash());
	        }
	    }
	


