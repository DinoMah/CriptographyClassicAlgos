package cifrado.del.césar;

import java.util.Scanner;

/**
 *
 * @author DinoMa
 */

public class CifradoDelCésar{
    @SuppressWarnings("FieldMayBeFinal")
    private static char alfabeto[] = { 'A', 'B', 'C', 'D', 'E', 
                                       'F', 'G', 'H', 'I', 'J',
                                       'K', 'L', 'M', 'N', 'Ñ',
                                       'O', 'P', 'Q', 'R', 'S', 
                                       'T', 'U', 'V', 'W', 'X',
                                       'Y', 'Z'};
    private static String mensaje;
    @SuppressWarnings("FieldMayBeFinal")
    private static Scanner input = new Scanner( System.in );
    private static char cifrado[];
    private static char descifrado[];
    
    public static void main( String[] args ){
        menu();
    }
    
    @SuppressWarnings("UnnecessaryContinue")
    public static char[] cifrar(){
        char temp[] = new char[mensaje.length()];
        int actual;
        
        for( int i = 0; i < mensaje.length(); i++ ){
            actual = buscar( i );
            
            if( actual == 27 ){}
            else if( actual - 3 < 0 ){
                int tempActual = actual;
                tempActual -= 3;
                actual = 27;
                actual += tempActual;
            }
            else
                actual -= 3;
            
            if( actual != 27 )
                temp[i] = alfabeto[actual];
            else
                temp[i] = mensaje.charAt(i);
            
        }
        return temp;
    }
    
    public static char[] descifrar(){
        char temp[] = new char[mensaje.length()];
        int actual;
        
        for( int i = 0; i < mensaje.length(); i++ ){
            actual = buscar( i );
            
            if( actual == 27 ){}
            else if( actual + 3 > 26 ){
                int tempActual = actual;
                tempActual += 3;
                actual = 27;
                actual -= tempActual;
                actual = -(actual);
            }
            else
                actual += 3;
            
            if( actual != 27 )
                temp[i] = alfabeto[actual];
            else
                temp[i] = mensaje.charAt(i);
            
        }
        
        return temp;
    }
    
    public static int buscar( int numCaracter ){
        int i;
        
        for( i = 0; i < 27; i++ )
            if( mensaje.charAt( numCaracter ) == alfabeto[i] )
                break;
        return i;
    }
    
    public static void menu(){
        short op = 0;
        while( op != 3 ){
            input = new Scanner( System.in );
            System.out.print( "\n\nBienvenido a cifrado César\nMENÚ\n1 - Cifrar mensaje\n2 - Descifrar mensaje\n3 - Salir\n¿Qué acción quieres realizar?: ");
            op = input.nextShort();
            switch( op ){
                case 1:
                    System.out.println( "\n\n\nDame el mensaje a cifrar: " );
                    input = new Scanner( System.in );
                    mensaje = input.nextLine();
                    mensaje = mensaje.toUpperCase();
                    
                    cifrado = new char[mensaje.length()];
                    cifrado = cifrar();
                    
                    System.out.print( "El mensaje cifrado es: " );
                    for( int i = 0; i < cifrado.length; i++ )
                        System.out.print( cifrado[i] );
                    break;
                case 2:
                    System.out.println( "\n\n\n\nDame el mensaje cifrado: " );
                    input = new Scanner( System.in );
                    mensaje = input.nextLine();
                    descifrado = new char[mensaje.length()];
                    descifrado = descifrar();
                    System.out.println( "El mensaje descifrado es: " );
                    for( int i = 0; i < descifrado.length; i++ )
                        System.out.print( descifrado[i] );
                    break;
                case 3:
                    break;
                default:
                    System.out.println( "Opción no válida X.X" );
            }
        }
    }
}
