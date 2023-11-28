/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import member.Member;
import member.MemberFrame;
import jenis_member.JenisMember;

/**
 *
 * @author Shinichi
 */
// Mendefinisikan kelas MemberDao
public class MemberDao {
    
    // Metode untuk memasukkan data Member ke dalam tabel member
    public int insert(Member member) {
        // Inisialisasi variabel result dengan nilai awal -1
        int result = -1;
        // Mencoba mendapatkan koneksi menggunakan try-with-resources
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk menyusun pernyataan SQL insert
            PreparedStatement statement = connection.prepareStatement("Insert into member(id, nama, jenis_member_id) values (?, ?, ?)");
            // Mengatur nilai parameter pertama (ID)
            statement.setString(1, member.getId());
            // Mengatur nilai parameter kedua (nama)
            statement.setString(2, member.getNama());
            // Mengatur nilai parameter ketiga (jenis_member_id) dengan mengambil ID dari objek JenisMember
            statement.setString(3, member.getJenisMember().getId());
            // Eksekusi pernyataan SQL insert dan menyimpan hasilnya
            result = statement.executeUpdate();
        } catch (SQLException e) {
            // Menangani pengecualian SQLException dengan mencetak trace
            e.printStackTrace();
        }
        // Mengembalikan nilai hasil eksekusi pernyataan SQL
        return result;
    }
    
    // Metode untuk memperbarui data Member dalam tabel member
    public int update(Member member) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk menyusun pernyataan SQL update
            PreparedStatement statement = connection.prepareStatement("update member set nama = ?, jenis_member_id = ? where id = ?");
            // Mengatur nilai parameter pertama (nama)
            statement.setString(1, member.getNama());
            // Mengatur nilai parameter kedua (jenis_member_id) dengan mengambil ID dari objek JenisMember
            statement.setString(2, member.getJenisMember().getId());
            // Mengatur nilai parameter ketiga (ID)
            statement.setString(3, member.getId());
            // Eksekusi pernyataan SQL update dan menyimpan hasilnya
            result = statement.executeUpdate();
        } catch (SQLException e) {
            // Menangani pengecualian SQLException dengan mencetak trace
            e.printStackTrace();
        }
        // Mengembalikan nilai hasil eksekusi pernyataan SQL
        return result;
    }
    
    // Metode untuk menghapus data Member dari tabel member
    public int delete(Member member) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk menyusun pernyataan SQL delete
            PreparedStatement statement = connection.prepareStatement("delete from member where id = ?");
            // Mengatur nilai parameter pertama (ID)
            statement.setString(1, member.getId());
            // Eksekusi pernyataan SQL delete dan menyimpan hasilnya
            result = statement.executeUpdate();
        } catch (SQLException e) {
            // Menangani pengecualian SQLException dengan mencetak trace
            e.printStackTrace();
        }
        // Mengembalikan nilai hasil eksekusi pernyataan SQL
        return result;
    }
    
    // Metode untuk mengambil semua data Member dari tabel member dengan informasi jenis_member dari tabel jenis_member
    public List<Member> findAll() {
        // Membuat objek ArrayList untuk menyimpan hasil query
        List<Member> list = new ArrayList<>();
        // Mencoba mendapatkan koneksi dan membuat Statement
        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();
            ) {
            // Mencoba eksekusi query SQL untuk mengambil semua data dengan menggabungkan tabel member dan jenis_member
            try (ResultSet resultSet = statement.executeQuery("select * from member join jenis_member on jenis_member.id = member.jenis_member_id")) {
                // Iterasi melalui hasil ResultSet
                while(resultSet.next()) {
                    // Membuat objek Member untuk setiap baris hasil
                    Member member = new Member();
                    // Mengatur nilai ID dari hasil query ke objek Member
                    member.setId(resultSet.getString("id"));
                    // Mengatur nilai nama dari hasil query ke objek Member
                    member.setNama(resultSet.getString("nama"));
                    
                    // Membuat objek JenisMember
                    JenisMember jenisMember = new JenisMember();
                    // Mengatur nilai ID dari hasil query ke objek JenisMember
                    jenisMember.setId(resultSet.getString("jenis_member_id"));
                    // Mengatur nilai nama dari hasil query ke objek JenisMember
                    jenisMember.setNama(resultSet.getString("nama"));
                    
                    // Mengatur objek JenisMember ke dalam objek Member
                    member.setJenisMember(jenisMember);
                    
                    // Menambahkan objek Member ke dalam daftar
                    list.add(member);
                }
            } catch (SQLException e) {
                // Menangani pengecualian SQLException dengan mencetak trace
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // Menangani pengecualian SQLException untuk blok utama dengan mencetak trace
            e.printStackTrace();
        }
        // Mengembalikan daftar objek Member yang telah ditemukan
        return list;
    }
}

