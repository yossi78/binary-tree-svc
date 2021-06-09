package com.example.binarytree.api;


import com.example.binarytree.dto.BinaryInput;
import com.example.binarytree.services.BTService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/v1/binary")
public class BinaryController {

    private static final Logger logger = LoggerFactory.getLogger(BinaryController.class);
    private BTService btService;


    @Autowired
    public BinaryController(BTService btService){
        this.btService = btService;
    }


    @PostMapping
    public ResponseEntity addNodes(@RequestBody BinaryInput binaryInput) {
        try {
            String result= btService.addNodes(binaryInput);
            logger.info("Nodes have been added to Binary Tree successfully\n" + result);
            return new ResponseEntity(result,HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Failed to add new Noded to Binary Treee",e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @GetMapping
    public ResponseEntity getBinaryTree() {
        try {
            String result=btService.getPrtintableTree();
            System.out.println(result);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            logger.error("Failed to get Prtintable Tree",e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






    @DeleteMapping
    public ResponseEntity deleteTree() {
        try {
            logger.info("Delete Binary Tree");
            Boolean isRemoved = btService.removeTree();
            if(!isRemoved){
                logger.warn("The Binary Tree has not been deleted");
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            logger.error("Failed to delete human",e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @GetMapping(value = "/health")
    public ResponseEntity healthCheck() {
        try {
            return new ResponseEntity("Binay Service Health is OK", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
