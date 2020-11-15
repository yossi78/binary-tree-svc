package com.example.binarytree.dto;


import lombok.Data;
import java.util.List;




@Data
public class BinaryInput {

    private List<Integer> numbers;

    public BinaryInput(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public BinaryInput() {
    }




}
