package com.company;

import static java.lang.Math.max;
import static java.lang.Math.pow;

public class StocksCount {
    double  betta;
    double  gamma;

    public static double	gamma_increase(double T, double r, int N, int n, double a, double b, double p, double S)
    {
        double result = pow(1 + r, -(N - n)) *
                (Fn(S * (1 + b), a, b, n, T, p) - Fn(S * (1 + a), b, a, n, T, p)) / (S * (b - a));
        return result;
    }

    public static double	betta_increase(double B_0, double T, double r, int N, int n, double a, double b, double p, double S)
    {
        double result = Fn(S, a, b, n, T, p) / B_0 + pow(1 + r, -(N - n)) *
                (Fn(S * (1 + b), a, b, n, T, p) - Fn(S * (1 + a) , b, a, n, T, p)) / (B_0 * (b - a));
        return result;
    }

    public static double	gamma_reduce(double T, double r, int N, int n, double a, double b, double p, double S)
    {
        double result = pow(1 + r, -(N - n)) *
                (Fn(S, a, b, n, T, p) - Fn(S, b, a, n, T, p)) / (S * (b - a));
        return result;
    }

    public static double	betta_reduce(double B_0, double T, double r, int N, int n, double a, double b, double p, double S)
    {
        double result = Fn(S, a, b, n, T, p) / B_0 + pow(1 + r, -(N - n)) *
                (Fn(S, a, b, n, T, p) - Fn(S, b, a, n, T, p)) / (B_0 * (b - a));
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
