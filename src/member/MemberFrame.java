/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member;

import jenis_member.JenisMember;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import dao.JenisMemberDao;
import dao.MemberDao;

/**
 *
 * @author Shinichi
 */
// Kelas MemberFrame yang mengextends JFrame
public class MemberFrame extends JFrame {

    // List untuk menyimpan data JenisMember
    private List<JenisMember> jenisMemberList;

    // List untuk menyimpan data Member
    private List<Member> memberList;

    // JTextField untuk input nama Member
    private JTextField textFieldNama;

    // JComboBox untuk memilih jenis Member
    private JComboBox comboJenis;

    // Model tabel untuk data Member
    private MemberTableModel tableModel;

    // Objek Dao untuk mengakses dan memanipulasi data Member
    private MemberDao memberDao;

    // Objek Dao untuk mengakses dan memanipulasi data JenisMember
    private JenisMemberDao jenisMemberDao;

    // Konstruktor MemberFrame dengan parameter MemberDao dan JenisMemberDao
    public MemberFrame(MemberDao memberDao, JenisMemberDao jenisMemberDao) {
        // Mengatur operasi default ketika frame ditutup
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Menginisialisasi objek Dao dan list data Member dan JenisMember
        this.memberDao = memberDao;
        this.memberList = memberDao.findAll();

        this.jenisMemberDao = jenisMemberDao;
        this.jenisMemberList = jenisMemberDao.findAll();

        // Membuat komponen-komponen GUI seperti label, text field, combo box, tombol, dan tabel
        JLabel labelInput = new JLabel("Nama: ");
        labelInput.setBounds(15, 40, 350, 10);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelJenis = new JLabel("Jenis Member: ");
        labelJenis.setBounds(15, 100, 350, 10);

        comboJenis = new JComboBox();
        comboJenis.setBounds(15, 120, 150, 30);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 160, 100, 40);

        JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 220, 350, 200);

        // Membuat objek model tabel dan menghubungkannya dengan tabel
        tableModel = new MemberTableModel(memberList);
        table.setModel(tableModel);

        // Membuat action listener untuk tombol "Simpan"
        MemberButtonSimpanActionListener actionListener = new MemberButtonSimpanActionListener(this, memberDao);
        button.addActionListener(actionListener);

        // Menambahkan komponen-komponen ke dalam frame
        this.add(button);
        this.add(textFieldNama);
        this.add(labelInput);
        this.add(labelJenis);
        this.add(comboJenis);
        this.add(scrollableTable);

        // Mengatur ukuran dan layout frame
        this.setSize(400, 500);
        this.setLayout(null);
    }

    // Metode untuk mengisi combo box dengan data JenisMember
    public void populateComboJenis() {
        this.jenisMemberList = this.jenisMemberDao.findAll();
        comboJenis.removeAllItems();
        for (JenisMember jenisMember : this.jenisMemberList) {
            comboJenis.addItem(jenisMember.getNama());
        }
    }

    // Metode untuk mendapatkan nilai dari text field nama
    public String getNama() {
        return textFieldNama.getText();
    }

    // Metode untuk mendapatkan jenis Member yang dipilih dari combo box
    public JenisMember getJenisMember() {
        return jenisMemberList.get(comboJenis.getSelectedIndex());
    }

    // Metode untuk menambahkan data Member ke dalam tabel
    public void addMember(Member member) {
        tableModel.add(member);
        textFieldNama.setText("");
    }

    // Metode untuk menampilkan pesan peringatan
    public void showAlert(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

