-- UFC Event Details
CREATE TABLE ufc_event_details (
    event TEXT,
    url TEXT,
    date TEXT,  -- raw as text to handle malformed dates
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
    kd TEXT,
    sig_str TEXT,
    sig_str_pct TEXT,
    total_str TEXT,
    td TEXT,
    td_pct TEXT,
    sub_att TEXT,
    rev TEXT,
    ctrl TEXT,
    head TEXT,
    body TEXT,
    leg TEXT,
    distance TEXT,
    clinch TEXT,
    ground TEXT
);

