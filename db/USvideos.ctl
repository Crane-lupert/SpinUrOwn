options(skip =1, errors=-1)
load data
infile '/Users/Haka4700/Downloads/USvideos.csv'
append into table USvideo
fields terminated by ','
(
	video_id,
	title,
	channel_title,
	category_id,
	tags,
	views,
	likes,
	dislikes,
	comment_total,
	thumbnail_link,
	Uploaddate
)
	