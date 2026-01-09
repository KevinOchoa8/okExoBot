import java.util.Arrays;
import java.util.Scanner;

import okBusinessLogic.okEstadoCivilBL;
import okBusinessLogic.okSexoBL;
import okBusinessLogic.okPersonaTipoBL;

import okDataAccess.okEstadoCivilDAO;
import okDataAccess.okPersonaTipoDAO;
import okDataAccess.okSexoDAO;
import okDataAccess.okDTO.okEstadoCivilDTO;
import okDataAccess.okDTO.okPersonaTipoDTO;
import okDataAccess.okDTO.okSexoDTO;

import okUserInterface.okForm.okMainForm;
import okUserInterface.okForm.okSplashScreenForm;

public class App {
    public static void main(String[] args) throws Exception {
       
        //okargumento(args);

        //okflujoEntrada();

       okSplashScreenForm.okshow();
       okMainForm okMainForm = new okMainForm("IABot");



        //TESTING DAOs
        System.out.println("--------------------------------------------------------------------");
        try{
            okSexoDAO sexoDAO = new okSexoDAO();
            
           for (okSexoDTO s : sexoDAO.okreadAll())
               System.out.println(s.toString());

              System.out.println("------------------------------");

              okEstadoCivilDAO estcivilDAO = new okEstadoCivilDAO();

              for (okEstadoCivilDTO reg : estcivilDAO.okreadAll())
                  System.out.println(reg.toString());
              
              System.out.println("------------------------------");

              okPersonaTipoDAO perTDAO = new okPersonaTipoDAO();

              for (okPersonaTipoDTO reg : perTDAO.okreadAll())
                  System.out.println(reg.toString());

           }
           catch (Exception e){
               System.out.println(e.toString());
           }

        //------------
        System.out.println("--------------------------------------------------------------------");
        try{

            int a[] = {10,0}, b = 10;

            try { // INFORMAR UN ERROR
                int resultadoa = a[1] / b;
                int resultadob = b / a[0];
                throw new Exception(" Te quiero fregar la vida");
            } 
            catch (ArithmeticException e) {
                System.out.println("El denominador no debe ser cero "); //+ e.getMessage());
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Fuera de rango"); //+ e.getMessage());
            }
            catch (Exception e){
                System.out.println("Ha ocurrido un error" + e.getMessage());
            } finally{
                b = 10;
                //System.out.println("Finally: Ejecución con o sin error");
            }

            //TESTING BLs
            okSexoBL sBL = new okSexoBL();
            //sBL.okset(new okSexoDTO(0,0,"Nuevo Sexo","Prueba",null,null,null));
            for (okSexoDTO s : sBL.getAll())
                System.out.println(s.toString());

            System.out.println("------------------------------");

            okEstadoCivilBL eCivilBL = new okEstadoCivilBL();
            for (okEstadoCivilDTO reg : eCivilBL.getAll())
                System.out.println(reg.toString());

            System.out.println("------------------------------");

            okPersonaTipoBL perTBL = new okPersonaTipoBL();
            for (okPersonaTipoDTO reg : perTBL.getAll())
                System.out.println(reg.toString());
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

     }

    private static void okflujoEntrada() {
        int total = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese números para sumar:");
        while (sc.hasNextInt()) {
            total += sc.nextInt();
        }
        System.out.println("La suma de números es: " + total);
        sc.close();
    }

    private static void okargumento(String[] args) {
        if  ( (args.length == 2)
            && (args[0].equals("kevin"))
            && (args[1].equals("08"))      ){
                System.out.println("Hola Kevin, estoy listo para ejecutar el programa");
                
                System.out.println(args);
                var entrada = Arrays.toString(args);
                System.out.println("Los argumentos ingresados son: " + entrada);
            }
        else{
            System.out.println("Tú no eres Kevin, no puedes ejecutar este programa");
            System.exit(0);
        }

        // if (args.length < 1) {
        //   System.out.println("Tú no eres Kevin, no puedes ejecutar este programa.");
        //   System.exit(0);
        // }      
        // String nombre = args[0];
        // if (nombre.equals("kevin")) 
        //   System.out.println("Hola Kevin, estoy listo para ejecutar el programa.");
    }

}

