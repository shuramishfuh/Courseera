module Telegrambot.Container {
    requires Formatter.Implementation;
    requires telegrambots;
    requires telegrambots.meta;
    exports Mybot;
}