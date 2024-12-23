package com.ustb.hospital;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ustb.hospital.entity.Departments;

import java.util.ArrayList;

public class JsonTest {
    public static void main(String[] args) throws JsonProcessingException {
        Departments dept =new Departments();
        dept.setDepartmentName("testJson");
        System.out.println(dept);

        ObjectMapper objectMapper =new ObjectMapper();

        String s = objectMapper.writeValueAsString(dept);
        System.out.println(s);
        ArrayList<Departments> list = new ArrayList<>();
        list.add(dept);
        String s1 = objectMapper.writeValueAsString(list);
        System.out.println(s1);
    }
}
