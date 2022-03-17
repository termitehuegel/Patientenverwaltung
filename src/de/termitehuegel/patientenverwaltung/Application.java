package de.termitehuegel.patientenverwaltung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Application {
    ArrayList<Patient> list = new ArrayList<>();
    int selected = 0;
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

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.add(new Patient(nameTextField.getText(), firstNameTextField.getText(), (String) bloodGroupComboBox.getSelectedItem(), birthdayTextField.getText(), streetTextField.getText(), plzTextField.getText()));
                clear();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.remove(selected);
                clear();
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = (selected+1)%list.size();
                update();
            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected--;
                if (selected < 0) {
                    selected = list.size()-1;
                }
                update();
            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Patient patient = list.get(selected);
                patient.setName(nameTextField.getText());
                patient.setFirstName(firstNameTextField.getText());
                patient.setBirthday(birthdayTextField.getText());
                patient.setPlz(plzTextField.getText());
                patient.setStreet(streetTextField.getText());
                patient.setBloodGroup((String) bloodGroupComboBox.getSelectedItem());
            }
        });
    }


    private void update() {
        nameTextField.setText(list.get(selected).getName());
        firstNameTextField.setText(list.get(selected).getFirstName());
        birthdayTextField.setText(list.get(selected).getBirthday());
        streetTextField.setText(list.get(selected).getStreet());
        plzTextField.setText(list.get(selected).getPlz());
        bloodGroupComboBox.setSelectedItem(list.get(selected).getBloodGroup());
    }

    private void clear() {
        nameTextField.setText("");
        firstNameTextField.setText("");
        birthdayTextField.setText("");
        streetTextField.setText("");
        plzTextField.setText("");
        bloodGroupComboBox.setSelectedIndex(0);
    }
}
