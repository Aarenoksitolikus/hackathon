SELECT * FROM services s WHERE s.id in
	(SELEct DISTINCT service_id FROM service_prefs WHERE preference_id in
    	(SELECT preference_id FROM profile_prefs WHERE profile_id = ?));