package model;

import java.util.Objects;

public class Course {
    private int year;
    private String semester;
    private String id; //This is the course number
    private String description;
    private double units;
    private String prerequisite;

    public Course(
        int year,
        String semester,
        String id,
        String description,
        double units,
        String prerequisite
    ) {
        this.year = year;
        this.semester = semester;
        this.id = id;
        this.description = description;
        this.units = units;
        this.prerequisite = prerequisite;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnits() {
        return units;
    }

    public void setUnits(double units) {
        this.units = units;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(String prerequisite) {
        this.prerequisite = prerequisite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return year == course.year && semester == course.semester && units == course.units && id.equals(course.id) && Objects.equals(description, course.description) && Objects.equals(prerequisite, course.prerequisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, semester, id, description, units, prerequisite);
    }

    @Override
    public String toString() {
        return "["+this.year + " - " + this.semester+ " - "+ this.id+ " - " + this.description+
                " - " + this.units+" - Prerequisite: " + this.prerequisite + "]";
    }
}
