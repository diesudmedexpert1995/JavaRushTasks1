package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client{
    @Override
    protected String getUserName() {
        return "date_bot_" + (int)(100*Math.random());
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            if (message != null && !message.isEmpty() && message.contains(":")){
                int indexOfSeparator = message.indexOf(":");
                String name = message.substring(0, indexOfSeparator);
                String request = message.substring(indexOfSeparator+1);
                SimpleDateFormat df = null;
                if (request.contains("дата")) {
                    df = new SimpleDateFormat("d.MM.YYYY");
                } else if (request.contains("день")) {
                    df = new SimpleDateFormat("d");
                } else if (request.contains("месяц")) {
                    df = new SimpleDateFormat("MMMM");
                } else if (request.contains("год")) {
                    df = new SimpleDateFormat("YYYY");
                } else if (request.contains("время")) {
                    df = new SimpleDateFormat("H:mm:ss");
                } else if (request.contains("час")) {
                    df = new SimpleDateFormat("H");
                } else if (request.contains("минуты")) {
                    df = new SimpleDateFormat("m");
                } else if (request.contains("секунды")) {
                    df = new SimpleDateFormat("s");
                }

                String answer = null;
                if (df != null){
                    answer = df.format(Calendar.getInstance().getTime());
                    sendTextMessage("Информация для " + name + ": " + answer);
                }
            }
        }
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
