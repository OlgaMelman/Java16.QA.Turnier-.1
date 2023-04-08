package ru.netology;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String playerName) {
        super("This player:" + playerName + " not registered");
    }
}
