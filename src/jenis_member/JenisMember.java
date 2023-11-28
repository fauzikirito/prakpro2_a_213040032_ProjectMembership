/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jenis_member;

/**
 *
 * @author Shinichi
 */
// Kelas yang merepresentasikan entitas JenisMember
public class JenisMember {
    
    // Variabel instance untuk menyimpan ID JenisMember
    private String id;
    
    // Variabel instance untuk menyimpan nama JenisMember
    private String nama;
    
    // Metode untuk mengatur nilai ID JenisMember
    public void setId(String id) {
        this.id = id;
    }
    
    // Metode untuk mendapatkan nilai ID JenisMember
    public String getId() {
        return this.id;
    } 
    
    // Metode untuk mengatur nilai nama JenisMember
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    // Metode untuk mendapatkan nilai nama JenisMember
    public String getNama() {
        return this.nama;
    } 
}

    
