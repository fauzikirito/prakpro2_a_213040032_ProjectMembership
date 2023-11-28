/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member;

import jenis_member.*;
import java.awt.event.*;
import java.util.UUID;
import dao.MemberDao;
/**
 *
 * @author Shinichi
 */
// Kelas yang mengimplementasikan ActionListener untuk tombol simpan pada MemberFrame
public class MemberButtonSimpanActionListener implements ActionListener {

    // Variabel instance untuk MemberFrame yang akan dioperasikan
    private MemberFrame memberFrame;

    // Variabel instance untuk MemberDao yang digunakan untuk interaksi dengan database
    private MemberDao memberDao;

    // Konstruktor MemberButtonSimpanActionListener dengan parameter MemberFrame dan MemberDao
    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }

    // Metode yang diimplementasikan dari ActionListener
    public void actionPerformed(ActionEvent e) {
        // Mendapatkan nama dari MemberFrame
        String nama = this.memberFrame.getNama();

        // Memeriksa apakah nama kosong
        if (nama.isEmpty()) {
            // Jika ya, tampilkan pesan peringatan
            this.memberFrame.showAlert("Nama Tidak Boleh Kosong");
        } else {
            // Jika tidak, ambil jenisMember dan buat objek Member baru
            JenisMember jenisMember = this.memberFrame.getJenisMember();
            Member member = new Member();
            member.setId(UUID.randomUUID().toString());
            member.setNama(nama);
            member.setJenisMember(jenisMember);

            // Menambahkan Member ke MemberFrame dan menyimpannya ke database
            this.memberFrame.addMember(member);
            this.memberDao.insert(member);
        }
    }
}

