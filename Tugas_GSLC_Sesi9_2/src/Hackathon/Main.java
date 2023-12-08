package Hackathon;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Models.Team;
import Models.User;
import Repository.TeamRepository;
import Repository.UserRepository;

public class Main {
 public static void main(String[] args) {
     Connection userConnection = new Connection("user.csv");
     Connection teamConnection = new Connection("teams.csv");

     CSVFacade userFacade = new CSVFacade(userConnection);
     CSVFacade teamFacade = new CSVFacade(teamConnection);

     User user = new User(userFacade);
     Team team = new Team(teamFacade);

     UserRepository userRepository = new UserRepository(user);
     TeamRepository teamRepository = new TeamRepository(team);

     Scanner scanner = new Scanner(System.in);

     // Menu Utama
     while (true) {
         System.out.println("1. Menu Utama");
         System.out.println("2. Insert Data");
         System.out.println("3. Show");
         System.out.println("4. Exit");

         System.out.print("Pilih menu: ");
         int menuChoice = scanner.nextInt();
         scanner.nextLine(); // Membersihkan buffer

         switch (menuChoice) {
             case 1:
                 // Implementasi menu utama
                 break;
             case 2:
                 // Implementasi menu insert data
                 System.out.println("Which table to insert? 1. User, 2. Team.");
                 int tableChoice = scanner.nextInt();
                 scanner.nextLine(); // Membersihkan buffer

                 if (tableChoice == 1) {
                     System.out.print("add name: ");
                     String name = scanner.nextLine();
                     System.out.print("add nim: ");
                     String nim = scanner.nextLine();
                     System.out.print("add team: ");
                     String teamName = scanner.nextLine();

                     String[] userData = {name, nim, teamName};
                     userRepository.insert(userData);
                 } else if (tableChoice == 2) {
                     System.out.print("add team name: ");
                     String teamName = scanner.nextLine();

                     String[] teamData = {teamName};
                     teamRepository.insert(teamData);
                 } else {
                     System.out.println("Invalid choice");
                 }
                 break;
             case 3:
                 // Implementasi menu show
                 System.out.println("Which table to show? 1. User, 2. Team.");
                 int showChoice = scanner.nextInt();
                 scanner.nextLine(); // Membersihkan buffer

                 if (showChoice == 1 || showChoice == 2) {
                     System.out.print("Want to filter by condition? 1. Yes, 2. No. ");
                     int filterChoice = scanner.nextInt();
                     scanner.nextLine(); // Membersihkan buffer

                     if (filterChoice == 1) {
                         System.out.print("add condition, separate by semicolon: ");
                         String conditionInput = scanner.nextLine();
                         String[] conditions = conditionInput.split(";");
                         ArrayList<String[]> result;

                         if (showChoice == 1) {
                             result = userRepository.find(null, conditions, false, null);
                         } else {
                             result = teamRepository.find(null, conditions, false, null);
                         }

                         // Tampilkan hasil query
                         System.out.println("Query result:");
                         for (String[] row : result) {
                             System.out.println(Arrays.toString(row));
                         }
                     } else if (filterChoice == 2) {
                         ArrayList<String[]> result;

                         if (showChoice == 1) {
                             result = userRepository.find(null, null, false, null);
                         } else {
                             result = teamRepository.find(null, null, false, null);
                         }

                         // Tampilkan semua data
                         System.out.println("All data:");
                         for (String[] row : result) {
                             System.out.println(Arrays.toString(row));
                         }
                     } else {
                         System.out.println("Invalid choice");
                     }
                 } else {
                     System.out.println("Invalid choice");
                 }
                 break;
             case 4:
                 System.out.println("Exiting program.");
                 System.exit(0);
             default:
                 System.out.println("Invalid choice");
                 break;
         }
     }
 }
}
