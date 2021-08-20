package com.sparta.cmy.cvsproject.reader.writer;

import com.sparta.cmy.cvsproject.reader.dto.EmployeesDTO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CvsFilerWriter {

    public static void writeToFile(String filename, EmployeesDTO employeesDTO, String type){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
