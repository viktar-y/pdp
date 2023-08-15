import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDropLeftColumnOnRightTest() {
        mainPage.openDragAndDropPage();
        dragDropPage.makeLeftElementDragAndDropToRight();
        Assertions.assertTrue(dragDropPage.getLeftColumnReverted().isEnabled());
        Assertions.assertTrue(dragDropPage.getRightColumnReverted().isEnabled());
    }
}
