DROP TABLE IF EXISTS intervals;

Create Temp Table intervals ON COMMIT DROP
AS
SELECT
    ses.sessionid,
    f.name,
    ses.date,
    ses.starttime,
    f.duration,
CASE
 WHEN f.duration = '60' THEN ses.starttime + interval '60 minute'
 WHEN f.duration = '90' THEN ses.starttime + interval '90 minute'
 WHEN f.duration = '120' THEN ses.starttime + interval '120 minute'
END AS endtime
FROM lesson_4.sessions AS ses
	INNER JOIN lesson_4.films AS f ON ses.film = f.filmid;

SELECT
	t1.name AS "Фильм 1",
	t1.starttime AS "Время начала",
	t1.duration AS "Длительность",
	t1.endtime AS "Время окончания",
	t2.name AS "Фильм 2",
	t2.starttime AS "Время начала 2",
	t2.duration AS "Длительность 2"
FROM intervals AS t1
	INNER JOIN intervals AS t2 ON
		t1.date = t2.date
		AND NOT t2.sessionid=t1.sessionid
		AND t2.starttime>t1.starttime
		AND t2.starttime<t1.endtime;

