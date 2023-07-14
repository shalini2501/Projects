CREATE DATABASE filmmaking;

USE filmmaking;

CREATE TABLE artist(
	Artist_id int PRIMARY KEY,
	ArtistName varchar(20),
	Gender varchar(20)
);

CREATE TABLE director(
	director_id int PRIMARY KEY,
    director_name varchar(20)
);
CREATE TABLE movie_director(
	director_id int,
    foreign key(director_id) REFERENCES director(director_id),
    movie_id int PRIMARY KEY,
    Production_id int
);
CREATE TABLE casting(
	Artist_id int, 
    foreign key(Artist_id) REFERENCES artist(Artist_id),
    movie_id int,
    foreign key(movie_ID) references movie_director(movie_ID),
    Role varchar(30)
); 
CREATE TABLE movie (
	movie_ID int,
    foreign key(movie_id) references movie_director(movie_id),
    movie_name varchar(20),
    movie_Year year,
    movie_language varchar(50)
);
CREATE TABLE review(
	review_id int PRIMARY KEY,
    review_name varchar(30)
);
CREATE TABLE producers(
	Production_ID int ,
    Producer_Name varchar(20),
    Producer_Phone varchar(50)
);
CREATE TABLE rating(
	movie_id int,
    review_id int,
    foreign key(review_id) REFERENCES review(review_id),
    review_stars int
);


INSERT INTO artist VALUES(101,'Prabhas','male'),
						 (102,'Anushaka','Female'),
                         (103,'Rana','male'),
                         (104,'SharukhKhan','male'),
                         (105,'Deepika Padukone','Female'),
                         (106,'Nikitin Dheer','male'),
                         (107,'Kate Winslet','Female'),
                         (108,'Leonardo DiCaprio','male'),
                         (109,'Caledon Hockley','male'),
                         (110,'RaviTeja','male'),
                         (111,'Anu Emmanuel','Female'),
                         (112,'Megha Akash','Female'),
                         (113,'Jackie Shroff','male'),
                         (114,'Amir Khan','male'),
                         (115,'Fatima sana','Female'),
                         (116,'Pramod Khan','male'),
                         (117,'Ranveer Singh','male'),
                         (118,'Shahid Kapoor','male'),
                         (119,'N.T.R','male'),
                         (120,'Alia','Female'),
                         (121,'Steven Son','male');
INSERT INTO director VALUES(201,'S.S.Rajamouli'),
						   (202,'Rohit Shetty'),
                           (203,'James Cameron'),
                           (204,'Kasi'),
                           (205,'Farah Khan'),
                           (206,'Nitesh Tiwari'),
                           (207,'Sanjay Bhansali');
INSERT INTO movie_director VALUES(201,301,401),
								 (202,302,402),
                                 (203,303,403),
                                 (204,304,404),
                                 (205,305,405),
                                 (206,306,406),
                                 (207,307,407),
                                 (201,308,408);
INSERT INTO casting VALUES(101,301,'Actor'),(102,301,'Actress'),(103,301,'Villan'),
                          (104,302,'Actor'),(105,302,'Actress'),(106,303,'Villan'),
                          (107,303,'Actor'),(108,303,'Actress'),(109,303,'Villan'),
                          (110,304,'Actor'),(111,304,'Actress'),(112,304,'Villan'),
						  (104,305,'Actor'),(105,305,'Actress'),(113,305,'Villan'),
                          (114,306,'Actor'),(115,306,'Actress'),(116,306,'Villan'),
                          (117,307,'Villan'),(105,307,'Actress'),(118,307,'Actor'),
                          (119,308,'Actor'),(120,308,'Actress'),(121,308,'Villan');
INSERT INTO movie VALUES(301,'Bahubali','2015','Telugu'),
						(302,'Chennai Express','2013','Hindi'),
                        (303,'Titanic','1997','English'),
                        (304,'Ravanasura','2023','Telugu'),
                        (305,'Happy New Year','2014','Hindi'),
                        (306,'Dangal','2016','Hindi'),
                        (307,'Padmaavat','2018','Hindi'),
                        (308,'RRR','2022','Telugu');
INSERT INTO review VALUES(501,'Ramya'),(502,'Rahul'),
						(503,'Bill Paxton'),(504,'Akash'),
                        (505,'Mohini'),(506,'Mahavir Tanwar'),
                        (507,'Shahin'),(508,'Ram');
INSERT INTO producers VALUES(401,'Shobu','8689975652'),
							(402,'Karim Morani','6258924526'),
                            (403,'James cameron','5685645624'),
                            (404,'Abhishek Nama','7589645621'),
                            (405,'Gauri Khan','6589624562'),
                            (406,'Kiran Rao','7586452346'),
                            (407,'Ajit Andhare','9596453256'),
                            (408,'D.V.V. Danayya','8595223523');
INSERT INTO rating VALUES(301,501,5),(302,502,3),
						 (303,503,5),(304,504,2),
                         (305,505,3),(306,506,4),
                         (307,507,4),(308,508,5);

SELECT * FROM artist;
SELECT * FROM director;
SELECT * FROM movie_director;
SELECT * FROM casting;
SELECT * FROM movie;
SELECT * FROM review;
SELECT * FROM producers;
SELECT * FROM rating;

#1.From the movie table, find the name and year of the movies.
SELECT Movie_name,movie_year 
From movie;

#2.From the movie table, find when the movie padmavaat released.
SELECT movie_year 
FROM movie
WHERE Movie_name='Padmaavat';

#3.From the movie table, find the movie, which was made in the year 1997.
SELECT Movie_name 
FROM movie
WHERE movie_year=1997;

