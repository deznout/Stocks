package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainWindow extends JFrame {

    static final Dimension MIN_SIZE = new Dimension(450, 350);
    static final Dimension MIN_FRAME_SIZE = new Dimension(600, 500);

    public MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(MIN_FRAME_SIZE);
        setTitle("Расчет опционов европейского типа");
        JLabel inf = new JLabel("Введите данные:");
        JLabel SLabel = new JLabel("S:");
        JLabel BLabel = new JLabel("B:");
        JLabel aLabel = new JLabel("a:");
        JLabel bLabel = new JLabel("b:");
        JLabel rLabel = new JLabel("r:");
        JLabel TLabel = new JLabel("T:");
        JLabel NLabel = new JLabel("N:");
        JTextField SField = new JTextField(10);
        JTextField BField = new JTextField(10);
        JTextField aField = new JTextField(10);
        JTextField bField = new JTextField(10);
        JTextField rField = new JTextField(10);
        JTextField TField = new JTextField(10);
        JTextField NField = new JTextField(10);
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
                                .addComponent(CLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(CField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                        )
                        .addGap(4)
                        .addGroup(gl.createParallelGroup()
                                .addGap(4)
                                .addComponent(BLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(4)
                                .addComponent(BField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
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

//                                .addComponent(capIn, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
//                                .addGap(4)
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
                )
                .addGap(4)
                .addGroup(gl.createParallelGroup()
                        .addComponent(CLabel, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(CField, (int) (MIN_SIZE.height * 0.1), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
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
    }
}