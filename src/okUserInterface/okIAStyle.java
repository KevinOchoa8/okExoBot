package okUserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.SwingConstants;

public abstract class okIAStyle {

    public static final Color COLOR_FRONT       = new Color(200,10,50);
    public static final Color COLOR_FRONT_LIGHT = new Color(100,100,100);
    public static final Color COLOR_CURSOS      = Color.CYAN;
    public static final Color COLOR_BORDER      = Color.lightGray;
    
    public static final Font FONT       = new Font("New Team Roman", Font.PLAIN, 15);
    public static final Font FONT_BOLD  = new Font("New Team Roman", Font.BOLD, 15);
    public static final Font FONT_SMALL = new Font("New Team Roman", Font.PLAIN, 12);

    public static final int ALIGHNMENT_LEFT  = SwingConstants.LEFT;
    public static final int ALIGHMENT_RIGHT  = SwingConstants.RIGHT;
    public static final int ALIGHMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor CURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor CURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    // public static final URL URL_MAIN   = okIAStyle.class.getResource("/okUserInterface/okResource/okImg/Robot.png");
    // public static final URL URL_LOGO   = okIAStyle.class.getResource("/okUserInterface/okResource/okImg/RobotLogo.png");
    public static final URL URL_SPLASH = okIAStyle.class.getResource("/okUserInterface/okResource/okImg/Robot.png");

    public static void showMsgError(String message) {
        javax.swing.JOptionPane.showMessageDialog(null, message, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

}
