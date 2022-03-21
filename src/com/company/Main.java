package com.company;

import static com.company.StocksCount.*;
import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        int N = 2;
        double a = 0.3, b = 0.4, r = 0.1, T = 110, S_0 = 100, B_0 = 10;
        StocksCount stocks = new StocksCount();
        //        Scanner in = new Scanner(System.in);
//
//        System.out.println("Input values N:");
//        N = in.nextInt();
//        System.out.println("Input values T:");
//        T = in.nextDouble();
//
//        System.out.println("Input values S_0:");
//        S_0 = in.nextDouble();
//        System.out.println("Input values B_0:");
//        B_0 = in.nextDouble();
//        System.out.println("Input values a:");
//        a = in.nextDouble();
//        System.out.println("Input values b:");
//        b = in.nextDouble();
//        System.out.println("Input values r:");
//        r = in.nextDouble();
        //int n = 0;
        double C_n = 0;

        double p = (r + a) / (a + b);
        C_n = Fn(S_0, -a, b, N, T, p) * pow(1 + r, -N);

        for (int n = 1; n < N + 1; n++) {
            stocks.betta = betta_increase(B_0, T, r, N, n, -a, b, p, S_0);
            stocks.gamma = gamma_increase(T, r, N, n, -a, b, p, S_0);
            S_0 = S_0 * (1 + b);
            //double x = S_0; //gamma(T, r, N, n, a, b, p, S_0) * S_0 + betta(B_0, T, r, N, n, a, b, p, S_0) * B_0;
            System.out.println("betta_"+n+" = "+stocks.betta+" "+"gamma_"+n+" = "+stocks.gamma);

        }
        System.out.println(C_n);
    }
}


