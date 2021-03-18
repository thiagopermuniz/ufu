package com.br;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        String message = "uma string aleatória de pelo menos 80 caracteres";
        //CRIA THEAD POOL
        ExecutorService executor = Executors.newFixedThreadPool(30);
        //INSTANCIA O RUNNABLE
        Task t = new Task(message);
        Future future = null;
        //BOTANDO AS THREAD P TRABALHAR
        for (int i = 0; i < 30; i++) {
            executor.submit(t);
        }
    }

}
