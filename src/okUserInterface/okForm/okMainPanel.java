package okUserInterface.okForm;

import javax.swing.JButton;
import javax.swing.JPanel;

public class okMainPanel extends JPanel{

    public JButton okbtnHome;
    public JButton okbtnLogin;
    public JButton okbtnSexo;
    public JButton okbtnLocalidad;
    public JButton okbtnTest;

    public okMainPanel() {
        okbtnHome = new JButton("Home");
        okbtnLogin = new JButton("Login");
        okbtnSexo = new JButton("Sexo");
        okbtnLocalidad = new JButton("Localidad");
        okbtnTest = new JButton("Test");

        // Add buttons to the panel
        add(okbtnHome);
        add(okbtnLogin);
        add(okbtnSexo);
        add(okbtnLocalidad);
        add(okbtnTest);
    }

}
