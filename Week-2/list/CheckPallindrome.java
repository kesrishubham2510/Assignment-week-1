public class CheckPallindrome {
    
    public static <T> boolean isPallindrome(Node<T>  head){

        if(head==null || head.getNext()==null)
        return true;

       Node<T> slow, fast, prev, reversedHalf;
       prev = slow = fast = head;

       // finding middle of the linkedlist
       while(fast!=null && fast.getNext()!=null){
           prev = slow;
           slow = slow.getNext();
           fast = fast.getNext().getNext();
       } 

       if(fast==null){
           prev.setNext(null);
           reversedHalf = reverse(slow);
       }else{
           reversedHalf = reverse(slow.getNext());
           slow.setNext(null);
       }
       slow = head;
       fast = reversedHalf;

       while(slow!=null && reversedHalf!=null){
           if(slow.getData()!=reversedHalf.getData())
            return false;
           slow = slow.getNext();
           reversedHalf = reversedHalf.getNext(); 
       }

       return true;
   }

   public static <T> Node<T>  reverse(Node<T>  head){
    Node<T>  curr,prev, next;

       curr = head;
       prev = null;

       while(curr!=null){
           next = curr.getNext();
           curr.setNext(prev);
           prev = curr;
           curr = next;
       }

       return prev;

    }

}
