/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_member;


import java.awt.event.*;
import java.util.UUID;
import dao.JenisMemberDao;

/**
 *
 * @author Shinichi
 */
// Kelas yang mengimplementasikan ActionListener untuk tombol simpan pada JenisMemberFrame
public class JenisMemberButtonSimpanActionListener implements ActionListener {
    
    // Variabel instance untuk JenisMemberFrame yang akan dioperasikan
    private JenisMemberFrame jenisMemberFrame;
    
    // Variabel instance untuk JenisMemberDao yang digunakan untuk interaksi dengan database
    private JenisMemberDao jenisMemberDao;
    
    // Konstruktor untuk JenisMemberButtonSimpanActionListener dengan parameter JenisMemberFrame dan JenisMemberDao
    public JenisMemberButtonSimpanActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao) {
        this.jenisMemberFrame = jenisMemberFrame;
        this.jenisMemberDao = jenisMemberDao;
    }
    
    // Metode yang diimplementasikan dari ActionListener
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan nama dari JenisMemberFrame
        String nama = this.jenisMemberFrame.getNama();
        
        // Membuat objek JenisMember baru dengan ID yang dihasilkan secara acak
        JenisMember jenisMember = new JenisMember();
        jenisMember.setId(UUID.randomUUID().toString());
        jenisMember.setNama(nama);
        
        // Menambahkan JenisMember ke JenisMemberFrame
        this.jenisMemberFrame.addJenisMember(jenisMember);
        
        // Memanggil metode insert dari JenisMemberDao untuk menyimpan JenisMember ke database
        this.jenisMemberDao.insert(jenisMember);
    }
}

