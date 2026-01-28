package App.DesktopApp.Forms;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import App.DesktopApp.CustomControl.okButton;
import Infrastructure.okAppMSG;

public class okAppStart extends JFrame {
    okAppMenu pnlMenu = new okAppMenu();
    JPanel    pnlMain = new okHome();

    public okAppStart(String tilteApp) {
        initComponents(tilteApp);
 
        okButton btnHome    = new okButton("🤖 Home");
        okButton btnSexo    = new okButton("🤖 Sexo");
        okButton btnHormiga = new okButton("🤖 Tipo de Hormiga");
        okButton btnTest    = new okButton("🤖 Validar");

        btnHome   .addActionListener(e -> setPanel(new okHome()));
        btnSexo   .addActionListener(e -> setPanel(new okSexo()));
        btnHormiga.addActionListener(e -> setPanel(new okHome()));
        btnTest   .addActionListener(e -> okAppMSG.showError("mensaje de error"));

        pnlMenu.addMenuItem(btnHome   );
        pnlMenu.addMenuItem(btnSexo   );    
        pnlMenu.addMenuItem(btnHormiga);
        pnlMenu.addMenuItem(btnTest   );

    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void initComponents(String tilteApp) {
        setTitle(tilteApp);
        setSize(930, 600);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }
}