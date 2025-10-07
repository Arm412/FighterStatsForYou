-- flyway:executeInTransaction=false

-- Import Events
COPY ufc_event_details(event, url, date, location, event_id, event_norm)
FROM '/csv/ufc_event_details_with_id.csv'
WITH (FORMAT csv, HEADER true);

-- Import Fighters
COPY ufc_fighter_details(fighter_id, first, last, nickname, url)
FROM '/csv/ufc_fighter_details_with_id.csv'
WITH (FORMAT csv, HEADER true);

-- Import Fighter Tale of the Tape
COPY ufc_fighter_tott(fighter_id, height, weight, reach, stance, dob, url)
FROM '/csv/ufc_fighter_tott_with_id.csv'
WITH (FORMAT csv, HEADER true);

-- Import Fights
COPY ufc_fight_details(fight_id, event_id, bout, event_norm, bout_norm, bout_anagram)
FROM '/csv/ufc_fight_details_with_id.csv'
WITH (FORMAT csv, HEADER true);

-- Import Results
COPY ufc_fight_results(fight_id, bout, outcome, weightclass, method, round, time, time_format, referee, details, event, fighter_a_nickname, fighter_b_nickname)
FROM '/csv/ufc_fight_results_with_id.csv'
WITH (FORMAT csv, HEADER true);

-- Import Stats
COPY ufc_fight_stats(
    fight_id,
    fighter_id,
    round,
    kd,
    sig_str_pct,
    td_pct,
    sub_att,
    rev,
    ctrl,
    sig_str_landed,
    sig_str_attempted,
    total_str_landed,
    total_str_attempted,
    td_landed,
    td_attempted,
    head_landed,
    head_attempted,
    body_landed,
    body_attempted,
    leg_landed,
    leg_attempted,
    distance_landed,
    distance_attempted,
    clinch_landed,
    clinch_attempted,
    ground_landed,
    ground_attempted
)
FROM '/csv/ufc_fight_stats_with_id_split.csv'
WITH (FORMAT csv, HEADER true);
