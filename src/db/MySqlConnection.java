/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Shinichi
 */
// Kelas untuk mengelola koneksi ke database MySQL
public class MySqlConnection {

    // URL database MySQL
    private final static String DB_URL = "jdbc:mysql://localhost:3306/pp2_membership";
    
    // Nama pengguna database MySQL
    private final static String DB_USER = "root";
    
    // Kata sandi database MySQL
    private final static String DB_PASS = "";
    
    // Instance dari kelas MySqlConnection
    private static MySqlConnection instance;

    // Metode untuk mendapatkan instance dari MySqlConnection (singleton pattern)
    public static MySqlConnection getInstance() {
        // Jika instance belum dibuat, buat satu
        if (instance == null) {
            instance = new MySqlConnection();
        }
        // Mengembalikan instance
        return instance;
    }

    // Metode untuk mendapatkan koneksi ke database
    public Connection getConnection() {
        // Inisialisasi objek Connection
        Connection connection = null;
        try {
            // Mendaftarkan driver JDBC MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Membuat koneksi ke database dengan URL, nama pengguna, dan kata sandi
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (Exception e) {
            // Menangani pengecualian dengan mencetak trace
            e.printStackTrace();
        }
        // Mengembalikan objek Connection
        return connection;
    }
}

