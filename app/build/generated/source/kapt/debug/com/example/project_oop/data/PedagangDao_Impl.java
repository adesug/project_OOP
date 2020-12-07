package com.example.project_oop.data;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
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
public final class PedagangDao_Impl implements PedagangDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Pedagang> __insertionAdapterOfPedagang;

  public PedagangDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPedagang = new EntityInsertionAdapter<Pedagang>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `data_pedagang` (`id`,`nama`,`alamat_pedagang`,`no_lapak`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Pedagang value) {
        stmt.bindLong(1, value.getId());
        if (value.getNama() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNama());
        }
        if (value.getAlamat_pedagang() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAlamat_pedagang());
        }
        stmt.bindLong(4, value.getNo_lapak());
      }
    };
  }

  @Override
  public Object addPedagang(final Pedagang pedagang, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPedagang.insert(pedagang);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public LiveData<List<Pedagang>> readAllData() {
    final String _sql = "SELECT * FROM data_pedagang ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"data_pedagang"}, false, new Callable<List<Pedagang>>() {
      @Override
      public List<Pedagang> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNama = CursorUtil.getColumnIndexOrThrow(_cursor, "nama");
          final int _cursorIndexOfAlamatPedagang = CursorUtil.getColumnIndexOrThrow(_cursor, "alamat_pedagang");
          final int _cursorIndexOfNoLapak = CursorUtil.getColumnIndexOrThrow(_cursor, "no_lapak");
          final List<Pedagang> _result = new ArrayList<Pedagang>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Pedagang _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNama;
            _tmpNama = _cursor.getString(_cursorIndexOfNama);
            final String _tmpAlamat_pedagang;
            _tmpAlamat_pedagang = _cursor.getString(_cursorIndexOfAlamatPedagang);
            final int _tmpNo_lapak;
            _tmpNo_lapak = _cursor.getInt(_cursorIndexOfNoLapak);
            _item = new Pedagang(_tmpId,_tmpNama,_tmpAlamat_pedagang,_tmpNo_lapak);
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
