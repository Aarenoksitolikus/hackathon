SELECT * from profiles prof WHERE prof.user_id IN
	(SELECT profile_id from liked_events WHERE event_id = ?);
