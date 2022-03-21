create database JukeboxData;
use jukeboxData;
insert into Song(songName,songDruration,artist_id,album_Id,genre_id) values(?,?,?,?,?)
create table Song(
song_id int primary key auto_increment,
songName char(200),
songDruration char(100),
artist_id int,
album_Id int,
genre_id int,
FOREIGN KEY (artist_id)  REFERENCES Artist(artist_id),
FOREIGN KEY (album_Id)  REFERENCES Album(album_Id),
FOREIGN KEY (genre_id)  REFERENCES Genre(genre_id)
);
;
create table Artist(
artist_Id int primary key auto_increment,
artistName char(100),
artistGender char(10),
artistDob Date
);
create table Album(
album_id int primary key auto_increment,
albumName char(100),
albumDate Date
);
select * from album;
select * from artist;
select * from genre;

create table Genre(
genre_Id int primary key auto_increment,
genre_Type char(100)
);
insert into album values(300,'test','2021-02-12');
insert into Artist values(200,'test','m','2021-02-12');
insert into Genre values(400,'test');


CREATE VIEW jukeboxView AS
SELECT song.songName,song.songDruration,Artist.artistName,
Artist.artistGender,Album.albumName,Album.albumDate,Genre.genre_Type
FROM song join artist on song.artist_id=Artist.artist_id
join Album on song.Album_id=Album.album_id join Genre on Genre.genre_id=song.genre_id;
select * from song;
select * from jukeboxView ;
insert into song values(100,'test','3:00:09',200,1,400);