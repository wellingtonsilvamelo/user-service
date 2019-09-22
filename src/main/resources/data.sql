INSERT INTO TBG_USER (USER_FULL_NAME, USERNAME, USER_EMAIL, USER_HASH_PASSWORD)
SELECT * FROM (SELECT 'Wellington da Silva Melo', 'admin', 'wellington@gmil.com', '$2a$10$r0RFDmpneBVryx.ihHK9gu6FFJQi4nTxQUqzdSTvrPpaKZMxigqpy') AS tmp
WHERE NOT EXISTS (
    SELECT USERNAME FROM TBG_USER WHERE USERNAME = 'admin'
) LIMIT 1;

INSERT INTO TBG_AUTHORITY (AUTHORITY_DESCRIPTION)
SELECT * FROM (SELECT 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT AUTHORITY_DESCRIPTION FROM TBG_AUTHORITY WHERE AUTHORITY_DESCRIPTION = 'ROLE_ADMIN'
) LIMIT 1;

INSERT INTO TBG_AUTHORITY (AUTHORITY_DESCRIPTION)
SELECT * FROM (SELECT 'ROLE_USER') AS tmp
WHERE NOT EXISTS (
    SELECT AUTHORITY_DESCRIPTION FROM TBG_AUTHORITY WHERE AUTHORITY_DESCRIPTION = 'ROLE_ADMIN'
) LIMIT 1;

INSERT INTO TBG_USER_AUTHORITY (USER_ID, AUTHORITY_ID)
SELECT * FROM (SELECT U.USER_ID, A.AUTHORITY_ID FROM TBG_USER U, TBG_AUTHORITY A
WHERE U.USERNAME = 'admin' AND A.AUTHORITY_DESCRIPTION = 'ROLE_ADMIN') AS tmp
WHERE NOT EXISTS (
    SELECT ua.USER_ID, ua.AUTHORITY_ID FROM TBG_USER_AUTHORITY ua
    inner join TBG_AUTHORITY a on a.AUTHORITY_ID = ua.AUTHORITY_ID
    inner join TBG_USER u on u.USER_ID = ua.USER_ID  
    WHERE u.USERNAME = 'admin' and a.AUTHORITY_DESCRIPTION = 'ROLE_ADMIN'
) LIMIT 1;

