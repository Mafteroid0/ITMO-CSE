import pandas as pd
import matplotlib.pyplot as plt


data = pd.read_csv('Extra Task Graph.csv')
megadata = []
STATES = ["<OPEN>", "<HIGH>", "<LOW>", "<CLOSE>"]
DATES = ["9/6/2018", "10/8/2018", "11/6/2018", "12/6/2018"]


labels = []
for date in DATES:
    for state in STATES:
        megadata.append(data[data["<DATE>"] == date][state])
        labels.append(f'{date}\n{state}')

plt.title('MY BEST DIAGRAM')


plt.figure(figsize=(10, 8))
plt.xticks(rotation=270)
plt.tick_params(axis='both', which='major', labelsize=10)
plt.boxplot(megadata, patch_artist=True, tick_labels=labels)
plt.show()
