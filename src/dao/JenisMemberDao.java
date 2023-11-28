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
import jenis_member.JenisMember;

/**
 *
 * @author Shinichi
 */
// Mendefinisikan kelas JenisMemberDao
public class JenisMemberDao {
    
    // Metode untuk memasukkan data JenisMember ke dalam tabel jenis_member
    public int insert(JenisMember jenisMember) {
        // Inisialisasi variabel result dengan nilai awal -1
        int result = -1;
        // Mencoba mendapatkan koneksi menggunakan try-with-resources
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk menyusun pernyataan SQL insert
            PreparedStatement statement = connection.prepareStatement("Insert into jenis_member(id, nama) values (?, ?)");
            // Mengatur nilai parameter pertama (ID)
            statement.setString(1, jenisMember.getId());
            // Mengatur nilai parameter kedua (nama)
            statement.setString(2, jenisMember.getNama());
            // Eksekusi pernyataan SQL insert dan menyimpan hasilnya
            result = statement.executeUpdate();
        } catch (SQLException e) {
            // Menangani pengecualian SQLException dengan mencetak trace
            e.printStackTrace();
        }
        // Mengembalikan nilai hasil eksekusi pernyataan SQL
        return result;
    }
    
    // Metode untuk memperbarui data JenisMember dalam tabel jenis_member
    public int update(JenisMember jenisMember) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk menyusun pernyataan SQL update
            PreparedStatement statement = connection.prepareStatement("update jenis_member set nama = ? where id = ?");
            // Mengatur nilai parameter pertama (nama)
            statement.setString(1, jenisMember.getNama());
            // Mengatur nilai parameter kedua (ID)
            statement.setString(2, jenisMember.getId());
            // Eksekusi pernyataan SQL update dan menyimpan hasilnya
            result = statement.executeUpdate();
        } catch (SQLException e) {
            // Menangani pengecualian SQLException dengan mencetak trace
            e.printStackTrace();
        }
        // Mengembalikan nilai hasil eksekusi pernyataan SQL
        return result;
    }
    
    // Metode untuk menghapus data JenisMember dari tabel jenis_member
    public int delete(JenisMember jenisMember) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk menyusun pernyataan SQL delete
            PreparedStatement statement = connection.prepareStatement("delete from jenis_member where id = ?");
            // Mengatur nilai parameter pertama (ID)
            statement.setString(1, jenisMember.getId());
            // Eksekusi pernyataan SQL delete dan menyimpan hasilnya
            result = statement.executeUpdate();
        } catch (SQLException e) {
            // Menangani pengecualian SQLException dengan mencetak trace
            e.printStackTrace();
        }
        // Mengembalikan nilai hasil eksekusi pernyataan SQL
        return result;
    }
    
    // Metode untuk mengambil semua data JenisMember dari tabel jenis_member
    public List<JenisMember> findAll() {
        // Membuat objek ArrayList untuk menyimpan hasil query
        List<JenisMember> list = new ArrayList<>();
        // Mencoba mendapatkan koneksi dan membuat Statement
        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();
            ) {
            // Mencoba eksekusi query SQL untuk mengambil semua data
            try (ResultSet resultSet = statement.executeQuery("select * from jenis_member");) {
                // Iterasi melalui hasil ResultSet
                while(resultSet.next()) {
                    // Membuat objek JenisMember untuk setiap baris hasil
                    JenisMember jenisMember = new JenisMember();
                    // Mengatur nilai ID dari hasil query ke objek JenisMember
                    jenisMember.setId(resultSet.getString("id"));
                    // Mengatur nilai nama dari hasil query ke objek JenisMember
                    jenisMember.setNama(resultSet.getString("nama"));
                    // Menambahkan objek JenisMember ke dalam daftar
                    list.add(jenisMember);
                }
            } catch (SQLException e) {
                // Menangani pengecualian SQLException dengan mencetak trace
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // Menangani pengecualian SQLException untuk blok utama dengan mencetak trace
            e.printStackTrace();
        }
        // Mengembalikan daftar objek JenisMember yang telah ditemukan
        return list;
    }
}
