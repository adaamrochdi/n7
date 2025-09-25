import pandas as pd
from tkinter import *
from tkinter import ttk, filedialog, messagebox
from IndiceQualiteCalc import IndiceQualiteCalc
from ScoreConfortCalc import ScoreConfortCalc
from RisqueCalc import RisqueCalc
# Classe pour gérer la table et les calculs
class TableManager:

    def __init__(self, gui, initial_data):
        self.data = initial_data
        self.entries = []
        self.total_rows, self.total_columns = initial_data.shape

        # Création de l'interface graphique
        for i in range(self.total_rows + 1):  # Ligne supplémentaire pour les noms de colonnes
            row_entries = []
            for j in range(self.total_columns):
                if i == 0:
                    # Ajout des entêtes
                    entry = Entry(gui, width=20, bg='LightSteelBlue', fg='Black',
                                  font=('Arial', 16, 'bold'))
                    entry.insert(END, initial_data.columns[j])  # Affiche les noms des colonnes
                else:
                    # Ajout des données
                    entry = Entry(gui, width=20, fg='blue', font=('Arial', 16, ''))
                    entry.insert(END, initial_data.iloc[i - 1, j])
                entry.grid(row=i, column=j)
                row_entries.append(entry)
            self.entries.append(row_entries)

    def update_data(self):
        # Mise à jour des données du tableau
        for i in range(1, self.total_rows + 1):  # Commence à la ligne 1 (ignorer les entêtes)
            for j in range(self.total_columns):
                self.data.iloc[i - 1, j] = self.entries[i][j].get()

    def clear_table(self):
        # Efface toutes les cellules du tableau
        for i in range(self.total_rows + 1):
            for j in range(self.total_columns):
                self.entries[i][j].delete(0, END)

    def resize_table(self, new_rows, new_columns):
        # Redimensionne le tableau
        for i in range(self.total_rows + 1):
            for j in range(self.total_columns):
                self.entries[i][j].destroy()

        self.total_rows, self.total_columns = new_rows, new_columns

        # Création de nouvelles entrées
        self.entries = []
        for i in range(self.total_rows + 1):
            row_entries = []
            for j in range(self.total_columns):
                if i == 0:
                    entry = Entry(gui, width=20, bg='LightSteelBlue', fg='Black',
                                  font=('Arial', 16, 'bold'))
                else:
                    entry = Entry(gui, width=20, fg='blue', font=('Arial', 16, ''))
                entry.grid(row=i, column=j)
                if i < self.data.shape[0] and j < self.data.shape[1]:
                    entry.insert(END, self.data.iloc[i - 1, j])
                row_entries.append(entry)
            self.entries.append(row_entries)
# Fonction pour charger un fichier CSV et l'afficher
def upload_csv():
    file_path = filedialog.askopenfilename(filetypes=[("CSV files", "*.csv")])
    if file_path:
        try:
            new_data = pd.read_csv(file_path)
            table_manager.resize_table(new_data.shape[0], new_data.shape[1])
            table_manager.data = new_data
            for i in range(table_manager.total_rows + 1):  
                for j in range(table_manager.total_columns):
                    if i < len(table_manager.entries) and j < len(table_manager.entries[i]):
                        table_manager.entries[i][j].delete(0, END)
                        if i == 0 and j < new_data.shape[1]:
                            table_manager.entries[i][j].insert(END, new_data.columns[j])
                        elif i - 1 < new_data.shape[0] and j < new_data.shape[1]:
                            table_manager.entries[i][j].insert(END, new_data.iloc[i - 1, j])

            save_button.grid(columnspan=table_manager.total_columns)
            calculation_button.grid(columnspan=table_manager.total_columns)
            upload_button.grid(columnspan=table_manager.total_columns)

        except pd.errors.EmptyDataError:
            print("Empty CSV file")
def save_table_to_csv():
    table_manager.update_data()  
    file_path = filedialog.asksaveasfilename(defaultextension=".csv", filetypes=[("CSV files", "*.csv")])
    if file_path:
        try:
            table_manager.data.to_csv(file_path, index=False)
            print(f"Table saved to {file_path}")
        except Exception as e:
            print(f"Error saving the table: {e}")
