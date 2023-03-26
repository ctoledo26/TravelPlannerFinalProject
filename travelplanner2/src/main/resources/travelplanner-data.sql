INSERT INTO `travel-planner`.users (name,email,password) VALUES
	 ('Alexandra Toledo','alexandrat@gmail.com','Qwert123'),
	 ('Jane Smith','janesmith@hotmail.com','password2!'),
	 ('Bob Johnson','bobjohnson@gmail.com','htfaer3'),
	 ('Sarah Lee','sarahlee@gmail.com','bojack543'),
	 ('David Kim','davidkim@hotmail.com','password123!'),
	 ('Shirley Montoya','shirleym26@gmail.com','mypassword123'),
	 ('Tony Stark','tony.stark@marvel.com','mysecretpassword5');

INSERT INTO `travel-planner`.trips (name,start_date,end_date,destination,user_id) VALUES
	 ('Europe Trip','2023-06-01','2023-06-15','Europe',1),
	 ('Beach Vacation','2023-07-10','2023-07-17','Hawaii',1),
	 ('City Break','2022-09-01','2022-09-05','New York',2),
	 ('Ski Trip','2023-01-15','2023-01-22','Colorado',6),
	 ('Road Trip','2023-05-20','2023-06-01','California',4),
	 ('Hiking Trip','2023-09-01','2023-09-05','California',4),
	 ('France Trip','2023-04-15','2023-04-21','France',3),
	 ('Japan Trip','2023-05-01','2023-05-10','Japan',5),
	 ('Mexico Trip','2023-06-20','2023-06-26','Mexico',2),
	 ('Australia Trip','2023-07-15','2023-07-25','Australia',1);
INSERT INTO `travel-planner`.trips (name,start_date,end_date,destination,user_id) VALUES
	 ('New York City, USA','2023-08-10','2023-08-16','New York',2),
	 ('Europe Trip','2023-06-01','2023-06-15','Europe',1),
	 ('Beach Vacation','2023-07-10','2023-07-17','Hawaii',1),
	 ('City Break','2022-09-01','2022-09-05','New York',2),
	 ('Ski Trip','2023-01-15','2023-01-22','Colorado',6),
	 ('Road Trip','2023-05-20','2023-06-01','California',4),
	 ('Hiking Trip','2023-09-01','2023-09-05','California',4),
	 ('France Trip','2023-04-15','2023-04-21','France',3),
	 ('Japan Trip','2023-05-01','2023-05-10','Japan',5),
	 ('Mexico Trip','2023-06-20','2023-06-26','Mexico',2);
INSERT INTO `travel-planner`.trips (name,start_date,end_date,destination,user_id) VALUES
	 ('Australia Trip','2023-07-15','2023-07-25','Australia',1),
	 ('New York City, USA','2023-08-10','2023-08-16','New York',2);
INSERT INTO `travel-planner`.activities (activity_name,description,location,date_time) VALUES
	 ('Hiking','Enjoy the beautiful nature on a guided hike','Yosemite National Park, California','2023-09-02 10:00:00'),
	 ('Broadway Show','Watch the classic musical, The Lion King, in Broadway theater','Broadway, New York','2023-08-11 19:00:00'),
	 ('Museum Visit','Visit the Louvre','Paris, France','2023-04-18 15:00:00'),
	 ('City Tour','Explore the city''s historic landmarks and hidden gems','Cancun, Mexico','2023-06-26 13:00:00'),
	 ('Scuba Diving','Dive into the ocean and explore the underwater ecosystem	','Sydney, Australia','2023-07-15 11:00:00'),
	 ('Hiking in the park','Enjoy a relaxing hike through the park trails','Central Park, New York','2023-08-11 09:00:00');
	INSERT INTO `travel-planner`.trip_activities (trip_id,activity_id) VALUES
	 (49,1),
	 (66,2),
	 (51,3),
	 (56,3),
	 (56,4),
	 (65,5),
	 (66,6);

