public class PlayListPodcastView extends PlayListMasterView {
    int podcast_Id;
    String podcastName;
    int celibrity_Id;
    int narrator_id;
    int podcasttype_id;

//public PlayListMasterView(int playList_ID, int content_Id, int track_id, String playListName) {
    public PlayListPodcastView(int playList_ID, int content_Id, int track_id, String playListName,int podcast_Id,
                               String podcastName,int celibrity_Id,int narrator_id,int podcasttype_id) {
        super(playList_ID, content_Id, track_id, playListName);
        this.podcast_Id=podcast_Id;
        this.podcastName=podcastName;
        this.celibrity_Id=celibrity_Id;
        this.narrator_id=narrator_id;
        this.podcasttype_id=podcasttype_id;
    }

    public int getPodcast_Id() {
        return podcast_Id;
    }

    public void setPodcast_Id(int podcast_Id) {
        this.podcast_Id = podcast_Id;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public int getCelibrity_Id() {
        return celibrity_Id;
    }

    public void setCelibrity_Id(int celibrity_Id) {
        this.celibrity_Id = celibrity_Id;
    }

    public int getNarrator_id() {
        return narrator_id;
    }

    public void setNarrator_id(int narrator_id) {
        this.narrator_id = narrator_id;
    }

    public int getPodcasttype_id() {
        return podcasttype_id;
    }

    public void setPodcasttype_id(int podcasttype_id) {
        this.podcasttype_id = podcasttype_id;
    }

    @Override
    public String toString() {
        return "PlayListPodcastView{" +
                "playList_ID=" + playList_ID +
                ", content_Id=" + content_Id +
                ", track_id=" + track_id +
                ", playListName='" + playListName + '\'' +
                ", podcast_Id=" + podcast_Id +
                ", podcastName='" + podcastName + '\'' +
                ", celibrity_Id=" + celibrity_Id +
                ", narrator_id=" + narrator_id +
                ", podcasttype_id=" + podcasttype_id +
                '}';
    }
}
