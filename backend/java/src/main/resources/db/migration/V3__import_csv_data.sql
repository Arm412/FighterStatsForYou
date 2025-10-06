-- flyway:executeInTransaction=false

-- Import Events
COPY ufc_event_details(event, url, date, location)
FROM '/csv/ufc_event_details.csv'
WITH (FORMAT csv, HEADER true);

-- Import Fighters
COPY ufc_fighter_details(first, last, nickname, url)
FROM '/csv/ufc_fighter_details.csv'
WITH (FORMAT csv, HEADER true);

-- Import Fighter Tale of the Tape
COPY ufc_fighter_tott(fighter_id, height, weight, reach, stance, dob, url)
FROM '/csv/ufc_fighter_tott.csv'
WITH (FORMAT csv, HEADER true);

-- Import Fights
COPY ufc_fight_details(event_id, bout, url)
FROM '/csv/ufc_fight_details.csv'
WITH (FORMAT csv, HEADER true);

-- Import Results
COPY ufc_fight_results(fight_id, outcome, weightclass, method, round, time, time_format, referee, details, url)
FROM '/csv/ufc_fight_results.csv'
WITH (FORMAT csv, HEADER true);

-- Import Stats
COPY ufc_fight_stats(fight_id, fighter_id, round, kd, sig_str, sig_str_pct, total_str, td, td_pct, sub_att, rev, ctrl, head, body, leg, distance, clinch, ground)
FROM '/csv/ufc_fight_stats.csv'
WITH (FORMAT csv, HEADER true);
