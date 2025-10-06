import pandas as pd

# ---------- 1. Fighters ----------
fighters = pd.read_csv("csv/ufc_fighter_details.csv")
fighters.columns = fighters.columns.str.strip().str.lower()

# Add a unique fighter_id
fighters.insert(0, "fighter_id", range(1, len(fighters) + 1))
fighters.to_csv("csv/ufc_fighter_details_with_id.csv", index=False)

# ---------- 2. Fighter Tale of the Tape ----------
tott = pd.read_csv("csv/ufc_fighter_tott.csv")
tott.columns = tott.columns.str.strip().str.lower()

# Assign fighter_id incrementally from 1 to number of rows
tott.insert(0, "fighter_id", range(1, len(tott) + 1))

# Keep only needed columns
tott = tott[['fighter_id', 'height', 'weight', 'reach', 'stance', 'dob', 'url']]

# Save to new CSV
tott.to_csv("csv/ufc_fighter_tott_with_id.csv", index=False)

# ---------- 3. Events ----------
events = pd.read_csv("csv/ufc_event_details.csv")
events.columns = events.columns.str.strip().str.lower()

# Assign event_id
events['event_id'] = range(len(events), 0, -1)

# Normalize event names for merging
events['event_norm'] = events['event'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)

events.to_csv("csv/ufc_event_details_with_id.csv", index=False)

# ---------- 4. Fights ----------
fights = pd.read_csv("csv/ufc_fight_details.csv")
fights.columns = fights.columns.str.strip().str.lower()

fights['event_norm'] = fights['event'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)
fights['bout_norm'] = fights['bout'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)
fights['bout_anagram'] = fights['bout_norm'].apply(lambda x: ''.join(sorted(x.replace(' ', ''))))

# Merge event_id
fights = fights.merge(events[['event_id', 'event_norm']], on='event_norm', how='left')

# Add fight_id
fights.insert(0, "fight_id", range(len(fights), 0, -1))
fights = fights[['fight_id', 'event_id', 'bout', 'url', 'event_norm', 'bout_norm', 'bout_anagram']]
fights.to_csv("csv/ufc_fight_details_with_id.csv", index=False)

# ---------- 5. Fight Results ----------
results = pd.read_csv("csv/ufc_fight_results.csv")
results.columns = results.columns.str.strip().str.lower()

results['event_norm'] = results['event'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)
results['bout_norm'] = results['bout'].str.strip().str.lower().str.replace(r'\s+', ' ', regex=True)
results['bout_anagram'] = results['bout_norm'].apply(lambda x: ''.join(sorted(x.replace(' ', ''))))

# Merge fight_id
results = results.merge(
    fights[['fight_id', 'event_norm', 'bout_anagram']],
    on=['event_norm', 'bout_anagram'],
    how='left'
)

results = results[['fight_id', 'bout', 'outcome', 'weightclass', 'method', 'round',
                   'time', 'time format', 'referee', 'details', 'event', 
                   'fighter_a_nickname', 'fighter_b_nickname']]
results.to_csv("csv/ufc_fight_results_with_id.csv", index=False)

# ---------- 6. Fight Stats with Nickname Fallback ----------
stats = pd.read_csv("csv/ufc_fight_stats.csv")
stats.columns = stats.columns.str.strip().str.lower()

# Normalize string columns
for df in [fighters, results, stats]:
    for col in df.select_dtypes(include="object"):
        df[col] = df[col].str.strip().str.lower()

# Create 'merge_name' in stats: use nickname if available, otherwise first + last
stats['merge_name'] = stats['fighter_nickname'].fillna('')

# Split fighter name into first and last
stats[['first', 'last']] = stats['fighter'].str.split(' ', n=1, expand=True)

stats['merge_name'] = stats.apply(
    lambda row: row['merge_name'] if row['merge_name'] else f"{row['first']} {row['last']}",
    axis=1
)

# Prepare fighters dataframe for merging
fighters['merge_name'] = fighters['nickname'].fillna('')
fighters['merge_name'] = fighters.apply(
    lambda row: row['merge_name'] if row['merge_name'] else f"{row['first']} {row['last']}",
    axis=1
)

# Merge stats with fighters on merge_name to get fighter_id
stats_merged = stats.merge(
    fighters[['fighter_id', 'first', 'last', 'nickname']],
    left_on=['first', 'last', 'fighter_nickname'],
    right_on=['first', 'last', 'nickname'],
    how='left'
)

# Merge with results on event + bout
stats_merged['event'] = stats_merged['event'].str.strip().str.lower()
stats_merged['bout'] = stats_merged['bout'].str.strip().str.lower()
results['event'] = results['event'].str.strip().str.lower()
results['bout'] = results['bout'].str.strip().str.lower()

final_stats = stats_merged.merge(
    results[['fight_id', 'event', 'bout']],
    on=['event', 'bout'],
    how='left'
)

# Keep only relevant columns
final_stats = final_stats[['fight_id', 'fighter_id', 'round', 'kd', 'sig.str.', 'sig.str. %',
                           'total str.', 'td', 'td %', 'sub.att', 'rev.', 'ctrl',
                           'head', 'body', 'leg', 'distance', 'clinch', 'ground']]

# Ensure fighter_id is integer (no ".0")
final_stats['fighter_id'] = final_stats['fighter_id'].astype('Int64')  # allows NULLs
final_stats['kd'] = final_stats['kd'].astype('Int64')


# ---------- 7. Split "X of Y" columns into separate numeric columns ----------
columns_to_split = ['sig.str.', 'total str.', 'td', 'head', 'body', 'leg', 'distance', 'clinch', 'ground']

for col in columns_to_split:
    final_stats[[f"{col}_landed", f"{col}_attempted"]] = final_stats[col].str.extract(r'(\d+)\s+of\s+(\d+)').astype('Int64')

# Drop original string columns
final_stats = final_stats.drop(columns=columns_to_split)

# Save updated CSV
final_stats.to_csv("csv/ufc_fight_stats_with_id_split.csv", index=False)

print("✅ Fight stats updated with fighter IDs, nickname fallback, and split numeric columns!")
