package kr.huny.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by sousic on 2016-10-10.
 */
public class UploadFileHelper {
    private static final Logger logger = LoggerFactory.getLogger(UploadFileHelper.class);

    public static String uploadFile(String uploadPath, String orignalName, byte[] fileDate) throws Exception
    {
        UUID uuid = UUID.randomUUID();

        String savedName = uuid.toString() + "_" + orignalName;
        String savedPath = calcPath(uploadPath);

        File target = new File(uploadPath + savedPath, savedName);
        FileCopyUtils.copy(fileDate, target);

        String uploadFileName = uploadPath + savedPath + File.separator + savedName;

        return uploadFileName;
    }

    private static String calcPath(String uploadPath) {
        Calendar cal = Calendar.getInstance();

        String yearPath = File.separator + cal.get(Calendar.YEAR);
        String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
        String dayPath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));

        makeDir(uploadPath, yearPath, monthPath, dayPath);

        logger.info(uploadPath);

        return dayPath;
    }

    private static void makeDir(String uploadPath, String ... paths) {
        if(new File(paths[paths.length-1]).exists())
        {
            return;
        }

        for(String path : paths) {
            File dirPath = new File(uploadPath + path);

            if(!dirPath.exists()) {
                dirPath.mkdir();
            }
        }
    }
}