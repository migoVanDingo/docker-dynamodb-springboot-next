package com.watcher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.function.Consumer;

public class FileWatcher {

    public static void main(String[] args) throws IOException, InterruptedException {

        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("/Users/migo/Developer/environments/dev-env-1/backend/src");
        Path path1 = Paths.get("/Users/migo/Developer/environments/dev-env-1/backend/src/main/java/com/dbtest");
        Path path2 = Paths.get("/Users/migo/Developer/environments/dev-env-1/backend/src/main/java/com/dbtest/config");
        Path path3 = Paths.get("/Users/migo/Developer/environments/dev-env-1/backend/src/main/java/com/dbtest/controller");
        Path path4 = Paths.get("/Users/migo/Developer/environments/dev-env-1/backend/src/main/java/com/dbtest/entity");
        Path path5 = Paths.get("/Users/migo/Developer/environments/dev-env-1/backend/src/main/java/com/dbtest/repository");
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        path1.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        path2.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        path3.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        path4.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);
        path5.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;

        while ((key = watchService.take()) != null) {

            
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println("event kind: " + event.kind() + " -- File: " + event.context());

                File dir = new File("/Users/migo/Developer/environments/dev-env-1/fileWatcher/src/com/watcher");
                String cmd = "./myScript.sh";
                Process process = Runtime.getRuntime().exec(cmd, null, dir);

                BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

                BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

                // Read the output from the command
                System.out.println("Here is the standard output of the command:\n");
                String s = null;
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                }

                // Read any errors from the attempted command
                System.out.println("Here is the standard error of the command (if any):\n");
                while ((s = stdError.readLine()) != null) {
                    System.out.println(s);
                }

            
                process.destroy();
            }
           
            key.reset();
        }
        
        System.out.println("end end");
    }

    public static void printResults(Process process) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        writer.write(process.toString());
    }
}
