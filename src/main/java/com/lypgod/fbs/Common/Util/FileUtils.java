package com.lypgod.fbs.Common.Util;

//import org.apache.commons.lang3.StringUtils;
//import org.iata.mdmagent.Common.Constants.Constants;
//import org.iata.mdmagent.Common.Exceptions.WsException;

import java.io.File;

//import static org.apache.commons.io.FileUtils.writeLines;

public class FileUtils {

    private FileUtils() {
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static File mkdirs(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

//    public static String path(String... names) {
//        return StringUtils.join(names, File.separator);
//    }
//
//    public static void writeWadFile(ArrayList<String> result, File file) throws IOException, WsException {
//        try {
//            writeLines(file, Constants.DEFAULT_CHARSET_NAME, result);
//        } catch (Exception e) {
//            throw new WsException(Constants.WAD_PARAM_ERROR_CODE, Constants.WAD_PARAM_ERROR_MESSAGE + e.getMessage());
//        }
//    }
}
