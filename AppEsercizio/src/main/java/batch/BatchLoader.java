package batch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchLoader
{
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args)
    {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD))
        {
            connection.setAutoCommit(false);

            loadPrenotante(connection, "src/main/resources/prenotanti.csv");

            loadGelato(connection, "src/main/resources/gelati.csv");

            loadPrenotazione(connection, "src/main/resources/prenotazioni.csv");

            connection.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void loadGelato(Connection connection, String filePath)
    {
        String sql = "INSERT INTO gelato (id, nome, descrizione) VALUES (?, ?, ?)";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             PreparedStatement pstmt = connection.prepareStatement(sql))
        {

            String line = br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] fields = line.split(",");
                pstmt.setInt(1, Integer.parseInt(fields[0]));
                pstmt.setString(2, fields[1]);
                pstmt.setString(3, fields[2]);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
        catch (Exception e)
        {
            System.err.println("Errore durante il caricamento di gelato: " + e.getMessage());
        }
    }

    private static void loadPrenotante(Connection connection, String filePath)
    {
        String sql = "INSERT INTO prenotante (id, nome) VALUES (?, ?)";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            String line = br.readLine(); // Salta la prima riga
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                pstmt.setInt(1, Integer.parseInt(fields[0]));
                pstmt.setString(2, fields[1]);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
        catch (Exception e)
        {
            System.err.println("Errore durante il caricamento di prenotante: " + e.getMessage());
        }
    }

    private static void loadPrenotazione(Connection connection, String filePath)
    {
        String sql = "INSERT INTO prenotazione (id_prenotante, id_gelato) VALUES (?, ?)";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             PreparedStatement pstmt = connection.prepareStatement(sql))
        {
            String line = br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] fields = line.split(",");
                pstmt.setInt(1, Integer.parseInt(fields[0]));
                pstmt.setInt(2, Integer.parseInt(fields[1]));
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }
        catch (Exception e)
        {
            System.err.println("Errore durante il caricamento di prenotazione: " + e.getMessage());
        }
    }
}
