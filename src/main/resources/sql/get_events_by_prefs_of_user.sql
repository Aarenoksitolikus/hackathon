SELECT * FROM events e WHERE e.id in
	(SELEct DISTINCT event_id FROM event_prefs WHERE preference_id in
    	(SELECT preference_id FROM profile_prefs WHERE profile_id = ?));
