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
    public void remove (Node node){
        // 1 moznost , node je list:
        if(node.isLeaf()){
            Node parrent = getParrent((node));
            if(parrent == null)
                return ;
            if(parrent.getLeft()==node)
                parrent.setLeft(null);
            else
                parrent.setRight(null);
            return;
        }

        // node ma jedneho potomka - praveho
        if(node.getLeft()==null && node.getRight()!=null){
            Node parrent = getParrent(node);
            if(parrent==null)
                return;
            if(parrent.getLeft()==node){
                parrent.setLeft(node.getRight());

            }
            else
                parrent.setRight(node.getRight());
        }
        // node ma jedneho potomka - lavy
        if(node.getLeft()!=null && node.getRight()==null){
            Node parrent = getParrent(node);
            if(parrent==null)
                return;
            if(parrent.getLeft()==node){
                parrent.setLeft(node.getLeft());

            }
            else
                parrent.setRight(node.getLeft());
        }


    }
    public List<Node> getListOfLeafs() {return null;}
    public int getHeight(){return -1;}

    public Node getParrent(Node node){
        if(node==root){
            return null;
        }

         Node akt = root;
         while(akt!=null){
            if(akt.getLeft() ==node)
                return akt;
             if(akt.getRight() ==node)
                 return akt;
             if(akt.getKey()>node.getKey())
                 akt=akt.getLeft();
             else
                 akt=akt.getRight();

         }
         return null;
    }
}
