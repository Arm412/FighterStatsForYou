-- =====================================
-- Migration: Add numeric columns to fight stats
-- =====================================

ALTER TABLE ufc_fight_stats
    ADD COLUMN sig_str_landed INT,
    ADD COLUMN sig_str_attempted INT,
    ADD COLUMN sig_str_pct_num DECIMAL(5,2),

    ADD COLUMN total_str_landed INT,
    ADD COLUMN total_str_attempted INT,

    ADD COLUMN td_landed INT,
    ADD COLUMN td_attempted INT,
    ADD COLUMN td_pct_num DECIMAL(5,2),

    ADD COLUMN ctrl_seconds INT,

    ADD COLUMN head_landed INT,
    ADD COLUMN head_attempted INT,
    ADD COLUMN body_landed INT,
    ADD COLUMN body_attempted INT,
    ADD COLUMN leg_landed INT,
    ADD COLUMN leg_attempted INT,
    ADD COLUMN distance_landed INT,
    ADD COLUMN distance_attempted INT,
    ADD COLUMN clinch_landed INT,
    ADD COLUMN clinch_attempted INT,
    ADD COLUMN ground_landed INT,
    ADD COLUMN ground_attempted INT;
