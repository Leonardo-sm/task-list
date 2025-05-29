package org.example.core;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CommandScanner {
    public static List<Class<?>> findCommandsClasses(String packageName, Class<? extends Annotation> annotation) {
        List<Class<?>> result = new ArrayList<>();
        String path = packageName.replace('.', '/');

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL packageURL = classLoader.getResource(path);

            if (packageURL == null) {
                System.err.println("Pacote não encontrado: " + packageName);
                return result;
            }

            File folder = new File(packageURL.toURI());
            File[] files = folder.listFiles((dir, name) -> name.endsWith(".class") && !name.contains("$"));

            if (files == null) return result;

            for (File file : files) {
                String className = file.getName().replace(".class", "");
                Class<?> clazz = Class.forName(packageName + "." + className);

                if (clazz.isAnnotationPresent(annotation)) {
                    result.add(clazz);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
