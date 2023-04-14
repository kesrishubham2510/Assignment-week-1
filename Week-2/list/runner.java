

public class runner {
    public static void main(String[] args) {
        // var initNode = new Node(1);
        // var initNode = Linkedlist.constructNode(1);
        // Linkedlist list = new Linkedlist(initNode);
        
        // list.addNode(2);
        // list.addNode(3);
        // list.addNode(4);
        // list.addNode(5);
        
        // // list.traverse();

        // // list.insertAtBegining(6);
        // // list.traverse();

        // list.insertAtPos(6, 10);
        // // list.traverse();

        // // list.deleteNodeAtBeginning();
        // // list.deleteEndNode();
        // list.deleteAtPos(1);
        // list.traverse();

        Node<String> initNode = new Node<>("r");
        Linkedlist<String> linkedlist = new Linkedlist<>(initNode);

        linkedlist.addNode("a");
        linkedlist.addNode("c");
        linkedlist.addNode("p");
        linkedlist.addNode("l");
        linkedlist.addNode("a");
        linkedlist.addNode("r");

        System.out.println("The string '"+linkedlist.valueOfList()+"' represented by Linked is "+(CheckPallindrome.isPallindrome(initNode) ? "pallindrome" : "not pallindrome"));
        
        Node<Integer> initNode2 = new Node<>(1);
        Linkedlist<Integer> linkedlist2 = new Linkedlist<>(initNode2);

        linkedlist2.addNode(1);
        linkedlist2.addNode(1);
        linkedlist2.addNode(2);
        linkedlist2.addNode(1);
        linkedlist2.addNode(1);
        linkedlist2.addNode(1);

        System.out.println("The string '"+linkedlist2.valueOfList()+"' represented by Linked is "+(CheckPallindrome.isPallindrome(initNode2) ? "pallindrome" : "not pallindrome"));
    
    }
}
