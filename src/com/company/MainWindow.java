package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.lang.Math.*;

public class MainWindow extends JFrame {

    static final Dimension MIN_SIZE = new Dimension(450, 350);
    static final Dimension MIN_FRAME_SIZE = new Dimension(600, 500);
    private int i = 0;
    private double Gamma,Betta;
    private double NextGamma,NextBetta;

    public MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(MIN_FRAME_SIZE);
        setTitle("Расчет опционов европейского типа");
        setResizable(false);
        JLabel SLabel = new JLabel("S_0:");
        JLabel BLabel = new JLabel("B_0:");
        JLabel aLabel = new JLabel("a:");
        JLabel bLabel = new JLabel("b:");
        JLabel rLabel = new JLabel("r:");
        JLabel TLabel = new JLabel("T:");
        JLabel NLabel = new JLabel("N:");
        JLabel nextSLabel = new JLabel("S:");
        JLabel nextBLabel = new JLabel("B:");
        JLabel nextSField = new JLabel("0");
        JLabel nextBField = new JLabel("0");
        JTextField SField = new JTextField(Double.toString(100),10);
        JTextField BField = new JTextField(Double.toString(10),10);
        JTextField aField = new JTextField(Double.toString(0.3),10);
        JTextField bField = new JTextField(Double.toString(0.4),10);
        JTextField rField = new JTextField(Double.toString(0.1),10);
        JTextField TField = new JTextField(Double.toString(110),10);
        JTextField NField = new JTextField(Integer.toString(2),10);
        JButton input = new JButton("Рассчитать оптимальную стоимость");
        JButton start = new JButton("Следующий шаг");
        JLabel step = new JLabel("Шаг:");
        JLabel stepField = new JLabel("0");
        JLabel gammaLabel = new JLabel("Количество акций:");
        JLabel bettaLabel = new JLabel("Количество облигаций:");
        JLabel betta = new JLabel("0");
        JLabel gamma = new JLabel("0");
        JLabel capital = new JLabel("Капитал:");
        JLabel FuncForPay = new JLabel("Выплаты:");
        JLabel capIn = new JLabel("0");
        JLabel ForPayIn = new JLabel("0");
        JLabel total = new JLabel("Итог:");
        JLabel totalIn = new JLabel("0");
        JLabel CLabel = new JLabel("C_N:");
        JLabel CField = new JLabel("0");
        JCheckBox increase = new JCheckBox();
        JCheckBox reduce = new JCheckBox();
        JLabel increaseLabel = new JLabel("Цена повысилась");
        JLabel reduceLabel = new JLabel("Цена понизилась");
        GroupLayout gl = new GroupLayout(getContentPane());
        setLayout(gl);
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                        .addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addGap(4)
                                .addComponent(SLabel, (int) (MIN_SIZE.height * 0.01), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(SField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(nextSLabel, (int) (MIN_SIZE.height * 0.01), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(nextSField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                        )
                        .addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addGap(4)
                                .addComponent(BLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(BField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(nextBLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(nextBField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)

                        )
                        .addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addGap(4)
                                .addComponent(aLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(aField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(step, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(stepField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                        )
                        .addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addGap(4)
                                .addComponent(bLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(bField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(gammaLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(gamma, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                        )
                        .addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addGap(4)
                                .addComponent(rLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(rField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                        .addComponent(bettaLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(4)
                                        .addComponent(betta, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(4)
                        )
                        .addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addGap(4)
                                .addComponent(TLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(TField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(increaseLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(increase, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                        )
                        .addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addGap(4)
                                .addComponent(NLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(NField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(reduceLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(reduce, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                        )
                        .addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addGap(4)
                                .addComponent(input, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(start, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(4)
                                .addGap(4)

                        )
                        .addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addComponent(CLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(CField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addGap(8)
                                .addComponent(capital, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(capIn, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)

                        )
                        .addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addGap(8)
                                .addComponent(FuncForPay, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(ForPayIn, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)

                        ).addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addGap(8)
                                .addComponent(total, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(totalIn, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)

                        )
                        .addGap(4)
        );
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(4)
                .addGroup(gl.createParallelGroup()
                        .addGap(4)
                        .addComponent(SLabel, (int) (MIN_SIZE.height * 0.01), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(BLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(aLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(bLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(rLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(TLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(NLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(CLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                )
                .addGap(4)
                .addGroup(gl.createParallelGroup()
                        .addComponent(SField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(BField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(aField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(bField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(rField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(TField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(NField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(input, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(CField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                )
                .addGap(4)
                .addGroup(gl.createParallelGroup()
                        .addComponent(nextSLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(nextBLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(step, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(gammaLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(bettaLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(increaseLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(reduceLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(start, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(capital, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(FuncForPay, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(total, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                ).addGap(4)
                .addGroup(gl.createParallelGroup()
                        .addComponent(nextSField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(nextBField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(stepField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(gamma, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(betta, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(increase, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(reduce, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(capIn, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(ForPayIn, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                        .addComponent(totalIn, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(4)
                )
                .addGap(4)
        );
        pack();

        StocksCount SC = new StocksCount();
        input.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SC.S_0 = Double.parseDouble(SField.getText());
                SC.B_0 = Double.parseDouble(BField.getText());
                SC.a = abs(Double.parseDouble(aField.getText()));
                SC.b= Double.parseDouble(bField.getText());
                SC.r = Double.parseDouble(rField.getText());
                SC.T = Double.parseDouble(TField.getText());
                SC.N = Integer.parseInt(NField.getText());
                CField.setText( ""+SC.getC_n(SC.S_0,SC.a,SC.b,SC.N ,SC.T));
                nextSField.setText(SField.getText());
                nextBField.setText(BField.getText());
                Gamma = SC.gamma(SC.T,SC.r,SC.N,i+1, -SC.a,SC.b,SC.S_0);
                Betta = SC.betta(SC.B_0,SC.T,SC.r,SC.N,i+1,-SC.a,SC.b,SC.S_0);
            }
        });

        increase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i > 0){
                    Gamma = SC.gamma(SC.T,SC.r,SC.N,i+1, -SC.a,SC.b,SC.S_0);
                    Betta = SC.betta(SC.B_0,SC.T,SC.r,SC.N,i+1,-SC.a,SC.b,SC.S_0);
                }
                SC.S_0 = SC.S_0 * (1 + SC.b);
                SC.B_0 = SC.B_0 * (1 + SC.r);
            }
        });
        reduce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(i > 0){
                    Gamma = SC.gamma(SC.T,SC.r,SC.N,i+1, -SC.a,SC.b,SC.S_0);
                    Betta = SC.betta(SC.B_0,SC.T,SC.r,SC.N,i+1,-SC.a,SC.b,SC.S_0);
                }
                SC.S_0 = SC.S_0 * (1 - SC.a);
                SC.B_0 = SC.B_0 * (1 + SC.r);
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                increase.setSelected(false);
                reduce.setSelected(false);
                nextSField.setText(""+ SC.S_0);
                nextBField.setText("" + SC.B_0);
                stepField.setText(Integer.toString(i+1));
                gamma.setText(""+Gamma);
                betta.setText(""+Betta);
                i++;
                if(i == SC.N || (Gamma == 0 & Betta == 0)  ){
                    start.setText("Стоп!");
                    capIn.setText(Double.toString(Betta*SC.B_0+Gamma*SC.S_0));
                    ForPayIn.setText(Double.toString(max(SC.S_0-SC.T,0.0)));
                    totalIn.setText(Double.toString(Betta*SC.B_0+Gamma*SC.S_0-max(SC.S_0-SC.T,0.0)));
                }
            }
        });
    }
}