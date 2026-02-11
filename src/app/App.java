package app;

import blockchain.Block;
import blockchain.Blockchain;
import java.util.Scanner;

/**
 * Main class to demonstrate a blockchain simulation.
 * Provides an interactive CRUD-S menu.
 */
public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Blockchain blockchain = new Blockchain();

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("        BLOCKCHAIN SIMULATOR IN JAVA       ");
        System.out.println("      Using Singly Linked Lists (Academic) ");
        System.out.println("==========================================\n");

        System.out.println("Authors:");
        System.out.println("- David Lopez Barbosa");
        System.out.println("- Leon Alejandro Orrego Bello");
        System.out.println("- Dago David Palmera Navarro\n");

        initializeBlockchain();

        boolean running = true;
        while (running) {
            running = showMenu();
        }

        System.out.println("\nProgram terminated.");
    }

    private static void initializeBlockchain() {
        System.out.println("Initializing blockchain with sample data...\n");
        blockchain.addBlock("Alice sends 10 BTC to Bob");
        blockchain.addBlock("Bob sends 5 BTC to Charlie");
        blockchain.addBlock("Charlie sends 3 BTC to David");
        blockchain.addBlock("David sends 2 BTC to Eve");
    }

    private static boolean showMenu() {
        System.out.println("\n------------- MAIN MENU -------------");
        System.out.println("1. Add new block");
        System.out.println("2. Search block by ID");
        System.out.println("3. Search block by Hash");
        System.out.println("4. Display full blockchain");
        System.out.println("5. Update block data");
        System.out.println("6. Delete block");
        System.out.println("7. Verify chain integrity");
        System.out.println("8. Show blockchain statistics");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        int option;
        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return true;
        }

        switch (option) {
            case 1 -> addBlock();
            case 2 -> searchById();
            case 3 -> searchByHash();
            case 4 -> blockchain.displayChain();
            case 5 -> updateBlock();
            case 6 -> deleteBlock();
            case 7 -> blockchain.printIntegrityReport();
            case 8 -> showStatistics();
            case 0 -> {
                return false;
            }
            default -> System.out.println("Invalid option.");
        }
        return true;
    }

    private static void addBlock() {
        System.out.print("Enter transaction data: ");
        String data = scanner.nextLine();
        if (data.isBlank()) {
            System.out.println("Transaction data cannot be empty.");
            return;
        }
        blockchain.addBlock(data);
    }

    private static void searchById() {
        System.out.print("Enter block ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Block block = blockchain.findById(id);
            if (block != null) {
                block.printBlock();
            } else {
                System.out.println("Block not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }

    private static void searchByHash() {
        System.out.print("Enter block hash: ");
        String hash = scanner.nextLine();
        Block block = blockchain.findByHash(hash);
        if (block != null) {
            block.printBlock();
        } else {
            System.out.println("Block not found.");
        }
    }

    private static void updateBlock() {
        System.out.print("Enter block ID to update: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new transaction data: ");
            String data = scanner.nextLine();
            blockchain.updateBlock(id, data);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }

    private static void deleteBlock() {
        System.out.print("Enter block ID to delete: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            blockchain.deleteBlock(id);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }

    private static void showStatistics() {
        System.out.println("\nBlockchain size: " + blockchain.getSize());
        System.out.println("Empty: " + blockchain.isEmpty());
        System.out.println("Valid: " + blockchain.isChainValid());
    }
}
