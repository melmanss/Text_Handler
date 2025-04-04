package app;

import java.io.IOException; // Исключение, которое выбрасывается при возникновении ошибок ввода-вывода.
import java.nio.file.FileAlreadyExistsException; //Исключение, которое выбрасывается, если файл уже существует.
import java.nio.file.Files; //Класс, предоставляющий утилиты для работы с файлами.
import java.nio.file.Path; // Класс, представляющий путь к файлу или директории.

import static java.nio.file.Files.readString; //Статический импорт метода readString, который считывает содержимое файла в строку.

public class FileHandler {

    public String createFile(String path) {
        Path newFile;
        try {
            newFile = Files.createFile(Path.of(path));
        } catch (FileAlreadyExistsException e) {
            return "File already exists!";
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
        return "Created " + newFile;
    }

    public String writeToFile(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            return e.getMessage();
        }
        return "Recorded in " + path;
    }

    public String readFromFile(String path) {
        try {
            return readString(Path.of(path));
        } catch (IOException e) {
            return "Something went wrong: " + e.getMessage();
        }
    }
}
