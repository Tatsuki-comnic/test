package jp.co.comnic.lesson.kajiwara.webapp.dao;


public class DaoException extends Exception {

    private static final long serialVersionUID = 1L;

    public DaoException(Exception e) {
        super(e);
    }
}