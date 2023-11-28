/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_member;

import javax.swing.table.*;
import java.util.List;
/**
 *
 * @author Shinichi
 */
// Kelas JenisMemberTableModel yang mengextends AbstractTableModel
public class JenisMemberTableModel extends AbstractTableModel {

    // Array yang berisi nama kolom tabel
    private String[] columnNames = {"Nama"};

    // List yang menyimpan data JenisMember
    private List<JenisMember> data;

    // Konstruktor JenisMemberTableModel dengan parameter List<JenisMember>
    public JenisMemberTableModel(List<JenisMember> data) {
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

    // Metode untuk mendapatkan nilai dari sel pada baris dan kolom tertentu
    public Object getValueAt(int row, int col) {
        // Mengambil objek JenisMember pada baris tertentu
        JenisMember rowItem = data.get(row);
        // Variabel untuk menyimpan nilai sel
        String value = "";

        // Switch statement untuk menentukan nilai sel berdasarkan indeks kolom
        switch (col) {
            case 0:
                // Jika indeks kolom adalah 0, ambil nilai nama dari JenisMember
                value = rowItem.getNama();
                break;
        }

        // Mengembalikan nilai sel
        return value;
    }

    // Metode untuk menentukan apakah sel dapat diubah (editable) atau tidak
    public boolean isCellEditable(int row, int col) {
        // Selalu mengembalikan false, menandakan bahwa sel tidak dapat diubah
        return false;
    }

    // Metode untuk menambahkan data JenisMember baru ke dalam tabel
    public void add(JenisMember value) {
        // Menambahkan JenisMember ke dalam list data
        data.add(value);
        // Memberitahu model bahwa satu baris telah ditambahkan
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}

