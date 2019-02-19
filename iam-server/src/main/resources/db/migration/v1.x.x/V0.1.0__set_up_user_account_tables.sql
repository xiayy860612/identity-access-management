-- user table
create table User (
    id BIGINT UNSIGNED NOT NULL,
    nickName VARCHAR(255) NOT NULL DEFAULT '',
    password CHAR(32) NOT NULL DEFAULT '',
    genderEnum TINYINT UNSIGNED NOT NULL DEFAULT 0,
    birthday DATETIME NOT NULL DEFAULT now(),

    valid TINYINT UNSIGNED NOT NULL DEFAULT 1,
    creator VARCHAR(255) NOT NULL DEFAULT '',
    createTime DATETIME NOT NULL DEFAULT now(),
    updater VARCHAR(255) NOT NULL DEFAULT '',
    updateTime DATETIME NOT NULL DEFAULT now(),

    CONSTRAINT `PK_User_id` primary key (`id`)
) ENGINE=InnoDB;
