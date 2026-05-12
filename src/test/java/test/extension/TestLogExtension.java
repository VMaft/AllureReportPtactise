package test.extension;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class TestLogExtension implements TestWatcher {
    public void testDisabled(ExtensionContext context) {
        System.out.println("<<<>>> Тест: {" + context.getDisplayName() + "} выключен и не будет запущен. ");
    }

    public void testStarted(ExtensionContext context) {
        System.out.println(">>> Запуск теста: " + context.getDisplayName());
    }

    public void testSuccessful(ExtensionContext context) {
        System.out.println(">>> Тест выполнен успешно! Test.Name: {" + context.getDisplayName() + "}");
    }
}
