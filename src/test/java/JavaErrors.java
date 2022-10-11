import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class JavaErrors {
    private static Object checkedExceptions;
    //Throwable

    //cuvinte cheie;

    //throw
    //throwss
    // try - catch - finally

    //throw - ne folosim de el ca sa  aruncam explicit o eroare
    //throws - atentionare ca o metoda sau constructor arunca eroare/ecxpectie
    // try - catch - finally - handler
    //checkedExceptions();
    //uncheckedExceptions();
    // metodaRecursiva(3 , i);


    public static void main(String[] args) throws IOException {
        try {
            throw new IOException ("Am trimis mesajul custom");
        }catch (MyCustomException e ){
            System.out.println(" Am intrat in metoda catch ");
        }
        System.out.println("Am terminat metoda main");
    }

    public static void throwsException(){
        throw new ArithmeticException();

    }




    public static void exeplifyTryCatch(){

        try {
            String cuvant = "cuvant random" ;
            String rezultat = cuvant.toUpperCase();
            System.out.println("Rezultatul este : " + rezultat);

            int a = 10;
            int b = 2;
            int result = a / b;
            System.out.println(" Dupa ArithmeticException ");
        } catch (NullPointerException  e ) {

            System.out.println("Am intrat in blocul de catch ");
            metodaRecursiva(3, 1);
        }catch ( Error e  ){
            System.out.println("Am intrat in blocul de catch");

        } finally {
            System.out.println("Am intrat in blocul de finally");

        }

        System.out.println("S a terminat metoda main");
    }

    // checked exceptions
    public static void checkedExceptions() throws IOException {
        FileReader file = new FileReader("C:\\Users\\ungur\\IdeaProjects text.txt");
        BufferedReader fileInput = new BufferedReader(file);
        System.out.println(fileInput.readLine());
        fileInput.close();

    }


    //unchecked exceptions
    public static void uncheckedExceptions() throws IOException {
        //NULLPointerException
        String cuvant = null;
        cuvant.length();

        //AritmeticException
        int a = 10;
        int b = 0;
        int result = a / b;
        System.out.println("Rezultatul este : " + result);

    }

        //errors
    public static void metodaRecursiva(int numar, int i) {
        if (numar == 0) {
            return;
        } else {
            System.out.println("Numarul este: " + i);
            i++;
            metodaRecursiva( numar, i);
        }

    }


}