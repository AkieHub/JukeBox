import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String [] args)
    {
        Scanner sc=new Scanner(System.in);

        ImplimentationAllClassMethod ic=new ImplimentationAllClassMethod();
        PlaylistContent play=new PlaylistContent();
        System.out.println("Plz Enter following number for corresponding operation\n" +
                "Add song press 1\nFor view all song press 2\nFor view song by artist name or album name or song name" +
                "press 3\nFor crating podcast press 4\nFor show all podcast 5\nFor particular podcast 6\nFor" +
                "create playlist by podcast 7\nFor create playlist by song enter 8\nFor show content of playlist enter 9\nFor Play Song Enter 10");
        int data=sc.nextInt();
        String datq;
        switch (data)
        {
            case 1: ic.addsong();
            break;
            case 2: ic.showallSong();
            break;
            case 3:
                System.out.println("Search Song Based on\nEnter Artist Name or Enter Album Name or Enter Song Name");
                datq=sc.next();
                ic.showSongBaseOnfiltter(datq);
                break;
            case 4:ic.createpodcast();
            break;
            case 5: ic.showallPodcast();
            break;
            case  6:System.out.println("Plz enter which base you want to filter\nFor Celebrity Name 1" +
                    "\nFor date press 2");
            boolean flag=false;
            data=sc.nextInt();
            if (data==1) {
                System.out.println("plz enter celebrity name");
                datq = sc.next();
                List<PodcastView> pw = ic.searchCelebrityName(datq);
                for (PodcastView x : pw) {
                    System.out.println(x);
                    if (datq.equalsIgnoreCase(x.getCelibrityName())) flag=true;
                }
            }
            else if (data==2)
            {
                System.out.println("plz enter date");
                datq = sc.next();
                List<PodcastView> pw = ic.searchPodcastDate(datq);
                for (PodcastView x : pw) {
                    System.out.println(x);
                    if (datq.equalsIgnoreCase(x.getPodDate())) flag=true;
                }
            }
            else {
                System.out.println("plz valid input");
            }
            if (flag==false)System.out.println("Data is not present");
                break;
            case 7:play.podcastPlayList();
            break;
            case  8:play.songPlaylist();
            break;
            case 9:System.out.println("which type playList you want to see " +
                    "\nFor song playlist enter 1\nFor podcast enter 2\nFor both enter 3");
                int choice=sc.nextInt();
                ic.songAndPodcastPlayList(choice);
            break;
            case 10:
                System.out.println("which base you want to play song\n1 For By Song\n2 For By Podcast\n3 For By Both");
                int choie=sc.nextInt();
                String a[]=ic.forPlay(choie);
                String filePath ="\\A:\\songs\\"+a[0]+".wav";
                PlayMusic audioPlayer = new PlayMusic(a,filePath);
                System.out.println("PlayList Content This Song ");
                for (String h:a)
                {
                    System.out.println(h);
                }

                while (true)
                {
                    System.out.println("1. Play");
                    System.out.println("2. Pause");
                    System.out.println("3. Resume");
                    System.out.println("4. next");
                    System.out.println("5. stop");
                    choie = sc.nextInt();
                    audioPlayer.gotoChoice(choie);
                    if (choie == 5)
                        break;
                }
                sc.close();
                break;
            default:System.out.println("Enter vaalid input");
        }



    }
}
