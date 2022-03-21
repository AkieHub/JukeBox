public class PodcastView {
    private String podcastName;
    private String celibrityName;
    private String podcastType;
    private String podDate;
    private String narratorName;

    public PodcastView(String podcastName, String celibrityName, String podcastType, String podDate, String narratorName) {
        this.podcastName = podcastName;
        this.celibrityName = celibrityName;
        this.podcastType = podcastType;
        this.podDate = podDate;
        this.narratorName = narratorName;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getCelibrityName() {
        return celibrityName;
    }

    public void setCelibrityName(String celibrityName) {
        this.celibrityName = celibrityName;
    }

    public String getPodcastType() {
        return podcastType;
    }

    public void setPodcastType(String podcastType) {
        this.podcastType = podcastType;
    }

    public String getPodDate() {
        return podDate;
    }

    public void setPodDate(String podDate) {
        this.podDate = podDate;
    }

    public String getNarratorName() {
        return narratorName;
    }

    public void setNarratorName(String narratorName) {
        this.narratorName = narratorName;
    }

    @Override
    public String toString() {
        return "PodcastView{" +
                "podcastName='" + podcastName + '\'' +
                ", celibrityName='" + celibrityName + '\'' +
                ", podcastType='" + podcastType + '\'' +
                ", podDate='" + podDate + '\'' +
                ", narratorName='" + narratorName + '\'' +
                '}';
    }
}
