# Personal-Diary

A simple **command-line diary application** written in Java that helps you create, store, and view personal diary entries in text files.

---

## 🚀 Features

- **Create** diary entries with a title and timestamp.
- **List** all saved entries.
- **Read** previous entries by selecting from the list.
- Entries are saved as `.txt` files (file-based persistence).

---

## 🧰 Technologies Used

- Java (Java SE 8+)
- `java.io` for file handling
- `java.time` for timestamping
- Collections and `Scanner` (user interaction)

---

## 💻 Installation & Setup

1. **Clone the repository**  
   ```bash
   git clone https://github.com/student-prithvipatel/Personal-Diary.git
   cd Personal-Diary

2. **Compile the Java files**  
   ```bash
   javac Main.java DiaryEntry.java DiaryApp.java

3. **Run the application**  
   ```bash
   java DiaryApp

## 📝 Usage Guide

1. Launch the app with `java DiaryApp`.
2. Use the menu to:
   - **Create a new diary entry**: Enter a title and content → it will be saved as a timestamped `.txt` file.
   - **View all entries**: Shows a numbered list of saved diary files.
   - **Read an entry**: Select a number from the list to read that specific entry.
3. Exit the app using the menu option.

---

## 🚧 Future Enhancements (To-Do)

- ✅ Input validation (e.g., title cannot be empty).
- ✅ Better file organization (e.g., group entries by date).
- ✅ Option to **delete** or **search** entries.
- ✅ Export all entries to a single file (like `.md` or `.pdf`).
- ✅ GUI or web interface for easier use.
- ✅ Encrypt entries for privacy.

---

## 👤 Author

- **Prithvi Patel**  
  [@student-prithvipatel](https://github.com/student-prithvipatel)
