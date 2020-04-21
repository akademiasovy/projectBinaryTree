package sk.itsovy.binarytree;

import java.util.List;

public class Tree {

    private Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public void addNode(Node node){
        if(node==null)
            return;
        root.addChild(node);
    }

    public void printInOrder()
    {
        if(root!=null)
             root.inorder();
    }
    public void printPreOrder(){
        if(root!=null)
            root.preorder();
    }
    public void printPostOrder(){
        root.postorder();
    }

    // to do


    public String getValue(int key){
        Node akt=root;
        while(akt!=null) {
            if (akt.getKey() == key) {
                return akt.getValue();
            }
            if (akt.getKey() > key) {
                akt = akt.getLeft();
            } else
                akt = akt.getRight();
        }
        return null;
    }
    public boolean containsKey(int key) { return false;}
    public void remove (Node node){}
    public List<Node> getListOfLeafs() {return null;}
    public int getHeight(){return -1;}

}
