#Valid Phone Numbers
Given a text file file.txt that contains list of phone numbers (one per line), write a one liner bash script to print all valid phone numbers.

You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)

You may also assume each line in the text file must not contain leading or trailing white spaces.

For example, assume that file.txt has the following content:

	987-123-4567
	123 456 7890
	(123) 456-7890
Your script should output the following valid phone numbers:
	
	987-123-4567
	(123) 456-7890
##My thinking
use regular expression, first match the string of 3digits-3digits-4digits, then use an or operator to match the second string
(3digits) 3digits-4digits
##Solution

	Read from the file file.txt and output all valid phone numbers to stdout.
	egrep '^[0-9]{3}-[0-9]{3}-[0-9]{4}$|^\([0-9]{3}\) [0-9]{3}-[0-9]{4}$' file.txt