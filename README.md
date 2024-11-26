# CSC251_Group5

# 🎵 **Java Playlist Application**

## 📝 **Project Description**

This Java application allows users to create and manage playlists of songs directly from the command line. It provides a simple and effective way to add, remove, and sort songs, as well as save playlists to disk. The application simulates a digital jukebox for managing music playlists.

## 📂 **Project Structure**

- **`Main.java`**: The main entry point that offers a command-line interface for managing playlists and songs.
- **`Song.java`**: Represents a song with properties like title, artist, and length.
- **`Playlist.java`**: Represents a playlist, supporting operations like adding, removing, shuffling, and sorting songs.
- **`TestSong.java`**: Contains tests for validating the `Song` class functionality.
- **`TestPlaylist.java`**: Contains tests for validating the `Playlist` class functionality.

## 🚀 **Features**

- **Create New Songs**: Add songs with title, artist, and duration.
- **Manage Playlists**: Create multiple playlists, add songs, remove songs, and sort by title, artist, or length.
- **Save Playlists**: Persist playlists to disk for future use.
- **Shuffle Songs**: Randomize the order of songs within a playlist.

### 📜 **Instructions**
1. Clone or download this project to your local machine.
2. Compile the Java files:
   ```sh
   javac *.java
   ```
3. Run the `Main` class:
   ```sh
   java Main
   ```
4. Follow the command-line prompts to create songs and playlists, manage them, and save playlists.

## 📋 **Commands Overview**
The main commands available in the application are:

1. **Create a New Playlist** - Allows you to create a new playlist and select it as the active playlist.
2. **Select a Playlist** - Choose a playlist from the list to make modifications.
3. **Add a Song** - Add a new song to the currently selected playlist.
4. **Remove a Song** - Remove an existing song from the playlist by index.
5. **Show Playlist** - View all songs currently in the playlist.
6. **Shuffle Playlist** - Randomize the order of the songs in the current playlist.
7. **Sort Playlist** - Sort songs in the playlist by title, artist, or length.
8. **Save Playlist** - Save the current playlist to disk.
9. **Exit** - Exit the application.

## 🧪 **Testing**
- **TestSong.java** and **TestPlaylist.java** provide testing for the core functionalities of both `Song` and `Playlist` classes, ensuring that they behave as expected.
- 🎵 **Song Information** is displayed in the format: `Artist - Title (Length)`.
- 🔀 **Playlist Actions** like shuffle and sorting are indicated with clear messages.

## 📜 **Example Usage**

```sh
--- Playlist Command Line Tool ---
1. Select a playlist
2. Create a new playlist
3. Add a song to the current playlist
...
Enter your choice: 2
Enter playlist title: Rock Classics
Playlist created: Rock Classics
Select this playlist? (y/n): y
```

In the above example, a new playlist titled *Rock Classics* is created and selected for further actions.
