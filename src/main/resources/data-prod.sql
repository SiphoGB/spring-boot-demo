insert into topic(name, active) values ('Demo Preview', true);
insert into question(topic_id, question) values (1, 'Who is one of the founding fathers of Spring');
insert into answer(question_id, answer, display, correct) values (1, 'a', 'Bill Burke', false);
insert into answer(question_id, answer, display, correct) values (1, 'b', 'Rod Johnson', true);
insert into answer(question_id, answer, display, correct) values (1, 'c', 'Gavin King', false);
insert into answer(question_id, answer, display, correct) values (1, 'd', 'James Gosling', false);

insert into topic(name, active) values ('Competition Time', false);
insert into question(topic_id, question) values (2, 'Does Spring Boot start off in a main method?');
insert into answer(question_id, answer, display, correct) values (2, 'a', 'Yes', true);
insert into answer(question_id, answer, display, correct) values (2, 'b', 'No', false);

insert into question(topic_id, question) values (2, 'Which other language besides Java does Spring Boot support?');
insert into answer(question_id, answer, display, correct) values (3, 'a', 'dot NET', false);
insert into answer(question_id, answer, display, correct) values (3, 'b', 'python', false);
insert into answer(question_id, answer, display, correct) values (3, 'c', 'groovy', true);
insert into answer(question_id, answer, display, correct) values (3, 'd', 'maven', false);

insert into question(topic_id, question) values (2, 'What is the default web container that gets included with spring-boot-starter-web?');
insert into answer(question_id, answer, display, correct) values (4, 'a', 'jetty 8', false);
insert into answer(question_id, answer, display, correct) values (4, 'b', 'jetty 9', false);
insert into answer(question_id, answer, display, correct) values (4, 'c', 'apache', false);
insert into answer(question_id, answer, display, correct) values (4, 'd', 'tomcat 7', true);
insert into answer(question_id, answer, display, correct) values (4, 'e', 'tomcat 8', false);

insert into question(topic_id, question) values (2, 'Which starter project provides us with a health check web endpoint?');
insert into answer(question_id, answer, display, correct) values (5, 'a', 'spring-boot-starter-remote-shell', false);
insert into answer(question_id, answer, display, correct) values (5, 'b', 'spring-boot-starter-actuator', true);
insert into answer(question_id, answer, display, correct) values (5, 'c', 'spring-boot-starter-web', false);
