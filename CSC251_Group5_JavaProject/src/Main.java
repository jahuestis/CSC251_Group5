import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // The currently selected playlist
    private static Playlist currentPlaylist = null;

    // List of all available playlists
    private static ArrayList<Playlist> playlists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Main loop to keep the application running until the user decides to exit
        while (running) {
            System.out.println("\n--- Playlist Command Line Tool ---");
            System.out.println("1. Select a playlist");
            System.out.println("2. Create a new playlist");
            System.out.println("3. Add a song to the current playlist");
            System.out.println("4. Remove a song from the current playlist");
            System.out.println("5. Show the current playlist");
            System.out.println("6. Shuffle the current playlist");
            System.out.println("7. Sort the current playlist by title");
            System.out.println("8. Sort the current playlist by artist");
            System.out.println("9. Sort the current playlist by length");
            System.out.println("10. Save the current playlist to disk");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            // Handles user choice with a switch statement
            switch (choice) {
                case 1:
                    selectPlaylist(scanner);
                    break;
                case 2:
                    createNewPlaylist(scanner);
                    break;
                case 3:
                    addSongToPlaylist(scanner);
                    break;
                case 4:
                    removeSongFromPlaylist(scanner);
                    break;
                case 5:
                    showCurrentPlaylist();
                    break;
                case 6:
                    shufflePlaylist();
                    break;
                case 7:
                    sortPlaylistByTitle();
                    break;
                case 8:
                    sortPlaylistByArtist();
                    break;
                case 9:
                    sortPlaylistByLength();
                    break;
                case 10:
                    savePlaylist();
                    break;
                case 11:
                    running = false; // Exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close(); // Close the scanner to prevent resource leaks
    }

    // Method to select a playlist from the list of existing playlists
    private static void selectPlaylist(Scanner scanner) {
        if (playlists.size() < 1) {
            System.out.println("No playlists to select from.");
            return;
        }

        // Display's all available playlists to the user
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println(i + ": " + playlists.get(i).getTitle());
        }

        System.out.print("Enter index of playlist to select: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Checks if the entered index is valid
        if (index >= 0 && index < playlists.size()) {
            currentPlaylist = playlists.get(index);
            System.out.println("Playlist selected: " + currentPlaylist.getTitle());
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    // Method to create a new song by prompting user input
    private static Song createNewSong(Scanner scanner) {
        System.out.print("Enter song title: ");
        String title = scanner.nextLine();
        System.out.print("Enter song artist: ");
        String artist = scanner.nextLine();
        System.out.print("Enter song length (mm:ss): ");
        String length = scanner.nextLine();

        try {
            // Creates a new Song object and return it
            Song newSong = new Song(title, artist, length);
            return newSong;
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating song: " + e.getMessage());
            return null;
        }
    }

    // Method to create a new playlist and optionally select it
    private static void createNewPlaylist(Scanner scanner) {
        System.out.print("Enter playlist title: ");
        String title = scanner.nextLine();
        playlists.add(new Playlist(title));
        System.out.println("Playlist created: " + title);
        System.out.print("Select this playlist? (y/n): ");
        String choice = scanner.nextLine();
        if (choice.toLowerCase().charAt(0) == 'y') {
            currentPlaylist = playlists.get(playlists.size() - 1);
        }
    }

    // Method to add a song to the currently selected playlist
    private static void addSongToPlaylist(Scanner scanner) {
        if (currentPlaylist == null) {
            System.out.println("No playlist selected. Please select a playlist first.");
            return;
        }

        System.out.println("Adding song to " + currentPlaylist.getTitle());

        // Create a new song and add it to the current playlist
        Song newSong = createNewSong(scanner);
        if (newSong != null) {
            currentPlaylist.add(newSong);
            System.out.println("Song added to playlist: " + newSong);
        }
    }

    // Method to remove a song from the currently selected playlist
    private static void removeSongFromPlaylist(Scanner scanner) {
        if (currentPlaylist == null) {
            System.out.println("No playlist selected. Please select a playlist first.");
            return;
        }

        System.out.print("Enter the index of the song to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Check if the entered index is valid
        if (index >= 0 && index < currentPlaylist.size()) {
            Song removedSong = currentPlaylist.get(index);
            currentPlaylist.remove(index);
            System.out.println("Removed song: " + removedSong);
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    // Method to show the currently selected playlist
    private static void showCurrentPlaylist() {
        if (currentPlaylist == null) {
            System.out.println("No playlist selected. Please select a playlist first.");
        } else {
            System.out.println(currentPlaylist);
        }
    }

    // Method to shuffle the songs in the currently selected playlist
    private static void shufflePlaylist() {
        if (currentPlaylist == null) {
            System.out.println("No playlist selected. Please select a playlist first.");
        } else {
            currentPlaylist.shuffle();
            System.out.println("Playlist shuffled.");
        }
    }

    // Method to sort the currently selected playlist by song title
    private static void sortPlaylistByTitle() {
        if (currentPlaylist == null) {
            System.out.println("No playlist selected. Please select a playlist first.");
        } else {
            currentPlaylist.sortByTitle();
            System.out.println("Playlist sorted by title.");
        }
    }

    // Method to sort the currently selected playlist by artist
    private static void sortPlaylistByArtist() {
        if (currentPlaylist == null) {
            System.out.println("No playlist selected. Please select a playlist first.");
        } else {
            currentPlaylist.sortByArtist();
            System.out.println("Playlist sorted by artist.");
        }
    }

    // Method to sort the currently selected playlist by song length
    private static void sortPlaylistByLength() {
        if (currentPlaylist == null) {
            System.out.println("No playlist selected. Please select a playlist first.");
        } else {
            currentPlaylist.sortByLength();
            System.out.println("Playlist sorted by length.");
        }
    }

    // Method to save the currently selected playlist to disk
    private static void savePlaylist() {
        if (currentPlaylist == null) {
            System.out.println("No playlist selected. Please select a playlist first.");
        } else {
            currentPlaylist.savePlaylist();
        }
    }
}
