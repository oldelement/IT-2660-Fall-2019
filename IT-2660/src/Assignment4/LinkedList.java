package Assignment4;

public class LinkedList {
    public Node head;

    public LinkedList() {
        head= null;
    }

    
    public boolean insert(Listing newListing)   { //insert
        Node newNode = new Node();
        newNode.listing = newListing;
        Node currentNode = head;

        if (head == null)   {   //checking to see if there is a item in the list already
            head = newNode;
            System.out.println(newNode.listing.name + " inserted successfully");
            return true;
        }
       while(currentNode.next != null)
       {
           currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        System.out.println(newNode.listing.name + " inserted successfully");
         return false;
    }
    
    
    public Listing fetch(String targetKey)   {  //fetch method
        Node currentNode = head;
        if (currentNode == null) {  //if its empty do nothing
            return null;
        }
        while(currentNode != null) {
            if (currentNode.listing.name.equals(targetKey))    { //if its not empty, return currentnode
            return currentNode.listing;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

   
    
    public boolean delete(String targetKey) {   //delete method
        Node currentNode = head;
        Node previousNode = null;

        if (head == null)   {
            return false;
        }
        while(currentNode != null)
        {
            if(currentNode.listing.name.equals(targetKey))  { //nested if to detect all possible node deletions
                if(previousNode == null)    {
                    head = currentNode.next;
                    System.out.println(targetKey + " deleted successfully");
                    break;
                }
                else {
                    previousNode.next = currentNode.next;
                    System.out.println(targetKey + " deleted successfully");
                }
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return true;
    }

    public boolean update(String targetKey, Listing newListing) {
       Node currentNode = head;
       if(head == null) {
           return false;
       }
       while(currentNode != null)   {
           if (currentNode.listing.name.equals(targetKey))  {
               currentNode.listing.name = newListing.name;
               currentNode.listing.id = newListing.id;
               currentNode.listing.gpa = newListing.gpa;
               System.out.println(targetKey + " updated successfully to " + currentNode.listing.name + "\n");
           }
           currentNode = currentNode.next;
       }
       return true;
    }
    public void showAll()   {
        Node temp;
        temp = head;              //prints all the elements in the list
        while(temp != null) {
            System.out.println("Name: " + temp.listing.name + "\n" + "ID: " + temp.listing.id + "\n" + "GPA: " + temp.listing.gpa + "\n");
            temp = temp.next;
        }
    
        
    }
    
        class Node {
        Listing listing;
        Node next;
    }
        
}
