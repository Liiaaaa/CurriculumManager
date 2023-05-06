// This class

package service;

import model.Degree;

import java.util.HashMap;
import java.util.Map;

public class Utility {

    private static Map<Degree, String> degreeToCurriculumMap = new HashMap<>();
    static {
        degreeToCurriculumMap.put(Degree.BSCS, "C:\\FinalsGroupproject1\\src\\resources\\BSCS_CURRICULUM.csv");
        degreeToCurriculumMap.put(Degree.BSIT, "C:\\FinalsGroupproject1\\src\\resources\\BSIT_CURRICULUM.csv");
    }


    // Generates a key given a year and semester
    public static String generateTermKey(int year, String semester) {
        return year+"-"+ semester;
    }

    // Returns the corresponding filename given a degree
    public static String getCurriculumFile(Degree degree) {
        return degreeToCurriculumMap.get(degree);
    }
}
