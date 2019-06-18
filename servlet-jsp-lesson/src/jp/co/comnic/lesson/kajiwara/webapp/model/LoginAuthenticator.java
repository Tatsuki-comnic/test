package jp.co.comnic.lesson.kajiwara.webapp.model;

import java.time.LocalDateTime;

import jp.co.comnic.lesson.kajiwara.webapp.beans.Account;
import jp.co.comnic.lesson.kajiwara.webapp.dao.AccountDao;
import jp.co.comnic.lesson.kajiwara.webapp.dao.DaoException;

public class LoginAuthenticator {

        public static Account authenticate(String userName, String password) 
                                                           throws DaoException {

        Account account = AccountDao.findBy(userName, password);
        //Account account = AccountDaoStub.findBy(userName, password);
        if (account.isAuthenticated()) {
            account.setLastLoginTime(LocalDateTime.now());
        }
        
        return account;
    }
}