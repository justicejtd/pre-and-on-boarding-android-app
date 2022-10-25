package com.example.preandonboarding.data.api.service

import com.example.preandonboarding.BuildConfig
import com.example.preandonboarding.data.api.service.appIntroPage.AppIntroService
import com.example.preandonboarding.data.api.service.authentication.AuthService
import com.example.preandonboarding.data.api.service.conversation.ConversationService
import com.example.preandonboarding.data.api.service.module.ModuleService
import com.example.preandonboarding.data.api.service.theme.ThemeService
import com.example.preandonboarding.data.model.Token
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object ApiClientService {
    private const val BASE_URL = "https://mobiledev-justice-api-test.lwdev.nl/api/"

    // Add parameters for okhttp client and logging
    private fun getRetrofit(): Retrofit {

        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.addHeader("Authorization", "Bearer ${Token.accessToken}")
                }.build())
            }.also { client ->
                if (BuildConfig.DEBUG) {
                    // Logger to log http request, response and body
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
                }
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getAuthService(): AuthService {
        return getRetrofit().create(AuthService::class.java)
    }

    fun getModuleService(): ModuleService {
        return getRetrofit().create(ModuleService::class.java)
    }

    fun getConversationService(): ConversationService {
        return getRetrofit().create(ConversationService::class.java)
    }

    fun getAppIntroConfigsService(): AppIntroService {
        return getRetrofit().create(AppIntroService::class.java)
    }

    fun getThemeService(): ThemeService {
        return getRetrofit().create(ThemeService::class.java)
    }
}