/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Le Cherng
 */
class Node  
{
    int height;
    Car key;  
    Node left, right;  
  
    Node(Car d)  
    {  
        key = d;  
        height = 1;  
    }  
}  
  
public class AVLCar  
{  
    public Node root;  
  
    // A utility function to get height of the tree  
    int height(Node N)  
    {  
        if (N == null)  
            return 0;  
        return N.height;  
    }  
  
    // A utility function to get maximum of two integers  
    int max(int a, int b)  
    {  
        return (a > b) ? a : b;  
    }  
  
    // A utility function to right rotate subtree rooted with y  
    // See the diagram given above.  
    Node rightRotate(Node y)  
    {  
        Node x = y.left;  
        Node T2 = x.right;  
  
        // Perform rotation  
        x.right = y;  
        y.left = T2;  
  
        // Update heights  
        y.height = max(height(y.left), height(y.right)) + 1;  
        x.height = max(height(x.left), height(x.right)) + 1;  
  
        // Return new root  
        return x;  
    }  
  
    // A utility function to left rotate subtree rooted with x  
    // See the diagram given above.  
    Node leftRotate(Node x)  
    {  
        Node y = x.right;  
        Node T2 = y.left;  
  
        // Perform rotation  
        y.left = x;  
        x.right = T2;  
  
        // Update heights  
        x.height = max(height(x.left), height(x.right)) + 1;  
        y.height = max(height(y.left), height(y.right)) + 1;  
  
        // Return new root  
        return y;  
    }  
  
    // Get Balance factor of node N  
    int getBalance(Node N)  
    {  
        if (N == null)  
            return 0;  
        return height(N.left) - height(N.right);  
    } 
    
    public String inOrderSuccessor(String key) 
    { 
        Node n = findKey(key);
        if (n.right != null) { 
            return minValueNode(n.right).key.VIN; 
        } 
        
        Node succ=null;
        
        while(root != null){
            if(stringCompare(n.key.VIN,root.key.VIN)<0){
                succ = root;
                root = root.left;
            }
            else if(stringCompare(n.key.VIN, root.key.VIN)>0){
                root = root.right;
            }
            else{
                break;
            }
        }
        return succ.key.VIN; 
    }
    
