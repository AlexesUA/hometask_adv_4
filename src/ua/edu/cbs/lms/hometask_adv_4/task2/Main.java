package ua.edu.cbs.lms.hometask_adv_4.task2;

public class Main {
    public static void main(String[] args) {
        JokeDecoder jokeDecoder = new JokeDecoder();

        System.out.println("Text in source file before replace:");
        System.out.println(" = = = = = = = = = = = = = = = = = = ");
        jokeDecoder.printSourceFile();

        System.out.println(" = = = = = = = = = = = = = = = = = = ");

        System.out.println("Text in destination file after replace:");

        //може підкажете, я не розумію чому файл Destination.txt залишається порожній по завершенню програми
        //Вивід працює, а файл порожній
        System.out.println(" = = = = = = = = = = = = = = = = = = ");
        jokeDecoder.clearDestinationFile();
        jokeDecoder.replacePreposition();
        jokeDecoder.printDestinationFile();

        System.out.println(" = = = = = = = = = = = = = = = = = = ");
        //jokeDecoder.printDestinationFile();
    }
}
