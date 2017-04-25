package com.hucet.scheduler.config;

import com.hucet.batch.code.download.StockService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Configuration
public class RetrofitConfig {
    @Bean
    StockService stockCodeDownloadService(@Value("${krx.url}") String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(MoshiConverterFactory.create())
                .build();
        return retrofit.create(StockService.class);
    }
}
