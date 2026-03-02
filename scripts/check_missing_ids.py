import csv
from pathlib import Path
p = Path(__file__).parents[1] / 'csv' / 'ufc_fight_stats_with_id_split.csv'
missing_fight = []
missing_fighter = []
with p.open(newline='', encoding='utf-8') as f:
    reader = csv.reader(f)
    header = next(reader, None)
    for i, row in enumerate(reader, start=2):
        # handle short rows
        if len(row) < 2:
            missing_fight.append((i, ','.join(row)))
            missing_fighter.append((i, ','.join(row)))
            continue
        fight_id = row[0].strip()
        fighter_id = row[1].strip()
        if fight_id == '':
            missing_fight.append((i, ','.join(row)))
        if fighter_id == '':
            missing_fighter.append((i, ','.join(row)))

print('Scanned:', p)
print('Total rows (excluding header):', sum(1 for _ in open(p, encoding='utf-8')) - 1)
print('Missing fight_id count:', len(missing_fight))
print('Missing fighter_id count:', len(missing_fighter))
if missing_fight:
    print('\nSample rows missing fight_id (line,content):')
    for ln, content in missing_fight[:20]:
        print(ln, content)
if missing_fighter:
    print('\nSample rows missing fighter_id (line,content):')
    for ln, content in missing_fighter[:20]:
        print(ln, content)
