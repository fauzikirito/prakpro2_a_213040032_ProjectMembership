/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import member.MemberFrame;
import jenis_member.JenisMemberFrame;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import dao.*;

/**
 *
 * @author Shinichi
 */
// Kelas MainFrame yang mengextends JFrame
public class MainFrame extends JFrame {

    // Variabel instance untuk JenisMemberFrame
    private JenisMemberFrame jenisMemberFrame;

    // Variabel instance untuk MemberFrame
    private MemberFrame memberFrame;

    // Tombol untuk menampilkan frame JenisMember
    private JButton buttonJenisMember;

    // Tombol untuk menampilkan frame Member
    private JButton buttonMember;

    // Objek Dao untuk mengakses dan memanipulasi data Member
    private MemberDao memberDao;

    // Objek Dao untuk mengakses dan memanipulasi data JenisMember
    private JenisMemberDao jenisMemberDao;

    // Konstruktor MainFrame
    public MainFrame() {
        // Mengatur operasi default ketika frame ditutup
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Mengatur ukuran frame
        this.setSize(400, 500);

        // Membuat objek JenisMemberDao dan MemberDao
        this.jenisMemberDao = new JenisMemberDao();
        this.memberDao = new MemberDao();

        // Membuat objek JenisMemberFrame dan MemberFrame
        this.jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        this.memberFrame = new MemberFrame(memberDao, jenisMemberDao);

        // Mengatur layout frame menjadi FlowLayout
        this.setLayout(new FlowLayout());

        // Membuat action listener untuk tombol utama
        MainButtonActionListener actionListener = new MainButtonActionListener(this);

        // Membuat tombol JenisMember dan Member
        this.buttonJenisMember = new JButton("Jenis Member");
        this.buttonMember = new JButton("Member");

        // Menambahkan action listener ke tombol JenisMember dan Member
        this.buttonJenisMember.addActionListener(actionListener);
        this.buttonMember.addActionListener(actionListener);

        // Menambahkan tombol-tombol ke dalam frame
        this.add(buttonJenisMember);
        this.add(buttonMember);
    }

    // Metode untuk mendapatkan tombol JenisMember
    public JButton getButtonJenisMember() {
        return buttonJenisMember;
    }

    // Metode untuk mendapatkan tombol Member
    public JButton getButtonMember() {
        return buttonMember;
    }

    // Metode untuk menampilkan frame JenisMember
    public void showJenisMemberFrame() {
        // Jika JenisMemberFrame belum dibuat, buat satu
        if (jenisMemberFrame == null) {
            jenisMemberFrame = new JenisMemberFrame(jenisMemberDao);
        }
        jenisMemberFrame.setVisible(true);
    }

    // Metode untuk menampilkan frame Member
    public void showMemberFrame() {
        // Membuat objek MemberFrame dan menampilkan frame
        memberFrame = new MemberFrame(memberDao, jenisMemberDao);
        memberFrame.populateComboJenis();
        memberFrame.setVisible(true);
    }

    // Metode utama untuk menjalankan aplikasi Swing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Membuat objek MainFrame dan menampilkannya
                MainFrame f = new MainFrame();
                f.setVisible(true);
            }
        });
    }
}

