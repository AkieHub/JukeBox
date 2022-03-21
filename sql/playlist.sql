create table PlayList(
playList_ID int primary key auto_increment,
playListName char(200) not null
);
create table PlayListContent(
content_Id int primary key auto_increment,
playList_ID int,
track_id int not null,
FOREIGN KEY (playList_ID)  REFERENCES PlayList(playList_ID)
);
select * from PlayList;
select * from PlayListContent;

alter table PlayListContent drop constraint playlistcontent_ibfk_1;
drop table playlist;
drop table PlayListContent;
drop view playlistsongview;
ALTER TABLE PlayList AUTO_INCREMENT = 1;
alter table PlayListContent auto_increment=100;

-- ----------------------------------->playlist song view<-----------------------------------------------------------------------------------

CREATE VIEW PlayListSongView as select s.song_id ,s.songName,s.songDruration,s.artist_id,s.album_Id,s.genre_id 
from playlist pl join playlistcontent plc on pl.playList_ID=plc.playList_ID
 join song s on plc.track_id=s.song_id;
 select * from PlayListSongView;

-- ---------------------------------->playlist podcast view<------------------------------------------------------------------------------------
CREATE VIEW PlayListPodcastView as select pe.podcast_Id,pe.podcastName,
pe.celibrity_Id,pe.narrator_id,pe.podcasttype_id from playlist pl join playlistcontent plc on pl.playList_ID=plc.playList_ID
 join podcast pe on plc.track_id=pe.podcast_Id;
 select * from PlayListPodcastView;
 select * from playlist;
 select * from playlistcontent;

-- -------------------------------------------->both view<------------------------------------------------------------------------------------
CREATE VIEW PlayListMasterView AS select pl.playList_ID,plc.content_Id,plc.track_id,pl.playListName,
s.song_id,s.songName,s.songDruration,s.artist_id,s.album_Id,s.genre_id,pe.podcast_Id,pe.podcastName,pe.celibrity_Id
,pe.narrator_id,pe.podcasttype_id,pe.podEpisode_Id
from playlist pl join playlistcontent plc on pl.playList_ID=plc.playList_ID
left outer join song s on plc.track_id=s.song_id left outer join podcast pe on plc.track_id=pe.podcast_Id;


select * from PlayListMasterView;


 
   
   
select * from PlayListMasterView;
select * from PlayListPodcastView;
select * from PlayListSongView;