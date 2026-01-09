package okUserInterface.okForm;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JFrame;

import okUserInterface.okIAStyle;

public class okMainForm extends JFrame{

    JPanel panelMain = new okMainPanel();

    public okMainForm (String tittleApp){
        okcustomizeComponent(tittleApp);
        ((okMainPanel)panelMain).okbtnHome.addActionListener(         e -> okSetPanel(new JPanel()));
        ((okMainPanel)panelMain).okbtnLogin.addActionListener(        e -> okSetPanel(new JPanel()));
        ((okMainPanel)panelMain).okbtnSexo.addActionListener(         e -> okSetPanel(new JPanel()));
        ((okMainPanel)panelMain).okbtnLocalidad.addActionListener(    e -> okSetPanel(new JPanel()));

        ((okMainPanel)panelMain).okbtnTest.addActionListener(         e -> { okIAStyle.okshowMsgError("Mensaje de error");});

    }

    private void okSetPanel(JPanel formularioPanel){
        Container container = getContentPane();
        container.remove(panelMain);
        panelMain = formularioPanel;
        container.add(panelMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }


    private void okcustomizeComponent(String tittleApp){
        setTitle(tittleApp);
        setSize(800,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(panelMain, BorderLayout.WEST);
        setVisible(true);
    }
}
