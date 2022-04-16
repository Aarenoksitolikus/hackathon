SELECT * from events e WHERE e.id in
	(SELECT event_id FROM event_owners where organization_id = ?);