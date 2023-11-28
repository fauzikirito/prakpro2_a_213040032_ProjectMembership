/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member;

import dao.JenisMemberDao;
import javax.swing.table.*;
import java.util.List;
import jenis_member.JenisMember;

/**
 *
 * @author Shinichi
 */
// Kelas yang mengimplementasikan AbstractTableModel untuk data Member
public class MemberTableModel extends AbstractTableModel {

    // Array untuk nama-nama kolom dalam tabel
    private String[] columnNames = {"Nama", "Jenis Member"};

    // List untuk menyimpan data Member
    private List<Member> data;

    // Objek JenisMemberDao untuk mengakses dan memanipulasi data JenisMember
    private JenisMemberDao jenisMember = new JenisMemberDao();

    // List untuk menyimpan data JenisMember
    private List<JenisMember> dataJenisMember = jenisMember.findAll();

    // Konstruktor untuk inisialisasi data Member
    public MemberTableModel(List<Member> data) {
        this.data = data;
    }

    // Metode untuk mendapatkan jumlah kolom dalam tabel
    public int getColumnCount() {
        return columnNames.length;
    }

    // Metode untuk mendapatkan jumlah baris dalam tabel
    public int getRowCount() {
        return data.size();
    }

    // Metode untuk mendapatkan nama kolom pada indeks tertentu
    public String getColumnName(int col) {
        return columnNames[col];
    }

    // Metode untuk mendapatkan nilai pada sel tabel berdasarkan baris dan kolom
    public Object getValueAt(int row, int col) {
        // Mendapatkan objek Member pada baris tertentu
        Member rowItem = data.get(row);
        String value = "";

        // Memilih nilai berdasarkan indeks kolom
        switch (col) {
            // Jika kolom pertama, ambil nilai Nama dari Member
            case 0:
                value = rowItem.getNama();
                break;
            // Jika kolom kedua, cari Jenis Member yang sesuai dan ambil nilai Nama Jenis Member
            case 1:
                for (JenisMember jenis : this.dataJenisMember) {
                    if (jenis.getId().equals(rowItem.getJenisMember().getId())) {
                        // Menampilkan nama Jenis Member ke konsol (opsional)
                        System.out.println(rowItem.getJenisMember().getNama());
                        // Mengambil nama Jenis Member
                        value = jenis.getNama();
                    }
                }
                break;
        }

        return value;
    }

    // Metode untuk menentukan apakah sel dapat diedit atau tidak
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    // Metode untuk menambahkan data Member baru ke dalam tabel
    public void add(Member value) {
        data.add(value);
        // Memberi tahu tabel bahwa baris telah ditambahkan
        fireTableRowsInserted(data.size()-1, data.size()-1);
    }
}

