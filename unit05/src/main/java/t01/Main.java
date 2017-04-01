package t01;

import java.io.IOException;
import java.util.Scanner;

import static t01.FileManager.ALL;

public class Main {
    private static void commandList() {
        System.out.println("cd <directory>- Change directory");
        System.out.println("dir - List of files and directories");
        System.out.println("create <filename> - Create a new file");
        System.out.println("delete <filename> - Delete file");
        System.out.println("read <filename> - Read text from file");
        System.out.println("write <filename> <false/true> - Set false to rewrite file, true - to write text to existing data. " +
                        "Default - true. Press 'Enter' and set text for append");
        System.out.println("exit - Exit from program");
    }

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        commandList();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please, enter the command: ");
            String command = scanner.nextLine();
            String[] lexemes = command.split(" ");
            if (command.equals("dir")) {
                for (String file :fileManager.getRequiredList(fileManager.currentPath, ALL)){
                    System.out.println(file);
                }
            } else {
                switch (lexemes[0].toLowerCase()) {
                    case "cd":
                        fileManager.goToDirectory(lexemes[1]);
                        System.out.println("Directory was changed to "+ fileManager.currentPath);
                        break;

                    case "create":
                        fileManager.create(lexemes[1]);
                        break;

                    case "delete":
                        fileManager.delete(lexemes[1]);
                        break;
                    case "read":
                        fileManager.read(lexemes[1]);
                        break;

                    case "write":
                        if (lexemes.length >3)
                            break;
                        else {
                            boolean flag = true;
                            switch (lexemes[2].toLowerCase()) {
                                case "true":
                                    flag = true;
                                    break;
                                case "false":
                                    flag = false;
                                    break;
                            }
                            String text = scanner.nextLine();
                            fileManager.write(lexemes[1], text, flag);
                        }
                        break;
                    case "quite":
                        System.exit(0);
                        break;
                }
            }
        }
    }
}

