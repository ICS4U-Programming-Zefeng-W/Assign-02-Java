/*
 * This program reads a string and returns the length of the longest
 * sequence of successive numbers/characters within the string. 
 *
 * 
 * @author Zefeng Wang
 * @since 2021-12-14
 * */

// Import Modules
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// class StringStuff
class StringStuff {
  public static void main(String[] args) throws IOException {
    List<String> lines = Collections.emptyList();
   
    // Reads each line of the file and stores it into an array
    lines = Files.readAllLines(Paths.get("input.txt"),
                               StandardCharsets.UTF_8);
    Iterator<String> itr = lines.iterator();
    List<String> list = new ArrayList<String>();
    for (int i = 0; itr.hasNext(); i++) {
      list.add(itr.next());
    }

    // Write the output to a file
    FileWriter writer = new FileWriter("output.txt");

    for (String input : list) { 
      writer.write(maxRun(input) + "\n");
    }
    writer.close();
  }

  private static int maxRun(String str) {
    int maxCount = 0;
    int count = 1;
    char[] array = str.toCharArray();
    
    // Finds and returns the longest run in the string
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] == array[i + 1]) {
        count++;
      } else {
        count = 1;
      }
      if (count > maxCount) {
        maxCount = count;
      }
    }
    return maxCount;
  }
}
