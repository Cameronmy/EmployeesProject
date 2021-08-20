package com.sparta.cmy.cvsproject.reader.reader;

import com.sparta.cmy.cvsproject.reader.dto.EmployeesDTO;
import com.sparta.cmy.cvsproject.reader.util.DataValidation;
import com.sparta.cmy.cvsproject.reader.writer.CvsFilerWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class CsvFilerReader {

    private static final HashMap<String, EmployeesDTO> employeesRec = new HashMap<>();

    public static void readFromFile(String filename) {

        HashMap<String, EmployeesDTO> employeesRec = new HashMap<>();

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                popHash(line);
                //System.out.println(Arrays.toString(line.split(",")));

                //Arrays.stream(new String[]{line}).distinct().toArray();

                System.out.println(line);
            }
            bufferedReader.close();


        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("file not found");
        }
    }


    private static void popHash(String line) {
        String[] empRow = line.split(",");
        EmployeesDTO employeesDTO = new EmployeesDTO(empRow);

        if (DataValidation.isRecValid(empRow)) {

            if (!employeesRec.containsKey(empRow[0])) {
                employeesRec.put(empRow[0], employeesDTO);
            } else {
                CvsFilerWriter.writeToFile("C:\\Users\\Cameron\\IdeaProjects\\FileIO\\src\\main\\resources\\dupValues.csv", employeesDTO, "duplicate");
            }
        } else {
            CvsFilerWriter.writeToFile("C:\\Users\\Cameron\\IdeaProjects\\FileIO\\src\\main\\resources\\invalidValues.csv", employeesDTO, "invalid");
        }
    }
}





