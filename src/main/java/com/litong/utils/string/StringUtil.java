package com.litong.utils.string;

import java.io.File;

/**
 * @author litong
 * @date 2018年9月26日_下午6:40:39
 * @version 1.0
 */
public class StringUtil {

  /**
   * 删除指定文string的后缀
   * @param string
   * @param suffix
   * @return
   */
  public static String removeSuffix(String string, String suffix) {
    boolean b = string.endsWith(suffix);
    if (!b) {
      // 如果不包含后缀,退出
      return string;
    }
    int lastIndexOf = string.lastIndexOf(suffix);
    String substring = string.substring(0, lastIndexOf);
    return substring;
  }

  /**
   * 删除指定string的前缀
   * @param string
   * @param prefix
   * @return
   */
  public static String removePrefix(String string, String prefix) {
    boolean b = string.startsWith(prefix);
    if (!b) {
      // 如果不包含前缀,退出
      return string;
    }
    int length = prefix.length();
    String substring = string.substring(length);
    return substring;
  }

  /**
   * 分隔路径,使用与linux和win
   * @param path
   * @return
   */
  public static String[] splitPath(String path) {
    path = path.replace(File.separator, "/");
    String[] split = path.split("/");
    return split;
  }
}