package edu.junit;

import java.util.logging.Logger;

public class bancoDeDados {
    private static final Logger LOGGER = Logger.getLogger(bancoDeDados.class.getName());

    public static void iniciarConexao() {
        LOGGER.info("Iniciou conexão");
    }

    public static void finzalizarConexao() {
        LOGGER.info("Finalizou conexão");
    }

}
