import model.Course;
import model.Degree;
import database.CurriculumDAOImpl;
import service.SubjectsService;

import java.util.List;
import java.util.Map;

public class Tester {
    public static void main(String[] args) {
        CurriculumDAOImpl curriculumReader = new CurriculumDAOImpl();
        SubjectsService subjectsService = new SubjectsService(curriculumReader);

        Map<String, List<Course>> termToSubjects = subjectsService.getSubjectsByTerm(Degree.BSCS);


        System.out.println(termToSubjects.get("3-2ND"));
        System.out.println(termToSubjects.get("0-ELECTIVE"));



    }
}