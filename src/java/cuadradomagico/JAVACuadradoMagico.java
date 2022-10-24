/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.cuadradomagico;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class JAVACuadradoMagico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[][] matriz=new int [3][3];
        System.out.println("Ingrese uno a uno los 9 elementos (cifras entre 1 y 9) de la matriz 3x3");
        VerificacionYRellenado(matriz);
        if (EsMagico(matriz)) {
            System.out.println("La matriz es mágica");
        } else {
            System.out.println("La matriz no es mágica");
        }
        MostrarMatriz(matriz);
    }
    
    public static void VerificacionYRellenado(int[][] matriz){
        Scanner leer = new Scanner(System.in);
        int cont=1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num;
                do {      
                    num=leer.nextInt();
                    if (num>=1&&num<=9) {
                    System.out.println("Elemento "+cont+" ingresado correctamente");
                    matriz[i][j]=num;
                    cont++;
                } else {
                        System.out.println("El número debe estar entre 1 y 9");
                    }
                } while (num<1||num>9);
            }
        }
    }
    public static boolean EsMagico(int[][] matriz){
        boolean bandera=false;
        int suma=0;
        int sumaFila=0;
        int sumaColumna=0;
        int sumaDiagonal1=0;
        int sumaDiagonal2=0;
        for (int i = 0; i < 3; i++) {
            int a=2-i;
            for (int j = 0; j < 3; j++) {
                suma=suma+matriz[i][j];
                if (i==0) {
                    sumaFila=sumaFila+matriz[i][j];
                }
                if (j==0) {
                    sumaColumna=sumaColumna+matriz[i][j];
                }
                if (i==j) {
                    sumaDiagonal1=sumaDiagonal1+matriz[i][j];
                }
                if (j==a) {
                    sumaDiagonal2=sumaDiagonal2+matriz[i][j];
                }
            }
        }
        if (sumaFila==(suma/3)&&sumaFila==sumaColumna&&sumaDiagonal1==sumaDiagonal2&&sumaDiagonal1==(suma/3)){
            bandera=true;
        }
        return bandera;
    }
    public static void MostrarMatriz(int[][] matriz){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }
    
}
