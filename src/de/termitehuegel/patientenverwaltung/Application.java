package de.termitehuegel.patientenverwaltung;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    ArrayList<Patient> list = new ArrayList<>();
    private JButton submit;
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel bloodGroupLabel;
    private JComboBox<String> bloodGroupComboBox;
    private JLabel birthdateLabel;
    private JTextField birthdayTextField;
    private JLabel streetLabel;
    private JTextField streetTextField;
    private JTextField plzTextField;
    private JLabel plzLabel;
    private JButton removeButton;
    private JButton nextButton;
    private JButton previousButton;
    private JButton editButton;
    private JTabbedPane tabbedPane;
    private JTable patientsJTable;
    private JPanel newJPanel;
    private JScrollPane patientsJScollPane;

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Patientenverwaltung");
        frame.setContentPane(new Application().mainPanel);
        frame.setMinimumSize(new Dimension(640, 360));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public Application() {
        bloodGroupComboBox.addItem("A");
        bloodGroupComboBox.addItem("B");
        bloodGroupComboBox.addItem("AB");
        bloodGroupComboBox.addItem("0");

        DefaultTableModel model = new DefaultTableModel(null, new Object[]{"Name", "Vorname", "Blutgruppe", "Gebrutstag", "Straße", "Postleitzahl"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        patientsJTable.setModel(model);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(new Patient(nameTextField.getText(), firstNameTextField.getText(), (String) bloodGroupComboBox.getSelectedItem(), birthdayTextField.getText(), streetTextField.getText(), plzTextField.getText()));
                clear();
                update();
            }
        });
        patientsJTable.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == 8 || e.getKeyCode() == 127) {
                    int[] selected = patientsJTable.getSelectedRows();
                    for (int i=selected.length-1; i>=0; i--) {
                        list.remove(selected[i]);
                    }
                    update();
                }
            }
        });
    }


    private void update() {
        DefaultTableModel model = (DefaultTableModel) patientsJTable.getModel();
        model.setRowCount(0);
        list.forEach((x) -> model.addRow(x.toStringArray()));
    }

    private void clear() {
        nameTextField.setText("");
        firstNameTextField.setText("");
        birthdayTextField.setText("");
        streetTextField.setText("");
        plzTextField.setText("");
    }
}
