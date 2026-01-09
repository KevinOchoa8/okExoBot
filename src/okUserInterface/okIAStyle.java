package okUserInterface;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.net.URL;

import javax.swing.SwingConstants;

public abstract class okIAStyle {

    public static final Color okCOLOR_FRONT       = new Color(200,10,50);
    public static final Color okCOLOR_FRONT_LIGHT = new Color(100,100,100);
    public static final Color okCOLOR_CURSOS      = Color.CYAN;
    public static final Color okCOLOR_BORDER      = Color.lightGray;
    
    public static final Font okFONT       = new Font("Arial", Font.PLAIN, 15);
    public static final Font okFONT_BOLD  = new Font("Arial", Font.BOLD, 15);
    public static final Font okFONT_SMALL = new Font("Arial", Font.PLAIN, 12);

    public static final int okALIGHNMENT_LEFT  = SwingConstants.LEFT;
    public static final int okALIGHMENT_RIGHT  = SwingConstants.RIGHT;
    public static final int okALIGHMENT_CENTER = SwingConstants.CENTER;

    public static final Cursor okCURSOR_HAND = new Cursor(Cursor.HAND_CURSOR);
    public static final Cursor okCURSOR_DEFAULT = new Cursor(Cursor.DEFAULT_CURSOR);

    // public static final URL URL_MAIN   = okIAStyle.class.getResource("/okUserInterface/okResource/okImg/Robot.png");
    // public static final URL URL_LOGO   = okIAStyle.class.getResource("/okUserInterface/okResource/okImg/RobotLogo.png");
    public static final URL okURL_SPLASH = okIAStyle.class.getResource("/okUserInterface/okResource/okImg/Robot.png");

    public static void okshowMsgError(String message) {
        javax.swing.JOptionPane.showMessageDialog(null, message, "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }

}
