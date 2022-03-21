import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDbOperation {
    public int createAlbum(String albumName, String albumDate) {
        int albumId = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String Query = "select album_id from album where albumName=?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, albumName);
            ResultSet rst = ps.executeQuery();
            if (rst.next()) {
                albumId = rst.getInt(1);
            }
            else
            {
                String customerQuery = "insert into Album(albumName,albumDate) values(?,?)";
                PreparedStatement pst = con.prepareStatement(customerQuery, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, albumName);
                pst.setString(2, albumDate);
                int result = pst.executeUpdate();
                if (result == 1) {
                    ResultSet rs = pst.getGeneratedKeys();
                    if (rs.next()) {
                        albumId = rs.getInt(1);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e + "jvv");
        }
        finally {
            return albumId;
        }

    }

    public int createArtist(String artistNam, String artistGender, String artistDob) {
        int artistId = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String Query = "select artist_Id from artist where artistName= ?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, artistNam);
            ResultSet rst = ps.executeQuery();
            if (rst.next()) {
                artistId = rst.getInt(1);
            } else
            {
                String customerQuery = "insert into Artist(artistName,artistGender,artistDob) values(?,?,?)";
                PreparedStatement pst = con.prepareStatement(customerQuery, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, artistNam);
                pst.setString(2, artistGender);
                pst.setString(3, artistDob);
                int result = pst.executeUpdate();
                if (result == 1) {
                    ResultSet rs = pst.getGeneratedKeys();
                    if (rs.next()) {
                        artistId = rs.getInt(1);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e + "jvh");
        } finally {
            return artistId;
        }

    }

    public int createGenre(String genre_Type) {
        int genreId = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");

            String Query = "select genre_id from genre where genre_Type=?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, genre_Type);
            ResultSet rst = ps.executeQuery();
            if (rst.next()) {
                genreId = rst.getInt(1);
            }
            else {
                String customerQuery = "insert into Genre(genre_Type) values(?)";
                PreparedStatement pst = con.prepareStatement(customerQuery, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, genre_Type);
                int result = pst.executeUpdate();
                if (result == 1) {
                    ResultSet rs = pst.getGeneratedKeys();
                    if (rs.next()) {
                        genreId = rs.getInt(1);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ji" + e);
        } finally {
            return genreId;
        }

    }

    public boolean createSong(String songName, String songDruration, int artist_id, int album_Id, int genre_id) {
        boolean songId = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String customerQuery = "insert into Song(songName,songDruration,artist_id,album_Id,genre_id) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(customerQuery);
            ps.setString(1, songName);
            ps.setString(2, songDruration);
            ps.setInt(3, artist_id);
            ps.setInt(4, album_Id);
            ps.setInt(5, genre_id);
            int result = ps.executeUpdate();
            if (result == 1) {


                    songId = true;

            }
        } catch (Exception e) {
            System.out.println("last" + e);
        }
        finally {
            return songId;
        }

    }

    public List<SongData> retrivedata() {
        List<SongData> listdata = new ArrayList<SongData>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String query = "select * from jukeboxView";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SongData sd = new SongData(rs.getString(1), rs.getString(2), rs.getString(3)
                        , rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listdata.add(sd);
            }
        } catch (Exception e) {

        }
        return listdata;
    }
}


