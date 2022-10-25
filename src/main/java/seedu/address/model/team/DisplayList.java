package seedu.address.model.team;

import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class DisplayList<T> {
    private final FilteredList<T> filtered;

    private final ObservableList<T> displayed;

    private ObservableList<? extends T> source;

    private ListChangeListener<T> listener;

    /**
     * Constructs a {@code DisplayList} that uses {@code toDisplay} as it source.
     */
    public DisplayList(ObservableList<? extends T> toDisplay) {
        source = toDisplay;
        displayed = FXCollections.observableArrayList(toDisplay);
        filtered = new FilteredList<>(displayed);

        listener = change -> displayed.setAll(source);
        source.addListener(listener);
    }

    /**
     * Filters the with the given {@code Predicate}.
     *
     * @throws ClassCastException if the predicate incorrectly casts the displayed elements.
     */
    public void setPredicate(Predicate<T> predicate) throws ClassCastException {
        filtered.setPredicate(predicate);
    }

    /**
     * Returns the filtered list of displayables to be displayed.
     */
    public FilteredList<T> getFilteredDisplayList() {
        return filtered;
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof DisplayList)) {
            return false;
        }

        // state check
        DisplayList other = (DisplayList) obj;
        return source.equals(other.source)
                && displayed.equals(other.displayed)
                && filtered.equals(other.filtered);
    }
}
