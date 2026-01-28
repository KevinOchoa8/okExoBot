package App.DesktopApp.CustomControl;

import javax.swing.ImageIcon;

import Infrastructure.okAppStyle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class okLabelLink extends okLabel implements MouseListener {

    okLabelLink(String text){
        super(text);
        setPersonalizacion();
    }

    okLabelLink(String text, String iconPath){
        super(text);
        setPersonalizacion();
        setIcon(new ImageIcon(iconPath));
    }
    
    void setPersonalizacion(){
        addMouseListener(this);
        setOpaque(false);
        setForeground(okAppStyle.COLOR_FONT);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // code
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // code
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // code
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setCursor(okAppStyle.CURSOR_HAND);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setCursor(okAppStyle.CURSOR_DEFAULT);
    }
}
