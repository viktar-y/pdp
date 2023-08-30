package pages;

import core.Browser;
import core.elements.DragAndDropElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;


public class DragDropPage extends BasePage {
    private final DragAndDropElement leftColumn = new DragAndDropElement(By.cssSelector(("#column-a")), "Column A");
    private final DragAndDropElement rightColumn = new DragAndDropElement(By.cssSelector(("#column-b")), "Column B");
    private final DragAndDropElement leftColumnReverted = new DragAndDropElement(By.xpath("//div[@id = 'column-a'][header = 'B']"), "Column B Reverted");
    private final DragAndDropElement rightColumnReverted = new DragAndDropElement(By.xpath("//div[@id = 'column-b'][header = 'A']"), "Column A Reverted");

    public DragDropPage() {
        super(By.xpath("//*[text() = 'Drag and Drop']"), "Drag and Drop");
    }

    public void makeLeftElementDragAndDropToRight() {
        leftColumn.performDragAndDrop(rightColumn.getElement());
    }

    public RemoteWebElement getLeftColumnReverted() {
        return leftColumnReverted.getElement();
    }

    public RemoteWebElement getRightColumnReverted() {
        return rightColumnReverted.getElement();
    }

}