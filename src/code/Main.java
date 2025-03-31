package code;


import code.part1.QueueTests;
import code.part2.CircularLinkedQueueTest;
import code.part2.CircularQueueDemo;
import code.part3.DFSTraversal;

import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
             // Command-line menu to choose which demo to run
        System.out.println("Programming 3 Coursework 1 Demos");
        System.out.println("1. JCF Queue Implementations (Part 1)");
        System.out.println("2. ArrayDeque Circular Queue (Part 2.1)");
        System.out.println("3. Custom Circular Linked Queue (Part 2.2)");
        System.out.println("4. Graph DFS Traversal (Part 3)");
        
        // Read user input and call the appropriate demo
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter your choice or 0 to quit: ");
        int choice = scanner.nextInt();
        scanner.close();

        
        switch(choice) {
            case 1:
                QueueTests.runDemo();
                break;
            case 2:
                CircularQueueDemo.demonstrateArrayDeque();
                break;
            case 3:
                CircularLinkedQueueTest.runDemo();
                break;
            case 4:
                System.out.println("TBD");
                //DFSTraversal.runDemo();
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
        }
    
    }
}