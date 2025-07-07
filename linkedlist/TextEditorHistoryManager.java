package linkedlist;
class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
    }
}

class TextEditor {
    private TextState head, tail, current;
    private int size = 0;
    private final int MAX_SIZE = 10;

    public void addState(String content) {
        TextState newState = new TextState(content);
        if (current != null && current.next != null) {
            current.next = null;
            tail = current;
        }
        if (head == null) {
            head = tail = current = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
        }
        size++;
        if (size > MAX_SIZE) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void displayCurrent() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        }
    }
}

public class TextEditorHistoryManager {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrent();
        editor.undo();
        editor.displayCurrent();
        editor.redo();
        editor.displayCurrent();
    }
}
