mysql -u root -p cineapp < cineapp.sql


ALTER USER 'root'@'localhost' IDENTIFIED BY 'pass123';
FLUSH PRIVILEGES;


CREATE USER 'eangulo'@'localhost' IDENTIFIED BY 'pass123';


GRANT ALL PRIVILEGES ON *.* TO 'eangulo'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO 'tamaki094'@'localhost';

CREATE USER 'tamaki094'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pa$$word';


GRANT ALL PRIVILEGES ON *.* TO 'tamaki'@'localhost';

ALTER USER 'eangulo'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Tamaki@$1994_5!';

SET GLOBAL time_zone = '-3:00';