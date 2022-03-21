public class PlayListSongView extends PlayListMasterView {
int song_id;
String songName;
String songDruration;
int artist_id;
int album_Id;
int genre_id;
//public PlayListMasterView(int playList_ID, int content_Id, int track_id, String playListName) {
    public PlayListSongView(int playList_ID, int content_Id, int track_id, String playListName,int song_id,
                            String songName,String songDruration,int artist_id,int album_Id,int genre_id) {
        super(playList_ID, content_Id, track_id, playListName);
        this.song_id=song_id;
        this.songName=songName;
        this.songDruration=songDruration;
        this.artist_id=artist_id;
        this.album_Id=album_Id;
        this.genre_id=genre_id;

    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDruration() {
        return songDruration;
    }

    public void setSongDruration(String songDruration) {
        this.songDruration = songDruration;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public int getAlbum_Id() {
        return album_Id;
    }

    public void setAlbum_Id(int album_Id) {
        this.album_Id = album_Id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    @Override
    public String toString() {
        return "PlayListSongView{" +
                "playList_ID=" + playList_ID +
                ", content_Id=" + content_Id +
                ", track_id=" + track_id +
                ", playListName='" + playListName + '\'' +
                ", song_id=" + song_id +
                ", songName='" + songName + '\'' +
                ", songDruration='" + songDruration + '\'' +
                ", artist_id=" + artist_id +
                ", album_Id=" + album_Id +
                ", genre_id=" + genre_id +
                '}';
    }
}
