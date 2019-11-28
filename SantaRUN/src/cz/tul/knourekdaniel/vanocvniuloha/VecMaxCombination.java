package cz.tul.knourekdaniel.vanocvniuloha;

import java.util.Scanner;

public class VecMaxCombination {
    static Scanner input = new Scanner(System.in);
    public static void start(){
        int vecCount, vecLen;
        double vectors[][];

        System.out.println("Pocet vektoru");
        vecCount = input.nextInt();
        System.out.println("Delka vektoru");
        vecLen = input.nextInt();
        vectors = new double[vecCount][vecLen];

        System.out.println("Zadej vektory [x y z ...]");
        for (int i = 0; i < vecCount; i++) {
            for (int j = 0; j < vecLen; j++) {
                vectors[i][j] = input.nextDouble();
            }
        }
        System.out.println("done");
    }
}
/*
3 2
0 1
5 8
2 8
 */