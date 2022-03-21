import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PodcastDbOperation {

    public  int createCelibrity(String celibrityName,String celibrityDob )
    {
        int celibrity_Id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String Query = "select celibrity_Id from Celibrity where celibrityName=?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, celibrityName);
            ResultSet rst = ps.executeQuery();
            if (rst.next()) {
                celibrity_Id = rst.getInt(1);
            }
            else
            {
                String celibrityQuery = "insert into Celibrity(celibrityName,celibrityDob) values(?,?)";
                PreparedStatement pst = con.prepareStatement(celibrityQuery, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, celibrityName);
                pst.setString(2, celibrityDob);
                int result = pst.executeUpdate();
                if (result == 1) {
                    ResultSet rs = pst.getGeneratedKeys();
                    if (rs.next()) {
                        celibrity_Id = rs.getInt(1);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e + "jvv");
        } finally {
           return celibrity_Id;
        }

    }
    public  int  createNarrator(String narratorName,String narratorGender )
    {
        int narrator_id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String Query = "select narrator_id from Narrator where narratorName=?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, narratorName);
            ResultSet rst = ps.executeQuery();
            if (rst.next()) {
                narrator_id= rst.getInt(1);
            }
            else
            {
                String celibrityQuery = "insert into Narrator(narratorName,narratorGender) values(?,?)";
                PreparedStatement pst = con.prepareStatement(celibrityQuery, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, narratorName);
                pst.setString(2, narratorGender);
                int result = pst.executeUpdate();
                if (result == 1) {
                    ResultSet rs = pst.getGeneratedKeys();
                    if (rs.next()) {
                        narrator_id = rs.getInt(1);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        } finally {
            return narrator_id;
        }
    }

    public int createPodEpisod(String podEpisodeName,String podDuration ,String podDate)
    {
        int podEpisode_id=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String Query = "select podEpisode_Id from PodcastEpisode where podEpisodeName= ?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, podEpisodeName);
            ResultSet rst = ps.executeQuery();
            if (rst.next()) {
                podEpisode_id = rst.getInt(1);
            } else
            {
                String customerQuery = "insert into PodcastEpisode(podEpisodeName,podDuration,podDate) values(?,?,?)";
                PreparedStatement pst = con.prepareStatement(customerQuery, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, podEpisodeName);
                pst.setString(2, podDuration);
                pst.setString(3, podDate);
                int result = pst.executeUpdate();
                if (result == 1) {
                    ResultSet rs = pst.getGeneratedKeys();
                    if (rs.next()) {
                        podEpisode_id= rs.getInt(1);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println(e);
        } finally {
            return podEpisode_id;
        }
    }
    public  int createPodType(String podcastType)
    {
        int podcasttype_id = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");

            String Query = "select podcasttype_id from PodcastType where podcastType=?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, podcastType);
            ResultSet rst = ps.executeQuery();
            if (rst.next()) {
                podcasttype_id = rst.getInt(1);
            }
            else {
                String customerQuery = "insert into PodcastType(podcastType) values(?)";
                PreparedStatement pst = con.prepareStatement(customerQuery, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, podcastType);
                int result = pst.executeUpdate();
                if (result == 1) {
                    ResultSet rs = pst.getGeneratedKeys();
                    if (rs.next()) {
                        podcasttype_id = rs.getInt(1);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return podcasttype_id;
        }
    }
    public void createPodcast(String podcastName,int celibrity_Id, int narrator_id, int podcasttype_id, int podEpisode_Id)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String customerQuery = "insert into Podcast(podcastName,celibrity_Id,narrator_id,podcasttype_id,podEpisode_Id) values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(customerQuery);
            ps.setString(1, podcastName);
            ps.setInt(2, celibrity_Id);
            ps.setInt(3, narrator_id);
            ps.setInt(4, podcasttype_id);
            ps.setInt(5, podEpisode_Id);
            int result = ps.executeUpdate();
            if (result == 1) {
                    System.out.println("create podcast with name "+podcastName+" successful");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<PodcastView> podcastView() {
        List<PodcastView> listview = new ArrayList<PodcastView>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String query = "select * from PodcastView";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PodcastView sd = new PodcastView(rs.getString(1), rs.getString(2), rs.getString(3)
                        , rs.getString(4), rs.getString(5));
                listview.add(sd);
            }
        } catch (Exception e) {

        }
        return listview;
    }
}
