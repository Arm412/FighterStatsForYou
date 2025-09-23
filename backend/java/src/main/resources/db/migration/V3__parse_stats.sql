-- Split "20 of 40" into landed and attempted
UPDATE ufc_fight_stats
SET sig_str_landed = split_part(sig_str, ' ', 1)::INT,
    sig_str_attempted = split_part(sig_str, ' ', 3)::INT
WHERE sig_str IS NOT NULL;

-- Convert "50%" to numeric
UPDATE ufc_fight_stats
SET sig_str_pct_num = replace(sig_str_pct, '%', '')::DECIMAL
WHERE sig_str_pct IS NOT NULL;

-- Control time "2:15" into seconds
UPDATE ufc_fight_stats
SET ctrl_seconds = split_part(ctrl, ':', 1)::INT * 60 + split_part(ctrl, ':', 2)::INT
WHERE ctrl IS NOT NULL;
