package ee.taltech.iti0202.mysticorbs.exceptions;

import ee.taltech.iti0202.mysticorbs.oven.Oven;

public class CannotFixException extends Exception {
    public Oven oven;
    public Reason reason;

    public enum Reason {
        IS_NOT_BROKEN,
        FIXED_MAXIMUM_TIMES,
        NOT_ENOUGH_RESOURCES
    }

    public CannotFixException(Oven oven, Reason reason) {
        this.oven = oven;
        this.reason = reason;

    }

    public Oven getOven() {
        return this.oven;
    }

    public Reason getReason() {
        return this.reason;
    }
}
