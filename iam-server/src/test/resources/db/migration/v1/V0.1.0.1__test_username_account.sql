-- password: test1234
insert into User
(id, nickName, password)
values
(1, 'test_user', '16D7A4FCA7442DDA3AD93C9A726597E4');

insert into UsernameAccount
(username, userId)
values
('test_user', 1);