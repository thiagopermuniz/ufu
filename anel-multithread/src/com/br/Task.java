package com.br;

import java.util.concurrent.atomic.AtomicBoolean;

class Task implements Runnable {
    static AtomicBoolean flag = new AtomicBoolean(false);
    private String message;

    public Task(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            processMessageText();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized boolean beingProcessed() {
        return flag.get();
    }

    public synchronized void hold() {
        flag.set(true);
    }

    public synchronized void free() {
        flag.set(false);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void processMessageText() throws InterruptedException {

        //RODA ETERNAMENTE ATÉ NÃO MODIFICAR NADA AO EXECUTAR;
        while (true) {
            //SE FLAG DA TASK FOR FALSE (DESOCUPADO)
            if (!beingProcessed()) {
                //FLAG QUE VALIDA SE ACHOU E MODIFICOU ALGUM CHAR LOWERCASE
                boolean changed = false;
                //OCUPA
                hold();
                System.out.println(Thread.currentThread().getName() + ": " + getMessage());
                char texto[] = getMessage().toCharArray();
                for (int i = 0; i < texto.length; i++) {
                    if (Character.isLowerCase(texto[i])) {
                        texto[i] = Character.toUpperCase(texto[i]);
                        //REPASSA A MENSAGEM (??)
                        setMessage(new String(texto));
                        changed = true;
                        break;
                    }
                }
                //LIBERA FLAG DA TASK
                free();
                Thread.sleep(1000l);

                if (!changed) {
                    break;

                }
            }
        }
    }

}