package com.example.retrofit;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;

public class Size2 {
    public static void main(String url) {

        FileChannel fc = null;

        try {

            File f = new File(url);

            if (f.exists() && f.isFile()) {

                FileInputStream fis = new FileInputStream(f);

                fc = fis.getChannel();

                // logger.info(fc.size());

                System.out.println(fc.size() + " 字节");

               Log.e("TAG",getPrintSize(fc.size()));
            } else {
                // logger.info("file doesn't exist or is not a file");
                System.out.println("file doesn't exist or is not a file");
            }
        } catch (FileNotFoundException e) {
            // logger.error(e);
            System.err.println(e);
        } catch (IOException e) {
            // logger.error(e);
            System.err.println(e);
        } finally {
            if (null != fc) {
                try {
                    fc.close();
                } catch (IOException e) {
                    // logger.error(e);
                    System.err.println(e);
                }
            }
        }
    }



    public static String getPrintSize(long size) {

        // 如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义

        double value = (double) size;

        if (value < 1024) {

            return String.valueOf(value) + "B";

        } else {

            value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();

        }

        // 如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位

        // 因为还没有到达要使用另一个单位的时候

        // 接下去以此类推

        if (value < 1024) {

            return String.valueOf(value) + "KB";

        } else {

            value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();

        }

        if (value < 1024) {

            return String.valueOf(value) + "MB";

        } else {

            // 否则如果要以GB为单位的，先除于1024再作同样的处理

            value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();

            return String.valueOf(value) + "GB";

        }

    }
}
