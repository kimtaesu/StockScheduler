package com.hucet.scheduler.schedule;

import com.hucet.batch.code.download.StockService;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Slf4j
@Configuration
@RestController
public class StockScheduler {
    @Autowired
    @Qualifier("stockCodeDownloadService")
    StockService stockService;

    @Scheduled(cron = "${scheduler.codeUpdate}")
    public void codeUpdate() throws IOException {
        Call<ResponseBody> request = stockService.downloadCodes("download");
        downloadFile(request.execute().body());

    }

    private void downloadFile(ResponseBody body) throws IOException {
        Path path = makeFolder();
        Files.write(path, body.bytes());
    }

    private Path makeFolder() {
        DateTimeFormatter format = DateTimeFormatter
                .ofPattern("yyyy-MM-dd");
        return Paths.get(ZonedDateTime.now().format(format) + ".xls");
    }
}
