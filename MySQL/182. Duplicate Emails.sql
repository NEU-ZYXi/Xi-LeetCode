
/*

Write a SQL query to find all duplicate emails in a table named Person.
+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:
+---------+
| Email   |
+---------+
| a@b.com |
+---------+

*/

/*

HAVING clause must follow GROUP BY clause as a condition check

*/

SELECT Email FROM Person
GROUP BY Email
HAVING COUNT(id) > 1


