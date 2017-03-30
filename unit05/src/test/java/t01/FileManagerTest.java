package t01;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static t01.FileManager.DIRS;
import static t01.FileManager.FILES;

/**
 * Created by Katerina on 28.03.2017.
 */
public class FileManagerTest {

    private FileManager fileManager  =new FileManager();

    @Test
    public void testThatUserCanSeeListOfOnlyDirs(){
        FileManager fileManager = new FileManager();
        List<String> dirsList = fileManager.getRequiredList("./",DIRS);
        assertThat(dirsList.contains("src"), is(true));
    }

    @Test
    public void testThatUserCanSeeListOfOnlyFiles(){
        List<String> filesList = fileManager.getRequiredList("./", FILES);
        assertThat(filesList.contains("pom.xml"), is(true));
    }

    @Test
    public void testThatWeCanGoToTheDirectory(){
        fileManager.goToDirectory("src");
        assertTrue(fileManager.currentPath.contains("src"));
    }

    @Test
    public void testThatWeCanGoToTheParentDirectory(){
        fileManager.goUp();
        assertTrue(fileManager.currentPath.contains("src"));
    }

}