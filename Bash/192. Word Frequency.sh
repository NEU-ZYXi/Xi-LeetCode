
: '

Write a bash script to calculate the frequency of each word in a text file words.txt.
For simplicity sake, you may assume:
words.txt contains only lowercase characters and space ' ' characters.
Each word must consist of lowercase characters only.
Words are separated by one or more whitespace characters.

Example:
Assume that words.txt has the following content:
the day is sunny the the
the sunny is is

Your script should output the following, sorted by descending frequency:
the 4
is 3
sunny 2
day 1

'

: '

tr -s: truncate the string with target string, but only remaining one instance (e.g. multiple whitespaces)
sort: To make the same string successive so that uniq could count the same string fully and correctly.
uniq -c: uniq is used to filter out the repeated lines which are successive, -c means counting
sort -nr: sort numeric values in descending order
awk '{ print $2, $1 }': To format the output

'

cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -nr | awk '{ print $2, $1 }'



