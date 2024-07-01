package me.kookaburra987.oldnorse;

import lombok.Getter;

/**
 * The Number can be Singular (SG) or Plural (PL) or Dual.
 * Plural and Dual indicate the presence of multiple objects/persons.
 * Dual means that its exactly 2.
 */
@Getter
public enum Number {
    SG(false),
    PL(true),
    DUAL(true);

    boolean multiple;

    Number(boolean multiple) {
        this.multiple = multiple;
    }
}
