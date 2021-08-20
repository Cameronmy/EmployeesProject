package com.sparta.cmy.cvsproject.reader.util;

import java.text.SimpleDateFormat;


public class DataValidation {

    private static int NumberOfCols = 10;

    public static boolean isRecValid(String[] employeeRecord) {
        return (employeeRecord.length == NumberOfCols &&
                isEmpIdVal(employeeRecord[0]) &&
                isNamePrefixVal(employeeRecord[1]) &&
                isFirstNameVal(employeeRecord[2]) &&
                isMidInitialVal(employeeRecord[3]) &&
                isLastNameVal(employeeRecord[4])  &&
                isGenderVal(employeeRecord[5]) &&
                isEmailVal(employeeRecord[6]) &&
                isDobVal(employeeRecord[7]) &&
                isJoinDateVal(employeeRecord[8]) &&
                isSalaryVal(employeeRecord[9]));
    }

    private static boolean isEmpIdVal(String empID) {
        try {
            Integer.parseInt(empID);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static boolean isNamePrefixVal(String namePrefix) {
        String[] titles = new String[]{"Mrs.", "Mr.", "Ms.", "Dr.", "Hon.", "Prof.", "Drs."};
        for (String nameTitle : titles) {
            if (nameTitle.equals(namePrefix)) return true;
        }
        return false;
    }

    private static boolean isFirstNameVal(String fName) {
        return (fName.matches("^[a-zA-z ]*$"));
    }

    private static boolean isMidInitialVal(String middleInitial) {
        return (middleInitial.matches("[A-Z]") || middleInitial.length() != 1);
    }

    private static boolean isLastNameVal(String lName) {
        return (lName.matches("^[a-zA-z ]*$"));
    }

    private static boolean isGenderVal(String gender) {
        return gender.equalsIgnoreCase("F") || gender.equalsIgnoreCase("M");
    }

    private static boolean isEmailVal(String email) {
        return email.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$");
    }

    private static boolean isDobVal(String dob) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            dateFormat.parse(dob);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean isJoinDateVal(String joinDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            dateFormat.parse(joinDate);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static boolean isSalaryVal(String salary) {
        try {
            Integer.parseInt(salary);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
