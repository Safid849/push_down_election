CREATE DATABASE election;
\c election;
CREATE TABLE candidate (
                           id SERIAL PRIMARY KEY,
                           name TEXT NOT NULL
);
CREATE TABLE voter (
                       id SERIAL PRIMARY KEY,
                       name TEXT NOT NULL
);
CREATE TYPE vote_type AS ENUM(‘VALID’, ‘BLANK’, ‘NULL’);
CREATE TABLE vote (
                      id SERIAL PRIMARY KEY,
                      candidate_id INT REFERENCES candidate(id),
                      voter_id INT NOT NULL REFERENCES voter(id),
                      vote_type vote_type NOT NULL);
INSERT INTO candidate (name) VALUES
                                 ('Alice'),
                                 ('Bob'),
                                 ('Charlie');
INSERT INTO voter (name) VALUES
                             ('Voter1'),
                             ('Voter2'),
                             ('Voter3'),
                             ('Voter4'),
                             ('Voter5'),
                             ('Voter6');
INSERT INTO vote (candidate_id, voter_id, vote_type) VALUES
                                                         (1, 1, 'VALID'),
                                                         (1, 2, 'VALID'),
                                                         (2, 3, 'VALID'),
                                                         (2, 4, 'BLANK'),
                                                         (NULL, 5, 'BLANK'),
                                                         (3, 6, 'NULL');
--Q1
select count(id) as total_vote from vote;

--Q2
select vote_type, count(id) from vote group by vote_type;

--Q3
select c.name as candidate_name, count(vote.id) as valid_vote from candidate c
       left join vote on c.id = vote.candidate_id AND vote.vote_type = 'VALID' group by c.name ;

--Q4
select SUM(CASE WHEN vote.vote_type = 'VALID' then  1 ELSE 0 end) as valid_count,
       SUM(CASE WHEN vote.vote_type = 'BLANK' then  1 ELSE 0 end) as blank_count,
       SUM(CASE WHEN vote.vote_type = 'NULL' then  1 ELSE 0 end) as null_count
from vote;

--Q5
SELECT (count_vote * 100.0 / count_voter) AS turnout_rate
FROM
    (SELECT COUNT(vote.id) AS count_vote FROM vote) AS v,
    (SELECT COUNT(voter.id) AS count_voter FROM voter) AS vr;

--Q6
SELECT c.name AS candidate_name, COUNT(v.id) AS valid_vote_count
FROM candidate c
         JOIN vote v ON c.id = v.candidate_id
WHERE v.vote_type = 'VALID'
GROUP BY c.name
ORDER BY valid_vote_count DESC
LIMIT 1;