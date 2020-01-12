import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class NoobChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 2;

	public static void main(String[] args) {	
		
		teste1();
		//teste2();
		//teste3();
		//teste4();
		//teste5();
		
	}
	
	public static void teste1() {
		
		blockchain.add(new Block("Hi im the first block", ""));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).mineBlock(difficulty);
		
		blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 2... ");
		blockchain.get(1).mineBlock(difficulty);
		
		blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 3... ");
		blockchain.get(2).mineBlock(difficulty);	
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
		
		Path path = Paths.get("/Users/rafaritter44/git/blockchain/teste1.json");

		try (PrintWriter writer = new PrintWriter (Files.newBufferedWriter (path, Charset.forName ("utf8")))) {
			writer.print(blockchainJson);
		}
		catch (IOException x) {
			System.err.format ("Erro de E/S: %s%n", x);
		}
		
	}
	
	public static void teste2() {
		
		blockchain.add(new Block("Hi im the first block from the 2nd test", ""));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).mineBlock(difficulty);
		
		blockchain.add(new Block("Yo im the second block from the 2nd test",
				blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 2... ");
		blockchain.get(1).mineBlock(difficulty);
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
		
		Path path = Paths.get("/Users/rafaritter44/git/blockchain/teste2.json");

		try (PrintWriter writer = new PrintWriter (Files.newBufferedWriter (path, Charset.forName ("utf8")))) {
			writer.print(blockchainJson);
		}
		catch (IOException x) {
			System.err.format ("Erro de E/S: %s%n", x);
		}
	}
	
	public static void teste3() {
		
		blockchain.add(new Block("Hi im the first block from the 3rd test", ""));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).mineBlock(difficulty);
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
		
		Path path = Paths.get("/Users/rafaritter44/git/blockchain/teste3.json");

		try (PrintWriter writer = new PrintWriter (Files.newBufferedWriter (path, Charset.forName ("utf8")))) {
			writer.print(blockchainJson);
		}
		catch (IOException x) {
			System.err.format ("Erro de E/S: %s%n", x);
		}
		
	}
	
	public static void teste4() {
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
		
		Path path = Paths.get("/Users/rafaritter44/git/blockchain/teste4.json");

		try (PrintWriter writer = new PrintWriter (Files.newBufferedWriter (path, Charset.forName ("utf8")))) {
			writer.print(blockchainJson);
		}
		catch (IOException x) {
			System.err.format ("Erro de E/S: %s%n", x);
		}
		
	}
	
	public static void teste5() {
		
		blockchain.add(new Block("Hi im the first block from the 5th test", ""));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).mineBlock(difficulty);
		
		blockchain.add(new Block("Yo im the second block from the 5th test",
				blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 2... ");
		blockchain.get(1).mineBlock(difficulty);
		
		blockchain.add(new Block("Hey im the third block from the 5th test",
				blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 3... ");
		blockchain.get(2).mineBlock(difficulty);	
		
		blockchain.add(new Block("Hey im the forth block from the 5th test",
				blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 4... ");
		blockchain.get(3).mineBlock(difficulty);
		
		System.out.println("\nBlockchain is Valid: " + isChainValid());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);
		
		Path path = Paths.get("/Users/rafaritter44/git/blockchain/teste5.json");

		try (PrintWriter writer = new PrintWriter (Files.newBufferedWriter (path, Charset.forName ("utf8")))) {
			writer.print(blockchainJson);
		}
		catch (IOException x) {
			System.err.format ("Erro de E/S: %s%n", x);
		}
		
	}
	
	
	public static Boolean isChainValid() {
		Block currentBlock; 
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		//loop through blockchain to check hashes:
		for(int i=1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i-1);
			//compare registered hash and calculated hash:
			if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
				System.out.println("Current Hashes not equal");			
				return false;
			}
			//compare previous hash and registered previous hash
			if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			//check if hash is solved
			if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}
}