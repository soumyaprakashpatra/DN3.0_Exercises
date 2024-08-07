//This is the model class that represents the student data with attributes like `name`, `id`, and `grade`.
//It has getter and setter methods for each attribute.

public class Student {
    private String id;
    private String name;
    private String grade;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}
