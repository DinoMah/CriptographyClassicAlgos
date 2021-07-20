package cifrado.de.vigenère;

/**
 *
 * @author DinoMa
 */

public class CifradoDeVigenère{
    @SuppressWarnings("FieldMayBeFinal")
    private static char tabla[][] = new char[28][28];
    @SuppressWarnings("FieldMayBeFinal")
    private static String mensaje = new String();
    @SuppressWarnings("FieldMayBeFinal")
    private static String cifrado = new String();
    @SuppressWarnings("FieldMayBeFinal")
    private static String descifrado = new String();
    
    public static void main( String args[] ){
        new CifradoDeVigenère();
    }
    
    public CifradoDeVigenère(){
        short x = 0;
        boolean esHora = true;
        
        {//Llena la primera fila de la tabla   
            tabla[0][0] = ' ';
            tabla[0][27] = ' ';
            for( short i = 1; i < 15; i++ )
                tabla[0][i] = (char)('A' + (i-1) );
            tabla[0][15] = 'Ñ';
            for( short i = 16; i < 26; i++ )
                tabla[0][i] = (char)('A' + (i-2) );
            tabla[0][24] = 'W';
            tabla[0][25] = 'Y';
            tabla[0][26] = 'Z';  
        }
        
        {//Llena la primera columna
            for( int i = 1; i < 28; i++ ){
                if( i < 15 )
                    tabla[i][0] = (char)('A' + (i-1) );
                else{
                    if( esHora ){
                        x = 15;
                        esHora = false;
                        tabla[i][0] = 'Ñ';
                        x++;
                    }
                    else{
                        tabla[x][0] = (char)('A' + (x-2) );
                        x++;
                    }    
                }
            }
        }
        
        //La tabla es ciclica, piensalo...
        
        
        for( int i = 0; i < tabla[0].length; i++ )
            System.out.print( tabla[i][0] + " " );
    }
    
    public static void cifrar(){
        
    }
    
    public static int[] buscar(){
        int posActual[] = new int[2];
        return posActual;
    }
    
    public static int[] buscarFC(){
        int posActual[] = new int[2];
        return posActual;
    }
    
    public static void descifrar(){
    
    }
    
    public static void menu(){
        
    }
}
