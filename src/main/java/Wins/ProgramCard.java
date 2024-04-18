/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Wins;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author zayat
 */
public class ProgramCard extends javax.swing.JFrame {

    /**
     * Creates new form ProgramCard
     */
    public ProgramCard() {
        initComponents();
    }


    private void initComponents() {

        JLabel title = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        JTextArea mainText = new JTextArea();
        JLabel version = new JLabel();
        JButton exitButton = new JButton();
        JLabel img = new JLabel();


        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(672, 345));

        title.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 24)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Информирование студентов о проходящих мероприятиях");

        mainText.setEditable(false);
        mainText.setColumns(20);
        mainText.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        mainText.setRows(5);
        mainText.setText("Программа собирает данные с сайта БНТУ\nПолучает информацию о последней новости\nОтправляет эту новость всем почтам, указанным\nв списке по нажатию кнопки \"Разослать\"");
        mainText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainText.setKeymap(null);
        jScrollPane1.setViewportView(mainText);

        version.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 24)); // NOI18N
        version.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        version.setText("Версия ver. 1.0.0.2023");
        version.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));

        exitButton.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        exitButton.setText("Назад");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAction();
            }
        });

        img.setIcon(new javax.swing.ImageIcon(String.valueOf(new ImageIcon("D:\\java Projects\\AleksShpakouski\\src\\main\\java\\Images\\news-2mini.jpg")))); // NOI18N
        img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        img.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(version, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                    .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(version)
                    .addComponent(exitButton))
                .addContainerGap())
        );
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();


        int screenWidth = gd.getDisplayMode().getWidth();
        int screenHeight = gd.getDisplayMode().getHeight();


        int x = (screenWidth - this.getWidth()) / 2;
        int y = (screenHeight - this.getHeight()) / 2;


        this.setLocation(x, y);

        this.setLocationRelativeTo(null);
        pack();
    }

    private void buttonAction() {
        setVisible(false);
    }
}
