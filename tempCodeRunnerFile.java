import java.util.Scanner;
import javax.swing.*;

public class SongTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many favorite songs do you want to track? (max 5, 0 to exit): ");
        int songs = sc.nextInt();
        if (songs == 0) return;
        if (songs > 5) songs = 5;

        System.out.print("How many days do you want to log play counts? (max 5): ");
        int days = sc.nextInt();
        if (days <= 0 || days > 5) days = 5;

        int[][] playCounts = new int[songs][days];

        for (int i = 0; i < songs; i++) {
            for (int j = 0; j < days; j++) {
                String val = JOptionPane.showInputDialog(null,"Enter play count for Song " + (i+1) + " Day " + (j+1) + ":");
                playCounts[i][j] = Integer.parseInt(val);
            }
        }

        String output = "Song Play Summary:\n\n";
        for (int i = 0; i < songs; i++) {
            int total = 0;
            for (int j = 0; j < days; j++) total += playCounts[i][j];
            double avg = (double) total / days;
            output += "Song " + (i+1) + ": Total = " + total + ", Average = " + String.format("%.2f", avg) + "\n";
            if (total >= 50) output += " → Frequently Played\n\n";
            else output += " → Occasionally Played\n\n";
        }

        JOptionPane.showMessageDialog(null, output);
    }
}