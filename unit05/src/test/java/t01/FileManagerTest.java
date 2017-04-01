package t01;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static t01.FileManager.ALL;
import static t01.FileManager.DIRS;
import static t01.FileManager.FILES;

/**
 * Created by Katerina on 28.03.2017.
 */
public class FileManagerTest {

    private FileManager fileManager = new FileManager();

    @Test
    public void testThatUserCanSeeListOfOnlyDirs() {
        FileManager fileManager = new FileManager();
        List<String> dirsList = fileManager.getRequiredList("./", DIRS);
        assertThat(dirsList.contains("src"), is(true));
    }

    @Test
    public void testThatUserCanSeeListOfOnlyFiles() {
        List<String> filesList = fileManager.getRequiredList("./", FILES);
        assertThat(filesList.contains("pom.xml"), is(true));
    }

    @Test
    public void testThatWeCanGoToTheDirectory() {
        fileManager.goToDirectory("src");
        assertTrue(fileManager.currentPath.contains("src"));
    }

    @Test
    public void testThatWeCantTakeFileAsDirectory() {
        fileManager.goToDirectory("src");
        fileManager.goToDirectory("file.d");
        assertFalse(fileManager.currentPath.contains("file.d"));
    }

    @Test
    public void testThatWeCantGoToNonExistingDirectory() {
        fileManager.goToDirectory("java");
        assertFalse(fileManager.currentPath.contains("java"));
    }

    @Test
    public void testThatWeCanGoToTheParentDirectory() {
        fileManager.goToDirectory("src");
        fileManager.goUp();
        assertFalse(fileManager.currentPath.contains("src"));
    }

    @Test
    public void testThatWeCanCreateTextFile() {
        fileManager.goToDirectory("src");
        fileManager.goToDirectory("resource");
        fileManager.create("newFile.txt");
        assertFalse(fileManager.getRequiredList("./", ALL).contains("newFile.txt"));
    }

    @Test
    public void testThatWeCantCreateExistingFile() {
        fileManager.goToDirectory("src");
        fileManager.goToDirectory("resource");
        int result = fileManager.create("newFile.txt");
        assertThat(result, is(1));
    }

    @Test
    public void testThatWeCantCreateAnotherFile() {
        fileManager.goToDirectory("src");
        fileManager.create("newFile.tsx");
        assertFalse(fileManager.getRequiredList("./", ALL).contains("newFile.tsx"));
    }

    @Test
    public void testThatWeCanDeleteTextFile() {
        fileManager.goToDirectory("src");
        fileManager.goToDirectory("resource");
        fileManager.delete("newFile.txt");
        assertFalse(fileManager.getRequiredList("./", ALL).contains("newFile.txt"));
    }

    @Test
    public void testThatWeCantDeleteNonExistingFile() {
        fileManager.goToDirectory("src");
        fileManager.delete("newFile.tsx");
        assertFalse(fileManager.getRequiredList("./", ALL).contains("newFile.tsx"));
    }

    @Test
    public void testThatWeCantDeleteNonTextFile() {
        fileManager.goToDirectory("src");
        fileManager.delete("file.d");
        assertFalse(fileManager.getRequiredList("./", ALL).contains("newFile.tsx"));
    }

    @Test
    public void testThatWeCanModifyTextFiles() {
        String myText = "Hello! This is text for file modifying.";
        fileManager.goToDirectory("src");
        int result = fileManager.write("newFile.txt", myText,true);
        assertThat(result, is(0));
    }

    @Test
    public void testThatWeCantModifyNonTextFiles() {
        String myText = "Hello! This is text for file modifying";
        fileManager.goToDirectory("src");
        int result = fileManager.write("file.d", myText,true);
        assertThat(result, is(1));
    }

    @Test
    public void testThatWeCantModifyNonExistingFiles() {
        String myText = "Hello! This is text for file modifying";
        fileManager.goToDirectory("src");
        int result = fileManager.write("file.txt", myText,true);
        assertThat(result, is(1));
    }

    @Test
    public void testThatWeCanReadTextFiles() {
        fileManager.goToDirectory("src");
        int result = fileManager.read("newFile.txt");
        assertThat(result, is(0));
    }

    @Test
    public void testThatWeCantReadNonTextFiles() {
        fileManager.goToDirectory("src");
        int result = fileManager.read("file.d");
        assertThat(result, is(1));
    }

    @Test
    public void testThatWeCantReadNonExistingFiles() {
        fileManager.goToDirectory("src");
        int result = fileManager.read("file.txt");
        assertThat(result, is(1));
    }


}