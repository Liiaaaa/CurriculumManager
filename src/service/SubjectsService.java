package service;

import database.CurriculumDAO;
import model.Course;
import model.Degree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectsService {
    private CurriculumDAO curriculumDAO;

    public SubjectsService(CurriculumDAO curriculumReader){
        this.curriculumDAO = curriculumReader;
    }

    public Map<String, List<Course>> getSubjectsByTerm(Degree degree){

        // Get curriculum / list of courses base on the degree
        //
        List<Course> courses = this.curriculumDAO.getCurriculum(degree);

        //
        //
        Map<String, List<Course>> termToCoursesMap = new HashMap<>();
        for(Course c: courses){


            // Check if the list of courses is already existing
            // Create if not existing
            //
            String key = Utility.generateTermKey(c.getYear(), c.getSemester());
            List<Course> coursesPerTerm = termToCoursesMap.get(key);
            if(coursesPerTerm == null) {
                List<Course> newList = new ArrayList<>();
                newList.add(c);
                termToCoursesMap.put(key,newList);
                continue;
            }

            // Simply add to the list if already existing
            termToCoursesMap.get(key).add(c);

        }
        return termToCoursesMap;
    }

    public void showByTermWithGrades(){

    }


}
