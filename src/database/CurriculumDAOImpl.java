// A class that


package database;

import model.Course;
import model.Degree;
import service.Utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CurriculumDAOImpl implements CurriculumDAO {

    //cache
    private Map<Degree, List<Course>> degreeToCurriculumMap = new HashMap<>();

    @Override
    public List<Course> getCurriculum(Degree degree) {

        // Return previously read curriculum
        //
        List<Course> courses = degreeToCurriculumMap.get(degree);
        if (courses != null) {
            return courses;
        }
        courses = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(Utility.getCurriculumFile(degree)));
            int lineNumber = 1;
            while (true){

                // Skip headers
                //
                String line = reader.readLine();
                if (lineNumber == 1) {
                    lineNumber++;
                    continue;
                }

                // Nothing read
                //
                if (line == null) {
                    break;
                }


                // Parse into course
                //
                String[] columns = line.split("\t");
                int year = Integer.parseInt(columns[0]);
                String semester = columns[1];
                String id = columns[2];
                String description = columns[3];
                double units = Double.parseDouble(columns[4]);


                // TODO: can be refactored
                //
                String prerequisite = "";
                if (columns.length == 6) {
                    prerequisite = columns[5];
                }
                else {
                    prerequisite = "N/A";
                }

                Course course = new Course(year,semester,id,description,units, prerequisite);

                // Add created course to list
                //
                courses.add(course);
                lineNumber++;
            }

            // store curriculum for future calls
            //
            degreeToCurriculumMap.put(degree, courses);
            reader.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("Data file read error.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }
}
