create table Celibrity(
celibrity_Id int primary key auto_increment,
celibrityName char(100),
celibrityDob date
);
create table Narrator(
narrator_id int primary key auto_increment,
narratorName char(100),
narratorGender char(30)
);
create table PodcastType(
podcasttype_id int primary key auto_increment,
podcastType char(100)
);
create table PodcastEpisode(
podEpisode_Id int primary key auto_increment,
podEpisodeName char(200),
podDuration char(50),
podDate date
);

create table Podcast(
podcast_Id int primary key auto_increment,
podcastName char(100),
celibrity_Id int,
narrator_id int,
podcasttype_id int,
podEpisode_Id int,
FOREIGN KEY (celibrity_Id)  REFERENCES Celibrity(celibrity_Id),
FOREIGN KEY (narrator_id)  REFERENCES Narrator(narrator_id),
FOREIGN KEY (podcasttype_id)  REFERENCES PodcastType(podcasttype_id),
FOREIGN KEY (podEpisode_Id)  REFERENCES PodcastEpisode(podEpisode_Id)
);
select * from podcast
ALTER TABLE Podcast AUTO_INCREMENT = 500;
ALTER TABLE PodcastEpisode AUTO_INCREMENT = 1;
ALTER TABLE PodcastType AUTO_INCREMENT = 200;
ALTER TABLE Narrator AUTO_INCREMENT = 300;
ALTER TABLE Celibrity AUTO_INCREMENT = 100;

CREATE VIEW PodcastView AS
SELECT Podcast.podcastName,Celibrity.celibrityName,PodcastType.podcastType,PodcastEpisode.podDate,Narrator.narratorName
FROM Podcast join Celibrity on Podcast.celibrity_Id=Celibrity.celibrity_Id
join PodcastEpisode on Podcast.podEpisode_Id=PodcastEpisode.podEpisode_Id join Narrator on Narrator.narrator_id=Podcast.narrator_id
join PodcastType on PodcastType.podcasttype_id =Podcast.podcasttype_id;

select * from podcastepisode;
select * from podcast;
select * from celibrity;

select podEpisode_Id from podcastepisode where podEpisode_Id in(
select podEpisode_Id from podcast where celibrity_Id in
(
select celibrity_Id from celibrity where  celibrityName='sachin'
)
); 
