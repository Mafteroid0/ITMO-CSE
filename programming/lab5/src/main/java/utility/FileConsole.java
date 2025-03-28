package utility;

import java.io.*;

/**
 * Класс представляющий строки файла в качестве консоли ввода
 */
public class FileConsole implements Console {
    private final BufferedInputStream inputStream;

    public FileConsole(String filePath) throws IOException {
        this.inputStream = new BufferedInputStream(new FileInputStream(filePath));
    }

    /** Выводит obj в консоль
     * @param obj объект для печати
     */
    @Override
    public void print(Object obj) {
        System.out.print(obj);
    }

    /** Выводит obj в консоль с переносом строки
     * @param obj объект для печати
     */
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }

    /**
     * @return следующую строку из файла
     */
    @Override
    public String nextLine() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int byteRead;
            while ((byteRead = inputStream.read()) != -1) {
                if (byteRead == '\n') {
                    break;
                }
                byteArrayOutputStream.write(byteRead);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла");
        }
        return byteArrayOutputStream.toString();
    }

    /**
     * @return true если в файле еще есть строки
     */
    @Override
    public boolean hasNextLine() {
        try {
            inputStream.mark(1);
            int byteRead = inputStream.read();
            inputStream.reset();
            return byteRead != -1;
        } catch (IOException e) {
            return false;
        }
    }

}
