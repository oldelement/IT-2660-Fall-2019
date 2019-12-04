package Assignment7;


public class BinaryTree {
		
    Node root;
    Node checkNode;
    Node parent;

    public void insert(Node newNode) {
      
        if (root == null) {         //first node entered becomes root node
            root = newNode;
        }
        else {
            checkNode = root;
          
            while (true) {         
                parent = checkNode;
                if (newNode.key > checkNode.key) {
                    checkNode = checkNode.rightChild;
                    if (checkNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
                if (newNode.key < checkNode.key) {
                    
                    parent = checkNode;        //check for null after first loop iteration 
                    checkNode = checkNode.leftChild;
                    if (checkNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    
                    parent = checkNode;       
                    checkNode = checkNode.rightChild;
                    if (checkNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node fetch(int key) {
        Node currentNode = root;
        while (true) {
            if (currentNode.key == key) {
                return currentNode;
            } else if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
            } else currentNode = currentNode.rightChild;
        }
    }

 
    public Node getParent(int key)  {//added this method to try to break some of the logic out of the already massive delete method
        Node currentNode = root;
        parent = currentNode;
        while (true) {
            if (currentNode.key == key) {
                return parent;
            } else if (key < currentNode.key) {
                parent = currentNode;
                currentNode = currentNode.leftChild;
            } else {
                parent = currentNode;
                currentNode = currentNode.rightChild;
            }
        }
    }

    public void delete(int key) {
       
        if (key == root.key)    { //handle a single node update in list
            root = null;
        }
        else    {
        Node currentNode = root;
        while (true) {
            if (currentNode.key == key) {       
                
                if (currentNode.rightChild != null && currentNode.leftChild != null && currentNode.key < getParent(key).key)    { //for the case when deletedNode has 2 children
                    getParent(currentNode.key).leftChild = currentNode.rightChild;
                    currentNode.rightChild.leftChild = currentNode.leftChild;
                    break;

                }
                if (currentNode.rightChild != null && currentNode.leftChild != null && currentNode.key > getParent(key).key)    {
                    getParent(currentNode.key).rightChild = currentNode.rightChild;
                    currentNode.rightChild.leftChild = currentNode.leftChild;
                    break;

                }
                
                if(currentNode.leftChild == null && currentNode.rightChild == null && currentNode.key < getParent(key).key)   {     //for the case when empty
                    getParent(key).leftChild = null;  
                    break;
                }
                if (currentNode.leftChild == null && currentNode.rightChild == null && currentNode.key > getParent(key).key)    {
                   getParent(key).rightChild = null;
                   break;
                }
            
                if (currentNode.leftChild == null && currentNode.key < getParent(key).key)  {
                    currentNode = currentNode.rightChild;                                    //for single leftChild in tree
                    getParent(key).leftChild = currentNode;
                    break;
                }
                if (currentNode.leftChild == null && currentNode.key > getParent(key).key)  {
                    currentNode = currentNode.rightChild;
                    getParent(key).rightChild = currentNode;
                    break;
                }
               
                if (currentNode.rightChild == null && currentNode.key < getParent(key).key)  {//for single rightChild in tree
                    currentNode = currentNode.leftChild; 
                    getParent(key).leftChild = currentNode;
                    break;
                }
                if (currentNode.rightChild == null && currentNode.key > getParent(key).key)  {
                    currentNode = currentNode.leftChild;
                    getParent(key).rightChild = currentNode;
                    break;
                }
            }
            else if (key < currentNode.key) {
                currentNode = currentNode.leftChild;
            }
            else {
                currentNode = currentNode.rightChild;
            }
        }
        }
        System.out.println("Deleted successful! \n");
    }

    public void updateNode(int key, Node newStudent) {
        delete(key);
        insert(newStudent);
    }
    
    public boolean outputAll(Node currentNode) {  //outputs all of the students info
        if (currentNode == null) {
            System.out.println();
            return true;
        }
        System.out.println("Name: " + currentNode.name +  "\nID: " + currentNode.key + "\nG.P.A: " + currentNode.gpa + "\n");

        outputAll(currentNode.rightChild);
        return false;
    }

	
    
}


class Node {
    Node leftChild, rightChild;  //create the notes for left and right child partly used in recursion 
    String name;
    int key;
    double gpa;

    public Node(int Key, String Name, double GPA)    {
        key = Key;
        name = Name;
        gpa = GPA;
    }
}