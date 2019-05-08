-- user table
create table User (
    id BIGINT UNSIGNED NOT NULL,
    nickName VARCHAR(255) NOT NULL DEFAULT '',
    password CHAR(32) NOT NULL DEFAULT '',
    gender TINYINT UNSIGNED NOT NULL DEFAULT 0,
    birthday DATETIME NOT NULL DEFAULT now(),

    valid TINYINT UNSIGNED NOT NULL DEFAULT 1,
    creator VARCHAR(255) NOT NULL DEFAULT '',
    createTime DATETIME NOT NULL DEFAULT now(),
    updater VARCHAR(255) NOT NULL DEFAULT '',
    updateTime DATETIME NOT NULL DEFAULT now(),

    CONSTRAINT `PK_User_id` primary key (`id`)
) ENGINE=InnoDB;

create table UsernameAccount (
    id BIGINT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(32) NOT NULL DEFAULT '',
    userId BIGINT UNSIGNED NOT NULL,

    valid TINYINT UNSIGNED NOT NULL DEFAULT 1,
    creator VARCHAR(255) NOT NULL DEFAULT '',
    createTime DATETIME NOT NULL DEFAULT now(),
    updater VARCHAR(255) NOT NULL DEFAULT '',
    updateTime DATETIME NOT NULL DEFAULT now(),

    INDEX `IK_UsernameAccount_username` (username(12))
) ENGINE=InnoDB;

