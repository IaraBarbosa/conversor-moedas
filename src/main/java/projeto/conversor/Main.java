package projeto.conversor;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        Menu menu = new Menu();
        menu.processaOpcao();
    }
}