package com.example.project_oop.data;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.project_oop.model.DataPasar;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DataPasarDao_Impl implements DataPasarDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DataPasar> __insertionAdapterOfDataPasar;

  private final EntityDeletionOrUpdateAdapter<DataPasar> __deletionAdapterOfDataPasar;

  private final EntityDeletionOrUpdateAdapter<DataPasar> __updateAdapterOfDataPasar;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllPasars;

  public DataPasarDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDataPasar = new EntityInsertionAdapter<DataPasar>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `tb_pasar` (`id`,`namaPasar`,`alamatPasar`,`tipePasar`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataPasar value) {
        stmt.bindLong(1, value.getId());
        if (value.getNamaPasar() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNamaPasar());
        }
        if (value.getAlamatPasar() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlamatPasar());
        }
        if (value.getTipePasar() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTipePasar());
        }
      }
    };
    this.__deletionAdapterOfDataPasar = new EntityDeletionOrUpdateAdapter<DataPasar>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `tb_pasar` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataPasar value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfDataPasar = new EntityDeletionOrUpdateAdapter<DataPasar>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tb_pasar` SET `id` = ?,`namaPasar` = ?,`alamatPasar` = ?,`tipePasar` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, DataPasar value) {
        stmt.bindLong(1, value.getId());
        if (value.getNamaPasar() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNamaPasar());
        }
        if (value.getAlamatPasar() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlamatPasar());
        }
        if (value.getTipePasar() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTipePasar());
        }
        stmt.bindLong(5, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAllPasars = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tb_pasar";
        return _query;
      }
    };
  }

  @Override
  public Object addDataPasar(final DataPasar dataPasar, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfDataPasar.insert(dataPasar);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deletePasar(final DataPasar dataPasar, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfDataPasar.handle(dataPasar);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object updatePasar(final DataPasar dataPasar, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfDataPasar.handle(dataPasar);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteAllPasars(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllPasars.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllPasars.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public LiveData<List<DataPasar>> readAllData() {
    final String _sql = "SELECT * FROM tb_pasar ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tb_pasar"}, false, new Callable<List<DataPasar>>() {
      @Override
      public List<DataPasar> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNamaPasar = CursorUtil.getColumnIndexOrThrow(_cursor, "namaPasar");
          final int _cursorIndexOfAlamatPasar = CursorUtil.getColumnIndexOrThrow(_cursor, "alamatPasar");
          final int _cursorIndexOfTipePasar = CursorUtil.getColumnIndexOrThrow(_cursor, "tipePasar");
          final List<DataPasar> _result = new ArrayList<DataPasar>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DataPasar _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNamaPasar;
            _tmpNamaPasar = _cursor.getString(_cursorIndexOfNamaPasar);
            final String _tmpAlamatPasar;
            _tmpAlamatPasar = _cursor.getString(_cursorIndexOfAlamatPasar);
            final String _tmpTipePasar;
            _tmpTipePasar = _cursor.getString(_cursorIndexOfTipePasar);
            _item = new DataPasar(_tmpId,_tmpNamaPasar,_tmpAlamatPasar,_tmpTipePasar);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
