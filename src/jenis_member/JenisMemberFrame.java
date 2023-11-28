/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_member;


import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import dao.JenisMemberDao;
import java.awt.HeadlessException;

/**
 *
 * @author Shinichi
 */
// Kelas JenisMemberFrame yang mengextends JFrame
public class JenisMemberFrame extends JFrame {

    // Variabel instance untuk menyimpan daftar JenisMember
    private List<JenisMember> jenisMemberList;

    // Variabel instance untuk JTextField yang digunakan untuk input nama
    private JTextField textFieldNama;

    // Variabel instance untuk table model yang digunakan dalam JTable
    private JenisMemberTableModel tableModel;

    // Variabel instance untuk JenisMemberDao yang digunakan untuk interaksi dengan database
    private JenisMemberDao jenisMemberDao;

    // Konstruktor JenisMemberFrame dengan parameter JenisMemberDao
    public JenisMemberFrame(JenisMemberDao jenisMemberDao) {
        // Mengatur JenisMemberDao yang diterima dari parameter
        this.jenisMemberDao = jenisMemberDao;

        // Mengambil daftar JenisMember dari database
        this.jenisMemberList = this.jenisMemberDao.findAll();

        // Mengatur operasi default ketika frame ditutup
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Membuat label untuk input nama
        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15, 40, 350, 10);

        // Membuat JTextField untuk input nama
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        // Membuat JButton untuk menyimpan data
        JButton button = new JButton("Simpan");
        button.setBounds(15, 100, 100, 40);

        // Membuat JTable dan JScrollPane untuk menampilkannya
        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 150, 350, 200);

        // Membuat JenisMemberTableModel dan mengatur model tabel
        tableModel = new JenisMemberTableModel(jenisMemberList);
        table.setModel(tableModel);

        // Membuat action listener untuk tombol Simpan
        JenisMemberButtonSimpanActionListener actionListener = new JenisMemberButtonSimpanActionListener(this, jenisMemberDao);

        // Menambahkan action listener ke tombol Simpan
        button.addActionListener(actionListener);

        // Menambahkan komponen-komponen ke frame
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(scrollableTable);

        // Mengatur ukuran dan layout frame
        this.setSize(400, 500);
        this.setLayout(null);
    }

    // Metode untuk mendapatkan nilai dari input nama
    public String getNama() {
        return textFieldNama.getText();
    }

    // Metode untuk menambahkan JenisMember ke dalam table model
    public void addJenisMember(JenisMember jenisMember) {
        tableModel.add(jenisMember);
        textFieldNama.setText(""); //Mengembalikan textFieldNama ke keadaan semula (kosong)
    }
}

