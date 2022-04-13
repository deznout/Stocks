package com.company;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.pow;

public class StocksCount {
    double  betta;
    double  gamma;
    double a;
    double b;
    double r;
    double S_0;
    double B_0;
    double T;
    int N ;
    //double a = 0.3, b = 0.4, r = 0.1, T = 110, S_0 = 100, B_0 = 10;
    //double a = 0.0, b = 0.0, r = 0.0, T = 0, S_0 = 0, B_0 = 0;
    //StocksCount stocks = new StocksCount();
    Scanner in = new Scanner(System.in);
    String answer;

    //double C_n = 0;
    double x = 0;

    public double getC_n(double S_0, double a, double b, int N, double T){
        double p = (r + a) / (a + b);
        return Fn(S_0, -a, b, N, T, p) * pow(1 + r, -N);
    }
//    public void CountStocks() {
//        double p = (r + a) / (a + b);
//    for (int n = 1; n < N + 1; n++) {
//        betta = betta(B_0, T, r, N, n, -a, b,  S_0);
//        gamma = gamma(T, r, N, n, -a, b,  S_0);
//
//        System.out.println("betta_" + n + " = " + betta + " " + "gamma_" + n + " = " + gamma);
//        x = B_0 * betta(B_0, T, r, N, n, a, b, S_0) + S_0 * gamma(T, r, N, n, a, b, S_0);
//        System.out.println(x);
//
//        System.out.println("Did price raise?");
//        answer = in.nextLine();
//        if (answer == "Yes") {
//            S_0 = S_0 * (1 + b);
//            B_0 = B_0 * (1 + r);
//        } else {
//            S_0 = S_0 * (1 - a);
//            B_0 = B_0 * (1 - r);
//        }
//    }
//}
        //System.out.println(C_n);

    public static double	gamma(double T, double r, int N, int n, double a, double b, double S)
    {
        double p = (r - a) / ( b - a);
        double result = pow(1 + r, -(N - n)) *
                (Fn(S* (1 + b), a, b, N-n, T, p) - Fn(S* (1 + a), b, a, N-n, T, p)) / (S * (b - a));
        return result;
    }

    public static double	betta(double B_0, double T, double r, int N, int n, double a, double b, double S)
    {
        double p = (r - a) / (b-a);
        double result = Fn(S, a, b, N-(n-1), T, p) / B_0 - pow(1 + r, -(N - n)) *
                ( Fn(S * (1 + b), a, b, N - n, T, p) - Fn(S * (1 + a) , b, a, N-n, T, p) ) / (B_0 * (b - a));
        return result;
    }

    public static int	factorial(int i)
    {
        if (i == 0) return 1;
        else
            return (i * factorial(i - 1));
    }

    public static double Fn(double x, double a, double b, int N, double T, double p)
    {
        double sum = 0;
        double C_n_k = 0;
        double max_0 = 0;
        for (int i = 0; i < N + 1; i++)
        {
            max_0 = max(x * pow((1 + b), i) * pow((1 + a), N - i) - T, 0.0);
            C_n_k = factorial(N)/(factorial(i) * factorial(N - i));
            sum += max_0 * C_n_k * pow(p, i) * pow(1 - p, N - i);
        }
        return sum;
    }
}
