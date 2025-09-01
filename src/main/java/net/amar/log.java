package net.amar;
/*
 * I made this class because im too lazy
 * to make new slf4j imstance for each
 * future class i make,i will simply use
 * this one.... BAHA!
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class log {
    private static final Logger log = LoggerFactory.getLogger(log.class);
public static void info(String info){
    log.info(info);
}
public static void warn(String warn){
    log.warn(warn);
}
public static void error(String error){
    log.error(error);
}
}
