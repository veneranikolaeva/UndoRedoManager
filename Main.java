public class Main {
    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        manager.addState("State 1");
        manager.addState("State 2");
        manager.addState("State 3");
        System.out.println("Current: " + manager.getCurrent());

        System.out.println("Undo: " + manager.undo());
        System.out.println("Current: " + manager.getCurrent());
        System.out.println("Undo: " + manager.undo());
        System.out.println("Current: " + manager.getCurrent());

        System.out.println("Undo at start: " + manager.undo());
        System.out.println("Current: " + manager.getCurrent());

        System.out.println("Redo: " + manager.redo());
        System.out.println("Current: " + manager.getCurrent());

        System.out.println("Redo: " + manager.redo());
    }
}