    public String inOrderPredecessor(String key) 
    { 
        Node n = findKey(key);
        if (n.left != null) { 
            return maxValueNode(n.left).key.VIN; 
        } 
        
        Node succ=null;
        
        while(root != null){
            if(stringCompare(n.key.VIN,root.key.VIN)<0){
                root = root.right;
            }
            else if(stringCompare(n.key.VIN, root.key.VIN)>0){
                succ = root;
                root = root.left;
            }
            else{
                break;
            }
        }
        return succ.key.VIN; 
    }
    
  
    Node insert(Node node, Car key)  
    {  
        /* 1. Perform the normal BST rotation */
        if (node == null)  
            return (new Node(key));  
        //key<node.key
        if (stringCompare(key.VIN, node.key.VIN)<0)  
            node.left = insert(node.left, key);
        //key>node.key
        else if (stringCompare(key.VIN, node.key.VIN)>0)  
            node.right = insert(node.right, key);  
        else // Equal keys not allowed  
            return node;  
  
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),  
                            height(node.right));  
  
        /* 3. Get the balance factor of this ancestor  
        node to check whether this node became  
        Wunbalanced */
        int balance = getBalance(node);  
  
        // If this node becomes unbalanced, then  
        // there are 4 cases Left Left Case  
        //key < node.left.key
        if (balance > 1 && stringCompare(key.VIN, node.left.key.VIN)<0)  
            return rightRotate(node);  
  
        // Right Right Case  
        //key>node.right.key
        if (balance < -1 && stringCompare(key.VIN, node.right.key.VIN)>0)  
            return leftRotate(node);  
  
        // Left Right Case  
        //key>node.left.key
        if (balance > 1 && stringCompare(key.VIN, node.left.key.VIN)>0)  
        {  
            node.left = leftRotate(node.left);  
            return rightRotate(node);  
        }  
  
        // Right Left Case
        //key<node.right.key
        if (balance < -1 && stringCompare(key.VIN, node.right.key.VIN)<0)  
        {  
            node.right = rightRotate(node.right);  
            return leftRotate(node);  
        }  
  
        /* return the (unchanged) node pointer */
        return node;  
    }  
  
    /* Given a non-empty binary search tree, return the  
    node with minimum key value found in that tree.  
    Note that the entire tree does not need to be  
    searched. */
    Node minValueNode(Node node)  
    {  
        Node current = node;  
  
        /* loop down to find the leftmost leaf */
        while (current.left != null)  
        current = current.left;  
  
        return current;  
    }  
    
    Node maxValueNode(Node node)
    {
        Node current = node;
        
        while(current.right!=null){
            current = current.right;
        }
        return current;
    }
  
    Node deleteNode(Node root, Car key)  
    {  
        // STEP 1: PERFORM STANDARD BST DELETE  
        if (root == null)  
            return root;  
  
        // If the key to be deleted is smaller than  
        // the root's key, then it lies in left subtree 
        //key.VIN < root.key.VIN
        if (stringCompare(key.VIN , root.key.VIN)<0)  
            root.left = deleteNode(root.left, key);  
  
        // If the key to be deleted is greater than the  
        // root's key, then it lies in right subtree  
        //key > root.key
        else if (stringCompare(key.VIN , root.key.VIN)>0)  
            root.right = deleteNode(root.right, key);  
  
        // if key is same as root's key, then this is the node  
        // to be deleted  
        else
        {  
  
            // node with only one child or no child  
            if ((root.left == null) || (root.right == null))  
            {  
                Node temp = null;  
                if (temp == root.left)  
                    temp = root.right;  
                else
                    temp = root.left;  
  
                // No child case  
                if (temp == null)  
                {  
                    temp = root;  
                    root = null;  
                }  
                else // One child case  
                    root = temp; // Copy the contents of  
                                // the non-empty child  
            }  
            else
            {  
  
                // node with two children: Get the inorder  
                // successor (smallest in the right subtree)  
                Node temp = minValueNode(root.right);  
  
                // Copy the inorder successor's data to this node  
                root.key = temp.key;  
  
                // Delete the inorder successor  
                root.right = deleteNode(root.right, temp.key);  
            }  
        }  
  
        // If the tree had only one node then return  
        if (root == null)  
            return root;  
  
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE  
        root.height = max(height(root.left), height(root.right)) + 1;  
  
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether  
        // this node became unbalanced)  
        int balance = getBalance(root);  
  
        // If this node becomes unbalanced, then there are 4 cases  
        // Left Left Case  
        if (balance > 1 && getBalance(root.left) >= 0)  
            return rightRotate(root);  
  
        // Left Right Case  
        if (balance > 1 && getBalance(root.left) < 0)  
        {  
            root.left = leftRotate(root.left);  
            return rightRotate(root);  
        }  
  
        // Right Right Case  
        if (balance < -1 && getBalance(root.right) <= 0)  
            return leftRotate(root);  
  
        // Right Left Case  
        if (balance < -1 && getBalance(root.right) > 0)  
        {  
            root.right = rightRotate(root.right);  
            return leftRotate(root);  
        }  
  
        return root;  
    }  
  
    // A utility function to print preorder traversal of  
    // the tree. The function also prints height of every  
    // node  
    public void preOrder(Node node)  
    {  
        if (node != null)  
        {  
            System.out.println(node.key + " ");  
            preOrder(node.left);  
            preOrder(node.right);  
        }  
    }  
    
    void inOrder(Node node, String indicator) 
    { 
        
        if (node != null){ 
  
            /* first recur on left child */
            inOrder(node.left, indicator); 
  
            /* then print the data of node */
            System.out.println(node.key.VIN+ " "); 
  
            /* now recur on right child */
            inOrder(node.right, indicator);
        }
    }
    
    void inOrder(Node node) 
    { 
        if (node != null){ 
  
            /* first recur on left child */
            inOrder(node.left); 
  
            /* then print the data of node */
            System.out.println(node.key+ " "); 
  
            /* now recur on right child */
            inOrder(node.right);
        }
    } 
    
     
    
    public void postOrder(Node node) 
    { 
        if (node == null) 
            return; 
  
        // first recur on left subtree 
        postOrder(node.left); 
  
        // then recur on right subtree 
        postOrder(node.right); 
  
        // now deal with the node 
        System.out.print(node.key + " "); 
    } 
    
    public void inOrderDecreasing(Node node)
    {
        if(node != null)
        {
            inOrderDecreasing(node.right);
            System.out.println(node.key);
            inOrderDecreasing(node.left);
        }
    }
    
    Car find(String key) {
        Node current = root;
        try{
            while (current != null) {
                if (current.key.VIN.equals(key)) {
                    break;
                }
                //current.key < key
                current = stringCompare(current.key.VIN, key)<0 ? current.right : current.left;
            }
            return current.key;
        }catch(NullPointerException e){
            return null;
        }
    }
    
    Node findKey(String key){
       Node current = root;
        try{
            while (current != null) {
                if (current.key.VIN.equals(key)) {
                    break;
                }
                //current.key < key
                current = stringCompare(current.key.VIN, key)<0 ? current.right : current.left;
            }
            return current;
        }catch(NullPointerException e){
            return null;
        } 
    }
    
    public static void main(String[] args) throws ParseException  
    {  
        AVLCar tree = new AVLCar();  
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1= sdf.parse("2020-01-22");
        Date date2= sdf.parse("2022-02-14");
        Date date3= sdf.parse("2019-02-14");
        Date date4= sdf.parse("2018-02-14");
        Date date5= sdf.parse("2017-02-14");
        Date date6= sdf.parse("2016-02-14");
        Date date7= sdf.parse("2015-02-14");
  
        /* Constructing tree given in the above figure */
        
        Car car1= new Car("0001", "Toyota",date1);
        Car car2= new Car("0002", "Toyota",date2);
        Car car3= new Car("0003", "Toyota",date3);
        Car car4= new Car("0004", "Toyota",date4);
        Car car5= new Car("0005", "Toyota",date5);
        Car car6= new Car("0006", "Toyota",date6);
        Car car7= new Car("0007", "Toyota",date7);
        
        tree.root = tree.insert(tree.root, car1);  
        tree.root = tree.insert(tree.root, car2);  
        tree.root = tree.insert(tree.root, car3);  
        tree.root = tree.insert(tree.root, car4);  
        tree.root = tree.insert(tree.root, car5);  
        tree.root = tree.insert(tree.root, car6);  
        tree.root = tree.insert(tree.root, car7); 
        
        System.out.println(tree.inOrderPredecessor("0006"));
        
        System.out.println(car1.Accidents);
  
        /* The constructed AVL Tree would be  
        9  
        / \  
        1 10  
        / \ \  
        0 5 11  
        / / \  
        -1 2 6  
        */
        System.out.println("Preorder traversal of "+  
                            "constructed tree is : ");  
        tree.preOrder(tree.root);  
        
        System.out.println("inOrder traversal");
        System.out.println("");
        tree.inOrder(tree.root, "Just Key");
  
        tree.root = tree.deleteNode(tree.root, car1);  
  
        /* The AVL Tree after deletion of 10  
        1  
        / \  
        0 9  
        /     / \  
        -1 5 11  
        / \  
        2 6  
        */
        System.out.println("");  
        System.out.println("Preorder traversal after "+  
                        "deletion of 1 :");  
        tree.preOrder(tree.root);  
        
        System.out.println("inOrder traversal");
        System.out.println("");
        tree.inOrder(tree.root);
        
        System.out.println("inOrder Descending traversal");
        System.out.println("");
        tree.inOrderDecreasing(tree.root);
        
        System.out.println("");
        System.out.println("Trying to find 0001");
        Car Result = tree.find("0001");
        System.out.println(Result);
        
        
        
    } 
    
    public static int stringCompare(String str1, 
                                    String str2) 
    { 
        for (int i = 0; i < str1.length() &&  
                    i < str2.length(); i++) { 
            if ((int)str1.charAt(i) ==  
                (int)str2.charAt(i)) { 
                continue; 
            }  
            else { 
                return (int)str1.charAt(i) -  
                    (int)str2.charAt(i); 
            } 
        } 
  
        // Edge case for strings like 
        // String 1="Geeky" and String 2="Geekyguy" 
        if (str1.length() < str2.length()) { 
            return (str1.length()-str2.length()); 
        }  
        else if (str1.length() > str2.length()) { 
            return (str1.length()-str2.length()); 
        } 
          
        // If none of the above conditions is true, 
        // it implies both the strings are equal 
        else { 
            return 0; 
        } 
    } 
}