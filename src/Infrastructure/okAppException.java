//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package Infrastructure;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Infrastructure.Tools.CMDColor;

public class okAppException extends Exception {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
 
    public okAppException(String showMsg) {
        super((showMsg== null || showMsg.isBlank()) ? okAppConfig.MSG_DEFAULT_ERROR   : showMsg);
        saveLogFile(null, null, null);
    }
    public okAppException(String showMsg, Exception e, Class<?> clase, String metodo) {
        super((showMsg== null || showMsg.isBlank()) ? okAppConfig.MSG_DEFAULT_ERROR   : showMsg);
        saveLogFile(e.getMessage(), clase, metodo);
    }
    private void saveLogFile(String logMsg, Class<?> clase, String metodo) {
        String timestamp  = LocalDateTime.now().format(FORMATTER);
        String className  = (clase  == null) ? okAppConfig.MSG_DEFAULT_CLASS          : clase.getSimpleName();
        String methodName = (metodo == null) ? okAppConfig.MSG_DEFAULT_METHOD         : metodo;
        logMsg = (logMsg == null || logMsg.isBlank()) ? okAppConfig.MSG_DEFAULT_ERROR : logMsg;
        logMsg = String.format("╭─💀─ SHOW ❱❱ %s \n╰──── LOG  ❱❱ %s | %s.%s | %s", getMessage(), timestamp, className, methodName, logMsg);

        try (PrintWriter writer = new PrintWriter(new FileWriter(okAppConfig.getLOGFILE(), true))) {
            System.err.println(CMDColor.BLUE  + logMsg);
            writer.println(logMsg);
        } catch (Exception e) {
            System.err.println(CMDColor.RED  + "[AppException.saveLogFile] ❱ " + e.getMessage());
        }finally {
            System.out.println(CMDColor.RESET);
        }
    }
}