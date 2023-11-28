/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.event.*;
/**
 *
 * @author Shinichi
 */
// Kelas yang mengimplementasikan ActionListener untuk tombol utama pada MainFrame
public class MainButtonActionListener implements ActionListener {

    // Variabel instance untuk MainFrame yang akan dioperasikan
    private MainFrame mainFrame;

    // Konstruktor MainButtonActionListener dengan parameter MainFrame
    public MainButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    // Metode yang diimplementasikan dari ActionListener
    public void actionPerformed(ActionEvent e) {
        // Memeriksa apakah sumber event adalah tombol JenisMember pada MainFrame
        if (e.getSource() == mainFrame.getButtonJenisMember()) {
            // Jika ya, tampilkan frame JenisMember
            mainFrame.showJenisMemberFrame();
        } else {
            // Jika tidak, tampilkan frame Member
            mainFrame.showMemberFrame();
        }
    }
}

