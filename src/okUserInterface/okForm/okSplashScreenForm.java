package okUserInterface.okForm;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import okUserInterface.okIAStyle;

public abstract class okSplashScreenForm {
    
    private static JFrame         sCFrame;
    private static JProgressBar   sCProgressBar; 
    private static ImageIcon      sCImageIcon;
    private static JLabel         sCImageLabel;

    public static void okshow(){
        
        sCImageIcon   = new ImageIcon(okIAStyle.URL_SPLASH);
        sCImageLabel  = new JLabel(sCImageIcon);
        sCProgressBar = new JProgressBar(0, 100);
        
        sCProgressBar.setStringPainted(true);

        sCFrame = new JFrame();
        sCFrame.setUndecorated(true);
        sCFrame.getContentPane().add(sCImageLabel, BorderLayout.CENTER);
        sCFrame.add(sCProgressBar, BorderLayout.SOUTH);
        sCFrame.setSize(sCImageIcon.getIconWidth(), sCImageIcon.getIconHeight());
        sCFrame.setLocationRelativeTo(null); //Centrar en pantalla

        sCFrame.setVisible(true);
        for(int i=0; i<=100; i++){
            try{
                Thread.sleep(50); //50ms
;            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sCProgressBar.setValue(i);
        }
        sCFrame.setVisible(false);
    }
    
}
