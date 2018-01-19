package pro.shadowfox.core.util;

import org.springframework.context.MessageSource;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by cuiyingjia on 2016/12/8.
 */
public class CustomProperty {

        public static final String numberChar = "0123456789";

        protected static final Pattern VAR_PATTERN = Pattern.compile("(\\$\\{)[^}]{1,}(\\})");

        private static MessageSource messageSource = null;

        public static MessageSource getMessageSource() {
            return messageSource;
        }

        public static void setMessageSource(MessageSource messageSource) {
            CustomProperty.messageSource = messageSource;
        }

        /**
         * 获取application.properties配置参数
         * @param key
         * @return value
         */
        public static String getValue(String key) {
            return CustomPropertyPlaceholder.getContextProperty(key);
        }

        /**
         * 获取application.properties配置参数 并使用参数替换里面的${0} ${1}等
         * @param key
         * @param obj
         * @return
         */
        public static String getValue(String key,String... obj) {
            String propertyValue = CustomPropertyPlaceholder.getContextProperty(key);
            Map<String, String> map = new HashMap<String, String>();
            for (int i = 0; i < obj.length; i++) {
                map.put(i+"", obj[i]);
            }
            return CustomMessageSource.replaceTempleteVariables(propertyValue, map);
        }



}
