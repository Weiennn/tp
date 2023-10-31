package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import seedu.address.commons.core.increment.Increment;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Department;
import seedu.address.model.person.DepartmentContainsKeywordsPredicate;
import seedu.address.model.person.Email;
import seedu.address.model.person.EmailContainsKeywordsPredicate;
import seedu.address.model.person.Id;
import seedu.address.model.person.IdContainsKeywordsPredicate;
import seedu.address.model.person.Name;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.PhoneContainsKeywordsPredicate;
import seedu.address.model.person.Role;
import seedu.address.model.person.RoleContainsKeywordsPredicate;
import seedu.address.model.person.Salary;
import seedu.address.model.person.SalaryWithinRangePredicate;



/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";
    public static final String MESSAGE_INVALID_NUMBER = "Number is not a non-zero unsigned integer.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String id} into a {@code Id}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code id} is invalid.
     */
    public static Id parseId(String id) throws ParseException {
        requireNonNull(id);
        String trimmedId = id.trim();
        if (!Id.isValidId(trimmedId)) {
            throw new ParseException(Id.MESSAGE_CONSTRAINTS);
        }
        return new Id(trimmedId);
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String department} into a {@code Department}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code department} is invalid.
     */
    public static Department parseDepartment(String department) throws ParseException {
        requireNonNull(department);
        String trimmedDepartment = department.trim();
        if (!Department.isValidDepartment(trimmedDepartment)) {
            throw new ParseException(Department.MESSAGE_CONSTRAINTS);
        }
        return new Department(trimmedDepartment);
    }

    /**
     * Parses a {@code String role} into a {@code Role}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code role} is invalid.
     */
    public static Role parseRole(String role) throws ParseException {
        requireNonNull(role);
        String trimmedRole = role.trim();
        if (!Role.isValidRole(trimmedRole)) {
            throw new ParseException(Role.MESSAGE_CONSTRAINTS);
        }
        return new Role(trimmedRole);
    }

    /**
     * Parses a {@code String salary} into a {@code Salary}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code salary} is invalid.
     */
    public static Salary parseSalary(String salary) throws ParseException {
        requireNonNull(salary);
        String trimmedSalary = salary.trim();
        if (!Salary.isValidSalary(trimmedSalary)) {
            throw new ParseException(Salary.MESSAGE_CONSTRAINTS);
        }
        return new Salary(trimmedSalary);
    }

    /**
     * Checks a {@code String findArgs} is valid.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code findArgs} is invalid.
     */
    public static void checkFindArgs(String findArgs) throws ParseException {
        requireNonNull(findArgs);
        String trimmedFindArgs = findArgs.trim();
        if (trimmedFindArgs.contains("/")) {
            throw new ParseException(FindCommand.INVALID_FIND_ARGS_MESSAGE);
        }
        checkTrimmedArgsNotEmpty(trimmedFindArgs);
    }

    /**
     * Parses {@code String increment} into a {@code Increment}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code increment} is invalid.
     */
    public static Increment parseIncrement(String increment) throws ParseException {
        requireNonNull(increment);
        String trimmedIncrement = increment.trim();
        if (!Increment.isValidIncrement(trimmedIncrement)) {
            throw new ParseException(Increment.MESSAGE_CONSTRAINTS);
        }
        return new Increment(trimmedIncrement);
    }

    /**
     * Parses {@code String number} into an {@code int} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified number is invalid (not non-zero unsigned integer).
     */
    public static int parseHistory(String number) throws ParseException {
        String trimmedIndex = number.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_NUMBER);
        }
        return Integer.parseInt(trimmedIndex);
    }

    /**
     * Parses {@code String trimmedArgs} into an {@code IdContainsKeywordsPredicate} and adds it to
     * {@code ArrayList<Predicate<Person>> predicateList}. Leading and trailing whitespaces will be
     * trimmed.
     * @param predicateList contains {@code Predicate<Person>} that will be used to find employees that satisfy all the
     *                      predicates.
     * @param trimmedArgs keyword that is entered by the user.
     * @throws ParseException if trimmedArgs is empty or if it contains '/' char.
     */
    public static void parseIdKeyword(ArrayList<Predicate<Person>> predicateList,
                                String trimmedArgs) throws ParseException {
        checkFindArgs(trimmedArgs);
        predicateList.add(new IdContainsKeywordsPredicate(trimmedArgs));
    }

    /**
     * Parses {@code String trimmedArgs} into an {@code NameContainsKeywordsPredicate} and adds it to
     * {@code ArrayList<Predicate<Person>> predicateList}. Leading and trailing whitespaces will be
     * trimmed.
     * @param predicateList contains {@code Predicate<Person>} that will be used to find employees that satisfy all the
     *                      predicates.
     * @param trimmedArgs keyword that is entered by the user.
     * @throws ParseException if trimmedArgs is empty or if it contains '/' char.
     */
    public static void parseNameKeyword(ArrayList<Predicate<Person>> predicateList,
                                  String trimmedArgs) throws ParseException {
        checkFindArgs(trimmedArgs);
        String[] nameKeywords = trimmedArgs.split("\\s+");
        predicateList.add(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

    /**
     * Parses {@code String trimmedArgs} into an {@code RoleContainsKeywordsPredicate} and adds it to
     * {@code ArrayList<Predicate<Person>> predicateList}. Leading and trailing whitespaces will be
     * trimmed.
     * @param predicateList contains {@code Predicate<Person>} that will be used to find employees that satisfy all the
     *                      predicates.
     * @param trimmedArgs keyword that is entered by the user.
     * @throws ParseException if trimmedArgs is empty or if it contains '/' char.
     */
    public static void parseRoleKeyword(ArrayList<Predicate<Person>> predicateList,
                                  String trimmedArgs) throws ParseException {
        checkFindArgs(trimmedArgs);
        String[] roleKeywords = trimmedArgs.split("\\s+");
        predicateList.add(new RoleContainsKeywordsPredicate(Arrays.asList(roleKeywords)));
    }

    /**
     * Parses {@code String trimmedArgs} into an {@code DepartmentContainsKeywordsPredicate} and adds it to
     * {@code ArrayList<Predicate<Person>> predicateList}. Leading and trailing whitespaces will be
     * trimmed.
     * @param predicateList contains {@code Predicate<Person>} that will be used to find employees that satisfy all the
     *                      predicates.
     * @param trimmedArgs keyword that is entered by the user.
     * @throws ParseException if trimmedArgs is empty or if it contains '/' char.
     */
    public static void parseDepartmentKeyword(ArrayList<Predicate<Person>> predicateList,
                                        String trimmedArgs) throws ParseException {
        checkFindArgs(trimmedArgs);
        String[] departmentKeywords = trimmedArgs.split("\\s+");
        predicateList.add(new DepartmentContainsKeywordsPredicate(Arrays.asList(departmentKeywords)));
    }

    /**
     * Parses {@code String trimmedArgs} into an {@code EmailContainsKeywordsPredicate} and adds it to
     * {@code ArrayList<Predicate<Person>> predicateList}. Leading and trailing whitespaces will be
     * trimmed.
     * @param predicateList contains {@code Predicate<Person>} that will be used to find employees that satisfy all the
     *                      predicates.
     * @param trimmedArgs keyword that is entered by the user.
     * @throws ParseException if trimmedArgs is empty or if it contains '/' char.
     */
    public static void parseEmailKeyword(ArrayList<Predicate<Person>> predicateList,
                                   String trimmedArgs) throws ParseException {
        checkFindArgs(trimmedArgs);
        String[] emailKeywords = trimmedArgs.split("\\s+");
        predicateList.add(new EmailContainsKeywordsPredicate(Arrays.asList(emailKeywords)));
    }

    /**
     * Parses {@code String trimmedArgs} into an {@code SalaryWithinRangePredicate} and adds it to
     * {@code ArrayList<Predicate<Person>> predicateList}. Leading and trailing whitespaces will be
     * trimmed.
     * @param predicateList contains {@code Predicate<Person>} that will be used to find employees that satisfy all the
     *                      predicates.
     * @param trimmedArgs keyword that is entered by the user.
     * @throws ParseException if trimmedArgs is empty or if it contains '/' char.
     */
    public static void parseSalaryKeyword(ArrayList<Predicate<Person>> predicateList,
                                    String trimmedArgs) throws ParseException {
        checkFindArgs(trimmedArgs);
        if (!isValidFindSalaryArgs(trimmedArgs)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }
        double lowerBound = findLowerBound(trimmedArgs);
        double upperBound = findUpperBound(trimmedArgs);
        predicateList.add(new SalaryWithinRangePredicate(lowerBound, upperBound));
    }

    /**
     * Parses {@code String trimmedArgs} into an {@code PhoneContainsKeywordsPredicate} and adds it to
     * {@code ArrayList<Predicate<Person>> predicateList}. Leading and trailing whitespaces will be
     * trimmed.
     * @param predicateList contains {@code Predicate<Person>} that will be used to find employees that satisfy all the
     *                      predicates.
     * @param trimmedArgs keyword that is entered by the user.
     * @throws ParseException if trimmedArgs is empty or if it contains '/' char.
     */
    public static void parsePhoneKeyword(ArrayList<Predicate<Person>> predicateList,
                                   String trimmedArgs) throws ParseException {
        checkFindArgs(trimmedArgs);
        predicateList.add(new PhoneContainsKeywordsPredicate(trimmedArgs));
    }

    /**
     * Checks whether salary arguments are valid. If the argument is not in the format of "400 - 5000" for example,
     * it will return false. If the user enters a number greater than can be assigned to a long or if user inputs number
     * greater than the maximum allowed salary, it will also return false.
     * @param salaryArgs user input for find command with PREFIX_SALARY.
     * @return true if argument is valid and false otherwise.
     */
    private static boolean isValidFindSalaryArgs(String salaryArgs) {
        String validationRegex = "^\\d+\\s-\\s\\d+$";
        if (!salaryArgs.matches(validationRegex)) {
            return false;
        }
        String upperBound = salaryArgs.split(" - ", 2)[1];
        String lowerBound = salaryArgs.split(" - ", 2)[0];
        double upperBoundDouble = Double.parseDouble(upperBound);
        double lowerBoundDouble = Double.parseDouble(lowerBound);
        if (upperBoundDouble > Salary.MAXIMUM_SALARY || lowerBoundDouble > upperBoundDouble) {
            return false;
        }
        return true;
    }

    private static double findLowerBound(String salaryArgs) {
        return Double.parseDouble(salaryArgs.split(" - ", 2)[0]);
    }

    private static double findUpperBound(String salaryArgs) {
        return Double.parseDouble(salaryArgs.split(" - ", 2)[1]);
    }

    private static void checkTrimmedArgsNotEmpty(String trimmedArgs) throws ParseException {
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
        }
    }

}
