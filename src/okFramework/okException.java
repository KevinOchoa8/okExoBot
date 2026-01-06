package okFramework;

public class okException extends Exception {
    
    public okException(String e, String clase, String metodo) {
        //grabar en log el error que está abajo
        //System.out.println("[ERROR DE LA APP -----> LOG] " + clase + "." + metodo + " : " + e);
    }

    @Override
    public String getMessage() {
        return "No andes de sapo";
    }
}