# Fonction pour créer le DataFrame à partir du modèle
def creer_dataframe():
    """Créer un DataFrame basé sur le modèle XMI"""
    colonnes = {}
    colonnes['RecordID'] = ["1.0", "2.0", "3.0", "4.0", "5.0", "6.0", "7.0", "8.0", "9.0", "10.0", "11.0", "12.0"];    
    colonnes['DateEnregistrement'] = ["1.1", "2.1", "3.1", "4.1", "5.1", "6.1", "7.1", "8.1", "9.1", "10.1", "11.1", "12.1"];    
    colonnes['Temperature'] = ["21.0", "21.5", "22.0", "22.5", "23.0", "23.5", "24.0", "24.5", "25.0", "25.5", "26.0", "26.5"];    
    colonnes['Humidite'] = ["45.0", "45.5", "46.0", "46.5", "47.0", "47.5", "48.0", "48.5", "49.0", "49.5", "50.0", "55.0"];    
    colonnes['ResRecordID'] = ["1.0", "2.0", "3.0", "4.0", "5.0", "6.0", "7.0", "8.0", "9.0", "10.0", "11.0", "12.0"];    
    colonnes['IndiceQualite'] = ["3.0", "3.1", "3.2", "3.4", "3.5", "3.6", "3.7", "3.8", "3.9", "4.0","0.0","0.0"];    
    colonnes['ScoreConfort'] = ["10.0", "10.5", "11.0", "11.2", "11.5", "11.8", "12.0", "12.2", "12.5", "12.7", "13.0", "13.2"];    
    colonnes['Risque'] = ["0.5", "0.6", "0.7", "0.8", "0.9", "1.0", "1.1", "1.2", "1.3", "1.4", "1.5","0.0"];    
    # Retourner le DataFrame
    return pd.DataFrame(colonnes)

def compute_calcul(df):
    # Appliquer les scripts pour calculer les colonnes dérivées
    df["Temperature"] = df["Temperature"].astype(float)
    df["Humidite"] = df["Humidite"].astype(float)
    df["IndiceQualite"] = list(map(IndiceQualiteCalc,df["Temperature"].to_list(),df["Humidite"].to_list()))
    df["Temperature"] = df["Temperature"].astype(float)
    df["DateEnregistrement"] = df["DateEnregistrement"].astype(float)
    df["ScoreConfort"] = list(map(ScoreConfortCalc,df["Temperature"].to_list(),df["DateEnregistrement"].to_list()))
    df["Humidite"] = df["Humidite"].astype(float)
    df["Temperature"] = df["Temperature"].astype(float)
    df["Risque"] = list(map(RisqueCalc,df["Humidite"].to_list(),df["Temperature"].to_list()))

    # Une fois les colonnes dérivées calculées, on les convertit également en chaînes avec guillemets
    df["IndiceQualite"] = df["IndiceQualite"].astype(str)
    df["ScoreConfort"] = df["ScoreConfort"].astype(str)
    df["Risque"] = df["Risque"].astype(str)
    return df

def verifier_contraintes(df):
    """
    Vérifie les contraintes définies sur les colonnes d'un DataFrame.
    Retourne 'OK' si toutes les contraintes sont respectées, sinon un message d'erreurs.
    """
    erreurs = []

    # Vérifications des contraintes pour les colonnes des tables source
    if not (df['Humidite'].astype(float) <= 50.0).all():
        erreurs.append(f"La contrainte <= 50.0 n'est pas vérifiée pour la colonne Humidite")
    if not (df['Temperature'].astype(float) > 22.0).all():
        erreurs.append(f"La contrainte > 22.0 n'est pas vérifiée pour la colonne Temperature")

    # Vérifications des contraintes pour les colonnes des tables résultantes
    #if not (df['ValeurFiltrée'].astype(float) >= 22.5).all():
      #  erreurs.append(f"La contrainte >= 22.5 n'est pas vérifiée pour la colonne ValeurFiltrée")
    if not (df['IndiceQualite'].astype(float) > 3.0).all():
        erreurs.append(f"La contrainte > 3.0 n'est pas vérifiée pour la colonne IndiceQualite")
    if not (df['ScoreConfort'].astype(float) >= 10.0).all():
        erreurs.append(f"La contrainte >= 10.0 n'est pas vérifiée pour la colonne ScoreConfort")
    if not (df['Risque'].astype(float) < 2.0).all():
        erreurs.append(f"La contrainte < 2.0 n'est pas vérifiée pour la colonne Risque")

    if len(erreurs) == 0:
        return "OK"
    else:
        return "\n".join(erreurs)


# Création du DataFrame à partir du modèle
df = creer_dataframe()
# Calcul des colonnes dérivées
df = compute_calcul(df)

# Création de l'interface graphique principale
gui = Tk()
table_manager = TableManager(gui, df)

# Boutons et événements

# Bouton pour vérifier les contraintes
def verifier_button_action():
	result = verifier_contraintes(table_manager.data)
	messagebox.showinfo("Vérification des contraintes", result)

verifier_button = Button(gui, text="Vérifier Contraintes", command=verifier_button_action)
verifier_button.grid(row=table_manager.total_rows + 3, columnspan=table_manager.total_columns)

save_button = Button(gui, text="Save", command=lambda: table_manager.update_data())
save_button.grid(row=table_manager.total_rows + 1, columnspan=table_manager.total_columns)

# Créer le bouton pour charger le CSV
upload_button = Button(gui, text="Upload CSV", command=upload_csv)
upload_button.grid(row=table_manager.total_rows + 4, columnspan=table_manager.total_columns)

# Créer le bouton pour sauvragrder le CSV
to_csv_button = Button(gui, text="Save CSV", command=save_table_to_csv)
to_csv_button.grid(row=table_manager.total_rows + 2, columnspan=table_manager.total_columns)

# Lancer l'interface graphique
gui.mainloop()
