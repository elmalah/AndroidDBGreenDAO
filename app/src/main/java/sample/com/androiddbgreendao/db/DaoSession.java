package sample.com.androiddbgreendao.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import sample.com.androiddbgreendao.db.SaveUserModel;

import sample.com.androiddbgreendao.db.SaveUserModelDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig saveUserModelDaoConfig;

    private final SaveUserModelDao saveUserModelDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        saveUserModelDaoConfig = daoConfigMap.get(SaveUserModelDao.class).clone();
        saveUserModelDaoConfig.initIdentityScope(type);

        saveUserModelDao = new SaveUserModelDao(saveUserModelDaoConfig, this);

        registerDao(SaveUserModel.class, saveUserModelDao);
    }
    
    public void clear() {
        saveUserModelDaoConfig.clearIdentityScope();
    }

    public SaveUserModelDao getSaveUserModelDao() {
        return saveUserModelDao;
    }

}
