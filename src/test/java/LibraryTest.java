import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class LibraryTest {

    @Test
    public void testSomeLibraryMethod() throws IOException, InterruptedException {
        List<String> commandParts = new ArrayList<String>();
        commandParts.add(getExecutable().getCanonicalPath());
        commandParts.add("--version");

//        String[] command = {"CMD", "/C", "dir"};
        ProcessBuilder processBuilder = new ProcessBuilder(commandParts)
                .directory(getExecutable().getParentFile());
        processBuilder.environment().put("LD_LIBRARY_PATH",
                getExecutable().getParentFile().getCanonicalPath());

        Process process = processBuilder.start();

        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
//        System.out.printf("Output of running %s is:\n",
//                Arrays.toString(command));
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        //Wait to get exit value
        int exitValue = process.waitFor();
        boolean success = exitValue == 0;
        System.out.println("\n\nExecution success: " + success);

    }

    private File getExecutable() throws FileNotFoundException {
        final String location = "src/main/resources/native/" + getOS() + "/solc/";
        final Scanner scanner = new Scanner(new FileInputStream(location + "file.list"));
        while (scanner.hasNext()) {
            String s = scanner.next();
            File targetFile = new File(location + s);
            targetFile.setExecutable(true);
            return targetFile;
        }
        throw new RuntimeException("No file found at " + location);
    }

    private String getOS() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return "win";
        } else if (osName.contains("linux")) {
            return "linux";
        } else if (osName.contains("mac")) {
            return "mac";
        } else {
            throw new RuntimeException("Can't find solc compiler: unrecognized OS: " + osName);
        }
    }
}
