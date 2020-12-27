package com.example.convidados.constants;

public class DataBaseConstants {

    private DataBaseConstants() {
    } // ninguém passa novos valores a esta classe;

    public static class GUEST {

        public static final String TABLE_NAME = "Guest";

        public static class COLUNS {
            public static final String ID = "id";
            public static final String NAME = "name";
            public static final String PRESENCE = "presence";
        }
    }

}
