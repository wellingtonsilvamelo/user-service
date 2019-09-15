CREATE TABLE IF NOT EXISTS tbg_user (
	wa_user_id INT PRIMARY KEY AUTO_INCREMENT, 
	wa_name VARCHAR(100),
	wa_username VARCHAR(50),
	wa_email VARCHAR(70),
	wa_password VARCHAR(100),
);