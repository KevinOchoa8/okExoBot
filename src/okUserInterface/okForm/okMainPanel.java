package okUserInterface.okForm;

import javax.swing.JButton;
import javax.swing.JPanel;

public class okMainPanel extends JPanel{

    public JButton btnHome;
    public JButton btnLogin;
    public JButton btnSexo;
    public JButton btnLocalidad;
    public JButton btnTest;

    public okMainPanel() {
        btnHome = new JButton("Home");
        btnLogin = new JButton("Login");
        btnSexo = new JButton("Sexo");
        btnLocalidad = new JButton("Localidad");
        btnTest = new JButton("Test");

        // Add buttons to the panel
        add(btnHome);
        add(btnLogin);
        add(btnSexo);
        add(btnLocalidad);
        add(btnTest);
    }

}
