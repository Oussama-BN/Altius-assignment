import java.io.*;

public class Altius_Assignment_1 {
    // Creating a class for the linked lists
    public static class LinkedList {
        SinglyLinkedListNode head; // head of list

        // Linked list Node.
        static class SinglyLinkedListNode {
            int data;
            SinglyLinkedListNode next;

            // Constructor
            SinglyLinkedListNode(int d) {
                data = d;
                next = null;
            }
        }
        // The function insert help us later to create the lists from the file
        public static LinkedList insert(LinkedList list, int data) {

            SinglyLinkedListNode new_node = new SinglyLinkedListNode(data);
            new_node.next = null;
            // If the Linked List is empty, then make the new node as head
            if (list.head == null) {
                list.head = new_node;
            } else {
                // Else traverse till the last node and insert the new_node there
                SinglyLinkedListNode last = list.head;
                while (last.next != null) {
                    last = last.next;
                }
                // Insert the new_node at last node
                last.next = new_node;
            }
            return list;
        }
        // The compare_lists function that compare two linked lists
        // It has two parameters which are the references to the heads of each list
        public static int compare_lists(SinglyLinkedListNode list1, SinglyLinkedListNode list2){
            int result = 1;

            SinglyLinkedListNode CurrentNode1 = list1;
            SinglyLinkedListNode CurrentNode2 = list2;

            while (CurrentNode1 != null && CurrentNode2 != null && CurrentNode1.data == CurrentNode2.data) {
                CurrentNode1 = CurrentNode1.next;
                CurrentNode2 = CurrentNode2.next;
            }
            if (CurrentNode1 != null || CurrentNode2 != null) {
                // One of the lists has more items left in it.
                // Otherwise, both lists are equal.
                result = 0;
            }
            return result;
        }
    }

    public static void main(String[] args) throws Exception {

        // Reading the file of the assessment
        // Please make sure to modify the path to your file path
        File file = new File("C:\\Users\\BENDJABALLAH Oussama\\" +
                "IdeaProjects\\Altius_Assignment_1\\src\\assignment01-1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        // Retrieving the number of test cases
        int NB_cases = 0;
        if ((st = br.readLine()) != null) {
            NB_cases = Integer.parseInt(st);

        }
        else {
            System.out.print("The file is empty");
        }
        // The loop for the test cases
        // first we retrieve the data of lists of each test case from the input file
        for (int i=0; i< NB_cases; i++) {
            int List1_length, List2_length;

            // Creating the first lists
            st = br.readLine();
            List1_length = Integer.parseInt(st);
            LinkedList list1 = new LinkedList();
            for (int j=0; j<List1_length; j++){
                st = br.readLine();
                list1 = LinkedList.insert(list1, Integer.parseInt(st));
            }

            // Creating the second list
            st = br.readLine();
            List2_length = Integer.parseInt(st);
            LinkedList list2 = new LinkedList();
            for (int j=0; j<List2_length; j++){
                st = br.readLine();
                list2 = LinkedList.insert(list2, Integer.parseInt(st));
            }

            // Here we call the function that compare the two lists
            System.out.println(LinkedList.compare_lists(list1.head, list2.head));
        }
    }
}