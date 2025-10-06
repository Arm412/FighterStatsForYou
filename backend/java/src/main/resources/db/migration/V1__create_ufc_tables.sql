-- Staging: UFC Event Details
CREATE TABLE staging_ufc_event_details (
    event TEXT,
    url TEXT,
    date TEXT,  -- raw as text to handle malformed dates
    location TEXT,
    event_id TEXT,
    event_norm TEXT
);

-- Staging: UFC Fighter Details
CREATE TABLE staging_ufc_fighter_details (
    fighter_id TEXT,
    first TEXT,
    last TEXT,
    nickname TEXT,
    url TEXT
);

-- Staging: Fighter Tale of the Tape
CREATE TABLE staging_ufc_fighter_tott (
    fighter_id TEXT,
    height TEXT,
    weight TEXT,
    reach TEXT,
    stance TEXT,
    dob TEXT,
    url TEXT
);

-- Staging: Fight Details
CREATE TABLE staging_ufc_fight_details (
    fight_id TEXT,
    event_id TEXT,
    bout TEXT,
    url TEXT,
    event_norm TEXT,
    bout_norm TEXT,
    bout_anagram TEXT
);

-- Staging: Fight Results
CREATE TABLE staging_ufc_fight_results (
    fight_id TEXT,
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

-- Staging: Fight Stats
CREATE TABLE staging_ufc_fight_stats (
    fight_id TEXT,
    fighter_id TEXT,
    round TEXT,
    kd TEXT,
    "sig.str." TEXT,
    "sig.str. %" TEXT,
    "total str." TEXT,
    td TEXT,
    "td %" TEXT,
    "sub.att" TEXT,
    "rev." TEXT,
    ctrl TEXT,
    head TEXT,
    body TEXT,
    leg TEXT,
    distance TEXT,
    clinch TEXT,
    ground TEXT
);
