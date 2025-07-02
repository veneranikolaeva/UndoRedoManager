public class Main {
    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        // Add some states
        manager.addState("State 1");
        manager.addState("State 2");
        manager.addState("State 3");
        System.out.println("Current: " + manager.getCurrent()); // Expect "State 3"

        // Undo twice
        System.out.println("Undo: " + manager.undo()); // Expect "State 2"
        System.out.println("Current: " + manager.getCurrent()); // Expect "State 2"
        System.out.println("Undo: " + manager.undo()); // Expect "State 1"
        System.out.println("Current: " + manager.getCurrent()); // Expect "State 1"

        // Boundary: undo beyond start
        System.out.println("Undo at start: " + manager.undo()); // null
        System.out.println("Current: " + manager.getCurrent()); // Expect "State 1"

        // Redo once
        System.out.println("Redo: " + manager.redo()); // Expect "State 2"
        System.out.println("Current: " + manager.getCurrent()); // Expect "State 2"

        // Redo again
        System.out.println("Redo: " + manager.redo()); //
    }
}