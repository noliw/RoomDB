package com.example.roomdb.database

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.Instant

class InstantTypeConverter {
    //instant can easily be converted into string
    @TypeConverter
    // this tells instant how to convert from instant to some other type
    fun fromInstant(instant: Instant): String {
        return instant.toString()
    }

    @TypeConverter
    // when room returns data from database
    @RequiresApi(Build.VERSION_CODES.O)
    fun toInstant(string: String): Instant {
        return Instant.parse(string)
    }


}