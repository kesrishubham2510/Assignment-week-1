

public class Linkedlist<T>{
    
    /*
          * The special node (startNode) marks the starting of the linkedList
          * If the startNode is final, the memory it's referring to can never be changed
            though the value stored inside the memory can be modified. Thus, disabling
            the opportunity to insert at beginning.
          * 
     */
    private Node<T> startNode;
    // to optimise the adding of the new nodes at the last
    // private Node endNode;


    public Linkedlist(Node<T>  node){
        this.startNode = node;
    }

    /*
         * Without using endNode
     */
    public void addNode(T data){
        var newNode = constructNode(data);
        var endNode = locateEnd();
        endNode.setNext(newNode); 
    }
 

    // Traverse the linkedList
    public void traverse(){

        var nodeIterator = this.startNode;

         while(nodeIterator!=null){
             System.out.println(nodeIterator.getData());           
             nodeIterator = nodeIterator.getNext();
         }
    }

    /*
        * Method is private so that it can only be accessible through inside the class
        * To Locate the end of the linkedList
    
    */ 
    private Node<T>  locateEnd(){

         var nodeIterator = this.startNode;

         while(nodeIterator.getNext()!=null){
            nodeIterator = nodeIterator.getNext();
         }

         return nodeIterator;
    }

    // static function to return a node with given data
    public Node<T> constructNode(T data){

        var newNode = new Node<>(data);
        return newNode;
    }

    // Insertion operations
    public void insertAtBegining(T data){
        this.insertAtBegining(constructNode(data));
    }

    public void insertAtEnd(T data){
        this.insertAtEnd(constructNode(data));
    }

    // If the insertion postion is greater than the length of the list, then insertion will by default take place at end
    public void insertAtPos(T data, int pos){
        var newNode = constructNode(data);

         if(startNode.getNext()==null && pos>2){
             System.out.println("Can't insert node at the demanded position");
             return;
         }else if(pos==0 || pos==1){
            insertAtBegining(newNode);
            return;
         }

         int k = 1;
         var nodeIterator = this.startNode;
         while(nodeIterator.getNext()!=null && k!=pos-1){
            k++;
            nodeIterator = nodeIterator.getNext();
         }

         if(k<pos-1){
             insertAtEnd(newNode);
             return;
         }
         
        //  now I am at the node after which the insertion needs to be done
        newNode.setNext(nodeIterator.getNext());
        nodeIterator.setNext(newNode);
           
    }

    private void insertAtBegining( Node<T>  newNode){
          newNode.setNext(startNode);
          startNode = newNode;
    }

    private void insertAtEnd( Node<T>  newNode){
        System.out.println("Inserting at end");
        locateEnd().setNext(newNode);
    }

    public void deleteNodeAtBeginning(){
        // to keep the address for resetting it to null later
        var nodeToDelete = this.startNode;

        this.startNode = nodeToDelete.getNext();
        nodeToDelete = null;
    }

    public void deleteEndNode(){

        var nodeIterator = this.startNode;

        while(nodeIterator.getNext().getNext()!=null){
           nodeIterator = nodeIterator.getNext();
        }

        // nodeIterator now points to the second last node of the list
        nodeIterator.setNext(null);
    }

    // check thoroughly
    public void deleteAtPos(int pos){
        if(startNode.getNext()==null && (pos==0||pos==1))
         this.startNode = null;
        
        else{
            int k = 1;
            var nodeIterator = this.startNode;
            while(nodeIterator.getNext()!=null && k!=pos-1){
               k++;
               nodeIterator = nodeIterator.getNext();
            }

            if(k<pos || nodeIterator.getNext()==null)
             return;
            // node iterator poinst to node previous to the node to deleted
            var nodeToDelete = nodeIterator.getNext();
            nodeIterator.setNext(nodeToDelete.getNext());
            nodeToDelete= null;
        } 
    }

    /*
         * The functions traverses and concats the value in form of string to evaluate the value 
           represented by LinkedList
    */

    public String valueOfList(){
        Node<T> itr = this.startNode;   
        StringBuilder strBuild = new StringBuilder();

        while(itr!=null){
           strBuild.append(itr.getData().toString());
           itr = itr.getNext();
        }

        return strBuild.toString(); 
    }
}
