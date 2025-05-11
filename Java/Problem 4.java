public static boolean isMatch(String s, String p) {
    int i = 0;
    int j = 0;
    while (true) {
        if (i >= s.length() && j >= p.length()) {
            return true;
        }
        if (j >= p.length()) {
            return false;
        }
        boolean coincide = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if ((j + 1) < p.length() && p.charAt(j + 1) == '*') {
            if (isMatch(s.substring(i), p.substring(j + 2))) {
                return true;
            }
            while (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                if (isMatch(s.substring(i + 1), p.substring(j + 2))) {
                    return true;
                }
                i++;
            }
            j += 2;
        } else if (coincide) {
            i++;
            j++;
        } else {
            return false;
        }
    }
}