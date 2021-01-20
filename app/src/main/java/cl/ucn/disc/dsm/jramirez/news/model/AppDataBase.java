/*
 * Copyright 2021 Jean Ramirez Castillo jean.ramirez@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.jramirez.news.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import org.threeten.bp.ZonedDateTime;

@Database(entities = {News.class}, version = 1)
@TypeConverters(Converters.class)
public abstract class AppDataBase extends RoomDatabase {

    /**
     * Initialize news dao
     */
    public abstract NewsDao newsDao();

    private static AppDataBase localDataBase;

    private static String DATABASE_NAME = "newsDataBase";

    /**
     *  Create local database
     *
     * @param context to use
     * @return localdatabase
     */
    public synchronized static AppDataBase getInstance(Context context){

        //Local databasenull
        if(localDataBase == null){

            localDataBase = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }

        return localDataBase;
    }


}

/**
 * Converter DateTime
 */
class Converters {
    @TypeConverter
    public static ZonedDateTime toDate(String dateString){
        if(dateString == null){
            return null;
        }else{
            return ZonedDateTime.parse(dateString);
        }
    }
    @TypeConverter
    public static String toDateString(ZonedDateTime date){
        if(date == null){
            return null;
        }else{
            return date.toString();
        }
    }
}
