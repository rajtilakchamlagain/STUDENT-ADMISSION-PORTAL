package model;

public class Student {

    private String studentId;
    private String fullName;
    private int age;
    private String gender;
    private String college;
    private String branch;
    private String semester;

    public Student() {
    }

    public Student(String studentId,
                   String fullName,
                   int age,
                   String gender,
                   String college,
                   String branch,
                   String semester) {

        this.studentId = studentId;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.college = college;
        this.branch = branch;
        this.semester = semester;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}