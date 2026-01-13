package leetcode;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LRUCacheTest {
    
    @Test
    public void test1() {
        LRUCache lruCache = new LRUCache(2);
        assertThat(lruCache.get(2)).isEqualTo(-1);
        lruCache.put(2,6);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        lruCache.put(1,5);
        lruCache.put(1,2);
        assertThat(lruCache.get(1)).isEqualTo(2);
        assertThat(lruCache.get(2)).isEqualTo(6);
    }
    
    @Test
    public void test2() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(3,2);
        assertThat(lruCache.get(3)).isEqualTo(2);
        assertThat(lruCache.get(2)).isEqualTo(1);
        lruCache.put(4,3);
        assertThat(lruCache.get(2)).isEqualTo(1);
        assertThat(lruCache.get(3)).isEqualTo(-1);
        assertThat(lruCache.get(4)).isEqualTo(3);
    }
}