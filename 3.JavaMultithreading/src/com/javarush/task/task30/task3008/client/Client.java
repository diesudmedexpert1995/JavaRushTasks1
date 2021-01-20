package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Enter new address");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Enter the server port");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Enter the username: ");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException ioException) {
            ioException.getMessage();
            clientConnected = false;
        }
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try {
            synchronized (this){
                this.wait();
            }
        } catch (InterruptedException e) {
            e.getMessage();
            System.exit(1);
        }

        if(clientConnected){
            ConsoleHelper.writeMessage("Соединение установлено.Для выхода наберите команду 'exit'.");
        }else{
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }

        while (clientConnected){
            String text = ConsoleHelper.readString();
            if (text.equals("exit")){
                break;
            }
            if (shouldSendTextFromConsole()){
                sendTextMessage(text);
            }

        }

    }

    public static void main(String[] args) {
        new Client().run();
    }

    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            System.out.println(message);
        }

        protected void informAboutAddingNewUser(String userName){
            System.out.println("Пользователь с ником " + userName + " вошел в чат.");
        }

        protected void informAboutDeletingNewUser(String userName){
            System.out.println("Пользователь с ником " + userName + " покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true){
                Message message = Client.this.connection.receive();
                try {
                    if (message.getType().equals(MessageType.NAME_REQUEST)){
                        String userNameRequested = getUserName();
                        Client.this.connection.send(new Message(MessageType.USER_NAME, userNameRequested));
                    }else if(message.getType().equals(MessageType.NAME_ACCEPTED)){
                        notifyConnectionStatusChanged(true);
                        return;
                    }else{
                        throw new IOException("Unexpected Type of Message");
                    }
                } catch (Exception ex){
                    throw new IOException("Unexpected Type of Message");
                }
            }

        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true){
                Message message = Client.this.connection.receive();
                try {
                    if (message.getType().equals(MessageType.TEXT)){
                        processIncomingMessage(message.getData());
                    }else if(message.getType().equals(MessageType.USER_ADDED)){
                        informAboutAddingNewUser(message.getData());
                    }else if(message.getType().equals(MessageType.USER_REMOVED)){
                        informAboutDeletingNewUser(message.getData());
                    }else{
                        throw new IOException("Unexpected Type of Message");
                    }
                } catch (Exception ex){
                    throw new IOException("Unexpected Type of Message");
                }
            }
        }

        public void run(){
            String host = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(host,port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException ioException) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
