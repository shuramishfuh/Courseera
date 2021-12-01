package GUIInterface;

import CoreInterfaces.Course;
import Implementations.IMCourSeeraFactory;
import Implementations.IMInstructor;
import Implementations.IMRoom;
import Implementations.Initializer;
import CoreInterfaces.CourSeera;
import CoreInterfaces.CourSeeraFactory;
import CoreInterfaces.Schedule;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserInterfaceGUI extends JFrame {

    private final JPanel panel = new JPanel();
    private JPanel contentPane;
    private JTextField textField;
    private JTextField txtDdmmyy;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Create the frame.
     */
    public UserInterfaceGUI() {
        Initializer initializer = new Initializer("\\Core.Implementation\\src\\Data\\", "https://www-banner.aub.edu.lb/catalog/schd_");
        List<Course> courses = new ArrayList<Course>();
        initializer.listGenerator(courses);
        CourSeeraFactory csf = new IMCourSeeraFactory();
        CourSeera CS = csf.createInstance(courses);

        setTitle("CourSeera: Your everyday tool for AUB courses");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.BLUE);
        setBounds(100, 100, 1121, 526);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Please choose an option from the dropdown menu");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(10, 95, 330, 28);
        contentPane.add(lblNewLabel);

        String[] choices = {"CourSeera Options",
                "Room Schedule",
                "Who Was There Last?",
                "Who Is There Now?",
                "Professor's Schedule",
                "Where Is Professor",
                "Where Will Professor Be"
        };
        String[] days = {"Days Of The Week",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        };

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 89, 318, 182);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1_1 = new JLabel("Optional Options:");
        lblNewLabel_1_1.setBounds(6, 11, 111, 19);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_1.add(lblNewLabel_1_1);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Specific Date (format: dd/mm/yy)");

        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnNewRadioButton.setBounds(6, 37, 254, 23);
        panel_1.add(rdbtnNewRadioButton);

        JRadioButton rdbtnDayOfThe = new JRadioButton("Day Of The Week");
        rdbtnDayOfThe.setFont(new Font("Tahoma", Font.PLAIN, 13));
        rdbtnDayOfThe.setBounds(6, 63, 148, 23);
        panel_1.add(rdbtnDayOfThe);


        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(rdbtnDayOfThe);
        btnGroup.add(rdbtnNewRadioButton);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(6, 85, 318, 54);
        panel_1.add(panel_3);
        panel_3.setLayout(null);

        txtDdmmyy = new JTextField();
        txtDdmmyy.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtDdmmyy.setToolTipText("dd/mm/yy");
        txtDdmmyy.setBounds(10, 11, 75, 28);
        panel_3.add(txtDdmmyy);
        txtDdmmyy.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setToolTipText("dd/mm/yy");
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_1.setColumns(10);
        textField_1.setBounds(108, 11, 75, 28);
        panel_3.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setToolTipText("dd/mm/yy");
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField_2.setColumns(10);
        textField_2.setBounds(203, 11, 75, 28);
        panel_3.add(textField_2);

        JLabel lblNewLabel_2 = new JLabel("/");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(95, 10, 13, 28);
        panel_3.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("/");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2_1.setBounds(193, 11, 13, 28);
        panel_3.add(lblNewLabel_2_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(6, 85, 302, 46);
        panel_1.add(panel_2);
        panel_2.setLayout(null);

        JComboBox comboBox_1 = new JComboBox(days);
        comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        comboBox_1.setBounds(0, 11, 171, 22);
        panel_2.add(comboBox_1);
        panel_2.setVisible(false);

        JLabel lblNewLabel_1 = new JLabel("Enter Room Name");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(0, 11, 298, 28);
        panel.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBounds(0, 50, 286, 28);
        textField.setColumns(10);
        panel.add(textField);

        panel_1.setVisible(false);
        panel.setVisible(false);
        panel_3.setVisible(false);

        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNewRadioButton.isSelected()) {
                    panel_2.setVisible(false);
                    panel_3.setVisible(true);
                }
            }
        });
        rdbtnDayOfThe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnDayOfThe.isSelected()) {
                    panel_2.setVisible(true);
                    panel_3.setVisible(false);
                }
            }
        });

        JComboBox comboBox = new JComboBox(choices);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedIndex() == 0) {
                    panel.setVisible(false);
                }
                if (comboBox.getSelectedIndex() == 1) {
                    lblNewLabel_1.setText("Enter Room Name");
                    panel.setVisible(true);
                    panel_1.setVisible(true);
                }
                if (comboBox.getSelectedIndex() == 2) {
                    lblNewLabel_1.setText("Enter Room Name");
                    panel.setVisible(true);
                    panel_1.setVisible(false);
                }
                if (comboBox.getSelectedIndex() == 3) {
                    lblNewLabel_1.setText("Enter Room Name");
                    panel.setVisible(true);
                    panel_1.setVisible(false);
                }
                if (comboBox.getSelectedIndex() == 4) {
                    lblNewLabel_1.setText("Enter Professor Name");
                    panel.setVisible(true);
                    panel_1.setVisible(false);
                }
                if (comboBox.getSelectedIndex() == 5) {
                    lblNewLabel_1.setText("Enter Professor Name");
                    panel.setVisible(true);
                    panel_1.setVisible(false);
                }
                if (comboBox.getSelectedIndex() == 6) {
                    lblNewLabel_1.setText("Enter Professor Name");
                    panel.setVisible(true);
                    panel_1.setVisible(false);
                }
            }
        });
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox.setToolTipText("CourSeera Options...");
        comboBox.setBounds(10, 134, 327, 22);
        contentPane.add(comboBox);
        panel.setBounds(10, 189, 318, 253);
        contentPane.add(panel);
        panel.setLayout(null);
        JTextArea textArea = new JTextArea(22, 57);
        JScrollPane taScroll = new JScrollPane(textArea);
        taScroll.setLocation(400, 20);
        taScroll.setSize(680, 450);
        contentPane.add(taScroll);
        textArea.setFont(new Font("Calibri", Font.BOLD, 15));

        textArea.setEditable(false);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (comboBox.getSelectedIndex() == 0) {

                    }
                    if (comboBox.getSelectedIndex() == 1) {

                        String[] room = textField.getText().split(" ");
                        IMRoom r = new IMRoom(room[0], room[1]);
                        List<Schedule> sc;
                        if (rdbtnNewRadioButton.isSelected()) {

                            LocalDate date = LocalDate.parse(textField_2.getText() + "-" + textField_1.getText() + "-" + txtDdmmyy.getText());

                            sc = CS.roomSchedule(r, date);
                        } else if (rdbtnDayOfThe.isSelected()) {
                            sc = CS.roomSchedule(r, DayOfWeek.values()[comboBox_1.getSelectedIndex() - 1]);
                        } else {
                            sc = CS.roomSchedule(r);
                        }

                        String line = "";
                        for (Schedule s : sc) {
                            line += "\n" + s.getInstructor() + " " + s.getCourse() + " " + s.getFromTime() + " " + s.getToTime() + " " + s.getRoom() + " " + s.getDay() + " \n";

                        }
                        textArea.setText(line);

                    }
                    if (comboBox.getSelectedIndex() == 2) {

                        String[] room = textField.getText().split(" ");
                        IMRoom r = new IMRoom(room[0], room[1]);
                        Schedule sc = CS.whoWasThereLast(r);
                        textArea.setText(sc.getInstructor() + " " + sc.getCourse());
                    }
                    if (comboBox.getSelectedIndex() == 3) {
                        String[] room = textField.getText().split(" ");
                        IMRoom r = new IMRoom(room[0], room[1]);
                        Schedule sc = CS.whoIsThereNow(r);
                        textArea.setText(sc.getInstructor() + " " + sc.getCourse());
                    }
                    if (comboBox.getSelectedIndex() == 4) {
                        String[] prof = textField.getText().split(" ");
                        IMInstructor inst = new IMInstructor(prof[0], prof[1]);
                        List<Schedule> lsc = CS.profSchedule(inst);
                        String line = "";
                        for (Schedule s : lsc) {
                            line += "\n" + s.getInstructor() + " " + s.getCourse() + " " + s.getFromTime() + " " + s.getToTime() + " " + s.getRoom() + " " + s.getDay() + " \n";

                        }
                        textArea.setText(line);

                    }
                    if (comboBox.getSelectedIndex() == 5) {
                        String[] prof = textField.getText().split(" ");
                        IMInstructor inst = new IMInstructor(prof[0], prof[1]);
                        Schedule sc = CS.whereIsProf(inst);
                        textArea.setText(sc.getRoom());
                    }
                    if (comboBox.getSelectedIndex() == 6) {
                        String[] prof = textField.getText().split(" ");
                        IMInstructor inst = new IMInstructor(prof[0], prof[1]);
                        List<Schedule> lsc = CS.whereWillProfBe(inst);
                        String line = "";
                        for (Schedule s : lsc) {
                            line += s.getInstructor() + " " + s.getCourse() + " " + s.getFromTime() + " " + s.getToTime() + " " + s.getRoom() + " " + s.getDay() + " \n";

                        }
                        textArea.setText(line);
                    }
                } catch (Exception eee) {
                    textArea.setText("\n\nThere Was Something Wrong In Your Input! \n \n Please Try Again :)");
                }

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(91, 453, 144, 23);
        contentPane.add(btnNewButton);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserInterfaceGUI frame = new UserInterfaceGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
