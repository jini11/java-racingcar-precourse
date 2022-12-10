package racingcar.model;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (validateType(name)) {
            throw new IllegalArgumentException("[ERROR]");
        }
        if (validateLength(name)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private boolean validateType(String name) {
        return name.matches("^[a-z]$");
    }

    private boolean validateLength(String name) {
        return name.length() > 5;
    }
}
