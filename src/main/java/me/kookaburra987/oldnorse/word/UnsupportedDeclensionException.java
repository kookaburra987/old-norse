package me.kookaburra987.oldnorse.word;

/**
 * Exception to indicate that the old-norse library does not support the requested declension.
 * The declension itself is valid and exists in the language. But the current version of the library
 * can not handle it yet.
 *
 * This exception is a checked exception. Users of the old-norse library must prevent the exception or
 * handle it in a proper way.
 */
public class UnsupportedDeclensionException extends Exception {
    public UnsupportedDeclensionException(String message) {
        super(message);
    }
}
