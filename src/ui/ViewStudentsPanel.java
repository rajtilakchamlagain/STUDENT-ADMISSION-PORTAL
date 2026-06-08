package ui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ViewStudentsPanel extends JPanel {

    private JTable table;
    private DefaultTableModel model;

    private JButton btnRefresh;
    private JButton btnDelete;
    private JButton btnUpdate;

    public ViewStudentsPanel() {

        setLayout(new BorderLayout());

        model = new DefaultTableModel();

        model.addColumn("Student ID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("Gender");
        model.addColumn("College");
        model.addColumn("Branch");
        model.addColumn("Semester");

        table = new JTable(model);

        JPanel topPanel = new JPanel();

        btnRefresh = new JButton("Refresh");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        topPanel.add(btnRefresh);
        topPanel.add(btnUpdate);
        topPanel.add(btnDelete);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnRefresh.addActionListener(e -> loadStudents());

        btnDelete.addActionListener(e -> deleteStudent());

        btnUpdate.addActionListener(e -> updateStudent());

        loadStudents();
    }

    private void loadStudents() {

        model.setRowCount(0);

        StudentDAO dao = new StudentDAO();

        ArrayList<Student> students =
                dao.getAllStudents();

        for(Student s : students) {

            model.addRow(new Object[]{

                    s.getStudentId(),
                    s.getFullName(),
                    s.getAge(),
                    s.getGender(),
                    s.getCollege(),
                    s.getBranch(),
                    s.getSemester()
            });
        }
    }

    private void deleteStudent() {

        int row = table.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a student first");

            return;
        }

        String id =
                model.getValueAt(row,0)
                        .toString();

        StudentDAO dao =
                new StudentDAO();

        if(dao.deleteStudent(id)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Student Deleted");

            loadStudents();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Delete Failed");
        }
    }

    private void updateStudent() {

        int row = table.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a student first");

            return;
        }

        String id =
                model.getValueAt(row,0)
                        .toString();

        new UpdateStudentDialog(id);

        loadStudents();
    }
}