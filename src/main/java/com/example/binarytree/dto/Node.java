package com.example.binarytree.dto;

import lombok.Data;




@Data
public  class Node<T>  {

    private Integer data;
    private Node left;
    private Node right;


    public Node(){
    }

    public Node(Integer data){
        this.data = data;
    }


    public Node(Integer data, Node left, Node right){
        this.data = data;
        this.left=left;
        this.right=right;
    }

    public Boolean hasLeft(){
        return this.left!=null;
    }

    public Boolean hasRight(){
        return this.right!=null;
    }

}

