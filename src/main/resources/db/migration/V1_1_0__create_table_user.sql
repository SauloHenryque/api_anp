CREATE TABLE IF NOT EXISTS `user` (
 
    'id' int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    'nome' nvarchar(200) not null,
	'password' nvarchar(200) not null,
    'email' varchar(50) not null
 
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;