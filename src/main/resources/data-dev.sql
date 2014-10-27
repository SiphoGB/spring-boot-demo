insert into topic(name, active) values ('Test Topic', true);
insert into question(topic_id, question) values (1, 'Question 1');
insert into answer(question_id, answer, display, correct) values (1, 'a', 'Answer 1', false);
insert into answer(question_id, answer, display, correct) values (1, 'b', 'Answer 2', true);
insert into question(topic_id, question) values (1, 'Question 2');
insert into answer(question_id, answer, display, correct) values (2, '1', 'Answer 1 to Q 2', false);
insert into answer(question_id, answer, display, correct) values (2, '2', 'Answer 2 to Q 2', true);

insert into topic(name, active) values ('Test Topic 2', true);
insert into question(topic_id, question) values (2, 'Question 1');
insert into answer(question_id, answer, display, correct) values (3, 'a', 'Answer 1', false);
insert into answer(question_id, answer, display, correct) values (3, 'b', 'Answer 2', true);
insert into question(topic_id, question) values (2, 'Question 2');
insert into answer(question_id, answer, display, correct) values (4, '1', 'Answer 1 to Q 2', false);
insert into answer(question_id, answer, display, correct) values (4, '2', 'Answer 2 to Q 2', true);
