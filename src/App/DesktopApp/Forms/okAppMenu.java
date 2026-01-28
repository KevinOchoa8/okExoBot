package App.DesktopApp.Forms;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import App.DesktopApp.CustomControl.okButton;
import Infrastructure.okAppConfig;


public class okAppMenu extends JPanel {
    private final List<okButton> menuItems = new ArrayList<>();
    private final JPanel buttonsPanel = new JPanel();

    public okAppMenu() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight()));

        // add-logo
        try {
            Image logo = ImageIO.read(okAppConfig.getImglogo());
            logo = logo.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // panel para los items del menu
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        add(buttonsPanel);

        // glue para empujar el copyright
        add(Box.createVerticalGlue());
        add(new JLabel(" ──❰ 🤖 ❱── © 2K26 KEVIN_OCHOA "));
    }

    public void addMenuItem(okButton button) {
        menuItems.add(button);
        buttonsPanel.add(button);
        buttonsPanel.revalidate();
        buttonsPanel.repaint();
    }

    public List<okButton> getMenuItems() {
        return menuItems;
    }
}
