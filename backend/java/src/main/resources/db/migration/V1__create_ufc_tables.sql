-- UFC Event Details
CREATE TABLE ufc_event_details (
    id SERIAL PRIMARY KEY,
    event VARCHAR(255) UNIQUE,
    url TEXT,
    date DATE,
    location VARCHAR(255)
);

-- UFC Fighter Details
CREATE TABLE ufc_fighter_details (
    id SERIAL PRIMARY KEY,
    first VARCHAR(100),
    last VARCHAR(100),
    nickname VARCHAR(100),
    url TEXT UNIQUE
);

-- Fighter Tale of the Tape
CREATE TABLE ufc_fighter_tott (
    id SERIAL PRIMARY KEY,
    fighter_id INT NOT NULL,
    height VARCHAR(20),
    weight VARCHAR(20),
    reach VARCHAR(20),
    stance VARCHAR(50),
    dob DATE,
    url TEXT,
    CONSTRAINT fk_fighter_tott FOREIGN KEY (fighter_id) REFERENCES ufc_fighter_details (id) ON DELETE CASCADE
);

-- Fight Details
CREATE TABLE ufc_fight_details (
    id SERIAL PRIMARY KEY,
    event_id INT NOT NULL,
    bout VARCHAR(255),
    url TEXT,
    CONSTRAINT fk_fight_event FOREIGN KEY (event_id) REFERENCES ufc_event_details (id) ON DELETE CASCADE
);

-- Fight Results
CREATE TABLE ufc_fight_results (
    id SERIAL PRIMARY KEY,
    fight_id INT NOT NULL,
    outcome VARCHAR(255),
    weightclass VARCHAR(100),
    method VARCHAR(255),
    round INT,
    time VARCHAR(20),
    time_format VARCHAR(50),
    referee VARCHAR(100),
    details TEXT,
    url TEXT,
    CONSTRAINT fk_results_fight FOREIGN KEY (fight_id) REFERENCES ufc_fight_details (id) ON DELETE CASCADE
);

-- Fight Stats
CREATE TABLE ufc_fight_stats (
    id SERIAL PRIMARY KEY,
    fight_id INT NOT NULL,
    fighter_id INT NOT NULL,
    round INT,
    kd INT,
    sig_str VARCHAR(50),
    sig_str_pct VARCHAR(10),
    total_str VARCHAR(50),
    td VARCHAR(50),
    td_pct VARCHAR(10),
    sub_att INT,
    rev INT,
    ctrl VARCHAR(20),
    head VARCHAR(50),
    body VARCHAR(50),
    leg VARCHAR(50),
    distance VARCHAR(50),
    clinch VARCHAR(50),
    ground VARCHAR(50),
    CONSTRAINT fk_stats_fight FOREIGN KEY (fight_id) REFERENCES ufc_fight_details (id) ON DELETE CASCADE,
    CONSTRAINT fk_stats_fighter FOREIGN KEY (fighter_id) REFERENCES ufc_fighter_details (id) ON DELETE CASCADE
);
