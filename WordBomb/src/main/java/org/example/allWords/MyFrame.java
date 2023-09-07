package org.example.allWords;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;



public class MyFrame extends JFrame {

    JButton buttonCheck;
    JButton buttonStart;
    JTextField answer;
    JLabel cdownLabel;
    JLabel label;
    JLabel result;
    JLabel question;
    JLabel explotion;
    JFrame jFrame;
    int seconds = 10;
    Timer timer;
    Check check = new Check();


    public MyFrame() {

        ImageIcon imageIcon = new ImageIcon("F:\\Java\\palabra_estres\\src\\main\\java\\org\\example\\img\\bomba.png");
        ImageIcon bum = new ImageIcon(new ImageIcon("F:\\Java\\palabra_estres\\src\\main\\java\\org\\example\\img\\explosion.png")
                .getImage().getScaledInstance(380, 400, Image.SCALE_DEFAULT));

        label = new JLabel();
        result = new JLabel();
        cdownLabel = new JLabel();
        buttonCheck = new JButton();
        buttonStart = new JButton();
        answer = new JTextField();
        question = new JLabel();
        explotion = new JLabel();

//Bomba y Cronometro
        label.setText(String.valueOf(seconds));
        label.setBounds(115, 375, 100, 70);
        label.setForeground(Color.GREEN);
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));
        cdownLabel.setIcon(imageIcon);
        cdownLabel.setBounds(10, 100, 400, 500);
        cdownLabel.setBackground(Color.BLUE);
        label.setHorizontalTextPosition(JLabel.LEFT);
        label.setVerticalTextPosition(JLabel.CENTER);
//Boton

        buttonCheck.setText("Check");
        buttonCheck.setForeground(Color.GREEN);
        buttonCheck.setBackground(Color.black);
        buttonCheck.setFont(new Font("MV Boli", Font.PLAIN, 20));
        buttonCheck.setBounds(340, 450, 150, 55);
        buttonCheck.addActionListener(e -> {
            String fastCheck = String.valueOf(answer.getText());
            if ((e.getSource() == buttonCheck)) {
                try {
                    buttonCheck.setText("Check");
                    if (!check.wordRepeated(answer.getText()) && buttonCheck.getText().equalsIgnoreCase("Check") && check.insideWord(answer.getText())) {
                        if (check.wordCheck(answer.getText())) {
                            result.setText("Correct");
                            seconds = 10;
                            check.randomWord();
                            question.setText(check.res);
                            answer.setText("");
                        } else if (fastCheck.equalsIgnoreCase("")) {
                            result.setText("Write a word");
                            answer.setText("");
                        } else {
                            result.setText("Not Correct");
                            answer.setText("");
                        }

                    } else if (check.isRepeated) {
                        result.setText("Repeated");
                        answer.setText("");
                    } else {
                        result.setText(check.res);
                        answer.setText("");
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonCheck.setFocusable(true);


//Boton
        buttonStart.setText("Start");
        buttonStart.setForeground(Color.GREEN);
        buttonStart.setBackground(Color.black);
        buttonStart.setFont(new Font("MV Boli", Font.PLAIN, 20));
        buttonStart.setBounds(340, 450, 150, 55);
        buttonStart.addActionListener(e -> {
            if (e.getSource() == buttonStart) {
                try {
                    try {
                        check.randomWord();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    question.setText(check.res);
                    buttonStart.setVisible(false);
                    buttonCheck.setVisible(true);
                    timer.start();
                } catch (RuntimeException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

//Linea de Respuesta
        answer.setBounds(270, 380, 295, 55);
        answer.setForeground(Color.GREEN);
        answer.setBackground(Color.black);
        answer.setFont(new Font("MV Boli", Font.PLAIN, 30));
        answer.setFocusable(true);
        answer.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if ( e.getKeyCode() == KeyEvent.VK_ENTER){
                    buttonCheck.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


//Etiqueta de pregunta
        question.setText("");
        question.setOpaque(true);
        question.setBounds(90, 50, 450, 50);
        question.setForeground(Color.GREEN);
        question.setBackground(Color.black);
        question.setFont(new Font("MV Boli", Font.PLAIN, 30));

//Etiqueta de resultado
        result.setText("");
        result.setOpaque(true);
        result.setBounds(90, 100, 450, 50);
        result.setForeground(Color.GREEN);
        result.setBackground(Color.black);
        result.setFont(new Font("MV Boli", Font.PLAIN, 30));

//Eplotion
        explotion.setIcon(bum);
        explotion.setBounds(100, 100, 380, 380);
        explotion.setVisible(false);


//Ventana
        jFrame = new JFrame();
        jFrame.setLayout(null);
        jFrame.setTitle("Word Bomb");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setSize(620, 620);
        jFrame.setVisible(true);
        jFrame.add(label);
        jFrame.add(cdownLabel);
        jFrame.add(buttonStart);
        jFrame.add(buttonCheck);
        jFrame.add(answer);
        jFrame.add(question);
        jFrame.add(result);
        jFrame.add(explotion);

        //jFrame.getContentPane().setBackground(Color.BLACK);


        timer = new Timer(1000, e -> {
            seconds--;
            label.setText(String.valueOf(seconds));

            if (seconds <= 0) {
                jFrame.getContentPane().setBackground(Color.BLACK);
                cdownLabel.setVisible(false);
                result.setVisible(false);
                question.setVisible(false);
                answer.setVisible(false);
                buttonCheck.setVisible(false);
                label.setVisible(false);
                explotion.setIcon(bum);
                explotion.setVisible(true);
                timer.stop();
            }
        });
    }

//button ACTIONPERFMED


}

