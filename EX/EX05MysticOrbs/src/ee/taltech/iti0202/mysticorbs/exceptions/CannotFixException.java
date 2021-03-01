package ee.taltech.iti0202.mysticorbs.exceptions;

import ee.taltech.iti0202.mysticorbs.oven.Oven;

public class CannotFixException extends Throwable {
    private Oven oven;
    private Reason reason;

    public enum Reason {
        IS_NOT_BROKEN,
        FIXED_MAXIMUM_TIMES,
        NOT_ENOUGH_RESOURCES
    }

    /**
     * @param oven   .
     * @param reason .
     */
    public CannotFixException(Oven oven, Reason reason) {
        this.oven = oven;
        this.reason = reason;

    }

    /**
     * @return .
     */
    public Oven getOven() {
        return this.oven;
    }

    /**
     * @return .
     */
    public Reason getReason() {
        return this.reason;
    }
}
