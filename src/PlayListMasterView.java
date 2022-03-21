public class PlayListMasterView {
   int playList_ID;
   int content_Id;
   int track_id;
   String playListName;

    public PlayListMasterView(int playList_ID, int content_Id, int track_id, String playListName) {
        this.playList_ID = playList_ID;
        this.content_Id = content_Id;
        this.track_id = track_id;
        this.playListName = playListName;
    }

    public int getPlayList_ID() {
        return playList_ID;
    }

    public void setPlayList_ID(int playList_ID) {
        this.playList_ID = playList_ID;
    }

    public int getContent_Id() {
        return content_Id;
    }

    public void setContent_Id(int content_Id) {
        this.content_Id = content_Id;
    }

    public int getTrack_id() {
        return track_id;
    }

    public void setTrack_id(int track_id) {
        this.track_id = track_id;
    }

    public String getPlayListName() {
        return playListName;
    }

    public void setPlayListName(String playListName) {
        this.playListName = playListName;
    }


}
