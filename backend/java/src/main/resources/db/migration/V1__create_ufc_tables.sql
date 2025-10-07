-- UFC Event Details
CREATE TABLE ufc_event_details (
    event TEXT,
    url TEXT,
    date TEXT,
    location TEXT,
    event_id INT,
    event_norm TEXT
);

-- UFC Fighter Details
CREATE TABLE ufc_fighter_details (
    fighter_id INT,
    first TEXT,
    last TEXT,
    nickname TEXT,
    url TEXT
);

-- Fighter Tale of the Tape
CREATE TABLE ufc_fighter_tott (
    fighter_id INT,
    height TEXT,
    weight TEXT,
    reach TEXT,
    stance TEXT,
    dob TEXT,
    url TEXT
);

-- Fight Details
CREATE TABLE ufc_fight_details (
    fight_id INT,
    event_id INT,
    bout TEXT,
    url TEXT,
    event_norm TEXT,
    bout_norm TEXT,
    bout_anagram TEXT
);

-- Fight Results
CREATE TABLE ufc_fight_results (
    fight_id INT,
    bout TEXT,
    outcome TEXT,
    weightclass TEXT,
    method TEXT,
    round TEXT,
    time TEXT,
    time_format TEXT,
    referee TEXT,
    details TEXT,
    event TEXT,
    fighter_a_nickname TEXT,
    fighter_b_nickname TEXT
);

-- Fight Stats
CREATE TABLE ufc_fight_stats (
    fight_id INT,
    fighter_id INT,
    round TEXT,
    kd INT,
    sig_str_pct TEXT,
    td_pct TEXT,
    sub_att INT,
    rev INT,
    ctrl TEXT,
    sig_str_landed INT,
    sig_str_attempted INT,
    total_str_landed INT,
    total_str_attempted INT,
    td_landed INT,
    td_attempted INT,
    head_landed INT,
    head_attempted INT,
    body_landed INT,
    body_attempted INT,
    leg_landed INT,
    leg_attempted INT,
    distance_landed INT,
    distance_attempted INT,
    clinch_landed INT,
    clinch_attempted INT,
    ground_landed INT,
    ground_attempted INT
);

