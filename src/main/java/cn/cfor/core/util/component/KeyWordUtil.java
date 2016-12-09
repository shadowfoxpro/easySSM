package cn.cfor.core.util.component;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cuiyingjia on 2016/12/10.
 */
public class KeyWordUtil {
    private static HashMap keysMap = new HashMap();

    static {
        String keyWords = "fuck,管理员,我是管理员,我操,习禁评,金三胖";
        List<String> keywords = java.util.Arrays.asList(keyWords.split(","));
        for (int i = 0; i < keywords.size(); i++) {
            String key = keywords.get(i).trim();
            HashMap nowhash;
            nowhash = keysMap;
            for (int j = 0; j < key.length(); j++) {
                char word = key.charAt(j);
                Object wordMap = nowhash.get(word);
                if (wordMap != null) {
                    nowhash = (HashMap) wordMap;
                } else {
                    HashMap<String, String> newWordHash = new HashMap<>();
                    newWordHash.put("isEnd", "0");
                    nowhash.put(word, newWordHash);
                    nowhash = newWordHash;
                }
                if (j == key.length() - 1) {
                    nowhash.put("isEnd", "1");
                }
            }
        }
    }

    /**
     * 检查一个字符串从begin位置起开始是否有keyword符合， 如果有符合的keyword值，返回值为匹配keyword的长度，否则返回零
     */
    private static int checkKeyWords(String text, int begin) {
        HashMap nowhash;
        nowhash = keysMap;
        int maxMatchRes = 0;
        int res = 0;
        int l = text.length();
        char word;
        for (int i = begin; i < l; i++) {
            word = text.charAt(i);
            Object wordMap = nowhash.get(word);
            if (wordMap != null) {
                res++;
                nowhash = (HashMap) wordMap;
                if ((nowhash.get("isEnd")).equals("1")) {
                    return res;
                }
            } else {
                return maxMatchRes;
            }
        }
        return maxMatchRes;
    }
    /**
     * 替换关键字
     */
    public static String replaceContent(String text) {
        int l = text.length();
        StringBuffer sb= new StringBuffer(text);
        for (int i = 0; i < l;) {
            int len = checkKeyWords(text, i);
            if (len > 0) {
                String repl = "";
                for (int j = 0 ;j<len;j++){
                    repl += "*";
                }
                sb=sb.replace(i,i+len,repl);
                i += len;
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
