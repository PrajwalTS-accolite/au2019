DROP DATABASE IF EXISTS db_Assign;
create database db_Assign;
use db_Assign;
create table Tournament(id int not null auto_increment, name varchar(256), location varchar(256),type varchar(256), primary key(id));
create table Teams(id int not null auto_increment, name varchar(256), primary key(id));
create table Matches(id int not null auto_increment, tournamentid int, team1id int, team2id int, team1score int, team2score int,winner int, primary key(id), foreign key(winner) references Teams(id), foreign key(team1id) references Teams(id), foreign key(team2id) references Teams(id), foreign key(tournamentid) references Tournament(id));
create table Players(id int not null auto_increment, name varchar(256), teamid int, primary key(id), foreign key(teamid) references Teams(id));
create table PlayerTournamentMap (tournamentid int, playerid int auto_increment, total_runs int, total_wickets int, primary key(tournamentid, playerid), foreign key(tournamentid) references Tournament(id), foreign key(playerid) references Players(id));

insert into Tournament values(1,"ICC WORLD CUP 2019", "England","ODI");

insert into Teams values(1, "Ïndia");
insert into Teams values(2,"Australia");
insert into Teams values(3,"England");
insert into Teams values(4,"New Zeland");
insert into Teams values(5,"Pakistan");

insert into Matches values (1, 1, 5, 3,108,310, 5); #Pakistan vs England 6
insert into Matches values (2, 1, 1, 2,102, 316, 1); #India vs Aus 14
insert into Matches values (3, 1, 2, 5, 107, 266, 2); #Aus vs Pak 17
insert into Matches values (4, 1, 1, 5, 336,212,1); #Ind vs Pak 22
insert into Matches values (5, 1, 2, 3, 285,221, 2); #Aus vs Eng 32
insert into Matches values (6, 1, 4, 5, 237, 241, 5); #New vs Pak 33

insert into Players values(default, "Quinton de Kock", 2);
insert into Players values(default, "Hashim Amla", 2);
insert into Players values(default, "Jason Behrendorff", 2);
insert into Players values(default, "Aaron Finch", 2);
insert into Players values(default, "Nathan Coulter-Nile", 2);
insert into Players values(default, "Pat Cummins", 2);
insert into Players values(default, "Peter Handscomb", 2);
insert into Players values(default, "Nathan Lyon", 2);
insert into Players values(default, "Glenn Maxwell", 2);
insert into Players values(default, "Kane Richardson", 2);
insert into Players values(default, "Steven Smith", 2);
insert into Players values(default, "Mitchell Starc", 2);

insert into Players values(default, "Virat Kohli", 1);
insert into Players values(default, "Rohit Sharma", 1);
insert into Players values(default, "Jasprit Bumrah", 1);
insert into Players values(default, "Yuzvendra Chahal", 1);
insert into Players values(default, "Dinesh Karthik", 1);
insert into Players values(default, "KL Rahul", 1);
insert into Players values(default, "Kedar Jadhav", 1);
insert into Players values(default, "Ravindra Jadeja", 1);
insert into Players values(default, "Rishabh Pant", 1);
insert into Players values(default, "Mohammed Shami", 1);
insert into Players values(default, "MS Dhoni", 1);

insert into Players values(default, "Kane Williamson", 4);
insert into Players values(default, "Tom Blundell", 4);
insert into Players values(default, "Trent Boult", 4);
insert into Players values(default, "Colin de Grandhomme", 4);
insert into Players values(default, "Lockie Ferguson", 4);
insert into Players values(default, "Martin Guptill", 4);
insert into Players values(default, "Matt Henry", 4);
insert into Players values(default, "Tom Latham", 4);
insert into Players values(default, "Colin Munro", 4);
insert into Players values(default, "James Neesham", 4);
insert into Players values(default, "Henry Nicholls", 4);

insert into Players values(default, "Sarfaraz Ahmed", 5);
insert into Players values(default, "Asif Ali", 5);
insert into Players values(default, "Babar Azam", 5);
insert into Players values(default, "Fakhar Zaman", 5);
insert into Players values(default, "Haris Sohail", 5);
insert into Players values(default, "Hasan Ali", 5);
insert into Players values(default, "Imad Wasim", 5);
insert into Players values(default, "Imam-ul-Haq", 5);
insert into Players values(default, "Mohammad Amir", 5);
insert into Players values(default, "Mohammad Hafeez", 5);
insert into Players values(default, "Mohammad Hasnain", 5);

