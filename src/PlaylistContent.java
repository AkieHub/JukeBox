import java.sql.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistContent {
    Scanner sc=new Scanner(System.in);
    public int createPlayListid(String playlistName) {
        int playList_Id = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String Query = "select playlist_id from playlist where playlistName=?";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, playlistName);
            ResultSet rst = ps.executeQuery();
            if (rst.next()) {
                playList_Id = rst.getInt(1);
            } else {
                String celibrityQuery = "insert into playlist(playlistName) values(?)";
                PreparedStatement pst = con.prepareStatement(celibrityQuery, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, playlistName);
                int result = pst.executeUpdate();
                if (result == 1) {
                    ResultSet rs = pst.getGeneratedKeys();
                    if (rs.next()) {
                        playList_Id = rs.getInt(1);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e + "f");
        } finally {
            return playList_Id;
        }
    }

    public int bycelebrity(String data ,int choice) {
        int podcast_id = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String Query;
            if(choice==1) {
                Query = "select podcast_id from podcast where celibrity_Id in (select celibrity_Id from Celibrity where celibrityName=?)";
            }
            else {
                Query = "select podcast_id from podcast where podEpisode_Id in (select podEpisode_Id from PodcastEpisode where podDate=?)";
            }
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, data);
            ResultSet rst = ps.executeQuery();
            if (rst.next()) {
                podcast_id = rst.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e + "e");
        }
        return podcast_id;
    }
    public int bysong(String name, int choice) {
        int song_id = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String Query="";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            if (choice==1) {
                Query="select song_id from song where songname=?";
            }
            else if (choice==2)
            {
                Query = "select song_id from song where artist_id in(select artist_id from artist where artistname=?)";

            }
            else if (choice==3)
            {
                Query="select song_id from song where album_id in(select album_id from album where albumname=?)";
            }
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setString(1, name);
            ResultSet rst = ps.executeQuery();
            if (rst.next()) {
                song_id = rst.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e + "b");
        }
        return song_id;
    }

    //int playList_ID, int content_Id, int track_id, String playListName,int podcast_Id,
    //             String podcastName,int celibrity_Id,int narrator_id,int podcasttype_id) {

    public List<PlayListMasterView> getAllPlaylistContent()
    {
        List<PlayListMasterView> ob=new ArrayList<PlayListMasterView>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String Query = "select * from PlayListMasterView";
            PreparedStatement ps = con.prepareStatement(Query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(6)==null) // episode type
                {
                    PlayListPodcastView obj = new PlayListPodcastView(rs.getInt(1),
                            rs.getInt(2),rs.getInt(3),rs.getString(4),
                            rs.getInt(11),
                            rs.getString(12),rs.getInt(13),
                            rs.getInt(14),rs.getInt(15)
                    );
                    ob.add(obj);
                }
                else{ // song type
                    PlayListSongView obj = new PlayListSongView(
                            rs.getInt(1),
                            rs.getInt(2),rs.getInt(3),rs.getString(4),
                            rs.getInt(5),rs.getString(6),rs.getString(7)
                            , rs.getInt(8), rs.getInt(9), rs.getInt(10)
                    );
                    ob.add(obj);
                }
            }
        } catch (Exception e) {
            System.out.println(e + "z");
        }
       return ob;
    }
    public void insertinConext(int playlistid,int track)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JukeboxData", "root", "Akie1996");
            String Query = "insert into PlayListContent(playList_ID,track_id) values(?,?) ";
            PreparedStatement ps = con.prepareStatement(Query);
            ps.setInt(1, playlistid);
            ps.setInt(2, track);
            int rst = ps.executeUpdate();
            if (rst==1) {
                System.out.println("u playlist create");
            }
        } catch (Exception e) {
            System.out.println(e + "i");
        }
    }
    public void songPlaylist() {
        boolean flag=false;
        SongDbOperation sd=new SongDbOperation();
        List<SongData> sl=sd.retrivedata();
        System.out.println("if u want create playlist with song name plz enter" +
                "1 and song name for artist press 2 artist name and for album press 3 and album name");
        int choice= sc.nextInt();
        String data= sc.next();
        if (choice==1)
        {
            for(SongData pw:sl)
            {
                if (pw.getSongName().equalsIgnoreCase(data)) {
                    int songid = bysong(data,choice);
                    System.out.println("plz enter playlist name");
                    data = sc.next();
                    int playid = createPlayListid(data);
                    insertinConext(playid, songid);
                    break;
                }
                else flag=true;

            }
        }
        else if (choice==2)
        {
            for(SongData pw:sl)
            {
                if (pw.getArtistName().equalsIgnoreCase(data)) {
                    int songid = bysong(data,choice);
                    System.out.println("plz enter playlist name");
                    data = sc.next();
                    int playid = createPlayListid(data);
                    insertinConext(playid,songid);
                    break;
                }
                else flag=true;
            }
        }
        else if (choice==3)
        {
            for(SongData pw:sl)
            {
                if (pw.getAlbumName().equalsIgnoreCase(data)) {
                    int songid = bysong(data,choice);
                    System.out.println("plz enter playlist name");
                    data = sc.next();
                    int playid = createPlayListid(data);
                    insertinConext(playid,songid);
                    break;
                }
                else flag=true;
            }

        }
        else {
            System.out.println("enter valid input like \n1 For song name\n2 For Artist name\n3 For Album name and try on more time");
            songPlaylist();
        }
        if (flag==true)
        {
            System.out.println("data is not matches"+data);
        }

    }

    public void podcastPlayList()
    {
        boolean flag=false;
        PodcastDbOperation pd=new PodcastDbOperation();
        List<PodcastView>pv=pd.podcastView();
        System.out.println("if u want create playlist with celebrity name plz enter" +
                "1 and celebrity name for podcast name press 2 and name");
        int choice= sc.nextInt();
        String data= sc.next();
        if (choice==1)
        {
            for(PodcastView pw:pv)
            {
                if (pw.getCelibrityName().equalsIgnoreCase(data)) {
                    int celebrityid = bycelebrity(data, choice);
                   System.out.println("plz enter playlist name");
                    data = sc.next();
                    int playid = createPlayListid(data);
                    insertinConext(playid, celebrityid);
                    break;
                }
                else flag=true;

            }
        }
        else if (choice==2)
        {
            for(PodcastView pw:pv)
            {
                if(pw.getPodcastName().equalsIgnoreCase(data)) {
                    int celebrityid = bycelebrity(data, choice);
                    System.out.println("plz enter playlist name");
                    data = sc.next();
                    int playid = createPlayListid(data);
                    insertinConext(playid, celebrityid);
                    break;
                }
                else flag=true;
            }
        }
        else {
            System.out.println("enter valid input like\n1 For celebrity name\n 2 For podcast name and try again");
            podcastPlayList();
        }
        if (flag==true)
        {
            System.out.println("data is not matches"+data);
        }
    }

}

