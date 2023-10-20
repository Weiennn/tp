package seedu.address.model.person;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code Salary} is within the range given.
 */
public class SalaryWithinRangePredicate implements Predicate<Person> {
    private final int lowerBound;
    private final int upperBound;

    /**
     * Constructor method that takes in a lowerBound and an upperBound for the range
     */
    public SalaryWithinRangePredicate(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean test(Person person) {
        if (person.getSalary().value == null) {
            return false;
        }
        int key = Integer.parseInt(person.getSalary().value);
        return (key >= lowerBound) && (key <= upperBound);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SalaryWithinRangePredicate)) {
            return false;
        }

        SalaryWithinRangePredicate otherSalaryWithinRangePredicate = (SalaryWithinRangePredicate) other;
        return (lowerBound == otherSalaryWithinRangePredicate.lowerBound)
                && (upperBound == otherSalaryWithinRangePredicate.upperBound);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("lowerBound", lowerBound)
                .add("upperBound", upperBound).toString();
    }
}
