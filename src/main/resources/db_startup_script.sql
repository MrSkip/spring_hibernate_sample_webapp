CREATE DATABASE IF NOT EXISTS sampledatabase CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE sampledatabase;

--
-- Table structure for table app_authorities
--

DROP TABLE IF EXISTS app_authorities;
CREATE TABLE app_authorities (
  uuid VARCHAR(36) NOT NULL,
  authority VARCHAR(100) NOT NULL,
  PRIMARY KEY (uuid)
) ENGINE=InnoDB;

--
-- Dumping data for table app_authorities
--

LOCK TABLES app_authorities WRITE;
INSERT INTO app_authorities VALUES ('3207fca0-0dee-4501-a728-9dd2677b8372','ROLE_USER');
UNLOCK TABLES;

--
-- Table structure for table app_users
--

DROP TABLE IF EXISTS app_users;
CREATE TABLE app_users (
   uuid VARCHAR(36) NOT NULL,
   user_name VARCHAR(20) NOT NULL,
   password VARCHAR(30) NOT NULL,
   PRIMARY KEY (uuid)
) ENGINE=InnoDB;

--
-- Table structure for table app_user_authorities
--

DROP TABLE IF EXISTS app_user_authorities;
CREATE TABLE app_user_authorities (
  app_user VARCHAR(36) NOT NULL,
  app_authority VARCHAR(36) NOT NULL,
  PRIMARY KEY (app_user, app_authority),
  CONSTRAINT fk_app_user_authorities_2_app_users FOREIGN KEY (app_user) REFERENCES app_users(uuid) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT fk_app_user_authorities_2_app_authorities FOREIGN KEY (app_authority) REFERENCES app_authorities(uuid) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;