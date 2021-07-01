package com.jfuentes.rickymortyapp.presentation.di

import android.content.Context
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Juan Fuentes on 30/06/2021.
 */

val picassoModule = module {
    single {
        providePicasso(androidContext())
    }
}

private fun providePicasso(context: Context) = Picasso.Builder(context).downloader(okHttp3Downloader()).build()

private fun okHttp3Downloader() = OkHttp3Downloader(OkHttpClient.Builder().build())
