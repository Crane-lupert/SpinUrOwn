options(skip =1, errors=-1)
load data
infile '/Users/Haka4700/Downloads/UScomments.csv'
append into table UScomments
fields terminated by ','
(
	video_id,
	comment_text
)
	