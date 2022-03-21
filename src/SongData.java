public class SongData {
    private String songName;
    private String songDuration;
    private String artistName;
    private String artistGender;
    private String albumName;
    private String albumDate;
    private String genreType;

    public SongData(String songName, String songDuration, String artistName, String artistGender, String albumName, String albumDate, String genreType) {
        this.songName = songName;
        this.songDuration = songDuration;
        this.artistName = artistName;
        this.artistGender = artistGender;
        this.albumName = albumName;
        this.albumDate = albumDate;
        this.genreType = genreType;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistGender() {
        return artistGender;
    }

    public void setArtistGender(String artistGender) {
        this.artistGender = artistGender;
    }


    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumDate() {
        return albumDate;
    }

    public void setAlbumDate(String albumDate) {
        this.albumDate = albumDate;
    }

    public String getGenreType() {
        return genreType;
    }

    public void setGenreType(String genreType) {
        this.genreType = genreType;
    }

    @Override
    public String toString() {
        return "SongData{" +
                "songName='" + songName + '\'' +
                ", songDuration='" + songDuration + '\'' +
                ", artistName='" + artistName + '\'' +
                ", artistGender='" + artistGender + '\'' +
                ", albumName='" + albumName + '\'' +
                ", albumDate='" + albumDate + '\'' +
                ", genreType='" + genreType + '\'' +
                '}';
    }
}
