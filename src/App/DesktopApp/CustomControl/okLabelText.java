package App.DesktopApp.CustomControl;

import javax.swing.*;

import Infrastructure.okAppStyle;

import java.awt.*;

public class okLabelText extends JPanel{
    private okLabel    lblEtiqueta = new okLabel();
    private okTextBox  txtContenido= new okTextBox();

    public okLabelText(String etiqueta) {
        setLayout(new BorderLayout());

        lblEtiqueta.setCustomizeComponent(  etiqueta, 
                                            okAppStyle.FONT_SMALL, 
                                            okAppStyle.COLOR_FONT_LIGHT, 
                                            okAppStyle.ALIGNMENT_LEFT); 
        add(lblEtiqueta, BorderLayout.NORTH);
        add(txtContenido, BorderLayout.CENTER);
    }
}
