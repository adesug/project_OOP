package com.example.project_oop.data;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DataPasarDatabase_Impl extends DataPasarDatabase {
  private volatile DataPasarDao _dataPasarDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tb_pasar` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `namaPasar` TEXT NOT NULL, `alamatPasar` TEXT NOT NULL, `tipePasar` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'e1d345ef2003fe480f4f1a2a7ca7623c')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `tb_pasar`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTbPasar = new HashMap<String, TableInfo.Column>(4);
        _columnsTbPasar.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbPasar.put("namaPasar", new TableInfo.Column("namaPasar", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbPasar.put("alamatPasar", new TableInfo.Column("alamatPasar", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTbPasar.put("tipePasar", new TableInfo.Column("tipePasar", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTbPasar = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTbPasar = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTbPasar = new TableInfo("tb_pasar", _columnsTbPasar, _foreignKeysTbPasar, _indicesTbPasar);
        final TableInfo _existingTbPasar = TableInfo.read(_db, "tb_pasar");
        if (! _infoTbPasar.equals(_existingTbPasar)) {
          return new RoomOpenHelper.ValidationResult(false, "tb_pasar(com.example.project_oop.model.DataPasar).\n"
                  + " Expected:\n" + _infoTbPasar + "\n"
                  + " Found:\n" + _existingTbPasar);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "e1d345ef2003fe480f4f1a2a7ca7623c", "f3d75c3c9d4f402b664a5a8d58aa9b79");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "tb_pasar");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `tb_pasar`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DataPasarDao dataPasarDao() {
    if (_dataPasarDao != null) {
      return _dataPasarDao;
    } else {
      synchronized(this) {
        if(_dataPasarDao == null) {
          _dataPasarDao = new DataPasarDao_Impl(this);
        }
        return _dataPasarDao;
      }
    }
  }
}
