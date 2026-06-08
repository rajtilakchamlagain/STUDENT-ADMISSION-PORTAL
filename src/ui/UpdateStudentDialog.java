package ui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;

public class UpdateStudentDialog extends JFrame {

    private JTextField txtName;
    private JTextField txtAge;

    private JComboBox<String> genderBox;
    private JTextField txtCollege;

    private JComboBox<String> branchBox;
    private JComboBox<String> semesterBox;

    private JButton btnUpdate;

    private String studentId;

    public UpdateStudentDialog(String id) {

        studentId = id;

        setTitle("Update Student");

        setSize(500,500);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(7,2,10,10));

        txtName = new JTextField();

        txtAge = new JTextField();

        genderBox =
                new JComboBox<>(new String[]{
                        "Male",
                        "Female"
                });

        txtCollege =
                new JTextField();

        branchBox =
                new JComboBox<>(new String[]{
                        "Computer Science Engineering (CSE)",
                        "Mechanical Engineering",
                        "Civil Engineering",
                        "Electrical Engineering"
                });

        semesterBox =
                new JComboBox<>(new String[]{
                        "1st Semester",
                        "2nd Semester",
                        "3rd Semester",
                        "4th Semester",
                        "5th Semester",
                        "6th Semester",
                        "7th Semester",
                        "8th Semester"
                });

        btnUpdate =
                new JButton("Update");

        add(new JLabel("Name"));
        add(txtName);

        add(new JLabel("Age"));
        add(txtAge);

        add(new JLabel("Gender"));
        add(genderBox);

        add(new JLabel("College"));
        add(txtCollege);

        add(new JLabel("Branch"));
        add(branchBox);

        add(new JLabel("Semester"));
        add(semesterBox);

        add(new JLabel());
        add(btnUpdate);

        loadStudent();

        btnUpdate.addActionListener(
                e -> updateStudent());

        setVisible(true);
    }

    private void loadStudent() {

        StudentDAO dao =
                new StudentDAO();

        Student s =
                dao.getStudentById(studentId);

        if(s != null) {

            txtName.setText(
                    s.getFullName());

            txtAge.setText(
                    String.valueOf(s.getAge()));

            genderBox.setSelectedItem(
                    s.getGender());

            txtCollege.setText(
                    s.getCollege());

            branchBox.setSelectedItem(
                    s.getBranch());

            semesterBox.setSelectedItem(
                    s.getSemester());
        }
    }

    private void updateStudent() {

        Student s = new Student();

        s.setStudentId(studentId);

        s.setFullName(txtName.getText());

        s.setAge(
                Integer.parseInt(
                        txtAge.getText()));

        s.setGender(
                genderBox.getSelectedItem()
                        .toString());

        s.setCollege(
                txtCollege.getText());

        s.setBranch(
                branchBox.getSelectedItem()
                        .toString());

        s.setSemester(
                semesterBox.getSelectedItem()
                        .toString());

        StudentDAO dao =
                new StudentDAO();

        if(dao.updateStudent(s)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Updated Successfully");

            dispose();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Update Failed");
        }
    }
}