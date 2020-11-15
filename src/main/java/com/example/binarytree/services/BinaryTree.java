package com.example.binarytree.services;

import com.example.binarytree.dto.BinaryInput;
import com.example.binarytree.dto.Node;
import com.example.binarytree.utils.BTreePrinter;
import lombok.Data;
import org.springframework.stereotype.Service;





@Service
@Data
public class BinaryTree {

    private Node  head;
    private Integer size;


    public BinaryTree(){
        head=null;
        size=0;

    }



    public String addNodes(BinaryInput binaryInput){
        for(Integer current:binaryInput.getNumbers()){
            addNode(head,current);
        }
        return getPrintableTree();
    }

    public String getPrintableTree() {
        String result = BTreePrinter.createPrintableTree(head);
        return result;
    }


    public Boolean addNode(Node currentNode, Integer newValue){
        if(currentNode==null){
            head=new Node(newValue);
            size++;
            return true;
        }
        if(currentNode.getData()>newValue){
            if(currentNode.hasLeft()){
               return addNode(currentNode.getLeft(),newValue);
            }else {
                currentNode.setLeft(new Node(newValue));
                size++;
                return true;
            }
        }
        if(currentNode.getData()<newValue){
            if(currentNode.hasRight()){
                return addNode(currentNode.getRight(),newValue);
            }else {
                currentNode.setRight(new Node(newValue));
                size++;
                return true;
            }
        }
        System.out.println("THE NUMBER " + newValue + " ALREADY EXISTS");
        return false;
    }


    public void printTree(){
        String treeStr = BTreePrinter.createPrintableTree(head);
        System.out.println(treeStr);
    }


    public Boolean removeTree() {
        head=null;
        return true;
    }

    public void printAscending(Node node) {
        if(node != null) {
            printAscending(node.getLeft());
            System.out.println(node.getData());
            printAscending(node.getRight());
        }
    }




}
