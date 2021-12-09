import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static StringBuilder log = new StringBuilder();

    public static void main(String[] args) {
        File dirGames = new File("Games");
        if (dirGames.exists()) {
            File dirSrc = new File("Games/src");
            createNewDir(dirSrc);

            if (dirSrc.exists()) {
                File dirSrcMain = new File("Games/src/main");
                createNewDir(dirSrcMain);

                if (dirSrcMain.exists()) {
                    File fileSrcMainMain = new File("Games/src/main/Main.java");
                    createNewFile(fileSrcMainMain);

                    File fileSrcMainUtils = new File("Games/src/main/Utils.java");
                    createNewFile(fileSrcMainUtils);
                }

                File dirSrcTest = new File("Games/src/test");
                createNewDir(dirSrcTest);
            }

            File dirRes = new File("Games/res");
            createNewDir(dirRes);

            if (dirRes.exists()) {
                File dirResDrawables = new File("Games/res/drawables");
                createNewDir(dirResDrawables);

                File dirResVectors = new File("Games/res/vectors");
                createNewDir(dirResVectors);

                File dirResIcons = new File("Games/res/icons");
                createNewDir(dirResIcons);
            }

            File dirSavegames = new File("Games/savegames");
            createNewDir(dirSavegames);

            File dirTemp = new File("Games/temp");
            createNewDir(dirTemp);

            File fileTempTemp = new File("Games/temp/temp.txt");
            if (dirTemp.exists()) {
                createNewFile(fileTempTemp);
            }

            if (fileTempTemp.exists()) {
                try (FileWriter writer = new FileWriter(fileTempTemp, false)) {
                    writer.write(log.toString());
                    writer.flush();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println(log);
            }
        } else {
            System.out.println("Директория Games не найдена");
        }
    }

    private static void createNewDir(File dir) {
        if (dir.mkdir()) {
            log.append("Директория " + dir.getPath() + " была создана");
        } else if (dir.exists()) {
            log.append("Директория " + dir.getPath() + " уже существует");
        } else {
            log.append("Не удалось создать директорию " + dir.getPath());
        }
        log.append("\n");
    }

    private static void createNewFile(File file) {
        try {
            if (file.createNewFile())
                log.append("Файл " + file.getPath() + " был создан");
            else
                log.append("Файл " + file.getPath() + " уже существует");
        } catch (IOException e) {
            log.append("Не удалось создать файл " + file.getPath() + ". " + e.getMessage());
        }
        log.append("\n");
    }
}
