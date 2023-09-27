package Recorder;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;


import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyScreenRecorder {
    private ScreenRecorder screenRecorder;

    public void startRecording(String methodName) throws Exception {
        File file = new File("./Recordings/");
        File movieFile = createMovieFile(file, methodName);
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        this.screenRecorder = new ScreenRecorder(gc, null,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                        FrameRateKey, Rational.valueOf(30)),
                null, movieFile);
        this.screenRecorder.start();
    }

    public void stopRecording() throws Exception {
        this.screenRecorder.stop();
    }

    private File createMovieFile(File movieFolder, String methodName) throws IOException {
        if (!movieFolder.exists()) {
            movieFolder.mkdirs();
        } else if (!movieFolder.isDirectory()) {
            throw new IOException("\"" + movieFolder + "\" is not a directory.");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH.mm.ss");
        String formattedDate = dateFormat.format(new Date());
        String filename = formattedDate;
        return new File(movieFolder, filename + ".avi");
    }
}

