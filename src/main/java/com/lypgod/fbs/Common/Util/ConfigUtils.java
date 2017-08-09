package com.lypgod.fbs.Common.Util;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.io.Resources;
//import org.apache.commons.lang3.StringUtils;
//import org.iata.mdmagent.Common.Configs.SftpConfig;
//import org.iata.mdmagent.Common.Exceptions.ConfigFileLoadingException;
//import org.iata.mdmagent.Common.Exceptions.ConfigNotFoundException;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//import static org.iata.mdmagent.Common.Utils.FileUtils.path;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class ConfigUtils {
//    public static final String HOME_NAME = "MDMAGENT_HOME";
//    public static final String DEFAULT_HOME_FOLDER = ".mdmagent";
//    public static final String CONFIG_FOLDER = "config";
//    public static final String RECEIVE_FOLDER = "receive";
//
//    private static String homePath;
//    private static String configPath;
//    private static String receivePath;
//    private static Map<Class<?>, String> configFiles = new ConcurrentHashMap<>();
//
//    private Map<String, Object> cachedConfigs = new ConcurrentHashMap<>();
//
//    static {
//        initConfigs();
//    }
//
//    public ConfigUtils() {
//        reloadConfig();
//    }
//
//    private static void initConfigs() {
//        createHomeDir();
//        createConfigDir();
//        createReceiveDir();
//        configFiles.put(SftpConfig.class, SftpConfig.FILENAME);
//    }
//
//    private static void createHomeDir() {
//        File homeDir;
//        String env = System.getenv(HOME_NAME);
//        if (StringUtils.isNotBlank(env)) {
//            homeDir = new File(env.trim());
//        } else {
//            homeDir = new File(new File(System.getProperty("user.home")), DEFAULT_HOME_FOLDER);
//        }
//        if (!homeDir.exists()) {
//            homeDir.mkdirs();
//        }
//        homePath = homeDir.getPath();
//    }
//
//    private static void createConfigDir() {
//        configPath = path(homePath, CONFIG_FOLDER);
//        File configDir = new File(configPath);
//        if (!configDir.exists()) {
//            configDir.mkdirs();
//        }
//    }
//
//    private static void createReceiveDir() {
//        receivePath = path(homePath, RECEIVE_FOLDER);
//        File configDir = new File(receivePath);
//        if (!configDir.exists()) {
//            configDir.mkdirs();
//        }
//    }
//
//    private void reloadConfig() {
//        cachedConfigs.clear();
//
//        for (Map.Entry<Class<?>, String> fileConfigEntry : configFiles.entrySet()) {
//            addConfigFromFile(fileConfigEntry.getKey(), fileConfigEntry.getValue());
//        }
//    }
//
//    private void addConfigFromFile(Class<?> clazz, String configFileName) {
//        File configFile = new File(configPath, configFileName);
//
//        try {
//            if (!configFile.exists()) {
//                FileOutputStream outputStream = new FileOutputStream(configFile);
//                Resources.copy(Resources.getResource(clazz, configFileName), outputStream);
//                outputStream.close();
//            }
//
//            cachedConfigs.put(clazz.getName(), readConfigFile(configFile, clazz));
//        } catch (IOException e) {
//            throw new ConfigFileLoadingException("Could not load config: " + clazz.getName() + " from: " + configFileName + " in " + configFile.getAbsolutePath(), e);
//        }
//    }
//
//    public static void writeConfigFile(File file, Object object) throws IOException {
//        new ObjectMapper().writeValue(file, object);
//    }
//
//    public static <T> T readConfigFile(File file, Class<T> clazz) throws IOException {
//        return new ObjectMapper().readValue(file, clazz);
//    }
//
//
//    public static String getHomePath() {
//        return homePath;
//    }
//
//    public static String getConfigPath() {
//        return configPath;
//    }
//
//    public static String getReceivePath() {
//        return path(homePath, RECEIVE_FOLDER);
//    }
//
//    @SuppressWarnings("unchecked")
//    private <T> T getConfig(Class<T> clazz) {
//        if (cachedConfigs.containsKey(clazz.getName())) {
//            return (T) cachedConfigs.get(clazz.getName());
//        }
//
//        throw new ConfigNotFoundException("Could not find config for " + clazz.getName());
//    }
//
//    public SftpConfig getSftpConfig() {
//        return getConfig(SftpConfig.class);
//    }
}