package org.example.p01web;
//父类
public class BaseScreen {
    public  void clear() {
        //
        try {
            //windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            //linux
            //new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {

        }
    }
}
