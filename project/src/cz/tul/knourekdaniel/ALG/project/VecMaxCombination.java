package cz.tul.knourekdaniel.ALG.project;

import java.util.Scanner;

class VecMaxCombination {

    /**
     *
     */
    static void start(){
        Scanner input = new Scanner(System.in);
        int vecCount, vecLen;
        double[][] vectors;

        System.out.println("Pocet vektoru");
        while ( (vecCount = input.nextInt()) > 0 ){


        System.out.println("Delka vektoru");
        vecLen = input.nextInt();
        vectors = new double[vecCount][vecLen];

        System.out.println("Zadej vektory [x y z ...]");
        for (int i = 0; i < vecCount; i++) {
            for (int j = 0; j < vecLen; j++) {
                vectors[i][j] = input.nextDouble();
            }
        }

        double Biggest = -Double.MAX_VALUE;
        int[] BiggestVec = new int[2];
        for (int i = 0; i < vecCount; i++) {
            for (int j = 0; j < vecCount; j++) {
                if (i == j){ continue;}
                double tmp = 0;
                for (int k = 0; k < vecLen; k++) {
                    tmp += vectors[i][k] * vectors[j][k];
                }
                if (tmp > Biggest){
                    Biggest = tmp;
                    BiggestVec[0] = i;
                    BiggestVec[1] = j;
                }
            }
        }

        System.out.println("Vektory s maximalnim skalarnim soucinem");
        System.out.printf("%s %n%s %n", vecToString(vectors[BiggestVec[0]]), vecToString(vectors[BiggestVec[1]]));
        System.out.printf("Jejich skalarni soucin je %.2f %n%n", Biggest);

        System.out.println("Pocet vektoru");
        }
        input.close();
    }

    /**
     *
     * @param vector
     *  input array of type double
     * @return
     * gives string in format ( x y z ... )
     */
    private static String vecToString(double[] vector){
        StringBuilder out = new StringBuilder("( ");
        for ( double item : vector ) {
            out.append(item).append(" ");
        }
        out.append(")");
        return out.toString();
    }
}
/*
3 2
0 1
5 8
2 8
 */