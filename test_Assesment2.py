import csv

class ReadAndWriteData:
    def __init__(self, filename):
        self.filename = filename
        self.data = []

    def read_data_from_csv(self):
        with open(self.filename, 'r') as file:
            csv_reader = csv.DictReader(file)
            for row in csv_reader:
                self.data.append(row)

    def display_data(self):
        if not self.data:
            print("No data to display. Please read data from CSV file first.")
        else:
            print("Name\t\tSkillSet\tExperience")
            print("--------------------------------------")
            for row in self.data:
                print(f"{row['Name']}\t\t{row['SkillSet']}\t\t{row['Experience']}")

# Creating an instance of the ReadAndWriteData class
data_handler = ReadAndWriteData("C:\\Users\\sivaj\\eclipse-workspace\\Selepract\\SS_csv_file.csv")

# Reading data from CSV file
data_handler.read_data_from_csv()

# Displaying the data
data_handler.display_data()
