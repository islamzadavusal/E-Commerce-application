package com.islamzada.abbtask.di

import android.content.Context
import androidx.room.Room
import com.islamzada.abbtask.data.datasource.ItemDatasource
import com.islamzada.abbtask.data.repo.ItemRepo
import com.islamzada.abbtask.room.AppDao
import com.islamzada.abbtask.room.MyDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideItemRepository(ids: ItemDatasource): ItemRepo {
        return ItemRepo(ids)
    }

    @Provides
    @Singleton
    fun provideItemDataSource(idao: AppDao): ItemDatasource {
        return ItemDatasource(idao)
    }

    @Provides
    @Singleton
    fun provideNoteDao(@ApplicationContext context: Context) : AppDao {
        val db = Room.databaseBuilder(context, MyDataBase::class.java,"items.sqlite")
            .createFromAsset("items.sqlite").build()
        return db.getItemsDao()

    }
}