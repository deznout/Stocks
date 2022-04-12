package com.company;

import static java.lang.Math.max;
import static java.lang.Math.pow;

public class StocksCount {

    public static double gamma(int n, double S, vars values)
    {
        vars vars_1 = new vars(values.N - n, values.a, values.b, values.r, values.T);
        vars vars_2 = new vars(values.N - n, values.b, values.a, values.r, values.T);
        return pow(1 + values.r, -(values.N - n)) *
                (Fn(S * (1 + values.b), vars_1) - Fn(S * (1 + values.a), vars_2)) / (S * (values.b - values.a));
    }

    public static double	betta(double B_0, double S, int n, vars values)
    {
        vars vars_1 = new vars(values.N-(n-1), values.a, values.b, values.r, values.T);
        vars vars_2 = new vars(values.N - n, values.a, values.b, values.r, values.T);
        vars vars_3 = new vars(values.N - n, values.b, values.a, values.r, values.T);
        return Fn(S, vars_1) / B_0 - pow(1 + values.r, -(values.N - n)) *
                (Fn(S * (1 + values.b), vars_2) - Fn(S * (1 + values.a) , vars_3) ) / (B_0 * (values.b - values.a));
    }

    public static int	factorial(int i)
    {
        if (i == 0) return 1;
        else
            return (i * factorial(i - 1));
    }

    public static double Fn(double x, vars values)
    {
        double sum = 0;
        double C_n_k;
        double max_0;
        for (int i = 0; i < values.N + 1; i++)
        {
            max_0 = max(x * pow((1 + values.b), i) * pow((1 + values.a), values.N - i) - values.T, 0.0);
            C_n_k = (double) factorial(values.N) / (factorial(i) * factorial(values.N - i));
            sum += max_0 * C_n_k * pow(values.p, i) * pow(1 - values.p, values.N - i);
        }
        return sum;
    }
}
