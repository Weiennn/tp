package seedu.address.model.exceptions;

/**
 * Thrown when trying to {@code undo()} but can't.
 */
public class NoUndoableStateException extends RuntimeException {
    public NoUndoableStateException() {
        super("Current state pointer at start of addressBookState list, unable to undo.");
    }
}
