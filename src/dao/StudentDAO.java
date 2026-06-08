package dao;

import database.DBConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAO {

    // ADD STUDENT
    public boolean addStudent(Student student) {

        try {

            Connection con = DBConnection.getConnection();

            String sql =
                    "INSERT INTO students VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, student.getStudentId());
            ps.setString(2, student.getFullName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getCollege());
            ps.setString(6, student.getBranch());
            ps.setString(7, student.getSemester());

            int rows = ps.executeUpdate();

            PreparedStatement seat =
                    con.prepareStatement(
                            "UPDATE branches SET available_seats = available_seats - 1 WHERE branch_name=?");

            seat.setString(1, student.getBranch());

            seat.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // VIEW ALL STUDENTS
    public ArrayList<Student> getAllStudents() {

        ArrayList<Student> list =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            Statement st =
                    con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM students");

            while (rs.next()) {

                Student s =
                        new Student();

                s.setStudentId(
                        rs.getString("student_id"));

                s.setFullName(
                        rs.getString("full_name"));

                s.setAge(
                        rs.getInt("age"));

                s.setGender(
                        rs.getString("gender"));

                s.setCollege(
                        rs.getString("college"));

                s.setBranch(
                        rs.getString("branch"));

                s.setSemester(
                        rs.getString("semester"));

                list.add(s);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }

    // DELETE STUDENT
    public boolean deleteStudent(String id) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String branch = "";

            PreparedStatement find =
                    con.prepareStatement(
                            "SELECT branch FROM students WHERE student_id=?");

            find.setString(1, id);

            ResultSet rs =
                    find.executeQuery();

            if (rs.next()) {

                branch =
                        rs.getString("branch");
            }

            PreparedStatement delete =
                    con.prepareStatement(
                            "DELETE FROM students WHERE student_id=?");

            delete.setString(1, id);

            int rows =
                    delete.executeUpdate();

            PreparedStatement seat =
                    con.prepareStatement(
                            "UPDATE branches SET available_seats = available_seats + 1 WHERE branch_name=?");

            seat.setString(1, branch);

            seat.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    // GET ONE STUDENT
    public Student getStudentById(String id) {

        Student s = null;

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT * FROM students WHERE student_id=?");

            ps.setString(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                s = new Student();

                s.setStudentId(
                        rs.getString("student_id"));

                s.setFullName(
                        rs.getString("full_name"));

                s.setAge(
                        rs.getInt("age"));

                s.setGender(
                        rs.getString("gender"));

                s.setCollege(
                        rs.getString("college"));

                s.setBranch(
                        rs.getString("branch"));

                s.setSemester(
                        rs.getString("semester"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return s;
    }

    // UPDATE STUDENT
    public boolean updateStudent(Student s) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String sql =
                    "UPDATE students SET full_name=?,age=?,gender=?,college=?,branch=?,semester=? WHERE student_id=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, s.getFullName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getGender());
            ps.setString(4, s.getCollege());
            ps.setString(5, s.getBranch());
            ps.setString(6, s.getSemester());
            ps.setString(7, s.getStudentId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}