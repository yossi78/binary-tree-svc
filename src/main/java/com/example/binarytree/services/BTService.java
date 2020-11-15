package com.example.binarytree.services;


import com.example.binarytree.dto.BinaryInput;
import com.example.binarytree.dto.Node;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Data
public class BTService {


    private BinaryTree  binaryTree;

    @Autowired
    public BTService(BinaryTree  binaryTree){
        this.binaryTree=binaryTree;
    }


    public String addNodes(BinaryInput binaryInput) {
        return binaryTree.addNodes(binaryInput);
    }

    public String getPrtintableTree() {
        return binaryTree.getPrintableTree();
    }


    public void printAscending() {
        binaryTree.printAscending(binaryTree.getHead());
    }

    public Boolean removeTree() {
        return binaryTree.removeTree();

    }
}
