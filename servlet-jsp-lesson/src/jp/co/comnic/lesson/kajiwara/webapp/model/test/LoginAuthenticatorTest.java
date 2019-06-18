package jp.co.comnic.lesson.kajiwara.webapp.model.test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;

import jp.co.comnic.lesson.kajiwara.webapp.beans.Account;
import jp.co.comnic.lesson.kajiwara.webapp.dao.DaoException;
import jp.co.comnic.lesson.kajiwara.webapp.model.LoginAuthenticator;


class LoginAuthenticatorTest {

    @Test
    void testAuthenticateSuccess() {
        try {
                
            Account actualAccount = 
                LoginAuthenticator.authenticate("John", "admin");
                
            Account expectedAccount = new Account();
            expectedAccount.setUserName("John");
            expectedAccount.setAuthenticated(true);
            expectedAccount.setLastLoginTime(actualAccount.getLastLoginTime());
                
            assertThat(actualAccount, is(samePropertyValuesAs(expectedAccount)));
                
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
    @Test
    void testAuthenticateFailure() {
        try {
                
            Account actualAccount = LoginAuthenticator.authenticate("John", "");
            Account expectedAccount = new Account();
                                    
            assertThat(actualAccount, is(samePropertyValuesAs(expectedAccount)));
            
            actualAccount = LoginAuthenticator.authenticate("", "admin");
            assertThat(actualAccount, is(samePropertyValuesAs(expectedAccount)));
                
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
