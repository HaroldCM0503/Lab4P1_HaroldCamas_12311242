/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab4p1_haroldcamas_12311242;
import java.util.Scanner;
/**
 *
 * @author harol
 */
public class Lab4P1_HaroldCamas_12311242 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner (System.in);
        Scanner sc = new Scanner (System.in);
        boolean respuesta = true;
        int opcion = 0;
        
        while (respuesta){
            System.out.println("");
            System.out.println("Ejercicio 1.) Conjuntos");
            System.out.println("Ejercicio 2.) Contraseña");
            System.out.println("3.) Salir");
            opcion = leer.nextInt();
            
            switch (opcion){
                case 1:
                    String c1,c2;
                    char ch1,ch2;
                    int cl1,cl2;
                    int estar = 0;
                    int cont_comas = 0;
                    boolean validacion_1 = true;
                    boolean validacion_2 = true;
                    int operacion = 0;
                    String acumulador_U = "C={";
                    String acumulador_I = "C={";
                    
                    System.out.println("Inserte su primer conjunto: ");
                    c1 = sc.next();
                    //Inicio validacion.
                    for ( int i = 0; i < c1.length(); i++){
                        cl1 = c1.charAt(i);
                        //Cuenta las comas.
                        if (cl1 == 44){
                            cont_comas += 1;
                        }
                        //Confirma que sea mayuscula.
                        if (i == 0 && (cl1 < 65 || cl1 > 90)){
                            validacion_1 = false;
                            break;
                        }
                        //Busca el =.
                        if (i == 1 && cl1 != 61){
                            validacion_1 = false;
                            break;
                        }
                        //Busca el { inicial y el } final.
                        if ((i == 2 && cl1 != 123) || (i == c1.length() - 1 && cl1 != 125)){
                            validacion_1 = false;
                            break;
                        }  
                    }
                    if (c1.length() != 5 + (cont_comas*2) && c1.length() > 4){
                            validacion_1 = false;
                    }
                    cont_comas = 1;
                    
                    if (validacion_1 == false){
                        System.out.println("El conjunto que introdujo es erroneo elija uno valido");
                        break;
                    }
                    
                    System.out.println("Inserte su segundo conjunto: ");
                    c2 = sc.next();
                    for ( int i = 0; i < c2.length(); i++){
                        cl2 = c2.charAt(i);
                        //Cuenta las comas.
                        if (cl2 == 44){
                            cont_comas += 1;
                        }
                        //Busca que sea mayuscula.
                        if (i == 0 && (cl2 < 65 || cl2 > 90)){
                            validacion_2 = false;
                            break;
                        }
                        //Busca el =.
                        if (i == 1 && cl2 != 61){
                            validacion_2 = false;
                            break;
                        }
                        //Busca el primer { y el } final.
                        if ((i == 2 && cl2 != 123) || (i == c2.length() - 1 && cl2 != 125)){
                            validacion_2 = false;
                            break;
                        }  
                    }
                    if (c2.length() != 5 + (cont_comas*2) && c2.length() > 4){
                            validacion_1 = false;
                    }
                    
                    if (validacion_2 == false){
                        System.out.println("El conjunto que introdujo es erroneo, elija uno valido");
                        break;
                    }
                    
                    if (c1.equals(c2)){
                        System.out.println("Ambos son iguales");
                        break;
                    }
                    //Fin Validacion.
                    
                    //Inicio Operacion.
                    //Sacar la interseccion 
                    if (c1.length() > c2.length()){
                      for (int i = 0; i < c2.length(); i++){
                             ch2 = c2.charAt(i);
                             for (int j = 3; j < c1.length(); j += 2){
                                 ch1 = c1.charAt(j);
                                 if (ch1 == ch2){
                                 acumulador_I += ch1 + ",";
                                 }
                             }  
                        }   
                    }
                    if (c1.length() < c2.length()){
                         for (int i = 0; i < c1.length(); i++){
                             ch1 = c1.charAt(i);
                             for (int j = 3; j < c1.length(); j += 2){
                                 ch2 = c2.charAt(j);
                                 if (ch1 == ch2){
                                 acumulador_I += ch2 + ",";
                                 }
                             }
                         }
                     }
                    System.out.println("La Interseccion es: " + acumulador_I + "}");
                    
                    //Sacar la Union. 
                    for (int j = 3; j < c1.length(); j += 2){
                        acumulador_U += c1.charAt(j) + ",";
                        }

                    for (int i = 3; i < c2.length(); i += 2){
                        acumulador_U += c2.charAt(i) + ",";
                    }
                    System.out.println("La union es: " + acumulador_U + "}");
                    break;
                            
                            
                            
                case 2:
                    String contraseña,
                    acum = "";
                    int letter;
                    int numero = 0;
                    boolean letras = false;
                    boolean number = false;
                    
                    System.out.println("Ingrese una contraseña de no menos 8 caracteres que incluyan minimo un numero y una letra. ");
                    contraseña = sc.next();
                    //Validacion.
                    if (contraseña.length() < 8){
                        System.out.println("Elija una contraseña con mas de 8 letras.");
                        break;
                    }
                    for (int i = 0; i < contraseña.length(); i++){
                        letter = contraseña.charAt(i);
                        if (letter > 47 && letter < 58){
                            number = true;
                        }
                        if ((letter > 96 && letter < 123) || (letter > 64 && letter < 91) ){
                            letras = true;
                        }
                    }
                    //Si nunca detecto numero la rechaza.
                    if (number == false){
                        System.out.println("Elija una contraseña con minimo 1 numero.");
                        break;
                    }
                    //Si nunca encuentra una letra la rechaza.
                    else if (letras = false){
                        System.out.println("Elija una contraseña con minimo 1 letra.");
                        break;
                    }
                    //Fin validacion.
                    
                    //Inicio operacion con el numero.
                    System.out.println("Introduzca un numero: ");
                    numero = leer.nextInt();
                    
                    for (int i = 0; i < contraseña.length(); i ++){
                        if (i%2 != 0 || i == 0){
                            acum += contraseña.charAt(i);
                        }
                        if (i%2 == 0 && i != 0 && i != contraseña.length() - 1){
                            acum += numero; 
                            acum += contraseña.charAt( i );
                            numero ++;
                        }
                        //Sin este if el codigo trata de leer mas alla del indice de la palabra y se para el codigo, entonces por eso es uno aparte.
                        if (i == contraseña.length() - 1){
                            acum += numero;
                        }
                    }
                    System.out.println("La contraseña final es: " + acum);
                    break;
                    
                case 3:
                    respuesta = false;
                    break;
                    
                default:
                    System.out.println("Elija una opcion valida");
                    break;
                        } 
                            
                    }

                    

                    
                
            }
        }
    
