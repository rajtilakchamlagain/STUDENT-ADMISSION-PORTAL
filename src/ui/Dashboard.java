package ui;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {

        setTitle("Student Admission System");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab(
                "New Admission",
                new NewAdmissionPanel());

        tabbedPane.addTab(
                "View Students",
                new ViewStudentsPanel());

        add(tabbedPane, BorderLayout.CENTER);
    }
}