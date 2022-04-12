package com.company;

import java.util.Scanner;

import static com.company.StocksCount.*;
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

public class Main {
    public static void main(String[] args) {
//        var w = new MainWindow();
//        w.setVisible(true);
        Scanner in = new Scanner(System.in);
        String answer;
        vars values = new vars(2, -0.3, 0.4, 0.1, 110);
        double  S_0 = 100;  // price of stock
        double  B_0 = 10;   // price of option
        double  betta;      // number of options
        double  gamma;      // number of stocks
        double  C_n;        // price of option to pay for F_n
        double  x;          // sum of suitable strategy

        // System.out.println("Input values N:");
        // N = in.nextInt();
        // System.out.println("Input values T:" );
        // T = in.nextDouble();

        // System.out.println("Input values S_0:");
        // S_0 = in.nextDouble();
        // System.out.println("Input values B_0:");
        // B_0 = in.nextDouble();
        // System.out.println("Input values a:");
        // a = in.nextDouble();
        // System.out.println("Input values b:");
        // b = in.nextDouble();
        // System.out.println("Input values r:");
        // r = in.nextDouble();
        // int n = 0;

        C_n = Fn(S_0, values) * pow(1 + values.r, -values.N);

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

        System.out.println("Optimal price of option = " + C_n);

    }
}
