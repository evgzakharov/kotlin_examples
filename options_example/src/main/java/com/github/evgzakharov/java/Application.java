package com.github.evgzakharov.java;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class Application {
    public static void main(String[] args) {
        Options javaStyleOptions = new Options();

        Option urlOption = new Option("url", true, "jdbc url connection string");
        urlOption.setRequired(true);
        javaStyleOptions.addOption(urlOption);

        Option userParamOption = new Option("u", "user", true, "db user name");
        userParamOption.setRequired(true);
        javaStyleOptions.addOption(userParamOption);

        Option passwordOption = new Option("p", "password", true, "password for db user");
        passwordOption.setRequired(true);
        javaStyleOptions.addOption(passwordOption);
    }
}