#4.From the movie table, find those movies, which was made before 1998.
SELECT Movie_name 
FROM movie
WHERE movie_year>2018;

#5.From the movie and reviewer tables, find the name of all reviewers and movies together in a single list.
SELECT review_name 
FROM review
UNION
SELECT Movie_name 
FROM movie;

#6.From the rating and reviewer tables, find all reviewers who have rated 4 or more stars to their rating.
SELECT review_name 
FROM review 
INNER JOIN rating
ON review.review_id=rating.review_id
Where review_stars>=4;

#7.From the movie table, find the movies with ID 301,303,305. 
SELECT movie_name 
FROM movie 
WHERE movie_id in (301,303,305);

#8.From the movie table, find those movie name Sort the result-set in ascending order by movie year.
SELECT movie_name,movie_year 
FROM movie
ORDER BY movie_year ASC;

#9.From the artist table, find those actors whose name is 'SharukhKhan'
SELECT artist_id 
FROM artist
WHERE ArtistName='SharukhKhan';

#10.From the movie, casting, and artist tables, find the actors who played a role in the movie 'Happy new year'. 
SELECT * FROM artist 
WHERE artist_id in
(SELECT artist_id FROM casting WHERE movie_id=
(SELECT movie_id FROM movie WHERE movie_name = 'Happy New Year')
);

#11.From the movie,movie_director,and director tables,find the director who directed a movie 'titanic'.
SELECT director_name 
FROM director
WHERE director_id=
(SELECT director_id FROM movie_director WHERE movie_id=
(SELECT movie_id FROM movie WHERE movie_name='Titanic')
);

#12.From the movie table, find those movies, which released in the country besides Telugu.
SELECT movie_name,movie_id,movie_year 
FROM movie
WHERE movie_language='Telugu';

#13.From the movie, casting, artist, movie_director, director, rating, and review tables, 
#find those movies where reviewer is Ramya.
SELECT m.movie_name,m.movie_year,d.director_name,a.ArtistName 
FROM movie AS m 
JOIN movie_director md ON 
m.movie_id=md.movie_id 
JOIN director AS d ON 
md.director_id = d.director_id
JOIN casting AS c ON 
m.movie_id = c.movie_id
JOIN artist AS a ON 
c.artist_id = a.artist_id
WHERE m.movie_id IN
(SELECT movie_id FROM rating WHERE review_id IN
(SELECT review_id FROM review WHERE review_name ='Ramya')
);

#14.From the Artist, casting,movie,rating find the role,movie_name,review_stars in Ascending order
SELECT ArtistName,role,movie_name,review_stars 
FROM artist AS a
JOIN casting AS c ON 
a.artist_id=c.artist_id
JOIN movie AS m ON 
m.movie_id=c.movie_id
JOIN rating AS r ON 
r.movie_id=c.movie_id
WHERE role IN ('Actor','Actress','Villan')
ORDER BY review_stars ASC;

SET sql_mode='only_FULL_group_BY';
SET GLOBAL SQL_MODE=(SELECT REPLACE(@@sql_mode ,'ONLY_FULL_GROUP_BY',' '));
SET SESSION SQL_MODE=(SELECT REPLACE(@@sql_mode ,'ONLY_FULL_GROUP_BY',' '));

#15.From the movie and rating tables, find those movies, which have received highest number of stars. 
#Group the result set on movie title and sorts the result-set in descending order by movie title.
SELECT movie_name, MAX(review_stars) 
FROM movie AS m
JOIN rating AS r ON 
r.movie_id = m.movie_id
GROUP BY m.movie_name
ORDER BY movie_name DESC;

#16.Find the name of movie name, id, language greater than 305 using having clause
SELECT movie_language, movie_id, movie_name 
FROM movie
GROUP BY movie_id
HAVING movie_id >305;

# some simple queries
SELECT * FROM  artist WHERE artist_id=108;
SELECT * FROM movie WHERE movie_language='ENGLISH';
SELECT * FROM rating WHERE review_stars <3;
SELECT * FROM director ORDER BY director_id  DESC;
SELECT * FROM producers WHERE production_id>403;
SELECT * FROM movie WHERE movie_id=308 AND movie_language='Telugu';
SELECT * FROM producers WHERE Producer_Name='Karim Morani' OR Producer_Phone='5685645624';
SELECT * FROM casting WHERE  role !='Actor';
SELECT * FROM rating WHERE NOT  review_stars = 4;
SELECT review_stars,review_stars+1 FROM rating;
SELECT review_stars,review_stars-1 FROM rating;
SELECT review_stars,review_stars/2 FROM rating;
SELECT review_stars,review_stars+(review_stars*50)/100 FROM rating;
SELECT * FROM movie WHERE movie_language IN('Telugu','Hindi');
SELECT * FROM movie WHERE movie_language NOT IN('Telugu','English') ORDER BY movie_id;
SELECT * FROM producers WHERE production_id BETWEEN  403 AND 406  ORDER BY producer_phone DESC;
SELECT * FROM director WHERE director_name LIKE 'S%';
SELECT * FROM director WHERE director_name LIKE '%O%';
SELECT * FROM director WHERE director_name LIKE '%Y';
SELECT SUM(review_stars) AS 'Sum of Stars' FROM rating;
SELECT AVG(review_stars)  FROM rating;
SELECT COUNT(artist_id) AS 'No. of. Artist' FROM Artist;
SELECT MAX(review_stars) AS 'Highest Stars' FROM rating;
SELECT MIN(review_stars) AS 'Lowest Stars' FROM rating;




