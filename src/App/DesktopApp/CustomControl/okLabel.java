package App.DesktopApp.CustomControl;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

import Infrastructure.okAppStyle;

public class okLabel extends JLabel{
    public okLabel(){
        customizeComponent();
    }
    public okLabel(String text){
        setText(text);
        customizeComponent();
    }
    private void customizeComponent(){
        setCustomizeComponent(getText(), okAppStyle.FONT, okAppStyle.COLOR_FONT_LIGHT, okAppStyle.ALIGNMENT_LEFT);
    }
    public void setCustomizeComponent(String text, Font  font, Color color, int alignment) {
        setText(text);
        setFont(font);
        setOpaque(false);
        setBackground(null);
        setForeground(color);
        setHorizontalAlignment(alignment);
        //setIcon(new ImageIcon(iconPath));
    }
}