insert into Players values(default, "Sarfaraz Ahmed", 5);
insert into Players values(default, "Asif Ali", 5);
insert into Players values(default, "Babar Azam", 5);
insert into Players values(default, "Fakhar Zaman", 5);
insert into Players values(default, "Haris Sohail", 5);
insert into Players values(default, "Hasan Ali", 5);
insert into Players values(default, "Imad Wasim", 5);
insert into Players values(default, "Imam-ul-Haq", 5);
insert into Players values(default, "Mohammad Amir", 5);
insert into Players values(default, "Mohammad Hafeez", 5);
insert into Players values(default, "Mohammad Hasnain", 5);

insert into Players values(default, "Eoin Morgan", 3);
insert into Players values(default, "Jofra Archer", 3);
insert into Players values(default, "Moeen Ali", 3);
insert into Players values(default, "Jonny Bairstow", 3);
insert into Players values(default, "Jos Buttler", 3);
insert into Players values(default, "Liam Dawson", 3);
insert into Players values(default, "Liam Plunkett", 3);
insert into Players values(default, "Adil Rashid", 3);
insert into Players values(default, "Joe Root", 3);
insert into Players values(default, "Jason Roy", 3);

insert into PlayerTournamentMap values(1, default, 100, 0);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 140, 0);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 400, 8);
insert into PlayerTournamentMap values(1, default, 310, 19);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 100, 15);
insert into PlayerTournamentMap values(1, default, 400, 10);
insert into PlayerTournamentMap values(1, default, 470, 10);
insert into PlayerTournamentMap values(1, default, 500, 0);
insert into PlayerTournamentMap values(1, default, 300, 27);

insert into PlayerTournamentMap values(1, default, 100, 0);
insert into PlayerTournamentMap values(1, default, 648, 0);
insert into PlayerTournamentMap values(1, default, 240, 18);
insert into PlayerTournamentMap values(1, default, 100, 10);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 310, 0);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 100, 15);
insert into PlayerTournamentMap values(1, default, 200, 0);
insert into PlayerTournamentMap values(1, default, 20, 10);
insert into PlayerTournamentMap values(1, default, 400, 0);

insert into PlayerTournamentMap values(1, default, 578, 0);
insert into PlayerTournamentMap values(1, default, 100, 0);
insert into PlayerTournamentMap values(1, default, 240, 17);
insert into PlayerTournamentMap values(1, default, 100, 10);
insert into PlayerTournamentMap values(1, default, 400, 7);
insert into PlayerTournamentMap values(1, default, 310, 0);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 100, 15);
insert into PlayerTournamentMap values(1, default, 200, 0);
insert into PlayerTournamentMap values(1, default, 470, 10);
insert into PlayerTournamentMap values(1, default, 500, 0);

insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 100, 0);
insert into PlayerTournamentMap values(1, default, 240, 0);
insert into PlayerTournamentMap values(1, default, 100, 10);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 310, 0);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 100, 15);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 470, 10);
insert into PlayerTournamentMap values(1, default, 400, 0);

insert into PlayerTournamentMap values(1, default, 200, 0);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 240, 24);
insert into PlayerTournamentMap values(1, default, 100, 10);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 310, 0);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 100, 15);
insert into PlayerTournamentMap values(1, default, 100, 0);
insert into PlayerTournamentMap values(1, default, 470, 10);
insert into PlayerTournamentMap values(1, default, 400, 0);

insert into PlayerTournamentMap values(1, default, 500, 0);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 240, 24);
insert into PlayerTournamentMap values(1, default, 532, 10);
insert into PlayerTournamentMap values(1, default, 400, 0);
insert into PlayerTournamentMap values(1, default, 310, 0);
insert into PlayerTournamentMap values(1, default, 440, 0);
insert into PlayerTournamentMap values(1, default, 500, 15);
insert into PlayerTournamentMap values(1, default, 556, 0);
insert into PlayerTournamentMap values(1, default, 470, 10);

select P.name, T.name, PTM.total_runs
from ((Players P
	inner join PlayerTournamentMap PTM
    on P.id = PTM.playerid)
inner join Teams T
on P.teamid = T.id)
where PTM.tournamentid = 1
order by total_runs DESC
limit 5;

select P.name, T.name, PTM.total_wickets
from ((Players P
	inner join PlayerTournamentMap PTM
    on P.id = PTM.playerid)
inner join Teams T
on P.teamid = T.id)
where PTM.tournamentid = 1
order by total_wickets DESC
limit 5;

create view avScore as (
select team1id as teamid, team1score as score
from Matches
where tournamentid  = 1
union
select team2id as teamid, team2score as score
from Matches
where tournamentid  = 1);

create view avgScores as
select name, avg(score) as avg_Score, teamid
from avScore
inner join Teams
on teamid = id
group by teamid;

select name, avg_Score
from avgScores;

create view minScore as
select min(avg_Score), teamid 
from avgScores;

update PlayerTournamentMap 
set total_runs = total_runs - 10
where playerid in (select id from Players where teamid = (select teamid from minScore))
	and tournamentid = 1;