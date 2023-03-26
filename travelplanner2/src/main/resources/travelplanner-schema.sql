DROP TABLE IF EXISTS trip_activities;
DROP TABLE IF EXISTS activities;
DROP TABLE IF EXISTS trips;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
  user_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (user_id)
);

CREATE TABLE trips (
  trip_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  destination VARCHAR(100) NOT NULL,
  user_id INT NOT NULL,
  PRIMARY KEY (trip_id),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE activities (
  activity_id INT NOT NULL AUTO_INCREMENT,
  activity_name VARCHAR(100) NOT NULL,
  description VARCHAR(255) NOT NULL,
  location VARCHAR(100) NOT NULL,
  date_time DATETIME NOT NULL,
  PRIMARY KEY (activity_id)
);

CREATE TABLE trip_activities (
  trip_id INT NOT NULL,
  activity_id INT NOT NULL,
  PRIMARY KEY (trip_id, activity_id),
  FOREIGN KEY (trip_id) REFERENCES trips(trip_id),
  FOREIGN KEY (activity_id) REFERENCES activities(activity_id)
);
