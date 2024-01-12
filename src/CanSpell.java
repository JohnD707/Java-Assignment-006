import java.util.Scanner;

public class CanSpell {
    public static boolean canSpell(String tiles, String word) {
        if (tiles == null || word == null) {
            return false;
        }

        tiles = tiles.toLowerCase();
        word = word.toLowerCase();

        int[] tileCounts = new int[26];
        for (char tile : tiles.toCharArray()) {
            tileCounts[tile - 'a']++;
        }

        for (char letter : word.toCharArray()) {
            if (tileCounts[letter - 'a'] <= 0) {
                return false;
            }
            tileCounts[letter - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the tiles: ");
        String tiles = scanner.nextLine().trim();

        System.out.print("Enter the word: ");
        String word = scanner.nextLine().trim();

        scanner.close();

        if (canSpell(tiles, word)) {
            System.out.println("The word can be spelled using the given tiles.");
        } else {
            System.out.println("The word cannot be spelled using the given tiles.");
        }
    }
}