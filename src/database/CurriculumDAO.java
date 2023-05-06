package database;

import model.Course;
import model.Degree;

import java.util.List;

public interface CurriculumDAO {
    public List<Course> getCurriculum(Degree degree);

}
