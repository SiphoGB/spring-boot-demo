insert into user(name, email) values ('Naeem', 'naeem@fingerprintsoft.co');
insert into topic(name, active) values ('Test Topic', true);
insert into question(topic_id, question) values (1, 'Question 1');
insert into answer(question_id, answer, display, correct) values (1, 'a', 'Answer 1', false);
insert into answer(question_id, answer, display, correct) values (1, 'b', 'Answer 2', true);

insert into user_topic (end, result, start, topic_id, user_id, uuid) values (1414139258641, 75.0, 1414139256041, 1, 1, 'aaa-bbb-ccc');
insert into user_topic_answer (answer_id, question_id, user_topic_id) values (2, 1, 1);