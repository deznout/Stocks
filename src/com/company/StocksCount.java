package com.company;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.pow;

class vars {
    public double   a;  // when price fall
    public double   b;  // when price rise
    public double   r;  // % rate
    public double   T;  // determined price of stock
    public double   p;  // divide (r - a) to (b - a)
    public int      N;  // number of cycles

    public vars(int N, double a, double b,
                double r, double T) {
        this.N = N;
        this.a = a;
        this.b = b;
        this.r = r;
        this.T = T;
        p = (r - a) / (b - a);
    }
}

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
    
    int N = 2;
    double a = 0.3, b = 0.4, r = 0.1, T = 110, S_0 = 100, B_0 = 10;
    //StocksCount stocks = new StocksCount();
    //Scanner in = new Scanner(System.in);
    String answer;

    //double C_n = 0;
    double x = 0;
    double p = (r + a) / (a + b);
    double C_n = Fn(S_0, -a, b, N, T, p) * pow(1 + r, -N);
    public void CountStocks() {
    for (int n = 1; n <= values.N; n++) {
            betta = betta(B_0, S_0, n, values);
            gamma = gamma(n, S_0, values);

            System.out.println("betta_" + n + " = " + betta + "\n" + "gamma_" + n + " = "+ gamma);
            if (betta == 0 && gamma == 0)
                break;
            x = B_0 * betta + S_0 * gamma;
            System.out.println("Sum of suitable strategy = " + x);

            while (true) {
                System.out.println("Did price raise? (y/n)");
                answer = in.nextLine();
                if (answer.equals("y"))
                {
                    S_0 = S_0 * (1 + values.b);
                    B_0 = B_0 * (1 + values.r);
                    break;
                }
                else if (answer.equals("n"))
                {
                    S_0 = S_0 * (1 + values.a);
                    B_0 = B_0 * (1 + values.r);
                    break;
                }
            }

        }
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
