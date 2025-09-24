import pandas as pd

# ---------- 1. Fighters ----------
fighters = pd.read_csv("ufc_fighter_details.csv")
fighters.columns = fighters.columns.str.strip().str.lower()

# Add a unique fighter_id
fighters.insert(0, "fighter_id", range(1, len(fighters) + 1))
fighters.to_csv("ufc_fighter_details_with_id.csv", index=False)

# fighter_id,FIRST,LAST,NICKNAME,URL






# ---------- 2. Fighter Tale of the Tape ----------
tott = pd.read_csv("ufc_fighter_tott.csv")
tott.columns = tott.columns.str.strip().str.lower()

# Split fighter name into first and last
tott[['first', 'last']] = tott['fighter'].str.strip().str.split(' ', n=1, expand=True)

# Merge to get fighter_id using names
tott = tott.merge(fighters[['fighter_id', 'first', 'last']], on=['first', 'last'], how='left')

# Keep only needed columns
tott = tott[['fighter_id', 'height', 'weight', 'reach', 'stance', 'dob', 'url']]
tott.to_csv("ufc_fighter_tott_with_id.csv", index=False)

# fighter_id FIGHTER,HEIGHT,WEIGHT,REACH,STANCE,DOB,URL






# ---------- 3. Events ----------
events = pd.read_csv("ufc_event_details.csv")
events.columns = events.columns.str.strip().str.lower()

# Assign event_id from highest to lowest
events['event_id'] = range(len(events), 0, -1)

# Normalize event names for merging
events['event_norm'] = events['event'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)

# Save updated CSV
events.to_csv("ufc_event_details_with_id.csv", index=False)





# ---------- 4. Fights ----------
fights = pd.read_csv("ufc_fight_details.csv")
fights.columns = fights.columns.str.strip().str.lower()

# Normalize event and bout for merges
fights['event_norm'] = fights['event'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)
fights['bout_anagram'] = fights['bout'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True).apply(lambda x: ''.join(sorted(x.replace(' ', ''))))
fights['bout_norm'] = fights['bout'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)


# Merge to get event_id
fights = fights.merge(events[['event_id', 'event_norm']], on='event_norm', how='left')

# Add unique fight_id
fights.insert(0, "fight_id", range(len(fights), 0, -1))

# Keep only necessary columns and temporary normalized columns
fights = fights[['fight_id', 'event_id', 'bout', 'url', 'event_norm', 'bout_norm', 'bout_anagram']]
fights.to_csv("ufc_fight_details_with_id.csv", index=False)





# ---------- 5. Fight Results ----------
results = pd.read_csv("ufc_fight_results.csv")
results.columns = results.columns.str.strip().str.lower()

# Normalize event and bout
results['event_norm'] = results['event'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)
results['bout_norm'] = results['bout'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)
results['bout_anagram'] = results['bout'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True).apply(lambda x: ''.join(sorted(x.replace(' ', ''))))
results['details'] = results['details'].str.strip()
results['event'] = results['event'].str.strip()

# Merge to get fight_id
results = results.merge(
    fights[['fight_id', 'event_norm', 'bout_anagram']], 
    on=['event_norm', 'bout_anagram'], 
    how='left'
)

# Keep proper columns
results = results[['fight_id', 'outcome', 'weightclass', 'method', 'round', 'time', 'time format', 'referee', 'details', 'event']]
results.to_csv("ufc_fight_results_with_id.csv", index=False)


# Halloway vs the korean zombie is missing from fight_results but exists in fight_details


# ---------- 6. Fight Stats ----------
stats = pd.read_csv("ufc_fight_stats.csv")
stats.columns = stats.columns.str.strip().str.lower()

# Normalize event, bout, and fighter
stats['event_norm'] = stats['event'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)
stats['bout_norm'] = stats['bout'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)
stats[['first', 'last']] = stats['fighter'].str.strip().str.split(' ', n=1, expand=True)

# Merge to get fight_id
stats = stats.merge(fights[['fight_id', 'event_norm', 'bout_norm']], 
                    on=['event_norm', 'bout_norm'], how='left')

# Merge to get fighter_id
stats = stats.merge(fighters[['fighter_id', 'first', 'last']], 
                    on=['first', 'last'], how='left')

# Keep only needed columns
stats = stats[['fight_id', 'fighter_id', 'round', 'kd', 'sig.str.', 'sig.str. %', 'total str.',
               'td', 'td %', 'sub.att', 'rev.', 'ctrl', 'head', 'body', 'leg', 'distance', 'clinch', 'ground']]
stats.to_csv("ufc_fight_stats_with_id.csv", index=False)

print("✅ All CSVs updated with IDs for primary and foreign keys!")
