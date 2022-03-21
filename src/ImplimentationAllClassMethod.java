import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ImplimentationAllClassMethod {
    Scanner sc = new Scanner(System.in);
    SongDbOperation as = new SongDbOperation();
    int count;
    String b[];
    public void addsong() {
        System.out.println("plz enter Artist name and gender and DOB");
        String aname = sc.next();
        String gender = sc.next();
        String date = sc.next();
        int b = as.createArtist(aname, gender, date);
        System.out.println("plz enter Album name and date of album");
        String abname = sc.next();
        String adate = sc.next();
        int a = as.createAlbum(abname, adate);
        System.out.println("plz enter Genre Type");
        String agname = sc.next();
        int c = as.createGenre(agname);
        System.out.println("plz enter song name and duration");
        String name = sc.next();
        String duration = sc.next();
        if (as.createSong(name, duration, b, a, c)) {
            System.out.println("successful create");
        } else {
            System.out.println("Something went to wrong");
        }

    }

    public void showallSong() {
        List<SongData> rob = as.retrivedata();
        Consumer<SongData> c = (k) -> System.out.println(k);
        rob.forEach(c);
    }

    public List<SongData> searchSong(String data) {
        List<SongData> rob = as.retrivedata();
        List<SongData> ob = rob.stream().filter(p -> p.getSongName().equalsIgnoreCase(data)).collect(Collectors.toList());
        return ob;
    }

    public List<SongData> searchAlbum(String data) {
        List<SongData> rob = as.retrivedata();
        List<SongData> ob = rob.stream().filter(p -> p.getAlbumName().equalsIgnoreCase(data)).collect(Collectors.toList());
        return ob;
    }

    public List<SongData> searchArtist(String data) {
        List<SongData> rob = as.retrivedata();
        List<SongData> ob = rob.stream().filter(p -> p.getArtistName().equalsIgnoreCase(data)).collect(Collectors.toList());
        return ob;
    }
    public void showSongBaseOnfiltter(String data)
    {
        System.out.println("plz enter choice \nBy song press 1\nBy album press 2" +
                "\nBy artist press 3");
        int a=sc.nextInt();
        if (a==1){
            List<SongData>sd= searchSong(data);
            for (SongData x : sd) {
                System.out.println(x);
            }
        }
        else if (a==2){
            List<SongData>sd= searchAlbum(data);
            for (SongData x : sd) {
                System.out.println(x);
            }
        }
        else if (a==3){
            List<SongData>sd= searchArtist(data);
            for (SongData x : sd) {
                System.out.println(x);
            }
        }
        else {System.out.println("enter valid input");}

    }

    public void createpodcast() {
        PodcastDbOperation sp = new PodcastDbOperation();
        System.out.println("For Creating Podcast plz enter follows details");
        System.out.println("Plz enter the Celebrity details 'Celebrity name and dob'");
        String name = sc.next();
        String dob = sc.next();
        int a = sp.createCelibrity(name, dob);
        System.out.println("Plz enter the Narrator details 'name and gender'");
        name = sc.next();
        String gender = sc.next();
        int b = sp.createNarrator(name, gender);
        System.out.println("plz enter the podcast episode details 'episode name and date and duration'");
        name = sc.next();
        String podDuration = sc.next();
        String podDate = sc.next();
        int c = sp.createPodEpisod(name, podDate, podDuration);
        System.out.println("plz enter the which type 'podcast' is this");
        name = sc.next();
        int d = sp.createPodType(name);
        System.out.println("plz enter your' podcast name 'which make it ready to use");
        name = sc.next();
        sp.createPodcast(name, a, b, d, c);

    }

    public void showallPodcast() {
        PodcastDbOperation sp = new PodcastDbOperation();
        List<PodcastView> rob = sp.podcastView();
        Consumer<PodcastView> c = (k) -> System.out.println(k);
        rob.forEach(c);
    }

    public List<PodcastView> searchCelebrityName(String data) {
        PodcastDbOperation sp = new PodcastDbOperation();
        List<PodcastView> rob = sp.podcastView();
        List<PodcastView> ob = rob.stream().filter(p -> p.getCelibrityName().equalsIgnoreCase(data)).collect(Collectors.toList());
        return ob;
    }

    public List<PodcastView> searchPodcastDate(String data) {
        PodcastDbOperation sp = new PodcastDbOperation();
        List<PodcastView> rob = sp.podcastView();
        List<PodcastView> ob = rob.stream().filter(p -> p.getPodDate().equalsIgnoreCase(data)).collect(Collectors.toList());
        return ob;
    }

    public void showplaylistcontent()
    {
        PlaylistContent p=new PlaylistContent();
       List<PlayListMasterView> pm=p.getAllPlaylistContent();
       for (PlayListMasterView x:pm) // x can have Song type of Episode type objects
       {
           System.out.println(x);
       }

    }

    public void songAndPodcastPlayList(int choice)
    {
        List<PlayListSongView> ps=new ArrayList<>();
        List<PlayListPodcastView>pcv=new ArrayList<>();
        PlaylistContent p=new PlaylistContent();
        List<PlayListMasterView> pm=p.getAllPlaylistContent();
        for (PlayListMasterView x:pm) // x can have Song type of Episode type objects
        {
            if( x instanceof PlayListSongView){ // if x is PlayListSongView of object
                ps.add((PlayListSongView) x);
            }
            else {
                pcv.add((PlayListPodcastView) x);
            }

        }
        if (choice==1)
        {
            for (PlayListSongView psv:ps)
            {
                System.out.println(psv);
            }
        }
        else if (choice==2)
        {
            for (PlayListPodcastView psv:pcv)
            {
                System.out.println(psv);
            }
        }
        else if (choice==3)
        {
            showplaylistcontent();
        }
        else
        {
            System.out.println("plz enter valid choice \nFor song playlist enter 1\nFor podcast enter 2\nFor both enter 3 and try again");

        }

    }

    public String[] forPlay(int choice)
    {

        List<PlayListSongView> ps=new ArrayList<>();
        List<PlayListPodcastView>pcv=new ArrayList<>();
        PlaylistContent p=new PlaylistContent();
        List<PlayListMasterView> pm=p.getAllPlaylistContent();
        for (PlayListMasterView x:pm) // x can have Song type of Episode type objects
        {
            if( x instanceof PlayListSongView){ // if x is PlayListSongView of object
                ps.add((PlayListSongView) x);
            }
            else {
                pcv.add((PlayListPodcastView) x);
            }

        }
        int i=0;
        if (choice==1)
        {

            b=new  String[ps.size()];
            for (PlayListSongView psv:ps)
            {
                b[i]=psv.getSongName();
                i++;
            }
        }
        else if (choice==2)
        {
            b=new  String[pcv.size()];
            for (PlayListPodcastView psv:pcv)
            {
                b[i]=psv.getPodcastName();
                i++;
            }
        }
        else if (choice==3)
        {
            b=new  String[pm.size()];
            for (PlayListMasterView x:pm) // x can have Song type of Episode type objects
            {
                if ( x instanceof PlayListSongView){ // if x is PlayListSongView of object
                    b[i]= ((PlayListSongView) x).getSongName();
                    i++;
                }
                else {
                    b[i]= ((PlayListPodcastView) x).getPodcastName();
                    i++;
                }


            }
        }
        else
        {
            System.out.println("plz enter valid choice \nFor song playlist enter 1\nFor podcast enter 2\nFor both enter 3 and try again");

        }
    return b;
    }

}

