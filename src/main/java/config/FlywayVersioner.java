package config;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlywayVersioner {

    private static String PREFIX_VERSION = "V";
    private static String PATH_TO_FIND = "src/main/resources/db/migration/";
    private static String VALIDATED_SYMBOL = "__";
    private static String DATE_PATTERN = "yyyyMMddHHmmssSSS";

    public static void main(String[] args) {
        List<Path> pathsFound = getFolderList();
        List<Path> pathsToVersion = filterPathsValidated(pathsFound);
        renameFiles(pathsToVersion);
    }


    private static void renameFiles(List<Path> paths) {
        paths.stream().forEach(path -> path.toFile().renameTo(new File(buildFileNewNameFullPath(path))));
    }

    private static String buildFileNewNameFullPath(Path path) {
        return PATH_TO_FIND + buildFileNewName(path);
    }

    private static String buildFileNewName(Path path) {
        return PREFIX_VERSION +
                DateTimeFormatter.ofPattern(DATE_PATTERN).format(getCreatedAtFromFile(path)) +
                VALIDATED_SYMBOL + path.toFile().getName();
    }

    private static ZonedDateTime getCreatedAtFromFile(Path path) {
        ZonedDateTime zonedDateTime = null;
        try {
            zonedDateTime = ZonedDateTime.ofInstant(Files.readAttributes(path, BasicFileAttributes.class).creationTime().toInstant(), ZoneId.systemDefault());
        } catch (Exception e) {
            System.out.println(e);
        }
        return zonedDateTime;
    }

    private static List<Path> filterPathsValidated(List<Path> paths) {
       return paths.stream().filter(path -> !path.toString().contains(VALIDATED_SYMBOL)).collect(Collectors.toList());
    }

    private static List<Path> getFolderList() {
        List<Path> filePaths = new ArrayList<>();
        try {
            filePaths = Files.list(getMigrationDir()).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e);
        }
        return filePaths;
    }

    private static Path getMigrationDir() {
        return Paths.get(PATH_TO_FIND);
    }
}
