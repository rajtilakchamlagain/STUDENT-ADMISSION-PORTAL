package ui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;

public class NewAdmissionPanel extends JPanel {

    private JTextField txtId;
    private JTextField txtName;
    private JTextField txtAge;

    private JComboBox<String> genderBox;
    private JComboBox<String> collegeBox;
    private JComboBox<String> branchBox;
    private JComboBox<String> semesterBox;

    private JButton btnAdmit;
    private JButton btnClear;

    public NewAdmissionPanel() {

        setLayout(null);

        JLabel title =
                new JLabel("Student Admission Form");

        title.setFont(
                new Font("Arial",
                        Font.BOLD,
                        24));

        title.setBounds(330, 20, 350, 30);

        add(title);

        int labelX = 120;
        int fieldX = 320;

        JLabel lblId =
                new JLabel("Student ID:");

        lblId.setBounds(labelX, 100, 150, 30);

        txtId =
                new JTextField();

        txtId.setBounds(fieldX, 100, 300, 30);

        add(lblId);
        add(txtId);

        JLabel lblName =
                new JLabel("Full Name:");

        lblName.setBounds(labelX, 150, 150, 30);

        txtName =
                new JTextField();

        txtName.setBounds(fieldX, 150, 300, 30);

        add(lblName);
        add(txtName);

        JLabel lblAge =
                new JLabel("Age:");

        lblAge.setBounds(labelX, 200, 150, 30);

        txtAge =
                new JTextField();

        txtAge.setBounds(fieldX, 200, 300, 30);

        add(lblAge);
        add(txtAge);

        JLabel lblGender =
                new JLabel("Gender:");

        lblGender.setBounds(labelX, 250, 150, 30);

        genderBox =
                new JComboBox<>(new String[]{
                        "Male",
                        "Female"
                });

        genderBox.setBounds(fieldX, 250, 300, 30);

        add(lblGender);
        add(genderBox);

        JLabel lblCollege =
                new JLabel("College:");

        lblCollege.setBounds(labelX, 300, 150, 30);

        collegeBox =
                new JComboBox<>(new String[]{
                        "AEC - Assam Engineering College"
                });

        collegeBox.setBounds(fieldX, 300, 300, 30);

        add(lblCollege);
        add(collegeBox);

        JLabel lblBranch =
                new JLabel("Branch:");

        lblBranch.setBounds(labelX, 350, 150, 30);

        branchBox =
                new JComboBox<>(new String[]{
                        "Computer Science Engineering (CSE)",
                        "Mechanical Engineering",
                        "Civil Engineering",
                        "Electrical Engineering"
                });

        branchBox.setBounds(fieldX, 350, 300, 30);

        add(lblBranch);
        add(branchBox);

        JLabel lblSemester =
                new JLabel("Admission Semester:");

        lblSemester.setBounds(labelX, 400, 150, 30);

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

        semesterBox.setBounds(fieldX, 400, 300, 30);

        add(lblSemester);
        add(semesterBox);

        btnAdmit =
                new JButton("Admit Student");

        btnAdmit.setBounds(280, 500, 180, 40);

        btnClear =
                new JButton("Clear Form");

        btnClear.setBounds(500, 500, 180, 40);

        add(btnAdmit);
        add(btnClear);

        btnAdmit.addActionListener(
                e -> saveStudent());

        btnClear.addActionListener(
                e -> clearForm());
    }

    private void saveStudent() {

        try {

            Student s =
                    new Student();

            s.setStudentId(
                    txtId.getText());

            s.setFullName(
                    txtName.getText());

            s.setAge(
                    Integer.parseInt(
                            txtAge.getText()));

            s.setGender(
                    genderBox.getSelectedItem()
                            .toString());

            s.setCollege(
                    collegeBox.getSelectedItem()
                            .toString());

            s.setBranch(
                    branchBox.getSelectedItem()
                            .toString());

            s.setSemester(
                    semesterBox.getSelectedItem()
                            .toString());

            StudentDAO dao =
                    new StudentDAO();

            if (dao.addStudent(s)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Student Admitted Successfully");

                clearForm();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Admission Failed");
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage());
        }
    }

    private void clearForm() {

        txtId.setText("");
        txtName.setText("");
        txtAge.setText("");

        genderBox.setSelectedIndex(0);
        collegeBox.setSelectedIndex(0);
        branchBox.setSelectedIndex(0);
        semesterBox.setSelectedIndex(0);
    }
}