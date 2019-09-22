CREATE TABLE IF NOT EXISTS TBG_USER ( 
	USER_ID INT NOT NULL AUTO_INCREMENT , 
	USER_FULL_NAME VARCHAR(100) NOT NULL , 
	USERNAME VARCHAR(50) NOT NULL , 
	USER_EMAIL VARCHAR(70) NOT NULL , 
	USER_HASH_PASSWORD VARCHAR(100) NOT NULL , 
	PRIMARY KEY (USER_ID), 
	UNIQUE USERNAME_UNQ (USERNAME), 
	UNIQUE USER_EMAIL_UNQ (USER_EMAIL)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS TBG_AUTHORITY ( 
	AUTHORITY_ID INT NOT NULL AUTO_INCREMENT , 
	AUTHORITY_DESCRIPTION VARCHAR(100) NOT NULL , 
	PRIMARY KEY (AUTHORITY_ID), 
	UNIQUE AUTH_DESC_UNQ (AUTHORITY_DESCRIPTION)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS TBG_USER_AUTHORITY (
	USER_AUTHORITY_ID INT NOT NULL AUTO_INCREMENT, 
	USER_ID INT NOT NULL , 
	AUTHORITY_ID INT NOT NULL , 
	PRIMARY KEY (USER_AUTHORITY_ID),
	FOREIGN KEY (USER_ID)
      REFERENCES TBG_USER (USER_ID),
    FOREIGN KEY (AUTHORITY_ID)
      REFERENCES TBG_AUTHORITY(AUTHORITY_ID)
) ENGINE = InnoDB;
