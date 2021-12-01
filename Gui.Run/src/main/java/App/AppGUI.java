package App;


import CoreInterfaces.HW4;
import GUIInterface.UserInterfaceGUI;

import java.awt.*;

public class AppGUI implements HW4 {
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