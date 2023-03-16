import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FilesOperations {


    public static File getLatestFilefromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        System.out.println(lastModifiedFile);
        return lastModifiedFile;
    }

    public static boolean moveRenameFile(String sourcePath, String targetPath) {

        boolean fileMoved = true;

        try {
            final File myFile = new File(sourcePath);
            if (myFile.renameTo(new File(targetPath + myFile.getName()))) {
                System.out.println("File is moved successful!");
            } else {
                System.out.println("File is failed to move!");
                fileMoved = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileMoved;
    }

    public static boolean deleteFile(String sourcePath) {
        boolean fileDel = true;

        try {
            final File myFile = new File(sourcePath);
            if (myFile.delete()) {
                System.out.println("File is deleted successful!");
            } else {
                System.out.println("File is failed to deleted!");
                fileDel = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileDel;
    }

    public static void readFirstLine(String dirPath){
        BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(dirPath));
			String line = reader.readLine();

			if(line != null) {
				System.out.println(line);
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
