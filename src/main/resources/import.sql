INSERT INTO DIRECTORS  (NAME, SURNAME) VALUES ( 'Martin', 'Scorsese' );

INSERT INTO DIRECTORS  (NAME, SURNAME) VALUES ( 'Quentin', 'Tarantino' );

INSERT INTO DIRECTORS  (NAME, SURNAME) VALUES ( 'Sergio', 'Leone' );

INSERT INTO ACTORS  (NAME, SURNAME) VALUES ( 'Leonardo', 'DiCaprio' );

INSERT INTO ACTORS  (NAME, SURNAME) VALUES ( 'Clint', 'Eastwood' );

INSERT INTO ACTORS  (NAME, SURNAME) VALUES ( 'Brad', 'Pitt' );

INSERT INTO MOVIES(DESCRIPTION, FEES, GENRE, TITLE, DIRECTOR_ID) VALUES ( 'Можно ли переписать историю? Самый ностальгический фильм Тарантино — с Шэрон Тейт, Брюсом Ли и Чарли Мэнсоном',
         372711080, 'DRAMA', 'Однажды в… Голливуде (2019)', 2);

INSERT INTO MOVIES(DESCRIPTION, FEES, GENRE, TITLE, DIRECTOR_ID) VALUES ( 'Американский спецотряд жестоко расправляется с нацистами. Пародия на военные фильмы от Квентина Тарантино',
         321455689 , 'COMEDY', 'Бесславные ублюдки (2009)', 2);

INSERT INTO MOVIES(DESCRIPTION, FEES, GENRE, TITLE, DIRECTOR_ID) VALUES ( 'Пристав оказывается заложником клиники для умалишенных. Сложносочиненный детектив с Леонардо ДиКаприо',
         294804195, 'THRILLER', 'Остров проклятых (2009)', 1);

INSERT INTO MOVIES(DESCRIPTION, FEES, GENRE, TITLE, DIRECTOR_ID) VALUES ( 'Биография гения-безумца: Мартин Скорсезе снял фильм об инженере и бизнесмене Говарде Хьюзе',
         213741459, 'DRAMA', 'Авиатор (2004)', 1);

INSERT INTO MOVIES(DESCRIPTION, FEES, GENRE, TITLE, DIRECTOR_ID) VALUES ( 'В маленьком городке идет война между двумя влиятельными семействами, которых абсолютно не интересует закон',
         3500000, 'WESTERN', 'За пригоршню долларов (1964)', 3);

INSERT INTO MOVIES(DESCRIPTION, FEES, GENRE, TITLE, DIRECTOR_ID) VALUES ( 'Заработать несколько лишних долларов честным путем на диком Западе не проблема',
         15000000, 'WESTERN', 'На несколько долларов больше (1965)', 3);

INSERT INTO MOVIES(DESCRIPTION, FEES, GENRE, TITLE, DIRECTOR_ID) VALUES ( 'В разгар гражданской войны таинственный стрелок скитается по просторам Дикого Запада',
         25118063, 'WESTERN', 'Хороший, плохой, злой (1966)', 3);

INSERT INTO ACTOR_MOVIES (ACTOR_ID, MOVIE_ID) VALUES (1, 1);

INSERT INTO ACTOR_MOVIES (ACTOR_ID, MOVIE_ID) VALUES (1, 3);

INSERT INTO ACTOR_MOVIES (ACTOR_ID, MOVIE_ID) VALUES (1, 4);

INSERT INTO ACTOR_MOVIES (ACTOR_ID, MOVIE_ID) VALUES (2, 1);

INSERT INTO ACTOR_MOVIES (ACTOR_ID, MOVIE_ID) VALUES (2, 2);

INSERT INTO ACTOR_MOVIES (ACTOR_ID, MOVIE_ID) VALUES (3, 5);

INSERT INTO ACTOR_MOVIES (ACTOR_ID, MOVIE_ID) VALUES (3, 6);

INSERT INTO ACTOR_MOVIES (ACTOR_ID, MOVIE_ID) VALUES (3, 7);