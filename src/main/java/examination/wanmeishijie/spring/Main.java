package examination.wanmeishijie.spring;

import java.util.*;

/**
 * @author 孙继峰
 * @since 2020/3/17
 */
public class Main {
    public static void main(String[] args) {

    }

    /*
     * 切换几次代理才能完成
     */
    public int switchTime(Set<String> proxyServers, Set<String> targetServers) {
        if (proxyServers.equals(targetServers)) {
            if (proxyServers.size() == 1) {
                return -1;
            } else {
                return 1;
            }
        }
        if (targetServers.containsAll(proxyServers)) {
            return 1;
        } else {
            return 0;
        }
    }

}
