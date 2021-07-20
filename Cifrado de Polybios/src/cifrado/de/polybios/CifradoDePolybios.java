package cifrado.de.polybios;

import java.util.Scanner;

/**
 *
 * @author DinoMa
 */

public class CifradoDePolybios{
    @SuppressWarnings("FieldMayBeFinal")
    private static char tabla[][] = { {' ', 'A', 'B', 'C', 'D'},
                                      {'A', 'A', 'B', 'C', 'D'},
                                      {'B', 'E', 'F', 'G', 'H'},
                                      {'C', 'I', 'J', 'K', 'L'},
                                      {'D', 'M', 'N', 'Ñ', 'O'},
                                      {'E', 'P', 'Q', 'R', 'S'},
                                      {'F', 'T', 'U', 'V', 'W'},
                                      {'G', 'X', 'Y', 'Z', ' '} };
    private static String mensaje;
    private static Scanner input = new Scanner( System.in );
    private static String cifrado = "";
    private static char descifrado[];
    
    public static void main( String args[] ){
        menu();
    }
    
    public static void cifrar(){
        @SuppressWarnings("UnusedAssignment")
        int posActual[] = new int[2];
        int i;
        
        for( i = 0; i < mensaje.length(); i++ ){
            posActual = buscar( i );
            if( posActual[0] == -1 && posActual[1] == -1 )
                cifrado += mensaje.charAt(i);
            else{
                cifrado += tabla[0][posActual[1]];
                cifrado += tabla[posActual[0]][0];
            }    
        }
    }
    
    public static int[] buscar( int i ){
        int posActual[] = new int[2];
        int j, k = 1;
        boolean salir = false;
        
        for( j = 1; j < tabla.length; j++ ){
            for( k = 1; k < tabla[j].length; k++ )
                if( mensaje.charAt(i) == tabla[j][k] ){
                    salir = true;
                    break;
                }
            if( salir )
                    break;
        }
        
        if( j > 7 && k > 4 ){
            posActual[0] = -1;
            posActual[1] = -1;
        }   
        else{
            posActual[0] = j;
            posActual[1] = k;
        }
        return posActual;
    }
    
    public static int[] buscarFC( String col, String fila ){
        int posiciones[] = new int[2];
        int i, j;
        
        for( i = 1; i < tabla[0].length; i++ )
            if( col.charAt(0) == tabla[0][i] )
                break;
        
        for(  j = 1; j < tabla.length; j++ )
            if( fila.charAt(0) == tabla[j][0] )
                break;
        
        if( i > 4 && j > 7 ){
            posiciones[0] = -1;
            posiciones[1] = -1;
        }
        else{
            posiciones[0] = j;
            posiciones[1] = i;
        }
            
        return posiciones;
    }
    
    public static void descifrar(){
        String primero, segundo;
        @SuppressWarnings("UnusedAssignment")
        int posiciones[] = new int[2];
        descifrado = new char[mensaje.length()/2];
        int x = 0;
        
        for( int i = 0; i < mensaje.length(); i += 2 ){
            primero = mensaje.substring(i);
            segundo = mensaje.substring( i+1 );
            posiciones = buscarFC( primero, segundo );
            descifrado[x] = tabla[posiciones[0]][posiciones[1]];
            x++;
        }
    }
    
    public static void menu(){
        short op = 0;
        while( op != 3 ){
            System.out.print( "\n\n\nBienvenido al cifrado de Polybios\nMENU\n1 - Cifrar Mensaje\n2 - Descifrar mensaje\n3 - Salir\nOpción deseada: " );
            input = new Scanner( System.in );
            op = input.nextShort();
            switch( op ){
                case 1:
                    System.out.println( "Mensaje a cifrar: " );
                    input = new Scanner( System.in );
                    mensaje = input.nextLine();
                    mensaje = mensaje.toUpperCase();
                    cifrar();
                    System.out.println( "El mensaje cifrado es: " + cifrado );
                    break;
                case 2:
                    System.out.print( "Mensaje a descifrar: " );
                    input = new Scanner( System.in );
                    mensaje = input.nextLine();
                    mensaje = mensaje.toUpperCase();
                    descifrar();
                    System.out.println( "El mensaje descifrado es: " );
                    for( int i = 0; i < descifrado.length; i++ )
                        System.out.print( descifrado[i] );
                    break;
                case 3:
                    System.out.println( "Gracias por usar el cifrado de Polybios" );
                    break;
                default:
                    System.out.println( "Opción inválida X_X" );
            }
        }
    }
}
