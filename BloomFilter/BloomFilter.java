public class BloomFilter {
    public int filter_len;
    public int filter;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        filter = 0;
    }

    public int hash1(String str1) {
        int x = 17;
        int h = 0;

        for (int i = 0; i < str1.length(); i++) {
            int code = (int)str1.charAt(i);
            h = (h * x + code) / filter_len;
        }


        return 1 << h;
    }

    public int hash2(String str1) {
        int x = 223;
        int h = 0;

        for (int i = 0; i < str1.length(); i++) {
            int code = (int)str1.charAt(i);
            h = (h * x + code) / filter_len;
        }


        return 1 << h;
    }

    public void add(String str1) {
        filter |= (hash1(str1) | hash2(str1));
    }

    public boolean isValue(String str1) {
        return (filter & hash1(str1)) != 0 && (filter & hash2(str1)) != 0;
    }
}