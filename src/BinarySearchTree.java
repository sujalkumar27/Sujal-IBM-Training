
public class BinarySearchTree{
    static  boolean search(Node root, int number){
        if(root == null) return false;
        if(root.data == number) return true;

        boolean leftSearch = search(root.left, number);
        boolean rightSearch = search(root.right, number);

        return leftSearch || rightSearch;
    }
    static void display(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        display(root.left);
        display(root.right);
    }

    static void insert(Node root, int data){
        if(root == null) return;
        if(data < root.data){
            if(root.left == null){
                root.left = new Node(data);
            }else{
                insert(root.left, data);
            }
        }else{
            if(root.right == null){
                root.right = new Node(data);
            }else{
                insert(root.right, data);
            }
        }
        
    }
     static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args) {
        Node root = new Node(9);
        insert(root, 10);
        insert(root, 5);    
        insert(root, 15);
        insert(root, 3);    
        insert(root, 7);
        insert(root, 13);
        insert(root, 17);
        insert(root, 1);
        

        System.out.println(search(root, 13));
        System.out.print("Inorder traversal: ");
        inorder(root);
        System.out.println();
        System.out.print("Preorder traversal: ");
        preorder(root);
        System.out.println();
        System.out.print("Postorder traversal: ");
        postorder(root);
        System.out.println();
    }
}
class Node{
    int data;
    Node right;
    Node left;

    Node(int data){
        this.data = data;
        left=null;
        right=null;

    }
}