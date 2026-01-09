package okUserInterface.okForm;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import okUserInterface.okIAStyle;

public abstract class okSplashScreenForm {
    
    private static JFrame         oksCFrame;
    private static JProgressBar   oksCProgressBar; 
    private static ImageIcon      oksCImageIcon;
    private static JLabel         oksCImageLabel;

    public static void okshow(){
        
        oksCImageIcon   = new ImageIcon(okIAStyle.okURL_SPLASH);
        oksCImageLabel  = new JLabel(oksCImageIcon);
        oksCProgressBar = new JProgressBar(0, 100);
        
        oksCProgressBar.setStringPainted(true);

        oksCFrame = new JFrame();
        oksCFrame.setUndecorated(true);
        oksCFrame.getContentPane().add(oksCImageLabel, BorderLayout.CENTER);
        oksCFrame.add(oksCProgressBar, BorderLayout.SOUTH);
        oksCFrame.setSize(oksCImageIcon.getIconWidth(), oksCImageIcon.getIconHeight());
        oksCFrame.setLocationRelativeTo(null); //Centrar en pantalla

        oksCFrame.setVisible(true);
        for(int i=0; i<=100; i++){
            try{
                Thread.sleep(50); //50ms
;            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            oksCProgressBar.setValue(i);
        }
        oksCFrame.setVisible(false);
    }
    
}
