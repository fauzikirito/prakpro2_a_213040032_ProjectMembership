/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member;
import jenis_member.JenisMember;
/**
 *
 * @author Shinichi
 */
// Kelas yang merepresentasikan entitas Member
public class Member {

    // Variabel instance untuk menyimpan ID Member
    private String id;

    // Variabel instance untuk menyimpan nama Member
    private String nama;

    // Variabel instance untuk menyimpan jenisMember terkait
    private JenisMember jenisMember;

    // Metode untuk mengatur nilai ID Member
    public void setId(String id) {
        this.id = id;
    }

    // Metode untuk mendapatkan nilai ID Member
    public String getId() {
        return this.id;
    }

    // Metode untuk mengatur nilai nama Member
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Metode untuk mendapatkan nilai nama Member
    public String getNama() {
        return this.nama;
    }

    // Metode untuk mengatur nilai jenisMember terkait
    public void setJenisMember(JenisMember jenisMember) {
        this.jenisMember = jenisMember;
    }

    // Metode untuk mendapatkan nilai jenisMember terkait
    public JenisMember getJenisMember() {
        return this.jenisMember;
    }
}

